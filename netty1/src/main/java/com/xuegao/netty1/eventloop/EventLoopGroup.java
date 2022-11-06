package com.xuegao.netty1.eventloop;

import com.xuegao.netty1.channel.Channel;

import java.util.Iterator;
import java.util.concurrent.Executor;

// 事件循环器组，和EventLoop提供一样的功能，同时可以选择下一个EventLoop且可以迭代
public interface EventLoopGroup extends Executor, Iterable<EventLoop>{

    void register(Channel channel);

    EventLoop next();

    @Override
    Iterator<EventLoop> iterator();
}