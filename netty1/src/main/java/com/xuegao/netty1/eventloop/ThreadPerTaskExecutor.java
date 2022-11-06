package com.xuegao.netty1.eventloop;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;


// 这俩的存在主要是给提供真实线程，并统一命名
public class ThreadPerTaskExecutor implements Executor {
    private final ThreadFactory threadFactory;

    public ThreadPerTaskExecutor(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException("threadFactory");
        }
        this.threadFactory = threadFactory;
    }

    @Override
    public void execute(Runnable command) {
        threadFactory.newThread(command).start();
    }
}