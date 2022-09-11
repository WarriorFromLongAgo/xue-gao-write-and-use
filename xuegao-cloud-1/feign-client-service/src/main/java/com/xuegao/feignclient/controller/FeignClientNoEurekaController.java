package com.xuegao.feignclient.controller;

import com.xuegao.JsonUtil;
import com.xuegao.feignclient.call.feignserver.FeignNoEurekaCall;
import com.xuegao.model.dto.TestRequest;
import com.xuegao.model.vo.TestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FeignClientNoEurekaController {
    private static final Logger log = LoggerFactory.getLogger(FeignClientNoEurekaController.class);

    @Autowired
    private FeignNoEurekaCall feignNoEurekaCall;

    @RequestMapping(path = "/feignNoEureka/test1", method = RequestMethod.GET)
    public TestResponse test1() {
        TestRequest request = new TestRequest();
        request.setName("[feignclient][FeignNoEurekaController][test1]-------");
        log.info("[xue-gao-write-and-use][FeignNoEurekaController][test1][={}]", JsonUtil.toJsonString(request));
        TestResponse response = feignNoEurekaCall.test1(request);
        log.info("[xue-gao-write-and-use][FeignNoEurekaController][test1][={}]", JsonUtil.toJsonString(response));
        return response;
    }

    @RequestMapping(path = "/feignNoEureka/timeOut", method = RequestMethod.GET)
    public TestResponse timeOut() {
        TestRequest request = new TestRequest();
        request.setName("[feignclient][FeignNoEurekaController][timeOut]-------");
        request.setTimeOut(5L);
        request.setTimeUnit(TimeUnit.SECONDS);
        log.info("[xue-gao-write-and-use][FeignNoEurekaController][timeOut][={}]", JsonUtil.toJsonString(request));
        TestResponse response = feignNoEurekaCall.timeOut(request);
        log.info("[xue-gao-write-and-use][FeignNoEurekaController][timeOut][={}]", JsonUtil.toJsonString(response));
        return response;
    }

}
