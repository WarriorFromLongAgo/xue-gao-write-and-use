package com.xuegao.springmybatisplus.business.demo.mapper.iservice;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuegao.mapper.mpservice.AbstractMpService;
import com.xuegao.springmybatisplus.business.demo.mapper.mapeer.UserInfoMapper;

import com.xuegao.springmybatisplus.doo.demo.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserInfoMpService extends AbstractMpService<UserInfoMapper, UserInfo, Integer> {

    protected UserInfoMpService(BaseMapper<UserInfo> baseMapper) {
        super(baseMapper);
    }

    @Override
    public String shardingKey() {
        return null;
    }
}
