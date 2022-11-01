package com.xuegao.springmybatisplus.business.demo.manage;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.xuegao.springmybatisplus.business.demo.mapper.iservice.UserInfoMpService;
import com.xuegao.springmybatisplus.business.demo.mapper.mapeer.UserInfoMapper;
import com.xuegao.springmybatisplus.doo.demo.UserInfo;
import com.xuegao.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoManage {
    private static final Logger log = LoggerFactory.getLogger(UserInfoManage.class);

    @Autowired
    private UserInfoMpService userInfoMpService;

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> list() {
        List<UserInfo> list1 = userInfoMpService.list();
        log.info("[xue-gao-write-and-use][UserInfoManage][list][list1={}]", JsonUtil.toJsonString(list1));

        List<UserInfo> list2 = userInfoMpService.lambdaQuery().list();
        log.info("[xue-gao-write-and-use][UserInfoManage][list][list2={}]", JsonUtil.toJsonString(list2));

        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        List<UserInfo> list3 = userInfoMapper.selectList(queryWrapper);
        log.info("[xue-gao-write-and-use][UserInfoManage][list][list3={}]", JsonUtil.toJsonString(list3));

        // LambdaQueryWrapper<Object> lambda = Wrappers.query().lambda();
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = Wrappers.lambdaQuery();
        List<UserInfo> list4 = userInfoMapper.selectList(lambdaQueryWrapper);
        log.info("[xue-gao-write-and-use][UserInfoManage][list][list4={}]", JsonUtil.toJsonString(list4));

        List<UserInfo> list5 = new LambdaQueryChainWrapper<>(userInfoMapper).list();
        log.info("[xue-gao-write-and-use][UserInfoManage][list][list5={}]", JsonUtil.toJsonString(list5));

        return list5;
    }

    public List<UserInfo> insert() {
        List<UserInfo> userInfoList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            // userInfo.setId(i);
            userInfo.setUsername(String.valueOf(i));
            userInfo.setPassword(String.valueOf(i));
            userInfoList.add(userInfo);
        }
        userInfoMpService.saveBatch(userInfoList);
        return userInfoList;
    }
}
