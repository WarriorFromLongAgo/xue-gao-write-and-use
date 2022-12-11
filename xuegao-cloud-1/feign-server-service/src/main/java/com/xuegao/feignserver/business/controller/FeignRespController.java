package com.xuegao.feignserver.business.controller;

import com.xuegao.core.model.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignRespController {
    @Value("${server.port:0}")
    private String serverPort;

    @Value("${spring.application.name:0}")
    private String applicationName;

    @RequestMapping(path = "/feignResp/test1", method = RequestMethod.POST)
    public Result<String> feignRespTest1() {
        return Result.success("[feignserver][" + serverPort + "][" + applicationName + "]");
    }
}
