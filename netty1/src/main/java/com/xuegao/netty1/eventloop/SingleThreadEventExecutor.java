package com.xuegao.netty1.eventloop;

import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

// 本来打算把EventExecutor去掉，代码写在EventLoop，但这个类太重要了，所以保留了下来

// 可以这么概括它：SingleThreadEventExecutor是一种特殊的任务执行器，第一次收到任务它就会启动(开启一个线程运行run方法，
// run方法是一个会一直执行的方法，否则报错)，当任务来时并不是立即执行，它们会加入到自己的任务对列中，并且按自己的套路(run)去执行

public abstract class SingleThreadEventExecutor implements Executor {
    /**
     * 默认任务列表长度
     */
    protected static final int DEFAULT_MAX_PENDING_TASKS = 16;
    /**
     * 待完成的任务
     */
    private final Queue<Runnable> taskQueue;
    /**
     * 实际工作者
     */
    private final Executor executor;
    /**
     * 当前运行线程
     */
    private volatile Thread thread;

    /**
     * ST_NOT_STARTED: 未启动, ST_STARTED 已启动
     */
    private static final int ST_NOT_STARTED = 1;
    private static final int ST_STARTED = 2;

    /**
     * 标记是否启动
     */
    private volatile int state = ST_NOT_STARTED;

    /**
     * 原子启动标记更新器
     */
    private static final AtomicIntegerFieldUpdater<SingleThreadEventExecutor> STATE_UPDATER =
            AtomicIntegerFieldUpdater.newUpdater(SingleThreadEventExecutor.class, "state");

    public SingleThreadEventExecutor(Executor executor) {
        taskQueue = newTaskQueue(DEFAULT_MAX_PENDING_TASKS);
        this.executor = executor;
    }

    /**
     * 初始化一个新的任务对列
     *
     * @param maxPendingTasks
     * @return
     */
    protected Queue<Runnable> newTaskQueue(int maxPendingTasks) {
        return new LinkedBlockingQueue<>(maxPendingTasks);
    }

    /**
     * 添加任务
     *
     * @param task
     */
    protected void addTask(Runnable task) {
        if (task == null) {
            throw new NullPointerException("task");
        }
        if (!taskQueue.offer(task)) {
            throw new RejectedExecutionException("event executor terminated");
        }
    }

    /**
     * 检查是否有任务
     *
     * @return
     */
    protected boolean hasTasks() {
        return !taskQueue.isEmpty();
    }

    /**
     * 运行所有任务
     *
     * @return
     */
    protected boolean runAllTasks() {
        // 省略乱七八糟的判断，把多个子方法简化
        Runnable task = taskQueue.poll();
        if (task == null) {
            return false;
        }
        for (; ; ) {
            task.run();
            task = taskQueue.poll();
            if (task == null) {
                return true;
            }
        }
    }

    @Override
    public void execute(Runnable task) {
        addTask(task);
        startThread();
    }

    /**
     * 开启线程执行(判断已启动过不再启动)
     */
    private void startThread() {
        // 未启动才能启动，也就是只启动一次
        if (state == ST_NOT_STARTED) {
            // 再次CAS判断避免线程不安全
            if (STATE_UPDATER.compareAndSet(this, ST_NOT_STARTED, ST_STARTED)) {
                doStartThread();
            }
        }
    }

    /**
     * 实际开启线程执行run方法
     */
    private void doStartThread() {
        // 使用真实的执行者执行任务
        executor.execute(() -> {
            // 保存执行的 线程
            thread = Thread.currentThread();
            // 省去乱起八遭的判断
            SingleThreadEventExecutor.this.run();
            // 如果执行结束，则报错
            System.out.println("Buggy EventExecutor implementation; SingleThreadEventExecutor.confirmShutdown() must be called before run() implementation terminates");
        });
    }

    /**
     * 抽象run方法，是一个不能运行结束的方法(除非手动关闭)，即loop
     */
    protected abstract void run();

}