package com.xuegao.springlog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private static final Logger log = LoggerFactory.getLogger(TestService.class);

    public void test1() {
        if (log.isDebugEnabled()) {
            log.debug("[debug][xue-gao-write-and-use][TestService][test1]");
        } else {
            log.info("[info][xue-gao-write-and-use][TestService][test1]");
        }
        test11();
    }

    private void test11() {
        log.info("[xue-gao-write-and-use][TestService][test11]");
        test111();
    }

    private void test111() {
        log.info("[xue-gao-write-and-use][TestService][test111]");
    }
}