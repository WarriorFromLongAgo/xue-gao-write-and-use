package com.xuegao.mpluspgsql.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xuegao.mpluspgsql.common.test.model.TempUserInfoV2;
import com.xuegao.mpluspgsql.test.mapper.TempUserInfoV2Mapper;
import com.xuegao.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022年11月26日 14:13
 */
@Slf4j
@RestController
public class TempUserInfoV2Controller {

    @Autowired
    private TempUserInfoV2Mapper tempUserInfoV2Mapper;

    @PostMapping(path = "/tempUserInfoV2/batchInsert")
    public void batchInsert(@RequestBody TempUserInfoV2 tempUserInfoV2) {
        log.info("[xue-gao-write-and-use][TempUserInfoV2Controller][batchInsert][1={}]", JsonUtil.toJsonString(tempUserInfoV2));
        tempUserInfoV2Mapper.insert(tempUserInfoV2);
        log.info("[xue-gao-write-and-use][TempUserInfoV2Controller][batchInsert][2={}]", JsonUtil.toJsonString(tempUserInfoV2));
    }

    @PostMapping(path = "/tempUserInfoV2/selectByInput")
    public void selectByInput() {
        LambdaQueryWrapper<TempUserInfoV2> lambdaQueryWrapper = Wrappers.lambdaQuery();
        List<TempUserInfoV2> tempUserInfoV2List = tempUserInfoV2Mapper.selectList(lambdaQueryWrapper);
        log.info("[xue-gao-write-and-use][TempUserInfoV2Controller][selectByInput][2={}]", JsonUtil.toJsonString(tempUserInfoV2List));
    }

    @PostMapping(path = "/tempUserInfoV2/updatePassword")
    public void updatePassword(@RequestBody TempUserInfoV2 tempUserInfoV2) {
        log.info("[xue-gao-write-and-use][TempUserInfoV2Controller][updatePassword][1={}]", JsonUtil.toJsonString(tempUserInfoV2));
        LambdaUpdateWrapper<TempUserInfoV2> lambdaUpdateWrapper = Wrappers.lambdaUpdate();
        lambdaUpdateWrapper.set(TempUserInfoV2::getPassword, tempUserInfoV2.getPassword());
        lambdaUpdateWrapper.eq(TempUserInfoV2::getId, tempUserInfoV2.getId());
        int update = tempUserInfoV2Mapper.update(null, lambdaUpdateWrapper);
        log.info("[xue-gao-write-and-use][TempUserInfoV2Controller][updatePassword][2={}]", update);
    }
}
