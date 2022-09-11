package com.xuegao.feignclient.call.feignserver2;

import com.xuegao.JsonUtil;
import com.xuegao.feignserver.business.service.InnerService;
import com.xuegao.model.vo.TestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// @Import(InnerService.class)
public class FeignInnerCall {
    private static final Logger log = LoggerFactory.getLogger(FeignInnerCall.class);

    @Autowired
    private InnerService innerService;

    public TestResponse test1() {
        TestResponse response = innerService.test1();
        log.info("[xue-gao-write-and-use][feignclient][FeignInnerCall][test1][={}]", JsonUtil.toJsonString(response));
        return response;
    }

}
