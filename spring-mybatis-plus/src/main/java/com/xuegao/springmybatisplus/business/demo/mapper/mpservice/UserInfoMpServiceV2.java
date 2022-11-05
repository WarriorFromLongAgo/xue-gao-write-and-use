package com.xuegao.springmybatisplus.business.demo.mapper.mpservice;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.springmybatisplus.business.demo.mapper.mapeer.UserInfoMapper;
import com.xuegao.springmybatisplus.doo.demo.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserInfoMpServiceV2 extends AbstractMpServiceV2<UserInfoMapper, UserInfo, Integer> {

    protected UserInfoMpServiceV2(BaseMapper<UserInfo> baseMapper) {
        super(baseMapper);
    }

    public void disableService() {
        mpDisable(1, 2, 3);
    }

}
