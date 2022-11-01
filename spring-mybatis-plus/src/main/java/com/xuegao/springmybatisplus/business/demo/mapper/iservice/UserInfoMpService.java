package com.xuegao.springmybatisplus.business.demo.mapper.iservice;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuegao.springmybatisplus.business.demo.mapper.mapeer.UserInfoMapper;
import com.xuegao.springmybatisplus.doo.demo.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserInfoMpService extends ServiceImpl<UserInfoMapper, UserInfo> {
}
