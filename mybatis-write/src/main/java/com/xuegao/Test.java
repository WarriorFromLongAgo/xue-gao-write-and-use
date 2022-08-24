package com.xuegao;

import com.xuegao.entity.Author;
import com.xuegao.mapper.AuthorMapper;
import com.xuegao.mybatis.session.MySqlSession;
import com.xuegao.mybatis.session.MySqlSessionFactory;
import com.xuegao.mybatis.session.MySqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        // 读取mybatis-config.xml配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis-config.xml");

        // 构建SqlSessionFactory
        MySqlSessionFactory mySqlSessionFactory = new MySqlSessionFactoryBuilder().build(inputStream);

        // 打开sqlsession
        MySqlSession mySqlSession = mySqlSessionFactory.openSession();

        // 获取Mapper接口对象
        AuthorMapper authorMapper = mySqlSession.getMappwe(AuthorMapper.class);

        // 操作数据库
        Author author = authorMapper.selectAuthor(1);

        System.out.println(author);
    }
}
