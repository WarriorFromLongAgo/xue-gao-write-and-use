package com.xuegao.xuegaospringotherues.controller.event;

import com.xuegao.xuegaospringotherues.spring.event.自己Diy.MyApplicationEventTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/event/pushMyApplicationEvent")
    public String pushEvent() {
        MyApplicationEventTest.MyApplicationEvent myApplicationEvent =
                new MyApplicationEventTest.MyApplicationEvent(this, "zhangsan", 10);
        applicationContext.publishEvent(myApplicationEvent);
        return "pushMyApplicationEvent";
    }

    @RequestMapping("/event/pushAll")
    public String pushEvent2() {
        applicationContext.publishEvent("大家好");
        return "pushAll";
    }

}
