package com.xuegao.netty1.channel;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

// 客户端的channel
// 这个和Server端差不多，只不过一个读channel，一个读字节。感兴趣的事件是SelectionKey.OP_READ
// 到此channel相关类写完~
public class NioSocketChannel extends AbstractNioByteChannel {

    /**
     * 多路复用器提供者
     */
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();

    /**
     * 开启一个 java SocketChannel 这个方法为客户端创建通道使用
     *
     * @param provider
     * @return
     */
    private static SocketChannel newSocket(SelectorProvider provider) {
        try {
            return provider.openSocketChannel();
        } catch (IOException e) {
            return null;
        }
    }

    public NioSocketChannel() {
        this(null, newSocket(DEFAULT_SELECTOR_PROVIDER));
    }

    /**
     * SocketChannel 感兴趣的事件是READ
     *
     * @param parent
     * @param channel
     */
    public NioSocketChannel(Channel parent, SocketChannel channel) {
        super(parent, channel, SelectionKey.OP_READ);
    }

    /**
     * 覆盖，因为可以确定返回的是SocketChannel
     *
     * @return
     */
    @Override
    protected SocketChannel javaChannel() {
        return (SocketChannel) super.javaChannel();
    }

    /**
     * 绑定端socket
     *
     * @param localAddress
     * @throws Exception
     */
    @Override
    protected void doBind(SocketAddress localAddress) throws Exception {
        javaChannel().socket().bind(localAddress);
    }

    @Override
    protected int doReadBytes(ByteBuffer buf) {
        try {
            return javaChannel().read(buf);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}