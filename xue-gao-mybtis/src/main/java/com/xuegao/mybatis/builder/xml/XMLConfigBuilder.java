package com.xuegao.mybatis.builder.xml;

import com.xuegao.mybatis.builder.BaseBuilder;
import com.xuegao.mybatis.builder.BuilderException;
import com.xuegao.mybatis.datasource.DataSourceFactory;
import com.xuegao.mybatis.executor.ErrorContext;
import com.xuegao.mybatis.io.Resources;
import com.xuegao.mybatis.mapping.Environment;
import com.xuegao.mybatis.parsing.XNode;
import com.xuegao.mybatis.parsing.XPathParser;
import com.xuegao.mybatis.session.Configuration;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class XMLConfigBuilder extends BaseBuilder {
    private final XPathParser parser;
    private String environment;

    public XMLConfigBuilder(InputStream inputStream) {
        this(inputStream, null, null);
    }

    public XMLConfigBuilder(InputStream inputStream, String environment) {
        this(inputStream, environment, null);
    }

    public XMLConfigBuilder(InputStream inputStream, String environment, Properties props) {
        this(new XPathParser(inputStream, true, props, new XMLMapperEntityResolver()), environment, props);
    }

    private XMLConfigBuilder(XPathParser parser, String environment, Properties props) {
        super(new Configuration());
        ErrorContext.instance().resource("SQL Mapper Configuration");
        this.environment = environment;
        this.parser = parser;
    }

    public Configuration parse() {
        parseConfiguration(parser.evalNode("/configuration"));
        return configuration;
    }

    private void parseConfiguration(XNode root) {
        try {
            // issue #117 read properties first
            // propertiesElement(root.evalNode("properties"));
            // Properties settings = settingsAsProperties(root.evalNode("settings"));
            // loadCustomVfs(settings);
            // loadCustomLogImpl(settings);
            // typeAliasesElement(root.evalNode("typeAliases"));
            // pluginElement(root.evalNode("plugins"));
            // objectFactoryElement(root.evalNode("objectFactory"));
            // objectWrapperFactoryElement(root.evalNode("objectWrapperFactory"));
            // reflectorFactoryElement(root.evalNode("reflectorFactory"));
            // settingsElement(settings);
            // read it after objectFactory and objectWrapperFactory issue #631
            environmentsElement(root.evalNode("environments"));
            // databaseIdProviderElement(root.evalNode("databaseIdProvider"));
            // typeHandlerElement(root.evalNode("typeHandlers"));
            mapperElement(root.evalNode("mappers"));
        } catch (Exception e) {
            throw new BuilderException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
        }
    }

    private void environmentsElement(XNode context) throws Exception {
        if (context != null) {
            if (environment == null) {
                environment = context.getStringAttribute("default");
            }
            for (XNode child : context.getChildren()) {
                String id = child.getStringAttribute("id");
                if (isSpecifiedEnvironment(id)) {
                    DataSourceFactory dsFactory = dataSourceElement(child.evalNode("dataSource"));
                    DataSource dataSource = dsFactory.getDataSource();
                    Environment.Builder environmentBuilder = new Environment.Builder(id).dataSource(dataSource);
                    configuration.setEnvironment(environmentBuilder.build());
                    break;
                }
            }
        }
    }

    private boolean isSpecifiedEnvironment(String id) {
        if (environment == null) {
            throw new BuilderException("No environment specified.");
        }
        if (id == null) {
            throw new BuilderException("Environment requires an id attribute.");
        }
        return environment.equals(id);
    }

    private DataSourceFactory dataSourceElement(XNode context) throws Exception {
        if (context != null) {
            String type = context.getStringAttribute("type");
            Properties props = context.getChildrenAsProperties();
            DataSourceFactory factory = (DataSourceFactory) resolveClass(type).getDeclaredConstructor().newInstance();
            factory.setProperties(props);
            return factory;
        }
        throw new BuilderException("Environment declaration requires a DataSourceFactory.");
    }

    private void mapperElement(XNode parent) throws Exception {
        if (parent != null) {
            for (XNode child : parent.getChildren()) {
                String resource = child.getStringAttribute("resource");
                if (resource != null) {
                    //10.1使用类路径
                    ErrorContext.instance().resource(resource);
                    InputStream inputStream = Resources.getResourceAsStream(resource);
                    //映射器比较复杂，调用XMLMapperBuilder
                    //注意在for循环里每个mapper都重新new一个XMLMapperBuilder，来解析
                    XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, resource, null);
                    mapperParser.parse();
                } else {
                    throw new BuilderException("A mapper element may only specify a url, resource or class, but not more than one.");
                }
            }
        }
    }
}
