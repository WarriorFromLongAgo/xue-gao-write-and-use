package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartingEventTest implements ApplicationListener<ApplicationStartingEvent> {
    private static final Logger log = LoggerFactory.getLogger(ApplicationStartingEventTest.class);

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][ApplicationStartingEventTest][onApplicationEvent][event=" + event);
    }

}

