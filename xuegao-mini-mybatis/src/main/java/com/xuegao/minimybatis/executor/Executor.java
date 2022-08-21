package com.xuegao.minimybatis.executor;

import com.xuegao.minimybatis.mapping.MappedStatement;
import com.xuegao.minimybatis.session.ResultHandler;

import java.sql.SQLException;
import java.util.List;

public interface Executor {
    //不需要ResultHandler
    ResultHandler NO_RESULT_HANDLER = null;
    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler handler) throws SQLException;
    // <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler handler, BoundSql boundSql) throws SQLException;
}
