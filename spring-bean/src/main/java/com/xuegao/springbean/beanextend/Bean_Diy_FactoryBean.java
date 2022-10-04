package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class Bean_Diy_FactoryBean implements FactoryBean<Bean_Diy_FactoryBean.TestFactoryInnerBean> {

    @Override
    public Bean_Diy_FactoryBean.TestFactoryInnerBean getObject() throws Exception {
        OnlyPrintUtil.print(getClass(), "getObject");
        return new Bean_Diy_FactoryBean.TestFactoryInnerBean();
    }

    @Override
    public Class<?> getObjectType() {
        return Bean_Diy_FactoryBean.TestFactoryInnerBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public static class TestFactoryInnerBean {
        public TestFactoryInnerBean() {
            System.out.println("TestFactoryInnerBean 构造方法");
        }
    }
}
