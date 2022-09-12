package com.xuegao.hr.mapper;

import com.xuegao.model.doo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfo> list();

}
