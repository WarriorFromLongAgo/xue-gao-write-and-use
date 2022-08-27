package com.xuegao.springmybatis.demo;

import com.xuegao.JsonUtil;
import com.xuegao.springmybatis.business.demo.controller.UserInfoController;
import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoControllerTest {
    private static final Logger log = LoggerFactory.getLogger(UserInfoControllerTest.class);

    @Autowired
    private UserInfoController userInfoController;

    @Test
    public void insert() {
        Integer insert = userInfoController.insert();
        log.info("[xue-gao-write-and-use][UserInfoControllerTest][insert][insert={}]", JsonUtil.toJsonString(insert));
    }

    @Test
    public void disable() {
        Integer insert = userInfoController.disable();
        log.info("[xue-gao-write-and-use][UserInfoControllerTest][insert][disable={}]", JsonUtil.toJsonString(insert));
    }

    @Test
    public void update() {
        Integer insert = userInfoController.update();
        log.info("[xue-gao-write-and-use][UserInfoControllerTest][insert][update={}]", JsonUtil.toJsonString(insert));
    }

    @Test
    public void list() {
        List<UserInfo> list = userInfoController.list();
        log.info("[xue-gao-write-and-use][UserInfoControllerTest][list][list={}]", JsonUtil.toJsonString(list));
    }

    @Test
    public void batchInsert() {
        List<UserInfo> list = userInfoController.batchInsert();
        log.info("[xue-gao-write-and-use][UserInfoControllerTest][batchInsert][list={}]", JsonUtil.toJsonString(list));
    }

    @Test
    public void batchUpdate() {
        Integer integer = userInfoController.batchUpdate();
        log.info("[xue-gao-write-and-use][UserInfoControllerTest][list][integer={}]", JsonUtil.toJsonString(integer));
    }

}
