package com.xuegao.feignclient.call.feignserver;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "vue-learn-noEureka", url = "127.0.0.1:8888")
public interface VueLearnNoEurekaCall {

    @GetMapping("/im/login")
    JSONObject get1();
}
