package com.xuegao.springmybatis.business.batch.service;

import com.google.common.collect.Lists;
import com.xuegao.springmybatis.business.batch.mapper.BatchUserInfoMapper;
import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchUserInfoService {

    @Autowired
    private BatchUserInfoMapper batchUserInfoMapper;

    @Autowired
    private BatchInsertUtil batchInsertUtil;

    public void batchInsert(List<UserInfo> userInfoList, int batchSize) {
        if (ObjectUtils.isEmpty(userInfoList)) {
            return;
        }
        List<List<UserInfo>> partition = Lists.partition(userInfoList, batchSize);
        for (List<UserInfo> batchList : partition) {
            batchUserInfoMapper.batchInsert(batchList);
        }
    }

    public void batchInsertV2(List<UserInfo> userInfoList, int batchSize) {
        if (ObjectUtils.isEmpty(userInfoList)) {
            return;
        }
        batchInsertUtil.batchSplitInsert(userInfoList, batchSize, tempList -> batchUserInfoMapper.batchInsert(tempList));
    }
}
