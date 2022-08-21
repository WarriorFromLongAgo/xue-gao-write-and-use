package com.xuegao.minimybatis.mapping;

import com.xuegao.minimybatis.session.MiniConfiguration;

public final class MappedStatement {

    private String resource;
    private MiniConfiguration miniConfiguration;
    private String id;
    private String databaseId;
    private StatementType statementType;
    //SQL源码
    private SqlSource sqlSource;

    MappedStatement() {
        // constructor disabled
    }

    public static class Builder {
        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(MiniConfiguration miniConfiguration, String id) {
            mappedStatement.miniConfiguration = miniConfiguration;
            mappedStatement.id = id;
            mappedStatement.statementType = StatementType.PREPARED;
        }

        public Builder resource(String resource) {
            mappedStatement.resource = resource;
            return this;
        }

        public Builder databaseId(String databaseId) {
            mappedStatement.databaseId = databaseId;
            return this;
        }

        public MappedStatement build() {
            assert mappedStatement.id != null;
            return mappedStatement;
        }
    }


    public MiniConfiguration getMiniConfigurtion() {
        return miniConfiguration;
    }

    public String getId() {
        return id;
    }

    public StatementType getStatementType() {
        return statementType;
    }

    public BoundSql getBoundSql(Object parameterObject) {
        BoundSql boundSql = sqlSource.getBoundSql(parameterObject);

        return boundSql;
    }
}