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

import com.xuegao.minimybatis.mapping.SqlSource;
import com.xuegao.minimybatis.session.MiniConfiguration;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Clinton Begin
 */

/**
 * SQL源码构建器
 * 
 */
public class SqlSourceBuilder extends BaseBuilder {

  private static final String parameterProperties = "javaType,jdbcType,mode,numericScale,resultMap,typeHandler,jdbcTypeName";

  public SqlSourceBuilder(MiniConfiguration miniConfiguration) {
    super(miniConfiguration);
  }

  public SqlSource parse(String originalSql, Class<?> parameterType, Map<String, Object> additionalParameters) {
    //返回静态SQL源码
    return new StaticSqlSource(miniConfiguration, originalSql, new ArrayList<>());
  }

}
