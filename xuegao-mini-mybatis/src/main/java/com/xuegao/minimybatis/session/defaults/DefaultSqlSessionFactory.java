package com.xuegao.minimybatis.session.defaults;

import com.xuegao.minimybatis.executor.Executor;
import com.xuegao.minimybatis.executor.SimpleExecutor;
import com.xuegao.minimybatis.session.MiniConfiguration;
import com.xuegao.minimybatis.session.SqlSession;
import com.xuegao.minimybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private MiniConfiguration miniConfiguration;

    public DefaultSqlSessionFactory(MiniConfiguration miniConfiguration) {
        this.miniConfiguration = miniConfiguration;
    }

    @Override
    public SqlSession openSession() {
        Executor executor = new SimpleExecutor(miniConfiguration);
        return new DefaultSqlSession(miniConfiguration, executor);
    }

    @Override
    public MiniConfiguration getConfiguration() {
        return miniConfiguration;
    }

}
