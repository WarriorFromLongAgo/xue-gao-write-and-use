package com.xuegao.netty1.channel;

// 即管道绑定的处理器，一个管道对应一个pipeline，一个pipeline用链表形式存储多个处理器，这个我简化了一下，只是空接口，
// 他有两种子类ChannelInboundHandler和ChannelOutboundHandler，分别管道进入即读事件的处理器和管道流出即写事件的处理器

public interface ChannelHandler {
}