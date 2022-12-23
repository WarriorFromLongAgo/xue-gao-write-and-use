package com.xuegao.refresh.call.call;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * pushDeer 官方
 */
@FeignClient(name = "xuegao-remind", url = "http://127.0.0.1:10000/", fallback = RemindCallFallBack.class)
public interface RemindCall {

    @RequestMapping(path = "/xuegao/pushText", method = RequestMethod.POST)
    Object pushText(@RequestParam(name = "text") String text);

}