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
package com.xuegao.minimybatis.transaction.jdbc;

import com.xuegao.minimybatis.transaction.Transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * {@link Transaction} that makes use of the JDBC commit and rollback facilities directly.
 * It relies on the connection retrieved from the dataSource to manage the scope of the transaction.
 * Delays connection retrieval until getConnection() is called.
 * Ignores commit or rollback requests when autocommit is on.
 *
 * @author Clinton Begin
 * @author Clinton Begin
 * @author Clinton Begin
 * @see JdbcTransactionFactory
 */
/**
 * @author Clinton Begin
 */

/**
 * Jdbc事务。直接利用JDBC的commit,rollback。
 * 它依赖于从数据源得 到的连接来管理事务范围。 
 */
public class JdbcTransaction implements Transaction {

    protected Connection connection;
    protected DataSource dataSource;

    public JdbcTransaction(DataSource ds) {
        dataSource = ds;
    }

    public JdbcTransaction(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            openConnection();
        }
        return connection;
    }

    protected void openConnection() throws SQLException {
        connection = dataSource.getConnection();
    }

}
