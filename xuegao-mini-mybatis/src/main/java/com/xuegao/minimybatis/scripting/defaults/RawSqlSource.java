package com.xuegao.minimybatis.scripting.defaults;

import com.xuegao.minimybatis.builder.SqlSourceBuilder;
import com.xuegao.minimybatis.mapping.BoundSql;
import com.xuegao.minimybatis.mapping.SqlSource;
import com.xuegao.minimybatis.session.MiniConfiguration;

import java.util.HashMap;

public class RawSqlSource implements SqlSource {

    private final SqlSource sqlSource;

    public RawSqlSource(MiniConfiguration miniConfiguration, String sql, Class<?> parameterType) {
        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(miniConfiguration);
        Class<?> clazz = parameterType == null ? Object.class : parameterType;
        sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<>());
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        System.out.println("=======getBoundSql");
        return sqlSource.getBoundSql(parameterObject);
    }

}
