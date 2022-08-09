package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import com.alibaba.fastjson2.JSON;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationReadyEventTest implements ApplicationListener<MyApplicationReadyEventTest.MyApplicationReadyEvent> {
    private static final Logger log = LoggerFactory.getLogger(MyApplicationReadyEventTest.class);

    @Override
    public void onApplicationEvent(MyApplicationReadyEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][MyApplicationReadyEventTest][onApplicationEvent][event=" + JSON.toJSONString(event));
    }

    @Getter
    @Setter
    public static class MyApplicationReadyEvent extends ApplicationReadyEvent {

        private String name;

        /**
         * Create a new {@link ApplicationReadyEvent} instance.
         *
         * @param application the current application
         * @param args        the arguments the application is running with
         * @param context     the context that was being created
         */
        public MyApplicationReadyEvent(SpringApplication application, String[] args,
                                       ConfigurableApplicationContext context, String name) {
            super(application, args, context);
            this.name = name;
        }
    }
}

