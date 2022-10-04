package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextStartedEventTest implements ApplicationListener<ContextStartedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ContextStartedEventTest.class);

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][ContextStartedEventTest][onApplicationEvent][event=" + event);
    }
}
