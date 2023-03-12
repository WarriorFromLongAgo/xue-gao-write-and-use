package com.xuegao.testthreadpool.test;

import com.xuegao.core.common.FmkConstant;
import com.xuegao.core.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class FmkThreadController {
    private static final Logger log = LoggerFactory.getLogger(FmkThreadController.class);

    @Autowired
    @Qualifier(FmkConstant.XUEGAO_THREAD_NAME_BEAN)
    private Executor asyncTaskExecutor;

    @GetMapping(path = "/printThreadInfo")
    public Result<String> printThreadInfo() {
        ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) asyncTaskExecutor;
        System.out.println("printThreadInfo: " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" ============================================ ");
        System.out.println("threadName = " + Thread.currentThread().getName());
        System.out.println("CorePoolSize = " + executor.getCorePoolSize());
        System.out.println("MaxPoolSize = " + executor.getMaxPoolSize());
        System.out.println("PoolSize = " + executor.getPoolSize());
        System.out.println("ActiveCount = " + executor.getActiveCount());
        System.out.println("22222222222222222222222222222222222222222222222");
        ThreadPoolExecutor threadPoolExecutor = executor.getThreadPoolExecutor();
        System.out.println("2 CorePoolSize = " + threadPoolExecutor.getCorePoolSize());
        System.out.println("2 MaxPoolSize = " + threadPoolExecutor.getMaximumPoolSize());
        System.out.println("2 PoolSize = " + threadPoolExecutor.getPoolSize());
        System.out.println("2 ActiveCount = " + threadPoolExecutor.getActiveCount());
        System.out.println("2 QueueSize = " + threadPoolExecutor.getQueue().size());
        System.out.println("2 TaskCount = " + threadPoolExecutor.getTaskCount());
        System.out.println("2 CompletedTaskCount = " + threadPoolExecutor.getCompletedTaskCount());
        System.out.println(" ============================================ ");
        return Result.ok("printThreadInfo");
    }

    @GetMapping(path = "/pushTask")
    public Result<String> pushTask() {
        ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) asyncTaskExecutor;
        executor.execute(() -> {
            System.out.println("pushTask threadName = " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return Result.ok("pushTask");
    }

}
