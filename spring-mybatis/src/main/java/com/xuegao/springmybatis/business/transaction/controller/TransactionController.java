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

    /** 
     * 如果最外层调用是有事务的，但是在方法内部直接调用一个private的方法，会有事务吗
     * transaction1
     *  
     * 
     * @return java.util.List<com.xuegao.springmybatis.model.demo.doo.UserInfo> 
     * @author xuegao
     * @date 2022/11/1 19:29 
     */
    @RequestMapping("/transaction/insert")
    public List<UserInfo> transaction1() {
        return transactionService.transaction1();
    }
}
