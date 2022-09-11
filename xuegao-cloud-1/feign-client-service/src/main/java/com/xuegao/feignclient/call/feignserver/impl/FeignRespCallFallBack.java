package com.xuegao.feignclient.call.feignserver.impl;

import com.xuegao.feignclient.call.feignserver.FeignRespCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignRespCallFallBack implements FeignRespCall {
    private static final Logger log = LoggerFactory.getLogger(FeignRespCallFallBack.class);

    @Override
    public String feignRespTest1() {
        log.info("[xue-gao-write-and-use][FeignRespCallFallBack][feignRespTest1][--------]");
        return null;
    }
}
