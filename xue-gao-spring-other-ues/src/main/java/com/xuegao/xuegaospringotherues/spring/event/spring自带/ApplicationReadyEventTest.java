package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyEventTest implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger log = LoggerFactory.getLogger(ApplicationReadyEventTest.class);

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][ApplicationReadyEventTest][onApplicationEvent][event=" + event);
    }

}

