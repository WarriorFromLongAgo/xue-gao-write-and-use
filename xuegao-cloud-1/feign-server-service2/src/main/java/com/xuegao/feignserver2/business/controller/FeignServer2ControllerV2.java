package com.xuegao.feignserver2.business.controller;

import com.xuegao.RespUtil;
import com.xuegao.feignserver2.business.remote.FeignServer2RemoteV2;
import com.xuegao.model.dto.TestRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignServer2ControllerV2 implements FeignServer2RemoteV2 {
    @Value("${server.port:0}")
    private String serverPort;

    @Value("${spring.application.name:0}")
    private String applicationName;

    @Override
    public RespUtil<String> test1(@RequestBody TestRequest request) {
        return RespUtil.success("[FeignServer2ControllerV2][" + serverPort + "][" + applicationName + "]");
    }

}
