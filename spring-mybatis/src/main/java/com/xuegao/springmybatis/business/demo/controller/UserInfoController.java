package com.xuegao.springmybatis.business.demo.controller;

import com.xuegao.springmybatis.business.demo.mapper.UserInfoMapper;
import com.xuegao.springmybatis.business.demo.model.doo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping("/userInfo/list")
    public List<UserInfo> list() {
        return userInfoMapper.list();
    }
}
