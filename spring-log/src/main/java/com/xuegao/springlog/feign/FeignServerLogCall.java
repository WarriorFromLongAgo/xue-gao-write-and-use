package com.xuegao.springlog.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "feign-server-log-service", url = "127.0.0.1:8081")
public interface FeignServerLogCall {

    @RequestMapping(path = "/test/get")
    String logTest1();

}