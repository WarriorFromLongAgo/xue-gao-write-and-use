package com.xuegao.feignserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class FeignServerService2Application {
    public static void main(String[] args) {
        SpringApplication.run(FeignServerService2Application.class, args);
    }
}
