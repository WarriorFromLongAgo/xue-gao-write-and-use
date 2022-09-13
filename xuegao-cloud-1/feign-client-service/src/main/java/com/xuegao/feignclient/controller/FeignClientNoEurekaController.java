package com.xuegao.feignclient.controller;

import com.xuegao.feignclient.call.feignserver.FeignNoEurekaCall;
import com.xuegao.model.dto.TestRequest;
import com.xuegao.model.vo.TestResponse;
import com.xuegao.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class FeignClientNoEurekaController {
    private static final Logger log = LoggerFactory.getLogger(FeignClientNoEurekaController.class);

    @Value("${server.port:0}")
    private String serverPort;

    @Value("${spring.application.name:0}")
    private String applicationName;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

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

    @RequestMapping(path = "/test/throwException")
    public String throwException() {
        log.info("[xue-gao-write-and-use][FeignClientNoEurekaController][throwException][serverPort={}][applicationName={}]", serverPort, applicationName);
        if (atomicInteger.getAndIncrement() == 0) {
            return "hello this is " + applicationName + ", port = " + serverPort;
        } else {
            throw new RuntimeException("111");
        }
    }
}
