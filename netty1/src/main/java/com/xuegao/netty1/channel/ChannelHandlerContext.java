package com.xuegao.netty1.channel;


// 由于用户再写处理器时需要得知上下文信息，即channel是哪个(可以通过channel写回数据)，eventLoop是哪个，
// 所以需要用一个上下文对象把handler包装起来，同时Context对象还保存了链表的关系，使得handler形成链表

import com.xuegao.netty1.eventloop.EventLoop;

public class ChannelHandlerContext {

    private final ChannelHandler handler;

    /**
     * 链表
     */
    volatile ChannelHandlerContext next;
    volatile ChannelHandlerContext prev;

    private final ChannelPipeline pipeline;

    public ChannelHandlerContext(ChannelPipeline pipeline, ChannelHandler handler) {
        this.pipeline = pipeline;
        this.handler = handler;
    }

    /**
     * 当前通道
     *
     * @return
     */
    public Channel channel() {
        return pipeline.channel();
    }

    /**
     * 当前管道
     *
     * @return
     */
    public ChannelPipeline pipeline() {
        return pipeline;
    }

    /**
     * 当前执行器
     *
     * @return
     */
    public EventLoop executor() {
        return channel().eventLoop();
    }

    public ChannelHandler handler() {
        return handler;
    }

    /**
     * 把信息传给链表下一个read节点去处理
     *
     * @param msg
     * @return
     */
    public ChannelHandlerContext fireChannelRead(final Object msg) {
        findContextInbound().invokeChannelRead(msg);
        return this;
    }

    /**
     * 找到自己后面的Inbound处理器
     *
     * @return
     */
    private ChannelHandlerContext findContextInbound() {
        ChannelHandlerContext ctx = this;
        do {
            ctx = ctx.next;
        } while (!(ctx.handler() instanceof ChannelInboundHandler));
        return ctx;
    }

    /**
     * 调用handler的channelRead方法
     *
     * @param msg
     */
    private void invokeChannelRead(Object msg) {
        try {
            ((ChannelInboundHandler) handler()).channelRead(this, msg);
        } catch (Throwable t) {
            // 如果当前的handler不是ChannelInboundHandler则报错
        }
    }

}