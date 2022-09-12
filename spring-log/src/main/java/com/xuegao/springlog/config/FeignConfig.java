package com.xuegao.springlog.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }

    @Bean
    @ConditionalOnMissingBean
    public Retryer feignRetryer() {
        //代表永远不重试
        // return Retryer.NEVER_RETRY;
        return new Retryer.Default();
    }

}