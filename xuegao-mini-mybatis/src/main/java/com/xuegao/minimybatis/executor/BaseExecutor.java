package com.xuegao.minimybatis.executor;

import com.xuegao.minimybatis.mapping.BoundSql;
import com.xuegao.minimybatis.mapping.MappedStatement;
import com.xuegao.minimybatis.session.MiniConfiguration;
import com.xuegao.minimybatis.session.ResultHandler;
import com.xuegao.minimybatis.transaction.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseExecutor implements Executor {

    protected Executor wrapper;

    protected MiniConfiguration miniConfiguration;

    protected Transaction transaction;

    protected BaseExecutor(MiniConfiguration miniConfiguration) {
        this.miniConfiguration = miniConfiguration;
        this.wrapper = this;
    }

    protected Connection getConnection() throws SQLException {
        return transaction.getConnection();
    }

    @Override
    public <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler) throws SQLException {
        BoundSql boundSql = ms.getBoundSql(parameter);
        return query(ms, parameter, resultHandler, boundSql);
    }

    //从数据库查
    private <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        return doQuery(ms, parameter, resultHandler, boundSql);
    }

    //从数据库查
    private <E> List<E> queryFromDatabase(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        return doQuery(ms, parameter, resultHandler, boundSql);
    }

    //query-->queryFromDatabase-->doQuery
    protected abstract <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) throws SQLException;
}
