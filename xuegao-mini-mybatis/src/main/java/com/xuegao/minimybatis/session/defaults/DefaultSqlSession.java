package com.xuegao.minimybatis.session.defaults;

import com.xuegao.minimybatis.executor.Executor;
import com.xuegao.minimybatis.mapping.MappedStatement;
import com.xuegao.minimybatis.session.MiniConfiguration;
import com.xuegao.minimybatis.session.SqlSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DefaultSqlSession implements SqlSession {
    private final MiniConfiguration miniConfiguration;
    private final Executor executor;

    public DefaultSqlSession(MiniConfiguration miniConfiguration, Executor executor) {
        this.miniConfiguration = miniConfiguration;
        this.executor = executor;
    }

    @Override
    public <E> List<E> selectList(String statement) {
        return this.selectList(statement, null);
    }

    @Override
    public <E> List<E> selectList(String statement, Object parameter) {
        try {
            MappedStatement ms = miniConfiguration.getMappedStatement(statement);
            return executor.query(ms, parameter, Executor.NO_RESULT_HANDLER);
        } catch (SQLException throwables) {
            throw new RuntimeException("da");
        } finally {
            System.out.println();
        }
    }


    @Override
    public void close() throws IOException {

    }
}
