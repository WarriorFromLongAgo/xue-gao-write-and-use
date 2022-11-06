package com.xuegao.netty1.eventloop;

// 继承EventLoopGroup，并且可以查到父Group
public interface EventLoop extends EventLoopGroup {
    EventLoopGroup parent();
}