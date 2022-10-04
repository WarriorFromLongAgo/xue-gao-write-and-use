package com.xuegao.xuegaospringotherues.spring.event.自己Diy;

import com.alibaba.fastjson2.JSON;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationStartingEventTest implements ApplicationListener<MyApplicationStartingEventTest.MyApplicationStartingEvent> {
    private static final Logger log = LoggerFactory.getLogger(MyApplicationStartingEventTest.class);

    @Override
    public void onApplicationEvent(MyApplicationStartingEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][MyApplicationStartingEventTest][onApplicationEvent][event=" + JSON.toJSONString(event));
    }

    @Getter
    @Setter
    public static class MyApplicationStartingEvent extends ApplicationStartingEvent {

        private String name;

        /**
         * Create a new {@link ApplicationStartingEvent} instance.
         *
         * @param application the current application
         * @param args        the arguments the application is running with
         */
        public MyApplicationStartingEvent(SpringApplication application, String[] args, String name) {
            super(application, args);
            this.name = name;
        }
    }
}

