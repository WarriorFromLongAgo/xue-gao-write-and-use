package com.xuegao.feignclient.call.feignserver;

import com.xuegao.model.dto.TestRequest;
import com.xuegao.model.vo.TestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "feign-server-service-noEureka", url = "127.0.0.1:13000")
public interface FeignNoEurekaCall {

    @RequestMapping(path = "/feignNoEureka/test1")
    TestResponse test1(TestRequest request);

    @RequestMapping(path = "/feignNoEureka/timeOut")
    TestResponse timeOut(TestRequest request);
}
