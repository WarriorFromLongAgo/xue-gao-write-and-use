package com.xuegao.netty1.channel;

import com.xuegao.netty1.eventloop.NioEventLoop;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

// 这个就是专门处理NIO的抽象channel了，就可以实际去实现NIO的注册了
// 存储了SelectableChannel，即ServerSocketChannel和SocketChannel的共同父类
// 实现了doRegister方法，即把jdk的channel注册到EventLoop下面的多路复用器
// 实现了doBeginRead方法，即注册感兴趣事件
// 抽象了一个read方法，即从channel读取信息，由于客户端与服务端读取方法不一样，所以抽象出来
// 而客户端与服务端的read实现也是分别抽象了两个类来提交给channel的handler，即AbstractNioMessageChannel和AbstractNioByteChannel

public abstract class AbstractNioChannel extends AbstractChannel {

    /**
     * java的channel 包括ServerSocketChannel和SocketChannel
     */
    private final SelectableChannel ch;

    private SelectionKey selectionKey;

    /**
     * 感兴趣的事件
     */
    protected final int readInterestOp;

    public AbstractNioChannel(Channel parent, SelectableChannel ch, int readInterestOp) {
        super(parent);
        this.ch = ch;
        this.readInterestOp = readInterestOp;
        try {
            ch.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回java的channel
     *
     * @return
     */
    protected SelectableChannel javaChannel() {
        return ch;
    }

    /**
     * 把通道注册到多路复用器
     *
     * @throws Exception
     */
    @Override
    protected void doRegister() throws Exception {
        // 最后一个字段this,相当于selectionKey.attach(this)，后续可以通过attachment()方法取到
        // 由于多个channel注册到一个eventLoop，所以需要传递当前的channel以便eventLoop获取到事件时可以知道是哪个channel产生的事件
        selectionKey = javaChannel().register(((NioEventLoop) eventLoop()).unwrappedSelector(), 0, this);
    }

    /**
     * 注册感兴趣事件
     */
    @Override
    protected void doBeginRead() {
        selectionKey.interestOps(readInterestOp);
    }

    /**
     * 从 {@link SelectableChannel} 读取事件，源码是写在Unsafe里
     */
    public abstract void read();

}