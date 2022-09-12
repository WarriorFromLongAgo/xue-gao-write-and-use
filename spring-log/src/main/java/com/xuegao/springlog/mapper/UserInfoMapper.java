package com.xuegao.springlog.mapper;

import com.xuegao.springlog.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfo> list();

}