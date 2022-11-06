package com.xuegao.netty1.bootstrap;

import com.xuegao.netty1.channel.*;
import com.xuegao.netty1.eventloop.EventLoopGroup;

// 子类ServerBootstrapAcceptor 就是ServerSocketChannel默认的handler，通过init方法添加上
// 到此，山寨版的netty写完了，累了一头汗，代码的命名和类命名尽量和源码保持一致，因为都是复制过来的，有些很复杂的地方做了简化处理，
// 但个人感觉核心的代码除了bytebuf应该都写上了，使用方式开头有写基本和netty差不多，还是那句话，手写的目的是理解netty源码
// 篇幅有限，这里面的事好多代码都没细讲，但代码也摘的很轻量，完全可以自行理解，回头再看netty，基本就差不多
// 回想一下，其实netty的核心概念就总结出来了：channel维护了jdk的通道，并可以设置后置处理器实现，
// EventLoop是针对channel事件的专用线程，而EventLoopGroup是它们组合即专用线程池

public class ServerBootstrap extends AbstractBootstrap<ServerBootstrap, NioServerSocketChannel> {

    private volatile EventLoopGroup childGroup;

    /**
     * 这里简化处理
     */
    private volatile ChannelHandler[] childHandlers;

    public ServerBootstrap() { }

    public ServerBootstrap group(EventLoopGroup parentGroup, EventLoopGroup childGroup) {
        super.group(parentGroup);
        this.childGroup = childGroup;
        return this;
    }

    public ServerBootstrap childHandler(ChannelHandler... childHandlers) {
        this.childHandlers = childHandlers;
        return this;
    }

    @Override
    void init(Channel channel) {
        ChannelPipeline p = channel.pipeline();
        // 这里给ServerChannel添加管道处理器，简化了代码
        p.addLast(new ServerBootstrapAcceptor(childGroup, childHandlers));
    }

    private static class ServerBootstrapAcceptor implements ChannelInboundHandler {

        private final EventLoopGroup childGroup;
        private final ChannelHandler[] childHandlers;

        private ServerBootstrapAcceptor(EventLoopGroup childGroup, ChannelHandler[] childHandlers) {
            this.childGroup = childGroup;
            this.childHandlers = childHandlers;
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            final Channel child = (Channel) msg;
            for (ChannelHandler childHandler : childHandlers) {
                child.pipeline().addLast(childHandler);
            }
            childGroup.register(child);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            // 略
        }
    }
}