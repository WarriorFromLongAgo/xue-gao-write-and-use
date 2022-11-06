package com.xuegao.netty1.eventloop;

// 它存在的意义和SingleThreadEventLoop差不多，帮助子类处理group和成员的关系，实现了next方法(这里我简化了用轮训，源码可以自定义chooser)
// 抽象了newChild交给子类去实际创建组成员

import com.xuegao.netty1.channel.Channel;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public abstract class MultithreadEventLoopGroup implements EventLoopGroup {

    private final EventLoop[] children;
    /**
     * 为了迭代用
     */
    private final Set<EventLoop> readonlyChildren;

    public MultithreadEventLoopGroup(int nThreads, Executor executor) {
        if (nThreads <= 0) {
            throw new IllegalArgumentException();
        }
        if (executor == null) {
            executor = new ThreadPerTaskExecutor(new DefaultThreadFactory());
        }
        this.children = new EventLoop[nThreads];
        for (int i = 0; i < nThreads; i++) {
            children[i] = newChild(executor);
        }

        /**
         * 为了迭代用
         */
        Set<EventLoop> childrenSet = new LinkedHashSet<EventLoop>(children.length);
        Collections.addAll(childrenSet, children);
        readonlyChildren = Collections.unmodifiableSet(childrenSet);
    }

    protected abstract EventLoop newChild(Executor executor);

    /**
     * 源码用一个chooser对象选择子线程，这里简化一下，就轮训吧
     *
     * @return
     */
    int i = 0;

    public EventLoop chooseNext() {
        if (i >= children.length) {
            i = 0;
        }
        EventLoop child = children[i];
        i++;
        return child;
    }

    @Override
    public void register(Channel channel) {
        next().register(channel);
    }

    @Override
    public EventLoop next() {
        return chooseNext();
    }

    @Override
    public Iterator<EventLoop> iterator() {
        return readonlyChildren.iterator();
    }

    @Override
    public void execute(Runnable command) {
        next().execute(command);
    }
}