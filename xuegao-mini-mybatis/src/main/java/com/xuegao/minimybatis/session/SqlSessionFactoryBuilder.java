package com.xuegao.minimybatis.session;

import com.xuegao.minimybatis.builder.xml.XMLConfigBuilder;
import com.xuegao.minimybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream) {
        MiniConfiguration miniConfiguration = new XMLConfigBuilder(inputStream).parse();
        return new DefaultSqlSessionFactory(miniConfiguration);
    }
}
