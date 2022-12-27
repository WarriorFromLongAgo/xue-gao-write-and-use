package com.xuegao.reject;

import com.xuegao.thread.DtExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * RejectedAware related
 *
 * @author yanhom
 * @since 1.0.0
 **/
public interface RejectedAware {

    /**
     * Do sth before reject.
     *
     * @param executor ThreadPoolExecutor instance
     */
    default void beforeReject(ThreadPoolExecutor executor) {
        if (executor instanceof DtExecutor) {
            DtExecutor dtExecutor = (DtExecutor) executor;
            System.out.println(" ====================beforeReject================ ");
        }
    }
}
