package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationFailedEventTest implements ApplicationListener<MyApplicationFailedEventTest.MyApplicationFailedEvent> {
    private static final Logger log = LoggerFactory.getLogger(MyApplicationFailedEventTest.class);

    @Override
    public void onApplicationEvent(MyApplicationFailedEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][MyApplicationFailedEventTest][onApplicationEvent][event=" + JSON.toJSONString(event));
    }

    @Getter
    @Setter
    public static class MyApplicationFailedEvent extends ApplicationFailedEvent {

        private String name;

        /**
         * Create a new {@link ApplicationFailedEvent} instance.
         *
         * @param application the current application
         * @param args        the arguments the application was running with
         * @param context     the context that was being created (maybe null)
         * @param exception   the exception that caused the error
         */
        public MyApplicationFailedEvent(SpringApplication application, String[] args,
                                        ConfigurableApplicationContext context, Throwable exception,
                                        String name) {
            super(application, args, context, exception);
            this.name = name;
        }
    }
}

