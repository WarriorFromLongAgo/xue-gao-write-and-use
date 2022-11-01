package com.xuegao.springmybatis.business.transaction.service.test1;

import com.xuegao.springmybatis.business.transaction.manage.TransactionManage;
import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import com.xuegao.util.JsonUtil;
import com.xuegao.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionServiceV1 {
    private static final Logger log = LoggerFactory.getLogger(TransactionServiceV1.class);

    @Autowired
    private TransactionManage transactionManage;

    // 最外层有一个大事务，，但是在大事务中开启了一个小事务往数据库塞值，在
    //
    // 注解开启一个大事务
    // ————————
    //   |   先查询一次数据，
    //   |
    //   |   request_new，这里面新增一条数据
    //   |
    //   |   再查询一次数据，看事务提交的是否能够查出来
    //   |
    // ————————

    @Transactional(rollbackFor = Exception.class)
    public void v1() {
        List<UserInfo> list = transactionManage.list();
        log.info("[xue-gao-write-and-use][TransactionServiceV1][v1][1={}]", JsonUtil.toJsonString(list));
        TransactionServiceV1 transactionServiceV1 = SpringUtil.getBean(TransactionServiceV1.class);
        transactionServiceV1.insert();
        List<UserInfo> list1 = transactionManage.list();
        log.info("[xue-gao-write-and-use][TransactionServiceV1][v1][2={}]", JsonUtil.toJsonString(list1));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void insert() {
        UserInfo insert = transactionManage.insert();
        log.info("[xue-gao-write-and-use][TransactionServiceV1][insert][={}]", JsonUtil.toJsonString(insert));
    }

    // 第一个 list 返回 null
    // insert 执行完成后数据库就有数据了
    // 但是第二个 list 查询的时候 还是 null，因为是两个事务，是两个session

    // 必须提交事务后，才可以查询到
}
