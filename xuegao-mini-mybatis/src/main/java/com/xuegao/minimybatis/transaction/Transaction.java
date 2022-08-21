package com.xuegao.minimybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

public interface Transaction {
    /**
     * Retrieve inner database connection
     * @return DataBase connection
     * @throws SQLException
     */
    Connection getConnection() throws SQLException;

}