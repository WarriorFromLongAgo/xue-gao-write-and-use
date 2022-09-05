package com.xuegao.springmybatis.batch;

import com.google.common.collect.Lists;
import com.xuegao.springmybatis.business.batch.mapper.BatchUserInfoMapper;
import com.xuegao.springmybatis.business.batch.service.BatchUserInfoService;
import com.xuegao.springmybatis.model.demo.doo.UserInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchServiceTest5000 {
    private final List<UserInfo> USER_INFO_LIST = new ArrayList<>(5000);
    private long START_1 = System.currentTimeMillis();
    private long START_2 = System.currentTimeMillis();
    private long START_3 = System.currentTimeMillis();
    @Autowired
    private BatchUserInfoService batchUserInfoService;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Before
    public void runBeforeTestMethod() {
        System.out.println("------------------------------");
        START_1 = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        for (int i = 0; i < 5000; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(i);
            userInfo.setUsername(uuid);
            userInfo.setPassword(uuid);
            USER_INFO_LIST.add(userInfo);
        }
        START_2 = System.currentTimeMillis();
        System.out.println("--------------初始化完成--" + (START_2 - START_1) + " ---------------");
    }

    // @Test
    public void batchSql500() {
        batchUserInfoService.batchInsert(USER_INFO_LIST, 500);
        // ------------------------------
        // --------------初始化完成--457 ---------------
        // -------------流程结束--2025 ---------------

        // ------------------------------
        // --------------初始化完成--419 ---------------
        // -------------流程结束--1797 ---------------

        // ------------------------------
        // --------------初始化完成--428 ---------------
        // -------------流程结束--1838 ---------------
    }

    // @Test
    public void batchSql2000() {
        batchUserInfoService.batchInsert(USER_INFO_LIST, 2000);
        // ------------------------------
        // --------------初始化完成--468 ---------------
        // -------------流程结束--4272 ---------------

        // ------------------------------
        // --------------初始化完成--443 ---------------
        // -------------流程结束--4701 ---------------

        // ------------------------------
        // --------------初始化完成--437 ---------------
        // -------------流程结束--4058 ---------------
    }

    // @Test
    public void batchSql5000() {
        batchUserInfoService.batchInsert(USER_INFO_LIST, 5000);
        // ------------------------------
        // --------------初始化完成--477 ---------------
        // -------------流程结束--12032 ---------------

        // ------------------------------
        // --------------初始化完成--402 ---------------
        // -------------流程结束--10931 ---------------

        // ------------------------------
        // --------------初始化完成--408 ---------------
        // -------------流程结束--10875 ---------------
    }

    // @Test
    public void sqlSession500() {
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        BatchUserInfoMapper batchUserInfoMapper = sqlSession.getMapper(BatchUserInfoMapper.class);
        if (ObjectUtils.isEmpty(USER_INFO_LIST)) {
            return;
        }
        List<List<UserInfo>> partition = Lists.partition(USER_INFO_LIST, 500);
        for (List<UserInfo> batchList : partition) {
            batchUserInfoMapper.batchInsert(batchList);
            sqlSession.commit();
        }
        // ------------------------------
        // --------------初始化完成--502 ---------------
        // -------------流程结束--2161 ---------------
        // ------------------------------
        // --------------初始化完成--635 ---------------
        // -------------流程结束--1742 ---------------
        // ------------------------------
        // --------------初始化完成--575 ---------------
        // -------------流程结束--1861 ---------------
    }

    // @Test
    public void sqlSession500_v2() {
        if (ObjectUtils.isEmpty(USER_INFO_LIST)) {
            return;
        }
        List<List<UserInfo>> partition = Lists.partition(USER_INFO_LIST, 500);
        for (List<UserInfo> batchList : partition) {
            SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
            BatchUserInfoMapper batchUserInfoMapper = sqlSession.getMapper(BatchUserInfoMapper.class);
            batchUserInfoMapper.batchInsert(batchList);
            sqlSession.commit();
        }
        // ------------------------------
        // --------------初始化完成--500 ---------------
        // -------------流程结束--1658 ---------------
        // ------------------------------
        // --------------初始化完成--550 ---------------
        // -------------流程结束--1760 ---------------
        // ------------------------------
        // --------------初始化完成--492 ---------------
        // -------------流程结束--1760 ---------------
    }

    // @Test
    public void sqlSession2000() {
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        BatchUserInfoMapper batchUserInfoMapper = sqlSession.getMapper(BatchUserInfoMapper.class);
        if (ObjectUtils.isEmpty(USER_INFO_LIST)) {
            return;
        }
        List<List<UserInfo>> partition = Lists.partition(USER_INFO_LIST, 2000);
        for (List<UserInfo> batchList : partition) {
            batchUserInfoMapper.batchInsert(batchList);
            sqlSession.commit();
        }
        // ------------------------------
        // --------------初始化完成--522 ---------------
        // -------------流程结束--4577 ---------------
        // ------------------------------
        // --------------初始化完成--443 ---------------
        // -------------流程结束--4087 ---------------
        // ------------------------------
        // --------------初始化完成--527 ---------------
        // -------------流程结束--4706 ---------------
    }

    // @Test
    public void sqlSession2000_v2() {
        if (ObjectUtils.isEmpty(USER_INFO_LIST)) {
            return;
        }
        List<List<UserInfo>> partition = Lists.partition(USER_INFO_LIST, 2000);
        for (List<UserInfo> batchList : partition) {
            SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
            BatchUserInfoMapper batchUserInfoMapper = sqlSession.getMapper(BatchUserInfoMapper.class);
            batchUserInfoMapper.batchInsert(batchList);
            sqlSession.commit();
        }
        // ------------------------------
        // --------------初始化完成--530 ---------------
        // -------------流程结束--4944 ---------------
        // ------------------------------
        // --------------初始化完成--522 ---------------
        // -------------流程结束--4440 ---------------
        // ------------------------------
        // --------------初始化完成--527 ---------------
        // -------------流程结束--4545 ---------------
    }

    @Test
    public void sqlSession5000() {
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        BatchUserInfoMapper batchUserInfoMapper = sqlSession.getMapper(BatchUserInfoMapper.class);
        if (ObjectUtils.isEmpty(USER_INFO_LIST)) {
            return;
        }
        List<List<UserInfo>> partition = Lists.partition(USER_INFO_LIST, 5000);
        for (List<UserInfo> batchList : partition) {
            batchUserInfoMapper.batchInsert(batchList);
            sqlSession.commit();
        }
        // ------------------------------
        // --------------初始化完成--415 ---------------
        // -------------流程结束--10308 ---------------
        // ------------------------------
        // --------------初始化完成--535 ---------------
        // -------------流程结束--10278 ---------------
    }

    @After
    public void runAfterTestMethod() {
        START_3 = System.currentTimeMillis();
        System.out.println("-------------流程结束--" + (START_3 - START_2) + " ---------------");
    }
}
