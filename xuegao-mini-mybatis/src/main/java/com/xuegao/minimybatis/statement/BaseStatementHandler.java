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
import com.xuegao.minimybatis.session.MiniConfiguration;
import com.xuegao.minimybatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Clinton Begin
 */

/**
 * 语句处理器的基类
 */
public abstract class BaseStatementHandler implements StatementHandler {

    protected final MiniConfiguration miniConfiguration;
    protected final ParameterHandler parameterHandler;

    protected final Executor executor;
    protected final MappedStatement mappedStatement;
    protected BoundSql boundSql;

    protected BaseStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject,
                                   ResultHandler resultHandler, BoundSql boundSql) {
        this.miniConfiguration = mappedStatement.getMiniConfigurtion();
        this.executor = executor;
        this.mappedStatement = mappedStatement;

        if (boundSql == null) { // issue #435, get the key before calculating the statement
            boundSql = mappedStatement.getBoundSql(parameterObject);
        }

        this.boundSql = boundSql;

        //生成parameterHandler
        this.parameterHandler = miniConfiguration.newParameterHandler(mappedStatement, parameterObject, boundSql);
        //生成resultSetHandler
        // this.resultSetHandler = miniConfiguration.newResultSetHandler(executor, mappedStatement, parameterHandler, resultHandler, boundSql);
    }

    @Override
    public BoundSql getBoundSql() {
        return boundSql;
    }

    @Override
    public ParameterHandler getParameterHandler() {
        return parameterHandler;
    }

    //准备语句
    @Override
    public Statement prepare(Connection connection) throws SQLException {
        Statement statement = null;
        try {
            //实例化Statement
            statement = instantiateStatement(connection);
            return statement;
        } catch (SQLException e) {
            closeStatement(statement);
            throw e;
        } catch (Exception e) {
            closeStatement(statement);
            throw new RuntimeException("Error preparing statement.  Cause: " + e, e);
        }
    }

    //如何实例化Statement，交给子类做
    protected abstract Statement instantiateStatement(Connection connection) throws SQLException;

    //关闭语句
    protected void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            //ignore
        }
    }

    public <E> List<E> handleResultSets(Statement stmt) throws SQLException {
        final List<Object> multipleResults = new ArrayList<Object>();
        System.out.println("handleResultSets");
        return new ArrayList<>();
    }
}
