package com.xuegao.minimybatis.executor;


import com.xuegao.minimybatis.mapping.BoundSql;
import com.xuegao.minimybatis.mapping.MappedStatement;
import com.xuegao.minimybatis.session.MiniConfiguration;
import com.xuegao.minimybatis.session.ResultHandler;
import com.xuegao.minimybatis.statement.StatementHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SimpleExecutor extends BaseExecutor {
    public SimpleExecutor(MiniConfiguration miniConfiguration) {
        super(miniConfiguration);
    }

    //select
    @Override
    public <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        Statement stmt = null;
        try {
            MiniConfiguration miniConfiguration = ms.getMiniConfigurtion();
            //新建一个StatementHandler
            //这里看到ResultHandler传入的是null
            StatementHandler handler = miniConfiguration.newStatementHandler(this, ms, parameter, null, null);
            //准备语句
            stmt = prepareStatement(handler);
            //StatementHandler.query
            return handler.<E>query(stmt, resultHandler);
        } finally {
            closeStatement(stmt);
        }
    }

    private Statement prepareStatement(StatementHandler handler) throws SQLException {
        Statement stmt;
        Connection connection = getConnection();
        //调用StatementHandler.prepare
        stmt = handler.prepare(connection);
        return stmt;
    }

    protected void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                // ignore
            }
        }
    }
}
