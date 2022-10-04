package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 这个是通用的接收器
 */
@Component
public class ApplicationEventTest implements ApplicationListener<ApplicationEvent> {
    private static final Logger log = LoggerFactory.getLogger(ApplicationEventTest.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("[xuegao_Spring_Boot_Demo][ApplicationEventTest][onApplicationEvent][event=" + applicationEvent);
    }
    // [xuegao_Spring_Boot_Demo][ApplicationEventTest][onApplicationEvent][event=org.springframework.context.event.ContextRefreshedEvent
    //      [source=org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@78b66d36, started on Wed Aug 10 21:27:44 CST 2022]
    // [xuegao_Spring_Boot_Demo][ApplicationEventTest][onApplicationEvent][event=org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent
    //      [source=org.springframework.boot.web.embedded.tomcat.TomcatWebServer@5aa6202e]
    // [xuegao_Spring_Boot_Demo][ApplicationEventTest][onApplicationEvent][event=org.springframework.boot.context.event.ApplicationStartedEvent
    //      [source=org.springframework.boot.SpringApplication@1e7f2e0f]
    // [xuegao_Spring_Boot_Demo][ApplicationEventTest][onApplicationEvent][event=org.springframework.boot.context.event.ApplicationReadyEvent
    //      [source=org.springframework.boot.SpringApplication@1e7f2e0f]
}
