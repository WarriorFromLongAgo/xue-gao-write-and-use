package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationEventTest implements ApplicationListener<SpringApplicationEvent> {
    private static final Logger log = LoggerFactory.getLogger(SpringApplicationEventTest.class);

    @Override
    public void onApplicationEvent(SpringApplicationEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][SpringApplicationEventTest][onApplicationEvent][event=" + event);
    }
}
