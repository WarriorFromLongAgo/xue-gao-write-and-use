package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartedEventTest implements ApplicationListener<ApplicationStartedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ApplicationStartedEventTest.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][ApplicationStartedEventTest][onApplicationEvent][event=" + event);
    }
}

