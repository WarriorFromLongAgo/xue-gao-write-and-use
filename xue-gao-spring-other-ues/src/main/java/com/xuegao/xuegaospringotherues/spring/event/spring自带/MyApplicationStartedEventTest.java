package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationStartedEventTest implements ApplicationListener<MyApplicationStartedEventTest.MyApplicationStartedEvent> {
    private static final Logger log = LoggerFactory.getLogger(MyApplicationStartedEventTest.class);

    @Override
    public void onApplicationEvent(MyApplicationStartedEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][MyApplicationStartedEventTest][onApplicationEvent][event=" + JSON.toJSONString(event));
    }

    @Getter
    @Setter
    public static class MyApplicationStartedEvent extends ApplicationStartedEvent {

        private String name;

        /**
         * Create a new {@link ApplicationStartedEvent} instance.
         *
         * @param application the current application
         * @param args        the arguments the application is running with
         * @param context     the context that was being created
         */
        public MyApplicationStartedEvent(SpringApplication application, String[] args,
                                         ConfigurableApplicationContext context, String name) {
            super(application, args, context);
            this.name = name;
        }
    }
}

