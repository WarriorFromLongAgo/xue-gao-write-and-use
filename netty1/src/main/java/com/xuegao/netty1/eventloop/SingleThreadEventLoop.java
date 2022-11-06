package com.xuegao.netty1.eventloop;

import com.xuegao.netty1.channel.Channel;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Executor;

// 单线程事件循环器
// 这个类其实就是实现了parent()，和next() ，iterator()这种应对Group接口的方法，之所以敢称单线程，
// 是因为他爹是单线程处理器SingleThreadEventExecutor，它的存在就是为了让子类不用再处理与Group的关系
// 内部携带了一个多路复用器，作为一个SingleThreadEventExecutor，它的运行套路是不断的监听selector，
// 如果任务队列有任务，就处理任务，这里我简化了代码，监听1秒再去查看是否有任务，没有再回来监听，
// 源码是有个策略判断该执行任务还是该阻塞到selector上

public abstract class SingleThreadEventLoop extends SingleThreadEventExecutor implements EventLoop {

    private final Collection<EventLoop> selfCollection = Collections.<EventLoop>singleton(this);

    private final EventLoopGroup parent;

    public SingleThreadEventLoop(EventLoopGroup parent, Executor executor) {
        super(executor);
        this.parent = parent;
    }

    @Override
    public EventLoopGroup parent() {
        return parent;
    }


    @Override
    public void register(Channel channel) {
        // netty源码  promise.channel().unsafe().register(this, promise); 简化不区分unsafe，如下
        channel.register(this);
    }

    @Override
    public EventLoop next() {
        return this;
    }

    @Override
    public Iterator<EventLoop> iterator() {
        return selfCollection.iterator();
    }

}