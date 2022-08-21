package com.xuegao.minimybatis.mapping;

import com.xuegao.minimybatis.session.MiniConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoundSql {

    private final String sql;
    private final Object parameterObject;
    private List<ParameterMapping> parameterMappings;
    private Map<String, Object> additionalParameters;

    public BoundSql(String sql, Object parameterObject) {
        this.sql = sql;
        this.parameterObject = parameterObject;
    }

    public BoundSql(MiniConfiguration miniConfiguration, String sql, List<ParameterMapping> parameterMappings, Object parameterObject) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.parameterObject = parameterObject;
        this.additionalParameters = new HashMap<>();
    }

    public String getSql() {
        return sql;
    }

    public Object getParameterObject() {
        return parameterObject;
    }

}
