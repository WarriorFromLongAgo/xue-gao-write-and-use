package com.xuegao.springmybatisplus.business.demo.service;

import com.xuegao.springmybatisplus.business.demo.manage.UserInfoManage;
import com.xuegao.springmybatisplus.doo.demo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoManage userInfoManage;

    public List<UserInfo> list() {
        return userInfoManage.list();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public List<UserInfo> insert() {
        return userInfoManage.insert();
    }
}
