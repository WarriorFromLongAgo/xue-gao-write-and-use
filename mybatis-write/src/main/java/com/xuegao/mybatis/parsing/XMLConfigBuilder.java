package com.xuegao.mybatis.parsing;

import com.xuegao.mybatis.mapping.MyConfiguration;
import com.xuegao.mybatis.mapping.MyEnvironment;
import com.xuegao.mybatis.mapping.MyMapperStatement;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class XMLConfigBuilder {

    // 把解析出来的赋值给MyConfiguration
    private MyConfiguration myConfiguration;
    private XPathParser parser;

    public XMLConfigBuilder(InputStream inputStream) {
        //构造一个需要验证，XMLMapperEntityResolver的XPathParser
        this(new XPathParser(inputStream));
    }

    private XMLConfigBuilder(XPathParser parser) {
        myConfiguration = new MyConfiguration();
        this.parser = parser;
    }

    public MyConfiguration parse() {
        // XPathParser传入xml路径，获取 XNode
        XNode xNode = parser.evalNode("/configuration");
        // 调用 parseConfiguration
        parseConfiguration(xNode);
        return myConfiguration;
    }

    //解析配置
    private void parseConfiguration(XNode root) {
        Map<String, MyMapperStatement> mapperStatementMap = new ConcurrentHashMap<>(10);

        try {
            XNode environments = root.evalNode("environments");

            for (XNode child : environments.getChildren()) {
                MyEnvironment myEnvironment = new MyEnvironment();
                XNode dataSourceNode = child.evalNode("dataSource");
                String dataSourceType = dataSourceNode.getStringAttribute("type");

                Properties childrenAsProperties = dataSourceNode.getChildrenAsProperties();
                for (Map.Entry<Object, Object> entry : childrenAsProperties.entrySet()) {
                    String propertyName = (String) entry.getKey();
                    String propertyValue = (String) entry.getValue();
                    if ("driver".equals(propertyName)) {
                        myEnvironment.setDriver(propertyValue);
                    }
                    if ("url".equals(propertyName)) {
                        myEnvironment.setUrl(propertyValue);
                    }
                    if ("username".equals(propertyName)) {
                        myEnvironment.setUsername(propertyValue);
                    }
                    if ("password".equals(propertyName)) {
                        myEnvironment.setPassword(propertyValue);
                    }
                }
                myConfiguration.setMyEnvironment(myEnvironment);
            }

            XNode mappersParentNode = root.evalNode("mappers");

            List<XNode> mappersNodeList = mappersParentNode.getChildren();
            for (XNode mappersNode : mappersNodeList) {
                MyMapperStatement myMapperStatement = new MyMapperStatement();
                // mapper.xml配置
                String resource = mappersNode.getStringAttribute("resource");
                // 解析mapper.xml文件
                InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
                this.parser = new XPathParser(inputStream);

                if (!myConfiguration.isResourceLoaded(resource)) {
                    //配置mapper
                    XNode mapperNode = parser.evalNode("/mapper");
                    String namespace = mapperNode.getStringAttribute("namespace");
                    if (namespace.equals("")) {
                        throw new RuntimeException("Mapper's namespace cannot be empty");
                    }
                    // 必须这么获取
                    // List<XNode> resultMapNodeList = mapperNode.evalNodes("/mapper/resultMap");

                    List<XNode> crudNodeList = mapperNode.evalNodes("select|insert|update|delete");
                    for (XNode crudNode : crudNodeList) {
                        String id = "";
                        String sql = "";
                        String resultType = "";
                        String parameterType = "";
                        String crudType = "";

                        id = crudNode.getStringAttribute("id");
                        sql = crudNode.getStringBody();
                        resultType = crudNode.getStringAttribute("resultType");
                        parameterType = crudNode.getStringAttribute("parameterType");
                        crudType = crudNode.getName();

                        myMapperStatement.setNamespace(namespace);
                        myMapperStatement.setId(id);
                        myMapperStatement.setSql(sql);
                        myMapperStatement.setResultType(resultType);
                        myMapperStatement.setParameterType(parameterType);
                        myMapperStatement.setCrudType(crudType);

                        System.out.println();
                        mapperStatementMap.put(namespace + "." + id, myMapperStatement);
                    }
                    //标记一下，已经加载过了
                    myConfiguration.addLoadedResource(resource);
                    myConfiguration.addLoadedResource("namespace:" + namespace);
                    //绑定映射器到namespace
                    // bindMapperForNamespace();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
        }
        myConfiguration.setMapperStatement(mapperStatementMap);
    }
}
