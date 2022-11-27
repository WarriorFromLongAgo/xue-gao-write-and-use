package com.xuegao.mybatispgsql.business.test.controller;

import com.xuegao.mybatispgsql.common.test.model.TempUserInfoV2;
import com.xuegao.mybatispgsql.business.test.mapper.TempUserInfoV2Mapper;
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
    public void batchInsert(@RequestBody List<TempUserInfoV2> tempUserInfoV2List) {
        log.info("[xue-gao-write-and-use][TempUserInfoV2Controller][batchInsert][1={}]", JsonUtil.toJsonString(tempUserInfoV2List));
        tempUserInfoV2Mapper.batchInsert(tempUserInfoV2List);
        log.info("[xue-gao-write-and-use][TempUserInfoV2Controller][batchInsert][2={}]", JsonUtil.toJsonString(tempUserInfoV2List));
    }

    @PostMapping(path = "/tempUserInfoV2/selectByInput")
    public void selectByInput() {
        List<TempUserInfoV2> tempUserInfoV2List = tempUserInfoV2Mapper.selectByInput();
        log.info("[xue-gao-write-and-use][TempUserInfoV2Controller][selectByInput][2={}]", JsonUtil.toJsonString(tempUserInfoV2List));
    }

    @PostMapping(path = "/tempUserInfoV2/updatePassword")
    public void updatePassword(@RequestBody TempUserInfoV2 tempUserInfoV2) {
        log.info("[xue-gao-write-and-use][TempUserInfoV2Controller][updatePassword][1={}]", JsonUtil.toJsonString(tempUserInfoV2));
        tempUserInfoV2Mapper.updatePassword(tempUserInfoV2);
        log.info("[xue-gao-write-and-use][TempUserInfoV2Controller][updatePassword][2={}]", JsonUtil.toJsonString(tempUserInfoV2));
    }
}
