package com.xuegao.netty1.channel;

import com.xuegao.netty1.eventloop.EventLoop;

import java.net.SocketAddress;

// 首先是抽象的channel接口，主要方法即绑定EventLoop，绑定端口和获取pipeline
public interface Channel {
    /**
     * 绑定事件持续处理器
     * @param eventLoop
     */
    void register(EventLoop eventLoop);

    /**
     * 获取事件持续处理器
     * @return
     */
    EventLoop eventLoop();

    /**
     * 通道内部的管道
     * @return
     */
    ChannelPipeline pipeline();

    /**
     * 绑定端口
     * @param localAddress
     */
    void bind(SocketAddress localAddress);

    /**
     * 开始读取，nio的实现即注册感兴趣的事件
     */
    void beginRead();
}