package com.xuegao.springmybatis.business.demo.mapper;

import com.xuegao.springmybatis.business.demo.model.doo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfo> list();
}
