package com.xuegao.feignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.xuegao.feignclient.call")
public class FeignClientServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignClientServiceApplication.class, args);
    }
}