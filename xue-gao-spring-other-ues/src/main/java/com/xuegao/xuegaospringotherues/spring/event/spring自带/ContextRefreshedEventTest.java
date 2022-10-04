package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedEventTest implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ContextRefreshedEventTest.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][ContextRefreshedEventTest][onApplicationEvent][event=" + event);
    }
}
