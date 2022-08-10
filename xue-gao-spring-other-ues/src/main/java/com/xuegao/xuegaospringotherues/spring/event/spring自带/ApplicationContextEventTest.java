package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextEventTest implements ApplicationListener<ApplicationContextEvent> {
    private static final Logger log = LoggerFactory.getLogger(ApplicationContextEventTest.class);

    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][ApplicationContextEventTest][onApplicationEvent][event=" + event);
    }

}
