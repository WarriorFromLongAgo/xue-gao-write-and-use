package com.xuegao.refresh.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DtpConfig {

    /**
     * tips: 建议直接在配置中心配置就行，不用@Bean声明
     *
     * @return 线程池实例
     */
    // @Bean
    // public ThreadPoolExecutor dtpExecutor2() {
    //     return ThreadPoolBuilder.newBuilder()
    //             .threadPoolName("thread_num_2")
    //             .buildDynamic();
    // }
}
