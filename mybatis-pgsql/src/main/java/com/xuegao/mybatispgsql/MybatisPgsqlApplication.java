package com.xuegao.mybatispgsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @MapperScan(basePackages = "com.xuegao.mybatispgsql.test")
public class MybatisPgsqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPgsqlApplication.class, args);
    }

}
