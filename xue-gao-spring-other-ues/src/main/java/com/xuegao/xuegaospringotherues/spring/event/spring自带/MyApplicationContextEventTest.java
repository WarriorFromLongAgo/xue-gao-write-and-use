package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContextEventTest implements ApplicationListener<MyApplicationContextEventTest.MyApplicationContextEvent> {
    private static final Logger log = LoggerFactory.getLogger(MyApplicationContextEventTest.class);

    @Override
    public void onApplicationEvent(MyApplicationContextEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][MyApplicationContextEventTest][onApplicationEvent][event=" + JSON.toJSONString(event));
    }

    @Getter
    @Setter
    public static class MyApplicationContextEvent extends ApplicationContextEvent {
        private String name;

        public MyApplicationContextEvent(ApplicationContext source, String name) {
            super(source);
            this.name = name;
        }
    }
}
