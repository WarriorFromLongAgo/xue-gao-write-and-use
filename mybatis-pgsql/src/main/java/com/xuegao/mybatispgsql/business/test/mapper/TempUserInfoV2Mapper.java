package com.xuegao.mybatispgsql.business.test.mapper;

import com.xuegao.mybatispgsql.common.test.model.TempUserInfoV2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022年11月26日 14:13
 */
@Mapper
public interface TempUserInfoV2Mapper {

    Integer batchInsert(@Param("tempUserInfoV2List") List<TempUserInfoV2> tempUserInfoV2List);

    List<TempUserInfoV2> selectByInput();

    Integer updatePassword(@Param("tempUserInfoV2") TempUserInfoV2 tempUserInfoV2);
}
