package com.example.sheji_moshi_shizhan.service;

import com.example.sheji_moshi_shizhan.domain.enums.ActionTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImplV1 implements ActionService, InitializingBean {
    @Autowired
    private SpringBeanTest springBeanTest;
    public void processMsg() {


        System.out.println("ActionServiceImplV1 ActionServiceImplV1");
        springBeanTest.testSpring();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        map.put(ActionTypeEnum.Actoin_1, this);
    }
}
