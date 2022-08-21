package com.xuegao.mybatis.session;

import com.xuegao.mybatis.mapping.Environment;
import com.xuegao.mybatis.mapping.MappedStatement;
import com.xuegao.mybatis.type.TypeAliasRegistry;

import java.util.*;

public class Configuration {

    protected Environment environment;
    //类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
    //映射注册机
    // protected MapperRegistry mapperRegistry = new MapperRegistry(this);
    //映射的语句,存在Map里
    protected final Map<String, MappedStatement> mappedStatements = new StrictMap<MappedStatement>("Mapped Statements collection");

    protected Properties variables = new Properties();
    // 已经加载的 xml
    protected final Set<String> loadedResources = new HashSet<String>();

    protected String databaseId;

    public Configuration(Environment environment) {
        this();
        this.environment = environment;
    }

    public Configuration() {
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public MappedStatement getMappedStatement(String id) {
        return this.getMappedStatement(id, true);
    }

    public MappedStatement getMappedStatement(String id, boolean validateIncompleteStatements) {
        //先构建所有语句，再返回语句
        if (validateIncompleteStatements) {
            buildAllStatements();
        }
        return mappedStatements.get(id);
    }

    protected void buildAllStatements() {

    }

    public void addMappers(String packageName) {
        // mapperRegistry.addMappers(packageName);
    }


    //静态内部类,严格的Map，不允许多次覆盖key所对应的value
    protected static class StrictMap<V> extends HashMap<String, V> {

        private static final long serialVersionUID = -4950446264854982944L;
        private String name;

        public StrictMap(String name, int initialCapacity, float loadFactor) {
            super(initialCapacity, loadFactor);
            this.name = name;
        }

        public StrictMap(String name, int initialCapacity) {
            super(initialCapacity);
            this.name = name;
        }

        public StrictMap(String name) {
            super();
            this.name = name;
        }

        public StrictMap(String name, Map<String, ? extends V> m) {
            super(m);
            this.name = name;
        }

        @SuppressWarnings("unchecked")
        public V put(String key, V value) {
            if (containsKey(key)) {
                //如果已经存在此key了，直接报错
                throw new IllegalArgumentException(name + " already contains value for " + key);
            }
            if (key.contains(".")) {
                //如果有.符号，取得短名称，大致用意就是包名不同，类名相同，提供模糊查询的功能
                final String shortKey = getShortName(key);
                if (super.get(shortKey) == null) {
                    //如果没有这个缩略，则放一个缩略
                    super.put(shortKey, value);
                } else {
                    //如果已经有此缩略，表示模糊，放一个Ambiguity型的
                    super.put(shortKey, (V) new Ambiguity(shortKey));
                }
            }
            //再放一个全名
            return super.put(key, value);
            //可以看到，如果有包名，会放2个key到这个map，一个缩略，一个全名
        }

        public V get(Object key) {
            V value = super.get(key);
            //如果找不到相应的key，直接报错
            if (value == null) {
                throw new IllegalArgumentException(name + " does not contain value for " + key);
            }
            //如果是模糊型的，也报错，提示用户
            //原来这个模糊型就是为了提示用户啊
            if (value instanceof Ambiguity) {
                throw new IllegalArgumentException(((Ambiguity) value).getSubject() + " is ambiguous in " + name
                        + " (try using the full name including the namespace, or rename one of the entries)");
            }
            return value;
        }

        //取得短名称，也就是取得最后那个句号的后面那部分
        private String getShortName(String key) {
            final String[] keyparts = key.split("\\.");
            return keyparts[keyparts.length - 1];
        }

        //模糊，居然放在Map里面的一个静态内部类，
        protected static class Ambiguity {
            //提供一个主题
            private String subject;

            public Ambiguity(String subject) {
                this.subject = subject;
            }

            public String getSubject() {
                return subject;
            }
        }
    }

    public Properties getVariables() {
        return variables;
    }

    public boolean isResourceLoaded(String resource) {
        return loadedResources.contains(resource);
    }

    public void addLoadedResource(String resource) {
        loadedResources.add(resource);
    }

    // public boolean hasMapper(Class<?> type) {
    //     return mapperRegistry.hasMapper(type);
    // }
    //
    // public <T> void addMapper(Class<T> type) {
    //     mapperRegistry.addMapper(type);
    // }
    //
    // public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
    //     return mapperRegistry.getMapper(type, sqlSession);
    // }

    public String getDatabaseId() {
        return databaseId;
    }
}