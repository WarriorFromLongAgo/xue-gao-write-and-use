package com.xuegao.mybatis.executor;

import com.xuegao.mybatis.mapping.MyConfiguration;
import com.xuegao.mybatis.mapping.MyMapperStatement;
import com.xuegao.pool.MyDataSource;
import com.xuegao.reflection.ReflectionUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyExecutor {

    private DataSource dataSource;

    public MyExecutor(MyConfiguration myConfiguration) {
        dataSource = MyDataSource.getInstance(myConfiguration.getMyEnvironment());
    }

    public <T> List<T> query(MyMapperStatement mapperStatement, Object[] args) {
        List<T> resultList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement(mapperStatement.getSql());
            if (args[0] instanceof Integer){
                preparedStatement.setInt(1,(Integer) args[0]);
            }
            resultSet = preparedStatement.executeQuery();
            handlerResultSet(resultSet,resultList,mapperStatement.getResultType());
            // 处理

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultList;
    }

    private <T> void handlerResultSet(ResultSet resultSet, List<T> resultList,String resultType){
        try {
            Class<T> clazz = (Class<T>) Class.forName(resultType);
            while (resultSet.next()){
                T entity = clazz.newInstance();
                ReflectionUtil.setProToBeanFromResult(entity,resultSet);
                resultList.add((T)entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
