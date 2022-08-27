package com.xuegao.springmybatis.business.demo.mapper;

import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    Integer insert(UserInfo userInfo);

    Integer disable(UserInfo userInfo);

    Integer update(UserInfo userInfo);

    List<UserInfo> list();

    Integer batchInsert(@Param("userInfoList") List<UserInfo> userInfoList);

    Integer batchUpdate(@Param("userInfoList") List<UserInfo> userInfoList);
}
