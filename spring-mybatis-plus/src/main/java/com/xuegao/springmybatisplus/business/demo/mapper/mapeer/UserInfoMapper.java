package com.xuegao.springmybatisplus.business.demo.mapper.mapeer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuegao.springmybatisplus.doo.demo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
