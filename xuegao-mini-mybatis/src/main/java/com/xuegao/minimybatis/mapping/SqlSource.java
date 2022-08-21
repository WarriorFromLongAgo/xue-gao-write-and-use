package com.xuegao.minimybatis.mapping;

public interface SqlSource {

  BoundSql getBoundSql(Object parameterObject);

}