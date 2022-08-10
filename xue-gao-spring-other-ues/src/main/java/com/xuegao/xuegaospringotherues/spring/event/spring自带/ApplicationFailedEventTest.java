package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationFailedEventTest implements ApplicationListener<ApplicationFailedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ApplicationFailedEventTest.class);

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][ApplicationFailedEventTest][onApplicationEvent][event=" + event);
    }

}

