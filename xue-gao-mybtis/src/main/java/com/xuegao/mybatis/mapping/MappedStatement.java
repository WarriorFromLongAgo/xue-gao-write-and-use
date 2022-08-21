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
package com.xuegao.mybatis.mapping;

import com.xuegao.mybatis.session.Configuration;

/**
 * @author Clinton Begin
 */

/**
 * 映射的语句
 */
public final class MappedStatement {

    private String resource;
    private Configuration configuration;
    private String id;
    private Integer fetchSize;
    private Integer timeout;
    private SqlCommandType sqlCommandType;
    private String[] keyProperties;
    private String[] keyColumns;
    private boolean hasNestedResultMaps;
    private String databaseId;
    private String[] resultSets;

    MappedStatement() {
        // constructor disabled
    }

    //静态内部类，建造者模式
    public static class Builder {
        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(Configuration configuration, String id, SqlCommandType sqlCommandType) {
            mappedStatement.configuration = configuration;
            mappedStatement.id = id;
            mappedStatement.sqlCommandType = sqlCommandType;
            String logId = id;
        }

        public Builder resource(String resource) {
            mappedStatement.resource = resource;
            return this;
        }

        public String id() {
            return mappedStatement.id;
        }

        public Builder fetchSize(Integer fetchSize) {
            mappedStatement.fetchSize = fetchSize;
            return this;
        }

        public Builder timeout(Integer timeout) {
            mappedStatement.timeout = timeout;
            return this;
        }

        public Builder keyProperty(String keyProperty) {
            mappedStatement.keyProperties = delimitedStringtoArray(keyProperty);
            return this;
        }

        public Builder keyColumn(String keyColumn) {
            mappedStatement.keyColumns = delimitedStringtoArray(keyColumn);
            return this;
        }

        public Builder databaseId(String databaseId) {
            mappedStatement.databaseId = databaseId;
            return this;
        }

        public Builder resulSets(String resultSet) {
            mappedStatement.resultSets = delimitedStringtoArray(resultSet);
            return this;
        }

        public MappedStatement build() {
            assert mappedStatement.configuration != null;
            assert mappedStatement.id != null;
            return mappedStatement;
        }
    }

    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    public String getResource() {
        return resource;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public String getId() {
        return id;
    }

    public boolean hasNestedResultMaps() {
        return hasNestedResultMaps;
    }

    public Integer getFetchSize() {
        return fetchSize;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    public String[] getKeyProperties() {
        return keyProperties;
    }

    public String[] getKeyColumns() {
        return keyColumns;
    }

    public String[] getResulSets() {
        return resultSets;
    }

    private static String[] delimitedStringtoArray(String in) {
        if (in == null || in.trim().length() == 0) {
            return null;
        } else {
            return in.split(",");
        }
    }

}
