package com.xuegao.springmybatis.business.transaction.service;

import com.xuegao.springmybatis.business.transaction.mapper.TransactionMapper;
import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    public List<UserInfo> list() {
        return transactionMapper.list();
    }



}
