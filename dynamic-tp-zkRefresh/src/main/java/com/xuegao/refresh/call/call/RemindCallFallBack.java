package com.xuegao.refresh.call.call;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RemindCallFallBack implements RemindCall {
    private static final Logger log = LoggerFactory.getLogger(RemindCallFallBack.class);

    @Override
    public Object pushText(String text) {
        log.info("[xue-gao-write-and-use]][RemindCallFallBack][pushText][]");
        return null;
    }
}