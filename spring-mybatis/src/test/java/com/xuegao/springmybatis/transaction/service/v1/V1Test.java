package com.xuegao.springmybatis.transaction.service.v1;

import com.xuegao.springmybatis.business.transaction.service.test1.TransactionServiceV1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class V1Test {
    @Autowired
    private TransactionServiceV1 transactionServiceV1;

    @Test
    public void insert() {
        transactionServiceV1.v1();
    }
}
