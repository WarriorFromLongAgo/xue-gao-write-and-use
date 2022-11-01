package com.xuegao.springmybatisplus.business.demo.controller;

import com.xuegao.springmybatisplus.business.demo.service.UserInfoService;
import com.xuegao.springmybatisplus.doo.demo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(path = "/userInfo/list", method = {RequestMethod.POST})
    public List<UserInfo> list() {
        return userInfoService.list();
    }

    @RequestMapping(path = "/userInfo/insert", method = {RequestMethod.POST})
    public List<UserInfo> insert() {
        return userInfoService.insert();
    }
}
