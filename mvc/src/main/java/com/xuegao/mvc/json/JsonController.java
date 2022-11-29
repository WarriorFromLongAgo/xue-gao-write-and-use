package com.xuegao.mvc.json;

import com.xuegao.mvc.model.TestResp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022年11月29日 18:04
 */
@RestController
public class JsonController {

    @RequestMapping(path = "/json/get", method = {RequestMethod.GET})
    public TestResp getJson() {
        return TestResp.getTestResp();
    }

    @RequestMapping(path = "/json/post", method = {RequestMethod.POST})
    public TestResp postJson() {
        return TestResp.getTestResp();
    }
}
