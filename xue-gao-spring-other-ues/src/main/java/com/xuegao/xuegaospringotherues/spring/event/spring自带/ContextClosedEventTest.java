package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextClosedEventTest implements ApplicationListener<ContextClosedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ContextClosedEventTest.class);

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][ContextClosedEventTest][onApplicationEvent][event=" + event);
    }
}
