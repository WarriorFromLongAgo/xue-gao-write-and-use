package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 也就是 event
@Component
public class Bean1060_ApplicationListener_Event implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        OnlyPrintUtil.print(getClass(), "ApplicationStartedEvent onApplicationEvent");
    }
}
