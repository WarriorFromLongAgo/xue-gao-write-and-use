package com.xuegao.refresh.notify;

import com.dtp.common.ApplicationContextHolder;
import com.dtp.common.dto.DtpMainProp;
import com.dtp.common.dto.NotifyPlatform;
import com.dtp.common.em.NotifyItemEnum;
import com.dtp.core.notify.AbstractDtpNotifier;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.xuegao.refresh.common.XueGaoConstant.Notify.NOTIFY_XUE_GAO_PUSH_DEER;

@Service
public class DtpPushDeerNotifier extends AbstractDtpNotifier {
    private static final Logger log = LoggerFactory.getLogger(DtpPushDeerNotifier.class);

    public DtpPushDeerNotifier() {
        super(ApplicationContextHolder.getBean(PushDeerNotifier.class));
    }

    @Override
    public String platform() {
        return NOTIFY_XUE_GAO_PUSH_DEER.toLowerCase();
    }

    @Override
    protected String getNoticeTemplate() {
        return null;
    }

    @Override
    protected String getAlarmTemplate() {
        return null;
    }

    @Override
    protected Pair<String, String> getColors() {
        return null;
    }

    @Override
    protected String buildAlarmContent(NotifyPlatform platform, NotifyItemEnum notifyItemEnum) {
        log.info("[xue-gao-write-and-use][DtpPushDeerNotifier][buildAlarmContent][]");
        return "aaaaaaaaaaaaaaaaaaaaaaaaa";
    }

    @Override
    protected String buildNoticeContent(NotifyPlatform platform, DtpMainProp oldProp, List<String> diffs) {
        log.info("[xue-gao-write-and-use][DtpPushDeerNotifier][buildNoticeContent][]");
        return "bbbbbbbbbbbbbbbbbbbbbbbbb";
    }
}
