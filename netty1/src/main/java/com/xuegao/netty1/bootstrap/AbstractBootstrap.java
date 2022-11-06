package com.xuegao.netty1.bootstrap;

import com.xuegao.netty1.channel.Channel;
import com.xuegao.netty1.eventloop.EventLoopGroup;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

// 抽象了一个channel init方法，如果前面看懂了，这里应该能猜到主要是为了给ServerChannel添加默认的handler
public abstract class AbstractBootstrap<B extends AbstractBootstrap<B, C>, C extends Channel> {

    volatile EventLoopGroup group;

    /**
     * 源码使用工厂模式存储是channelFactory，这里简化处理
     */
    private volatile Channel channel;

    AbstractBootstrap() {
        // Disallow extending from a different package.
    }

    private B self() {
        return (B) this;
    }

    public B group(EventLoopGroup group) {
        this.group = group;
        return self();
    }

    public B channel(Class<? extends C> channelClass) {
        try {
            channel = channelClass.getConstructor().newInstance();
        } catch (Exception e) {
        }
        return self();
    }

    public void bind(int inetPort) {
        doBind(new InetSocketAddress(inetPort));
    }

    private void doBind(final SocketAddress localAddress) {
        initAndRegister();
        // 让channel绑定的线程去实际绑定
        channel.eventLoop().execute(()->{
            channel.bind(localAddress);
        });
    }

    final void initAndRegister() {
        init(channel);
        group.register(channel);
    }

    abstract void init(Channel channel);
}