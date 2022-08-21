/*
 *    Copyright 2009-2012 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.xuegao.minimybatis.statement;

import com.xuegao.minimybatis.executor.Executor;
import com.xuegao.minimybatis.executor.parameter.ParameterHandler;
import com.xuegao.minimybatis.mapping.BoundSql;
import com.xuegao.minimybatis.mapping.MappedStatement;
import com.xuegao.minimybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author Clinton Begin
 */

/**
 * 路由选择语句处理器,有点像代理模式
 */
public class RoutingStatementHandler implements StatementHandler {

    private final StatementHandler delegate;

    public RoutingStatementHandler(Executor executor, MappedStatement ms, Object parameter,
                                   ResultHandler resultHandler, BoundSql boundSql) {

        //根据语句类型，委派到不同的语句处理器(STATEMENT|PREPARED|CALLABLE)
        switch (ms.getStatementType()) {
            // case STATEMENT:
                // delegate = new SimpleStatementHandler(executor, ms, parameter, rowBounds, resultHandler, boundSql);
                // break;
            case PREPARED:
                delegate = new PreparedStatementHandler(executor, ms, parameter, resultHandler, boundSql);
                break;
            // case CALLABLE:
                // delegate = new CallableStatementHandler(executor, ms, parameter, rowBounds, resultHandler, boundSql);
                // break;
            default:
                throw new RuntimeException("Unknown statement type: " + ms.getStatementType());
        }

    }

    @Override
    public Statement prepare(Connection connection) throws SQLException {
        return delegate.prepare(connection);
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        return delegate.<E>query(statement, resultHandler);
    }

    @Override
    public BoundSql getBoundSql() {
        return delegate.getBoundSql();
    }

    @Override
    public ParameterHandler getParameterHandler() {
        return delegate.getParameterHandler();
    }
}
