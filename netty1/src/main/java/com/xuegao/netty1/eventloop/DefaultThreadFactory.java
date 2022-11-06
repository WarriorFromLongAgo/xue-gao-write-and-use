package com.xuegao.netty1.eventloop;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadFactory implements ThreadFactory {
    private AtomicInteger no = new AtomicInteger(0);
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "nio-thread-"+(no.incrementAndGet()));
    }
}