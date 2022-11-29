package com.xuegao.mvc.modelview;

import com.xuegao.mvc.model.TestResp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022年11月29日 18:08
 */
@Controller
public class ModelViewController {

    @RequestMapping(path = "/modelView/get", method = {RequestMethod.GET})
    public TestResp getJson() {
        return TestResp.getTestResp();
    }

    @RequestMapping(path = "/modelView/post", method = {RequestMethod.POST})
    public TestResp postJson() {
        return TestResp.getTestResp();
    }
}
