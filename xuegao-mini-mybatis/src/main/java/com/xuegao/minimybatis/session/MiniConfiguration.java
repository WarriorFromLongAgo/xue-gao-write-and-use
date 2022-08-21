package com.xuegao.minimybatis.session;


import com.xuegao.minimybatis.executor.Executor;
import com.xuegao.minimybatis.executor.parameter.ParameterHandler;
import com.xuegao.minimybatis.mapping.BoundSql;
import com.xuegao.minimybatis.mapping.MappedStatement;
import com.xuegao.minimybatis.plugin.InterceptorChain;
import com.xuegao.minimybatis.scripting.defaults.DefaultParameterHandler;
import com.xuegao.minimybatis.statement.RoutingStatementHandler;
import com.xuegao.minimybatis.statement.StatementHandler;

import java.util.HashMap;
import java.util.Map;

public class MiniConfiguration {
    protected Environment environment;

    protected final Map<String, MappedStatement> mappedStatementMap = new StrictMap<>("Mapped Statements collection");

    protected final InterceptorChain interceptorChain = new InterceptorChain();

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatementMap.get(id);
    }

    //创建语句处理器
    public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement,
                                                Object parameterObject, ResultHandler resultHandler,
                                                BoundSql boundSql) {
        //创建路由选择语句处理器
        StatementHandler statementHandler = new RoutingStatementHandler(executor, mappedStatement, parameterObject, resultHandler, boundSql);
        //插件在这里插入
        statementHandler = (StatementHandler) interceptorChain.pluginAll(statementHandler);
        return statementHandler;
    }

    public ParameterHandler newParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
        //创建ParameterHandler
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        //插件在这里插入
        parameterHandler = (ParameterHandler) interceptorChain.pluginAll(parameterHandler);
        return parameterHandler;
    }


    protected static class StrictMap<V> extends HashMap<String, V> {
        private static final long serialVersionUID = -4950446264854982944L;
        private final String name;

        public StrictMap(String name) {
            super();
            this.name = name;
        }

        @Override
        @SuppressWarnings("unchecked")
        public V put(String key, V value) {
            if (containsKey(key)) {
                throw new IllegalArgumentException(name + " already contains value for " + key + super.get(key));
            }
            return super.put(key, value);
        }

        @Override
        public V get(Object key) {
            V value = super.get(key);
            if (value == null) {
                throw new IllegalArgumentException(name + " does not contain value for " + key);
            }
            return value;
        }
    }
}
