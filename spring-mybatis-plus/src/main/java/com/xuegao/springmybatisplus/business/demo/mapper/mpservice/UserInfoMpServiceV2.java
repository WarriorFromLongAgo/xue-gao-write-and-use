package com.xuegao.springmybatisplus.business.demo.mapper.mpservice;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuegao.mapper.mpservice.AbstractMpServiceV2;
import com.xuegao.springmybatisplus.business.demo.mapper.mapeer.UserInfoMapper;
import com.xuegao.springmybatisplus.doo.demo.UserInfo;
import com.xuegao.util.LocalDateTimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoMpServiceV2 extends AbstractMpServiceV2<UserInfoMapper, UserInfo, Integer> {

    protected UserInfoMpServiceV2(BaseMapper<UserInfo> baseMapper) {
        super(baseMapper);
    }

    public void disableService() {
        mpDisable(1, 2, 3);
    }

    public void mpUpdateService() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("username=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        // userInfo.setPassword("password=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        super.mpUpdate(userInfo);
    }

    public void mpUpdateBatchServiceNoTransactional() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("username11=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        // userInfo.setPassword("password11=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(2);
        userInfo2.setUsername("username22=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        // userInfo2.setPassword("password22=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));

        List<UserInfo> userInfoList = new ArrayList<>(2);
        userInfoList.add(userInfo);
        userInfoList.add(userInfo2);

        super.mpUpdateBatch(userInfoList);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void mpUpdateBatchServiceHaveTransactional() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("username11=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        // userInfo.setPassword("password11=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(2);
        userInfo2.setUsername("username22=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        // userInfo2.setPassword("password22=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));

        List<UserInfo> userInfoList = new ArrayList<>(2);
        userInfoList.add(userInfo);
        userInfoList.add(userInfo2);

        super.mpUpdateBatch(userInfoList);
    }

    public void mpUpdateFilterNullService() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2);
        userInfo.setUsername("username=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        super.mpUpdateFilterNull(userInfo);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void mpUpdateBatchFilterNullServiceHaveTransactional() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("username11=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        // userInfo.setPassword("password11=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(2);
        userInfo2.setUsername("username22=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        // userInfo2.setPassword("password22=" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));

        List<UserInfo> userInfoList = new ArrayList<>(2);
        userInfoList.add(userInfo);
        userInfoList.add(userInfo2);

        super.mpUpdateBatchFilterNull(userInfoList);
    }
}
