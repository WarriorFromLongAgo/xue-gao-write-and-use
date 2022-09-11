package com.xuegao.feignserver.business.controller;

import com.google.common.collect.Lists;
import com.xuegao.JsonUtil;
import com.xuegao.feignserver.business.remote.FeignEurekaRemoteController;
import com.xuegao.model.dto.TestRequest;
import com.xuegao.model.vo.TestResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignEurekaController implements FeignEurekaRemoteController {
    private static final Logger log = LoggerFactory.getLogger(FeignEurekaController.class);

    @Value("${server.port:0}")
    private String serverPort;

    @Value("${spring.application.name:0}")
    private String applicationName;

    @Override
    public TestResponse test1(@RequestBody TestRequest request) {
        log.info("[xue-gao-write-and-use][feignserver][FeignEurekaController][test1][request={}]", JsonUtil.toJsonString(request));
        String name = request.getName();
        name = name + "-[feignserver/feignEureka/test1]-";

        List<String> infoList = request.getInfoList();
        if (ObjectUtils.isEmpty(infoList)) {
            infoList = Lists.newArrayList();
        }
        infoList.add(serverPort + "===" + applicationName);

        TestResponse response = new TestResponse();
        response.setName(name);
        response.setInfoList(infoList);
        return response;
    }

}
