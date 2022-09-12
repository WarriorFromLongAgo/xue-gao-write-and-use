package com.xuegao.springlog.controller;

import com.xuegao.springlog.feign.FeignServerLogCall;
import com.xuegao.springlog.mapper.UserInfoMapper;
import com.xuegao.springlog.service.RestTemplateService;
import com.xuegao.springlog.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    @Value("${server.port:0}")
    private String serverPort;

    @Value("${spring.application.name:0}")
    private String applicationName;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Autowired
    private TestService testService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RestTemplateService restTemplateService;

    @Autowired
    private FeignServerLogCall feignServerLogCall;

    @RequestMapping(path = "/test/get")
    public String testGet() {
        if (log.isDebugEnabled()) {
            log.debug("[debug][spring-log][TestController][testGet]");
        } else {
            log.info("[info][spring-log][TestController][testGet]");
        }
        testService.test1();
        userInfoMapper.list();
        restTemplateService.getCrmTestGet();
        feignServerLogCall.logTest1();

        return "testGet";
    }

    @RequestMapping(path = "/test/get1")
    public String get1() {
        log.info("[spring-log][TestController][get1][serverPort={}][applicationName={}]", serverPort, applicationName);
        return "hello this is " + applicationName + ", port = " + serverPort;
    }

    @RequestMapping(path = "/test/throwException")
    public String throwException() {
        log.info("[spring-log][TestController][throwException][serverPort={}][applicationName={}]", serverPort, applicationName);
        if (atomicInteger.getAndIncrement() == 0) {
            return "hello this is " + applicationName + ", port = " + serverPort;
        } else {
            throw new RuntimeException("111");
        }
    }
}
