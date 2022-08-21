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
package com.xuegao.minimybatis.scripting.defaults;

import com.xuegao.minimybatis.executor.parameter.ParameterHandler;
import com.xuegao.minimybatis.mapping.BoundSql;
import com.xuegao.minimybatis.mapping.MappedStatement;
import com.xuegao.minimybatis.mapping.ParameterMapping;
import com.xuegao.minimybatis.session.MiniConfiguration;

import javax.security.auth.login.Configuration;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Clinton Begin
 * @author Eduardo Macarron
 */

/**
 * 默认参数处理器
 */
public class DefaultParameterHandler implements ParameterHandler {

    private final MappedStatement mappedStatement;
    private final Object parameterObject;
    private BoundSql boundSql;
    private MiniConfiguration miniConfiguration;

    public DefaultParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        this.mappedStatement = mappedStatement;
        this.miniConfiguration = mappedStatement.getMiniConfigurtion();
        this.parameterObject = parameterObject;
        this.boundSql = boundSql;
    }

    @Override
    public Object getParameterObject() {
        return parameterObject;
    }

    //设置参数
    @Override
    public void setParameters(PreparedStatement ps) throws SQLException {

    }

}
