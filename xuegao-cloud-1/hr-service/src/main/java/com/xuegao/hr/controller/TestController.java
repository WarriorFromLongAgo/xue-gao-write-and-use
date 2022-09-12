package com.xuegao.hr.controller;

import com.xuegao.hr.mapper.UserInfoMapper;
import com.xuegao.hr.service.RestTemplateService;
import com.xuegao.hr.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Value("${server.port:0}")
    private String serverPort;

    @Value("${spring.application.name:0}")
    private String applicationName;

    @Autowired
    private TestService testService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RestTemplateService restTemplateService;

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(path = "/test/get")
    public String get() {
        log.info("[xue-gao-write-and-use][TestController][get][serverPort={}][applicationName={}]", serverPort, applicationName);
        testService.test1();
        userInfoMapper.list();
        restTemplateService.getCrmTestGet();
        return "hello this is " + applicationName + ", port = " + serverPort;
    }

}
