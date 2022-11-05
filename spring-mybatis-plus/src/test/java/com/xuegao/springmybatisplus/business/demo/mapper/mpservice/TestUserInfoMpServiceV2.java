package com.xuegao.springmybatisplus.business.demo.mapper.mpservice;

import com.xuegao.springmybatisplus.doo.demo.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserInfoMpServiceV2 {

    @Autowired
    private UserInfoMpServiceV2 userInfoMpServiceV2;

    @Test
    public void testDisable() {

        // userInfoMpServiceV2.lambdaQuery().
        // userInfoMpServiceV2.lambdaUpdate().update();
        // userInfoMpServiceV2.update(new UserInfo(), Wrappers.lambdaUpdate())
        // userInfoMpServiceV2.lambdaQuery();
        // userInfoMpServiceV2.query();
        // userInfoMpServiceV2.update().in().update();

        // userInfoMpServiceV2.disableService();
    }

    @Test
    public void testDisable2() {


        userInfoMpServiceV2.disableService();
    }

    @Test
    public void testTest() {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(11);
        userInfo.setUsername("setUsername11111");
        userInfo.setPassword("setPassword111111");
        userInfo.setCreateBy("setCreateBy1111111");
        userInfo.setUpdateBy("setUpdateBy1111111");
        userInfoMpServiceV2.test(userInfo);
    }
}
