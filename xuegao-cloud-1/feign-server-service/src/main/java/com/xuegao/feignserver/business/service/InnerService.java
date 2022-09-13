package com.xuegao.feignserver.business.service;

import com.google.common.collect.Lists;
import com.xuegao.model.vo.TestResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InnerService {
    @Value("${server.port:0}")
    private String serverPort;

    @Value("${spring.application.name:0}")
    private String applicationName;

    public TestResponse test1() {
        // 如果是自己的controller调用，通过feign-client等方式，那么配置文件是读取的自己的
        // {"name":null,"infoList":["13000===feign-server-service"]}
        // {"name":null,"infoList":["13001===feign-server-service"]}
        // 如果是其他人通过jar包引入方式，那么配置文件是读取的对方服务的
        // 也就是整个Client+Server包被认为是一个整体
        // {"name":null,"infoList":["14000===feign-client-service"]}
        List<String> infoList = Lists.newArrayList();
        infoList.add(serverPort + "===" + applicationName);

        TestResponse response = new TestResponse();
        response.setInfoList(infoList);
        return response;
    }

}
