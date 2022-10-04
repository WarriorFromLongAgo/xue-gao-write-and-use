package com.xuegao.springbean;

import com.xuegao.springbean.beanextend.Bean1_ApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.xuegao.springbean"})
public class SpringBeanApplication {

    public static void main(String[] args) {
        SpringApplication applicationContext = new SpringApplication(SpringBeanApplication.class);
        applicationContext.addInitializers(new Bean1_ApplicationContextInitializer());
        applicationContext.run(args);

        // SpringApplication.run(SpringBeanApplication.class, args);

        // try {
        //     Bean100_FactoryBean bean100_factoryBean = new Bean100_FactoryBean();
        //     bean100_factoryBean.getObject();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

}
