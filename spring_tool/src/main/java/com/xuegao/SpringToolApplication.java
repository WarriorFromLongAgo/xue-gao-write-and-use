package com.xuegao;

import com.xuegao.config.XueGaoProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({XueGaoProperties.class})
@SpringBootApplication
public class SpringToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringToolApplication.class, args);
    }
}
