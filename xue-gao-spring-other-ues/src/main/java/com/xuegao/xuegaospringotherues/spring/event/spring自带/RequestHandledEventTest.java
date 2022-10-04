package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

@Component
public class RequestHandledEventTest implements ApplicationListener<RequestHandledEvent> {
    private static final Logger log = LoggerFactory.getLogger(RequestHandledEventTest.class);

    @Override
    public void onApplicationEvent(RequestHandledEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][RequestHandledEventTest][onApplicationEvent][event=" + event);
    }
}
