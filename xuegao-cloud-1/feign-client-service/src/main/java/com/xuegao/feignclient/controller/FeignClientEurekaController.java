package com.xuegao.feignclient.controller;

import com.xuegao.feignclient.call.feignserver.FeignEurekaCall;
import com.xuegao.model.dto.TestRequest;
import com.xuegao.model.vo.TestResponse;
import com.xuegao.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientEurekaController {
    private static final Logger log = LoggerFactory.getLogger(FeignClientEurekaController.class);

    @Autowired
    private FeignEurekaCall feignEurekaCall;

    @RequestMapping(path = "/feignEureka/test1", method = RequestMethod.GET)
    public TestResponse test1() {
        TestRequest request = new TestRequest();
        request.setName("[feignclientFeignEurekaController]-");
        log.info("[xue-gao-write-and-use][feignclient][FeignEurekaController][test1][={}]", JsonUtil.toJsonString(request));
        TestResponse response = feignEurekaCall.test1(request);
        log.info("[xue-gao-write-and-use][feignclient][FeignEurekaController][test1][={}]", JsonUtil.toJsonString(response));
        return response;
    }
}
