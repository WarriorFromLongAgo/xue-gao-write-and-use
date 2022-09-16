package com.xuegao.feignclient.schedule;

import com.alipay.sofa.tracer.plugin.flexible.annotations.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule1 {
    private static final Logger log = LoggerFactory.getLogger(Schedule1.class);

    @Tracer
    @Scheduled(cron = " 0/3 * * * * ? ")
    public void ada() {
        log.info("[xue-gao-write-and-use][Schedule1][ada][11111111111]");
        log.info("[xue-gao-write-and-use][Schedule1][ada][11111111111]");
    }

}
