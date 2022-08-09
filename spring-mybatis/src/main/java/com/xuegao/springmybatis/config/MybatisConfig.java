package com.xuegao.springmybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.xuegao.springmybatis.business.*")
public class MybatisConfig {
    @Bean("sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:/mapper/**/*.xml"));
        factoryBean.setTypeAliasesPackage("com.xuegao.springmybatis.business.*");

        return factoryBean.getObject();
    }
}
