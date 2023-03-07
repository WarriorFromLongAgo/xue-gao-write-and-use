package com.xuegao.springmybatis.business.manual;

import com.xuegao.springmybatis.business.transaction.mapper.TransactionMapper;
import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ManualManage {

    @Autowired
    private TransactionMapper transactionMapper;

    public UserInfo insert() {
        String string = UUID.randomUUID().toString();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(string);
        userInfo.setPassword(string);

        transactionMapper.insert(userInfo);
        return userInfo;
    }
}
