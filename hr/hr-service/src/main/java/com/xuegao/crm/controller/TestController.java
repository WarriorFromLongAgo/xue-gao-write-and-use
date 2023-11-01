package com.xuegao.crm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port:0}")
    private String serverPort;

    @Value("${spring.application.name:0}")
    private String applicationName;

    @RequestMapping(path = "/test/get")
    public String get() {
        return "hello this is " + applicationName + ", port = " + serverPort;
    }

}