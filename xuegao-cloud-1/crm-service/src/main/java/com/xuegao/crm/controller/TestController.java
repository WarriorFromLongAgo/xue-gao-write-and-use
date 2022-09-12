package com.xuegao.crm.controller;

import com.xuegao.crm.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private RestTemplateService restTemplateService;

    @RequestMapping(path = "/test/get")
    public String get() {
        log.info("[xue-gao-write-and-use][TestController][get]");
        restTemplateService.getHrTestGet();
        return "hello this is " + applicationName + ", port = " + serverPort;
    }

}
