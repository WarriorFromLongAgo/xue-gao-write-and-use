package com.xuegao.useagent1.controller;

import com.xuegao.agent.MyAgent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test1")
    public String test1() {
        return "aklsjdkasjkad";
    }

    @RequestMapping("/test2")
    public String test2() {
        long l = MyAgent.sizeOf("");
        return "aklsjdkasjkad";
    }
}
