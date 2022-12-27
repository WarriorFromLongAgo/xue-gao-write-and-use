package com.xuegao.thread;

import com.xuegao.reject.RejectHandlerGetter;
import com.xuegao.support.runnable.DtpRunnable;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.*;

@Getter
@Setter
public class DtExecutor extends ThreadPoolExecutor {

    protected String threadPoolName;

    /**
     * RejectHandler name.
     */
    private String rejectHandlerName;

    /**
     * Task execute timeout, unit (ms), just for statistics.
     */
    private long runTimeout;

    /**
     * Task queue wait timeout, unit (ms), just for statistics.
     */
    private long queueTimeout;

    public DtExecutor(int corePoolSize,
                      int maximumPoolSize,
                      long keepAliveTime,
                      TimeUnit unit,
                      BlockingQueue<Runnable> workQueue,
                      ThreadFactory threadFactory,
                      RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        this.rejectHandlerName = handler.getClass().getSimpleName();
        setRejectedExecutionHandler(RejectHandlerGetter.getProxy(handler));
    }

    @Override
    public void execute(Runnable command) {
        String taskName = null;
        if (runTimeout > 0 || queueTimeout > 0) {
            command = new DtpRunnable(command, taskName);
        }
        super.execute(command);
    }

    /**
     * 提交任务前，进行调用
     * beforeExecute
     *
     * @param t:
     * @param r:
     * @author xuegao
     * @date 2022/12/27 20:00
     */
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        if (!(r instanceof DtpRunnable)) {
            super.beforeExecute(t, r);
            return;
        }
        DtpRunnable runnable = (DtpRunnable) r;
        long currTime = System.currentTimeMillis();
        if (runTimeout > 0) {
            runnable.setStartTime(currTime);
        }
        if (queueTimeout > 0) {
            long waitTime = currTime - runnable.getSubmitTime();
            if (waitTime > queueTimeout) {
                System.out.println(" ================ queueTimeoutCount ================ ");
            }
        }

        super.beforeExecute(t, r);
    }

    /**
     * 任务执行完成后，进行调用
     * afterExecute
     *
     * @param r:
     * @param t:
     * @author xuegao
     * @date 2022/12/27 20:00
     */
    @Override
    protected void afterExecute(Runnable r, Throwable t) {

        if (runTimeout > 0) {
            DtpRunnable runnable = (DtpRunnable) r;
            long runTime = System.currentTimeMillis() - runnable.getStartTime();
            if (runTime > runTimeout) {
                System.out.println(" ================ runTimeoutCount ================ ");
            }
        }
        super.afterExecute(r, t);
    }


}
