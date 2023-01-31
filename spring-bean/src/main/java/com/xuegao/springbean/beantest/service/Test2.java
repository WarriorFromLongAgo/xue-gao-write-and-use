package com.xuegao.springbean.beantest.service;

import com.xuegao.springbean.util.SpringUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author xuegao
 * @version 1.0
 * @date 2023年01月30日 17:07
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Test2 {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test2{" +
                "name='" + name + '\'' +
                '}';
    }

    public void test(String inputName) {
        Test2 bean = SpringUtils.getBean(Test2.class);
        System.out.println(Thread.currentThread().getName() + " 1 == " + bean);
        if ("a".equals(inputName)) {
            setName("a");
            System.out.println(Thread.currentThread().getName() + " inputName == " + inputName + " == " + this.name);
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println(Thread.currentThread().getName() + " inputName == " + inputName + " == " + getName());
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).run();
        }
        System.out.println(Thread.currentThread().getName() + " 2 == " + bean);
    }
}
