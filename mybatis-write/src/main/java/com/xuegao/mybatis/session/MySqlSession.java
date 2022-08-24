package com.xuegao.mybatis.session;

import com.alibaba.fastjson2.JSON;
import com.xuegao.mybatis.executor.MyExecutor;
import com.xuegao.mybatis.mapping.MyConfiguration;
import com.xuegao.mybatis.mapping.MyMapperStatement;
import com.xuegao.mybatis.proxy.MapperProxy;

import java.lang.reflect.Proxy;
import java.util.List;

public class MySqlSession {

    private MyConfiguration myConfiguration;

    private MyExecutor myExecutor;

    public MySqlSession(MyConfiguration myConfiguration, MyExecutor myExecutor) {
        this.myConfiguration = myConfiguration;
        this.myExecutor = myExecutor;
    }

    public <T> T getMappwe(Class<T> clazz) {
        MapperProxy mapperProxy = new MapperProxy(this);
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, mapperProxy);
    }

    public <T> T selectOne(String statementKey, Object[] args) {
        MyMapperStatement mapperStatement = myConfiguration.getMapperStatement().get(statementKey);
        List<T> resultList = myExecutor.query(mapperStatement, args);
        System.out.println("selectOne " + JSON.toJSONString(resultList));
        if (resultList != null && resultList.size() > 1) {
            throw new RuntimeException("more than one");
        } else {
            return resultList.get(0);
        }
    }

    public void selectList(Object[] args) {
    }
}
