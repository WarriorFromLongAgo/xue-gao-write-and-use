package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextStoppedEventTest implements ApplicationListener<ContextStoppedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ContextStoppedEventTest.class);

    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][ContextStoppedEventTest][onApplicationEvent][event=" + event);
    }
}
