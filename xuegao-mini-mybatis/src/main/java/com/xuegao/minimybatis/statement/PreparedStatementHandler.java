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
import com.xuegao.minimybatis.mapping.BoundSql;
import com.xuegao.minimybatis.mapping.MappedStatement;
import com.xuegao.minimybatis.session.ResultHandler;

import javax.crypto.KeyGenerator;
import java.sql.*;
import java.util.List;

/**
 * @author Clinton Begin
 */

/**
 * 预处理语句处理器(PREPARED)
 */
public class PreparedStatementHandler extends BaseStatementHandler {

    public PreparedStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        super(executor, mappedStatement, parameter, resultHandler, boundSql);
    }

    @Override
    public <E> List<E> query(Statement statement, ResultHandler resultHandler) throws SQLException {
        PreparedStatement ps = (PreparedStatement) statement;
        ps.execute();
        return handleResultSets(ps);
    }

    @Override
    protected Statement instantiateStatement(Connection connection) throws SQLException {
        //调用Connection.prepareStatement
        String sql = boundSql.getSql();
        return connection.prepareStatement(sql);
    }

}
