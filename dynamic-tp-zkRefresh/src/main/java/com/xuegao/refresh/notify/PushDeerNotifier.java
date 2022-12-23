package com.xuegao.refresh.notify;

import com.dtp.common.dto.NotifyPlatform;
import com.dtp.core.notify.base.Notifier;
import com.xuegao.refresh.call.service.RemindCallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.xuegao.refresh.common.XueGaoConstant.Notify.NOTIFY_XUE_GAO_PUSH_DEER;

@Service
public class PushDeerNotifier implements Notifier {
    private static final Logger log = LoggerFactory.getLogger(PushDeerNotifier.class);

    @Autowired
    RemindCallService remindCallService;

    @Override
    public String platform() {
        return NOTIFY_XUE_GAO_PUSH_DEER.toLowerCase();
    }

    @Override
    public void send(NotifyPlatform platform, String content) {
        log.info("[xue-gao-write-and-use][PushDeerNotifier][send][platform={}]", platform);
        log.info("[xue-gao-write-and-use][PushDeerNotifier][send][content={}]", content);
        remindCallService.pushText(content);
    }
}