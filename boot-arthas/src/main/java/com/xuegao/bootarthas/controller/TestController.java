package com.xuegao.bootarthas.controller;

import com.xuegao.bootarthas.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test1")
    public String test1() {
        return testService.test1(" TestController");
    }

}
