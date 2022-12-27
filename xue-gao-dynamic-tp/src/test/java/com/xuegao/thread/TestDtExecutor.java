package com.xuegao.thread;

import com.xuegao.common.RejectedTypeEnum;
import com.xuegao.reject.RejectHandlerGetter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestDtExecutor {
    public static void main(String[] args) {
        // testBeforeAndAfterExecute();

        testBeforeReject();
    }

    public static void testBeforeAndAfterExecute() {

        DtExecutor dtExecutor = new DtExecutor(
                1,
                1,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("test-thread");
                    return thread;
                },
                RejectHandlerGetter.getProxy(RejectedTypeEnum.ABORT_POLICY.getName()));

        dtExecutor.execute(() -> {
            System.out.println(" ====================execute================ ");
        });


    }

    public static void testBeforeReject() {
        DtExecutor dtExecutor = new DtExecutor(
                1,
                1,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("test-thread");
                    return thread;
                },
                RejectHandlerGetter.getProxy(RejectedTypeEnum.ABORT_POLICY.getName()));

        for (int i = 0; i < 10; i++) {
            dtExecutor.execute(() -> {
                System.out.println(" ====================execute================ ");
            });
        }

    }
}
