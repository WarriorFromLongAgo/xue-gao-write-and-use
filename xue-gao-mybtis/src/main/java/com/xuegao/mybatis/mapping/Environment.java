package com.xuegao.mybatis.mapping;

import javax.sql.DataSource;

public final class Environment {
    private final String id;
    private final DataSource dataSource;

    public Environment(String id, DataSource dataSource) {
        if (id == null) {
            throw new IllegalArgumentException("Parameter 'id' must not be null");
        }
        this.id = id;
        if (dataSource == null) {
            throw new IllegalArgumentException("Parameter 'dataSource' must not be null");
        }
        this.dataSource = dataSource;
    }

    public static class Builder {
        private final String id;
        private DataSource dataSource;

        public Builder(String id) {
            this.id = id;
        }

        public Builder dataSource(DataSource dataSource) {
            this.dataSource = dataSource;
            return this;
        }

        public String id() {
            return this.id;
        }

        public Environment build() {
            return new Environment(this.id, this.dataSource);
        }
    }

    public String getId() {
        return this.id;
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }

}