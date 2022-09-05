package com.xuegao.springmybatis.business.batch.mapper;

import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BatchUserInfoMapper {

    Integer batchInsert(@Param("userInfoList") List<UserInfo> userInfoList);
}
