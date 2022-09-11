package com.xuegao.feignserver2.business.remote;

import com.xuegao.RespUtil;
import com.xuegao.model.dto.TestRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface FeignServer2Remote {

    @RequestMapping(path = "/feignServer2/test1", method = RequestMethod.POST)
    RespUtil<String> test1(@RequestBody TestRequest request);

}
