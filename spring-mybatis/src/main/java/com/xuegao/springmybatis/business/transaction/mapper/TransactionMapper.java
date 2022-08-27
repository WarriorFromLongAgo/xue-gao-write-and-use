package com.xuegao.springmybatis.business.transaction.mapper;

import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransactionMapper {

    List<UserInfo> list();


}
