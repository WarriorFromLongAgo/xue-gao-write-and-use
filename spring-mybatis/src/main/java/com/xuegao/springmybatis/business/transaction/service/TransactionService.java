package com.xuegao.springmybatis.business.transaction.service;

import com.xuegao.springmybatis.business.transaction.mapper.TransactionMapper;
import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    public List<UserInfo> list() {
        return transactionMapper.list();
    }

    /**
     * 如果最外层调用是有事务的，但是在方法内部直接调用一个private的方法，会有事务吗
     * transaction1
     *
     * @return java.util.List<com.xuegao.springmybatis.model.demo.doo.UserInfo>
     * @author xuegao
     * @date 2022/11/1 19:29
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public List<UserInfo> transaction1() {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(1);
        userInfo1.setUsername(String.valueOf(1));
        userInfo1.setPassword(String.valueOf(1));
        transactionMapper.insert(userInfo1);
        transaction1_a();
        return transactionMapper.list();
    }

    private void transaction1_a() {
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(2);
        userInfo2.setUsername(String.valueOf(2));
        userInfo2.setPassword(String.valueOf(2));
        transactionMapper.insert(userInfo2);
        int a = 1 / 0;
        UserInfo userInfo3 = new UserInfo();
        userInfo3.setId(2);
        userInfo3.setUsername(String.valueOf(2));
        userInfo3.setPassword(String.valueOf(2));
        transactionMapper.insert(userInfo3);
    }
// Creating a new org.apache.ibatis.session.SqlSession
// Registering transaction synchronization for SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@440bb9b1]
// JDBC Connection [
// HikariProxyConnection@1971302574 wrapping com.mysql.cj.jdbc.ConnectionImpl@7fb4d492] will be managed by Spring
// 2022-11-01 19:37:03.864  WARN 20016 --- [io-10000-exec-4] c.x.s.config.PrintSqlInterceptor         : DAO [com.xuegao.springmybatis.business.transaction.mapper.TransactionMapper.insert]
// [38ms] ===> insert into user_info (`id`, `username`, `password`) values (null, '1', '1')
// Count ===> 1
// Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@440bb9b1]
// Fetched SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@440bb9b1] from current transaction
// 2022-11-01 19:37:13.881  WARN 20016 --- [io-10000-exec-4] c.x.s.config.PrintSqlInterceptor         : DAO [com.xuegao.springmybatis.business.transaction.mapper.TransactionMapper.insert]
// [10ms] ===> insert into user_info (`id`, `username`, `password`) values (null, '2', '2')
// Count ===> 1
// Releasing transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@440bb9b1]
// Transaction synchronization deregistering SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@440bb9b1]
// Transaction synchronization closing SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@440bb9b1]
// 2022-11-01 19:37:18.665 ERROR 20016 --- [io-10000-exec-4] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.ArithmeticException: / by zero] with root cause
//
// java.lang.ArithmeticException: / by zero




}
