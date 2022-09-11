package com.xuegao.feignclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.xuegao")
@EnableFeignClients(basePackages = "com.xuegao.feignclient2.call")
public class FeignClientService2Application {
    public static void main(String[] args) {
        SpringApplication.run(FeignClientService2Application.class, args);
    }
}