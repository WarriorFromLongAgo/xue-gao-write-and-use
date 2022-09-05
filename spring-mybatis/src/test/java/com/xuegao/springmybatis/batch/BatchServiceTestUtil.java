package com.xuegao.springmybatis.batch;

import com.xuegao.springmybatis.business.batch.mapper.BatchUserInfoMapper;
import com.xuegao.springmybatis.business.batch.service.BatchInsertUtil;
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
public class BatchServiceTestUtil {
    private final List<UserInfo> USER_INFO_LIST = new ArrayList<>(5000);
    private long START_1 = System.currentTimeMillis();
    private long START_2 = System.currentTimeMillis();
    private long START_3 = System.currentTimeMillis();
    @Autowired
    private BatchUserInfoService batchUserInfoService;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private BatchInsertUtil batchInsertUtil;

    @Before
    public void runBeforeTestMethod() {
        System.out.println("------------------------------");
        START_1 = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        for (int i = 0; i < 2000; i++) {
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
        batchUserInfoService.batchInsertV2(USER_INFO_LIST, 500);
        // ------------------------------
        // --------------初始化完成--429 ---------------
        // -------------流程结束--824 ---------------

    }

    @Test
    public void sqlSession500() {
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        BatchUserInfoMapper batchUserInfoMapper = sqlSession.getMapper(BatchUserInfoMapper.class);
        if (ObjectUtils.isEmpty(USER_INFO_LIST)) {
            return;
        }
        batchInsertUtil.batchSplitInsert(USER_INFO_LIST, 500, batchUserInfoMapper::batchInsert);
        // ------------------------------
        // --------------初始化完成--547 ---------------
        // -------------流程结束--878 ---------------
    }

    @After
    public void runAfterTestMethod() {
        START_3 = System.currentTimeMillis();
        System.out.println("-------------流程结束--" + (START_3 - START_2) + " ---------------");
    }
}
