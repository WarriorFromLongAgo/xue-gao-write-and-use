package com.xuegao.springmybatisplus.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    @Bean
    public String MyBatisInterceptor(SqlSessionFactory sqlSessionFactory) {
        PrintSqlInterceptor printSqlInterceptor = new PrintSqlInterceptor();
        sqlSessionFactory.getConfiguration().addInterceptor(printSqlInterceptor);
        return "interceptor";
    }
}
