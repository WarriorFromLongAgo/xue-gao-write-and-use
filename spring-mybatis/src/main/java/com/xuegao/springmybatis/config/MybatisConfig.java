package com.xuegao.springmybatis.config;

import org.apache.ibatis.logging.stdout.StdOutImpl;
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
        factoryBean.setTypeAliasesPackage("com.xuegao.springmybatis.model.*");

        SqlSessionFactory sqlSessionFactory = factoryBean.getObject();


        // mybatis:
        // configuration:
        // log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
        org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
        // org.apache.ibatis.builder.xml.XMLConfigBuilder#settingsElement
        // configuration.setCacheEnabled();
        configuration.setLogImpl(StdOutImpl.class);
        configuration.setLogPrefix("[xuegao-spring-mybatis]");
        configuration.addInterceptor(new PrintSqlInterceptor());
        configuration.setMapUnderscoreToCamelCase(Boolean.TRUE);

        return sqlSessionFactory;
    }
}
