package com.xuegao.feignclient.call.feignserver.impl;

import com.xuegao.util.RespUtil;
import com.xuegao.feignclient.call.feignserver.FeignEurekaCall;
import com.xuegao.model.dto.TestRequest;
import com.xuegao.model.vo.TestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignEurekaCallFallBack implements FeignEurekaCall {
    private static final Logger log = LoggerFactory.getLogger(FeignEurekaCallFallBack.class);

    @Override
    public TestResponse test1(TestRequest request) {
        log.info("[xue-gao-write-and-use][FeignEurekaCallFallBack][test1][---]");
        return null;
    }

    @Override
    public RespUtil<String> feignRespTest1() {
        log.info("[xue-gao-write-and-use][FeignEurekaCallFallBack][feignRespTest1][--------]");
        return null;
    }
}
