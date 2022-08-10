package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextInitializedEventTest implements ApplicationListener<ApplicationContextInitializedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ApplicationContextInitializedEventTest.class);

    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent event) {
        log.info("[xuegao_Spring_Boot_Demo][ApplicationContextInitializedEventTest][onApplicationEvent][event={}]", event);
    }
}
