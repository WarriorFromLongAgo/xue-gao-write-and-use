package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPreparedEventTest implements ApplicationListener<ApplicationPreparedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ApplicationPreparedEventTest.class);

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][ApplicationPreparedEventTest][onApplicationEvent][event=" + event);
    }

}

