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
package com.xuegao.minimybatis.builder;

import com.xuegao.minimybatis.mapping.BoundSql;
import com.xuegao.minimybatis.mapping.ParameterMapping;
import com.xuegao.minimybatis.mapping.SqlSource;
import com.xuegao.minimybatis.session.MiniConfiguration;

import java.util.List;

/**
 * @author Clinton Begin
 */

/**
 * 静态SQL源码
 */
public class StaticSqlSource implements SqlSource {

    private String sql;
    private List<ParameterMapping> parameterMappings;
    private MiniConfiguration miniConfiguration;

    public StaticSqlSource(MiniConfiguration miniConfiguration, String sql) {
        this(miniConfiguration, sql, null);
    }

    public StaticSqlSource(MiniConfiguration miniConfiguration, String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.miniConfiguration = miniConfiguration;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return new BoundSql(miniConfiguration, sql, parameterMappings, parameterObject);
    }

}
