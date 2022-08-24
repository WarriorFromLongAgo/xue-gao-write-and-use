package com.xuegao.pool;

import com.xuegao.mybatis.mapping.MyEnvironment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyDataSource implements MyDataSourceInterface{

    private MyEnvironment myEnvironment;

    private List<Connection> pool;

    private Connection conn = null;

    private static MyDataSource instance = null;

    private static final int POOL_SIZE = 15;

    private MyDataSource(MyEnvironment myEnvironment){
        this.myEnvironment = myEnvironment;
        pool = new ArrayList<Connection>(POOL_SIZE);
        this.createConnection();
    }

    public static MyDataSource getInstance(MyEnvironment myEnvironment){
        if (instance == null){
            instance = new MyDataSource(myEnvironment);
        }
        return instance;
    }

    public synchronized Connection getConnection(){
        if (pool.size() > 0){
            Connection conn = pool.get(0);
            pool.remove(conn);
            return conn;
        }else {
            return null;
        }
    }

    /**
     * 创建原始数据库连接
     */
    public void createConnection(){
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                Class.forName(myEnvironment.getDriver());
                conn = DriverManager.getConnection(myEnvironment.getUrl(), myEnvironment.getUsername(), myEnvironment.getPassword());
                pool.add(conn);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    /**
     * 用完放回连接池
     * @param conn
     */
    public synchronized void release(Connection conn){
        pool.add(conn);
    }

    /**
     * 关闭链接
     */
    public synchronized void closePool(){
        for (int i = 0; i < pool.size(); i++) {
             conn = pool.get(i);
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            pool.remove(i);
        }
    }
}
