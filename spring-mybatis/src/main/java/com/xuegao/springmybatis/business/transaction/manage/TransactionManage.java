package com.xuegao.springmybatis.business.transaction.manage;

import com.xuegao.springmybatis.business.transaction.mapper.TransactionMapper;
import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TransactionManage {

    @Autowired
    private TransactionMapper transactionMapper;

    public List<UserInfo> list() {
        return transactionMapper.list();
    }


    public Integer insert(UserInfo userInfo) {
        return transactionMapper.insert(userInfo);
    }

    public UserInfo insert() {
        String string = UUID.randomUUID().toString();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(string);
        userInfo.setPassword(string);

        transactionMapper.insert(userInfo);
        return userInfo;
    }
}
