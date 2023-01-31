/**************************************************************************/
/*                                                                        */
/* Copyright (c) 2017 KYE Company                                         */
/* 跨越速运集团有限公司版权所有                                             */
/*                                                                        */
/* PROPRIETARY RIGHTS of KYE Company are involved in the                  */
/* subject matter of this material. All manufacturing, reproduction, use, */
/* and sales rights pertaining to this subject matter are governed by the */
/* license agreement. The recipient of this software implicitly accepts   */
/* the terms of the license.                                              */
/* 本软件文档资料是跨越速运集团有限公司的资产，任何人士阅读和                  */
/* 使用本资料必须获得相应的书面授权，承担保密责任和接受相应的法律约束。         */
/*                                                                        */
/**************************************************************************/

package com.xuegao.springbean.beantest.service;

import com.xuegao.springbean.util.SpringUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author fjm
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
