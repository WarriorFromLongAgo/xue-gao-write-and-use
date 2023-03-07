package com.xuegao.springmybatis.business.manual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class ManualService {
    private static final Logger log = LoggerFactory.getLogger(ManualService.class);

    @Autowired
    private ManualManage manualManage;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public void insert1() {
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        try {
            manualManage.insert();
            log.info("[xue-gao-write-and-use][ManualService][insert1][1]");
            manualManage.insert();
            log.info("[xue-gao-write-and-use][ManualService][insert1][2]");
            int a = 100 / 0;
            platformTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            log.info("[xue-gao-write-and-use][ManualService][insert1][e]", e);
            platformTransactionManager.rollback(transactionStatus);
        }
    }

    public void insert2() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            public void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    manualManage.insert();
                    log.info("[xue-gao-write-and-use][ManualService][insert2][1]");
                    manualManage.insert();
                    log.info("[xue-gao-write-and-use][ManualService][insert2][2]");
                    int a = 100 / 0;
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }
}
