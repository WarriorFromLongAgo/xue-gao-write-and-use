package com.xuegao.feignserver.business.controller;

import com.google.common.collect.Lists;
import com.xuegao.JsonUtil;
import com.xuegao.model.dto.TestRequest;
import com.xuegao.model.vo.TestResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class FeignNoEurekaController {
    private static final Logger log = LoggerFactory.getLogger(FeignNoEurekaController.class);

    @Value("${server.port:0}")
    private String serverPort;

    @Value("${spring.application.name:0}")
    private String applicationName;

    @RequestMapping(path = "/feignNoEureka/test1", method = RequestMethod.POST)
    public TestResponse test1(@RequestBody TestRequest request) {
        log.info("[xue-gao-write-and-use][feignserver][FeignNoEurekaController][test1][request={}]", JsonUtil.toJsonString(request));
        String name = request.getName();
        name = name + "-[feignserver/feignNoEureka/test1]-";

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

    @RequestMapping(path = "/feignNoEureka/timeOut", method = RequestMethod.POST)
    public TestResponse timeOut(@RequestBody TestRequest request) throws InterruptedException {
        String requestJson = JsonUtil.toJsonString(request);
        log.info("[xue-gao-write-and-use][feignserver][FeignNoEurekaController][timeOut][request={}]", requestJson);
        String name = request.getName();
        name = name + "----[feignserver][FeignNoEurekaController][timeOut]-----";
        request.setName(name);

        Long timeOut = request.getTimeOut();
        TimeUnit timeUnit = request.getTimeUnit();
        timeUnit.sleep(timeOut);

        TestResponse response = new TestResponse();
        List<String> infoList = new ArrayList<>();
        infoList.add(serverPort + "===" + applicationName);
        infoList.add(requestJson);
        response.setInfoList(infoList);
        response.setName(name);

        log.info("[xue-gao-write-and-use][FeignNoEurekaController][timeOut][resp={}]", JsonUtil.toJsonString(response));
        return response;
    }

}
