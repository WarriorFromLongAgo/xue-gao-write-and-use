package com.xuegao.feignclient.call.feignserver;

import com.xuegao.RespUtil;
import com.xuegao.feignclient.call.feignserver.impl.FeignRespCallFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "feign-server-service", contextId = "FeignRespCall", fallback = FeignRespCallFallBack.class)
public interface FeignRespCall {

    @RequestMapping(path = "/feignResp/test1", method = RequestMethod.POST)
    RespUtil<String> feignRespTest1();
}
