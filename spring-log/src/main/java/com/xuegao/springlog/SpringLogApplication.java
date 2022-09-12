package com.xuegao.springlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.xuegao.springlog.feign")
@SpringBootApplication
@MapperScan(basePackages = "com.xuegao.springlog.mapper")
public class SpringLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLogApplication.class, args);
    }

}