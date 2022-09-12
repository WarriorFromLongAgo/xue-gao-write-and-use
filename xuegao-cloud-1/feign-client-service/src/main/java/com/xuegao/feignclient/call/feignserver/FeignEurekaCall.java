package com.xuegao.feignclient.call.feignserver;

import com.xuegao.util.RespUtil;
import com.xuegao.model.dto.TestRequest;
import com.xuegao.model.vo.TestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "feign-server-service")
public interface FeignEurekaCall {

    @RequestMapping(path = "/feignEureka/test1")
    TestResponse test1(TestRequest request);

    @RequestMapping(path = "/feignResp/test1", method = RequestMethod.POST)
    RespUtil<String> feignRespTest1();
}
