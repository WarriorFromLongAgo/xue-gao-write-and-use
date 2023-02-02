package com.xuegao.testdynamictp.config;

import com.dtp.core.support.DynamicTp;
import com.dtp.core.support.ThreadPoolBuilder;
import com.dtp.core.support.ThreadPoolCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class DtpConfig {

    /**
     * 通过{@link DynamicTp} 注解定义普通juc线程池，会享受到该框架监控功能，注解名称优先级高于方法名
     *
     * @return 线程池实例
     */
    // @DynamicTp("commonExecutor")
    // @Bean
    // public ThreadPoolExecutor commonExecutor() {
    //     return (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
    // }

    /**
     * 通过{@link ThreadPoolCreator} 快速创建一些简单配置的动态线程池
     * tips: 建议直接在配置中心配置就行，不用@Bean声明
     *
     * @return 线程池实例
     */
    // @Bean
    // public DtpExecutor dtpExecutor1() {
    //     return ThreadPoolCreator.createDynamicFast("dtpExecutor1");
    // }

    /**
     * 通过{@link ThreadPoolBuilder} 设置详细参数创建动态线程池（推荐方式），
     * ioIntensive，参考tomcat线程池设计，实现了处理io密集型任务的线程池，具体参数可以看代码注释
     *
     * tips: 建议直接在配置中心配置就行，不用@Bean声明
     * @return 线程池实例
     */
    // @Bean
    // public DtpExecutor ioIntensiveExecutor() {
    //     return ThreadPoolBuilder.newBuilder()
    //             .threadPoolName("ioIntensiveExecutor")
    //             .corePoolSize(20)
    //             .maximumPoolSize(50)
    //             .queueCapacity(2048)
    //             .ioIntensive(true)
    //             .buildDynamic();
    // }

    /**
     * tips: 建议直接在配置中心配置就行，不用@Bean声明
     * @return 线程池实例
     */
    // @Bean
    // public ThreadPoolExecutor dtpExecutor2() {
    //     return ThreadPoolBuilder.newBuilder()
    //             .threadPoolName("xuegao-dtpExecutor")
    //             .corePoolSize(1)
    //             .maximumPoolSize(2)
    //             .keepAliveTime(60)
    //             .timeUnit(TimeUnit.MINUTES)
    //             .workQueue(QueueTypeEnum.ARRAY_BLOCKING_QUEUE.getName(), 1, false)
    //             .waitForTasksToCompleteOnShutdown(true)
    //             .awaitTerminationSeconds(5)
    //             .buildDynamic();
    // }

    /**
     * tips: 建议直接在配置中心配置就行，不用@Bean声明
     * @return 线程池实例
     */
    // @Bean
    // public ThreadPoolExecutor afterExecute() {
    //     return ThreadPoolBuilder.newBuilder()
    //             .threadPoolName("xuegao-dtpExecutor")
    //             .corePoolSize(1)
    //             .maximumPoolSize(2)
    //             .keepAliveTime(60)
    //             .runTimeout(10)
    //             .timeUnit(TimeUnit.MINUTES)
    //             .workQueue(QueueTypeEnum.ARRAY_BLOCKING_QUEUE.getName(), 1, false)
    //             .waitForTasksToCompleteOnShutdown(true)
    //             .awaitTerminationSeconds(5)
    //             .buildDynamic();
    // }

    @Bean("myAsyncTaskExecutor")
    public AsyncTaskExecutor afterExecute() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        return threadPoolTaskExecutor;
    }
}
