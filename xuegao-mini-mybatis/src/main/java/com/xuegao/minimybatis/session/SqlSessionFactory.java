package com.xuegao.minimybatis.session;

public interface SqlSessionFactory {

    SqlSession openSession();

    MiniConfiguration getConfiguration();
}
