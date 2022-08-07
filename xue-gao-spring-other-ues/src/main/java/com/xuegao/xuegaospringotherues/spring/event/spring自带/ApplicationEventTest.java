package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventTest implements ApplicationListener<ApplicationEvent> {
    private static final Logger log = LoggerFactory.getLogger(ApplicationEventTest.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("[xuegao_Spring_Boot_Demo][ApplicationEventTest][onApplicationEvent][event=" + applicationEvent);
    }
}
