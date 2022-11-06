package com.xuegao.netty1.channel;

// 管道进入事件处理器，与之对应管道返回事件处理器，我并没有写
public interface ChannelInboundHandler extends ChannelHandler{

    void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception;

    void channelReadComplete(ChannelHandlerContext ctx) throws Exception;
}