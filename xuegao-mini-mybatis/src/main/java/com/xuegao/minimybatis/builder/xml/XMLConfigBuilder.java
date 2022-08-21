package com.xuegao.minimybatis.builder.xml;

import com.xuegao.minimybatis.builder.BaseBuilder;
import com.xuegao.minimybatis.datasource.DataSourceFactory;
import com.xuegao.minimybatis.datasource.unpooled.UnpooledDataSourceFactory;
import com.xuegao.minimybatis.io.Resources;
import com.xuegao.minimybatis.parsing.XNode;
import com.xuegao.minimybatis.parsing.XPathParser;
import com.xuegao.minimybatis.session.Environment;
import com.xuegao.minimybatis.session.MiniConfiguration;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class XMLConfigBuilder extends BaseBuilder {
    private XPathParser parser;
    private String environment;

    public XMLConfigBuilder(InputStream inputStream) {
        this(inputStream, null, null);
    }

    //构造函数，转换成XPathParser再去调用构造函数
    public XMLConfigBuilder(InputStream inputStream, String environment, Properties props) {
        //构造一个需要验证，XMLMapperEntityResolver的XPathParser
        this(new XPathParser(inputStream, true, props, new XMLMapperEntityResolver()), environment, props);
    }

    //上面6个构造函数最后都合流到这个函数，传入XPathParser
    private XMLConfigBuilder(XPathParser parser, String environment, Properties props) {
        super(new MiniConfiguration());
        this.environment = environment;
        this.parser = parser;
    }

    public MiniConfiguration parse() {
        //如果已经解析过了，报错
        // XPathParser传入xml路径，获取 XNode
        XNode xNode = parser.evalNode("/configuration");
        // 调用 parseConfiguration
        parseConfiguration(xNode);
        return miniConfiguration;
    }

    //解析配置
    private void parseConfiguration(XNode root) {
        try {
            // read it after objectFactory and objectWrapperFactory issue #631
            //7.环境
            environmentsElement(root.evalNode("environments"));
            //10.映射器
            mapperElement(root.evalNode("mappers"));
        } catch (Exception e) {
            throw new RuntimeException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
        }
    }

    private void mapperElement(XNode mappers) throws IOException {
        List<XNode> xNodeList = mappers.getChildren();
        for (XNode xNode : xNodeList) {
            String resource = xNode.getStringAttribute("resource");
            //10.1使用类路径
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //映射器比较复杂，调用XMLMapperBuilder
            //注意在for循环里每个mapper都重新new一个XMLMapperBuilder，来解析
            XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, miniConfiguration, resource);
            mapperParser.parse();
        }
    }

    private void environmentsElement(XNode environments) {
        if (environments != null) {
            if (environment == null) {
                environment = environments.getStringAttribute("default");
            }
            for (XNode child : environments.getChildren()) {
                String id = child.getStringAttribute("id");
                //循环比较id是否就是指定的environment
                if (isSpecifiedEnvironment(id)) {
                    //7.2数据源
                    DataSourceFactory dsFactory = dataSourceElement(child.evalNode("dataSource"));
                    DataSource dataSource = dsFactory.getDataSource();
                    Environment.Builder environmentBuilder = new Environment.Builder(id)
                            .dataSource(dataSource);
                    miniConfiguration.setEnvironment(environmentBuilder.build());
                }
            }
        }
    }

    private DataSourceFactory dataSourceElement(XNode dataSource) {
        if (dataSource != null) {
            // String type = dataSource.getStringAttribute("type");
            Properties props = dataSource.getChildrenAsProperties();
            //根据type="POOLED"解析返回适当的DataSourceFactory
            DataSourceFactory factory = new UnpooledDataSourceFactory();
            factory.setProperties(props);
            return factory;
        }
        throw new RuntimeException("dataSource");
    }

    //比较id和environment是否相等
    private boolean isSpecifiedEnvironment(String id) {
        if (environment == null) {
            throw new RuntimeException("No environment specified.");
        } else if (id == null) {
            throw new RuntimeException("Environment requires an id attribute.");
        } else if (environment.equals(id)) {
            return true;
        }
        return false;
    }
}