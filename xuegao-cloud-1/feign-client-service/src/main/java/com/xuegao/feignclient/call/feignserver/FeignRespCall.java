package com.xuegao.feignclient.call.feignserver;

import com.xuegao.feignclient.call.feignserver.impl.FeignRespCallFallBack;
import com.xuegao.feignclient.config.feign.FeignRespConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "feign-server-service", contextId = "FeignRespCall", fallback = FeignRespCallFallBack.class, configuration = FeignRespConfig.class)
public interface FeignRespCall {

    // @RequestMapping(path = "/feignResp/test1", method = RequestMethod.POST)
    // RespUtil<String> feignRespTest1();

    /**
     * FeignRespConfig 加了配置文件之后就变了
     * feignRespTest1
     *
     * @return com.xuegao.RespUtil<java.lang.String>
     * @author xuegao
     * @date 2022/9/11 16:34
     */
    @RequestMapping(path = "/feignResp/test1", method = RequestMethod.POST)
    String feignRespTest1();
}
