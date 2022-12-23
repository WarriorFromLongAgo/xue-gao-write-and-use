package com.xuegao.refresh;

import com.dtp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDynamicTp
@SpringBootApplication
public class ZkRefreshApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkRefreshApplication.class, args);
    }

}
