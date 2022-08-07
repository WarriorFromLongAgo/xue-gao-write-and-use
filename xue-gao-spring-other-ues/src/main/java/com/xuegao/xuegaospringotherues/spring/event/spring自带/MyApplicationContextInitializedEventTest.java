package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContextInitializedEventTest implements ApplicationListener<MyApplicationContextInitializedEventTest.MyApplicationContextInitializedEvent> {
    private static final Logger log = LoggerFactory.getLogger(MyApplicationContextInitializedEventTest.class);

    @Override
    public void onApplicationEvent(MyApplicationContextInitializedEvent event) {
        log.info("[xuegao_Spring_Boot_Demo][MyApplicationContextInitializedEventTest][onApplicationEvent][event={}]", JSON.toJSONString(event));
    }

    @Getter
    @Setter
    public static class MyApplicationContextInitializedEvent extends ApplicationContextInitializedEvent {
        private String name;

        /**
         * Create a new {@link ApplicationContextInitializedEvent} instance.
         *
         * @param application the current application
         * @param args        the arguments the application is running with
         * @param context     the context that has been initialized
         */
        public MyApplicationContextInitializedEvent(SpringApplication application, String[] args,
                                                    ConfigurableApplicationContext context,
                                                    String name) {
            super(application, args, context);
            this.name = name;
        }
    }
}
