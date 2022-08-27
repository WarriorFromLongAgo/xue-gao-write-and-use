package com.xuegao.springmybatis.business.transaction.service;

import com.xuegao.springmybatis.business.transaction.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceV1 {

    @Autowired
    private TransactionMapper transactionMapper;

    public void v1() {
        transactionMapper.list();

    }


}
