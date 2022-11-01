package com.xuegao.springmybatis.business.demo.controller;

import com.xuegao.springmybatis.business.demo.mapper.UserInfoMapper;
import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import com.xuegao.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class UserInfoController {
    private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/userInfo/insert")
    public Integer insert() {
        Random random = new Random();
        int nextInt = random.nextInt();

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(String.valueOf(nextInt));
        userInfo.setPassword(String.valueOf(nextInt));

        Integer insert = userInfoMapper.insert(userInfo);
        log.info("[xue-gao-write-and-use][UserInfoController][insert][insert={}]", JsonUtil.toJsonString(insert));
        return userInfo.getId();
    }

    @RequestMapping("/userInfo/disable")
    public Integer disable() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(7);
        Integer insert = userInfoMapper.disable(userInfo);
        log.info("[xue-gao-write-and-use][UserInfoController][insert][disable={}]", JsonUtil.toJsonString(insert));
        return userInfo.getId();
    }

    @RequestMapping("/userInfo/update")
    public Integer update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(7);
        Integer insert = userInfoMapper.update(userInfo);
        log.info("[xue-gao-write-and-use][UserInfoController][insert][update={}]", JsonUtil.toJsonString(insert));
        return userInfo.getId();
    }

    @RequestMapping("/userInfo/list")
    public List<UserInfo> list() {
        return userInfoMapper.list();
    }

    @RequestMapping("/userInfo/batchInsert")
    @Transactional(rollbackFor = Exception.class)
    public List<UserInfo> batchInsert() {

        Random random = new Random();
        int nextInt = random.nextInt();

        List<UserInfo> userInfoList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(String.valueOf(nextInt));
            userInfo.setPassword(String.valueOf(nextInt));
            userInfoList.add(userInfo);
        }
        Integer insert = userInfoMapper.batchInsert(userInfoList);
        log.info("[xue-gao-write-and-use][UserInfoController][insert][insert={}]", JsonUtil.toJsonString(insert));

        return userInfoList;
    }

    @Transactional
    @RequestMapping("/userInfo/batchUpdate")
    public Integer batchUpdate() {
        List<UserInfo> list = list();
        for (UserInfo userInfo : list) {
            userInfo.setPassword("update2");
        }
        return userInfoMapper.batchUpdate(list);
    }
}
