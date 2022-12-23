package com.xuegao.refresh.call.service;

import com.xuegao.refresh.call.call.RemindCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemindCallService {
    private static final Logger log = LoggerFactory.getLogger(RemindCallService.class);

    @Autowired
    private RemindCall remindCall;

    /**
     * 推送文本消息
     * pushText
     *
     * @param text:
     * @author xuegao
     * @date 2022/12/12 20:57
     */
    public void pushText(String text) {
        Object o = remindCall.pushText(text);
        if (log.isDebugEnabled()) {
            log.info("[chick-remind][RemindCallService][pushText][o={}]", o);
        }
    }

}
