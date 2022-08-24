package com.xuegao.mybatis.session;

import com.xuegao.mybatis.mapping.MyConfiguration;
import com.xuegao.mybatis.parsing.XMLConfigBuilder;

import java.io.InputStream;

public class MySqlSessionFactoryBuilder {

    public MySqlSessionFactory build(InputStream inputStream) {
        MyConfiguration myConfiguration = new XMLConfigBuilder(inputStream).parse();
        return new MySqlSessionFactory(myConfiguration);
    }
}
