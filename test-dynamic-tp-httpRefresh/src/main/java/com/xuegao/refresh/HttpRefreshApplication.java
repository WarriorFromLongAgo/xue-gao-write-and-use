package com.xuegao.refresh;

import com.dtp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDynamicTp
@SpringBootApplication
public class HttpRefreshApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpRefreshApplication.class, args);
    }

}
