package com.xuegao.springmybatis.business.transaction.controller;

import com.xuegao.springmybatis.business.transaction.service.TransactionService;
import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/transaction/list")
    public List<UserInfo> list() {
        return transactionService.list();
    }

}
