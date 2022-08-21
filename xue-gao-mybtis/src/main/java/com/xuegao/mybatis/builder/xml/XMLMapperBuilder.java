/*
 *    Copyright 2009-2013 the original author or authors.
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
package com.xuegao.mybatis.builder.xml;

import com.xuegao.mybatis.builder.BaseBuilder;
import com.xuegao.mybatis.builder.BuilderException;
import com.xuegao.mybatis.builder.MapperBuilderAssistant;
import com.xuegao.mybatis.io.Resources;
import com.xuegao.mybatis.parsing.XNode;
import com.xuegao.mybatis.parsing.XPathParser;
import com.xuegao.mybatis.session.Configuration;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author Clinton Begin
 */

/**
 * XML映射构建器，建造者模式,继承BaseBuilder
 */
public class XMLMapperBuilder extends BaseBuilder {

    private XPathParser parser;
    //映射器构建助手
    private MapperBuilderAssistant builderAssistant;
    //用来存放sql片段的哈希表
    private Map<String, XNode> sqlFragments;
    private String resource;

    public XMLMapperBuilder(InputStream inputStream, Configuration configuration, String resource, Map<String, XNode> sqlFragments, String namespace) {
        this(inputStream, configuration, resource, sqlFragments);
        this.builderAssistant.setCurrentNamespace(namespace);
    }

    public XMLMapperBuilder(InputStream inputStream, Configuration configuration, String resource, Map<String, XNode> sqlFragments) {
        this(new XPathParser(inputStream, true, configuration.getVariables(), new XMLMapperEntityResolver()),
                configuration, resource, sqlFragments);
    }

    private XMLMapperBuilder(XPathParser parser, Configuration configuration, String resource, Map<String, XNode> sqlFragments) {
        super(configuration);
        this.builderAssistant = new MapperBuilderAssistant(configuration, resource);
        this.parser = parser;
        this.sqlFragments = sqlFragments;
        this.resource = resource;
    }

    //解析
    public void parse() {
        //如果没有加载过再加载，防止重复加载
        if (!configuration.isResourceLoaded(resource)) {
            //配置mapper
            configurationElement(parser.evalNode("/mapper"));
            //标记一下，已经加载过了
            configuration.addLoadedResource(resource);
            //绑定映射器到namespace
            bindMapperForNamespace();
        }
    }

    private void configurationElement(XNode context) {
        try {
            //1.配置namespace
            String namespace = context.getStringAttribute("namespace");
            if (namespace.equals("")) {
                throw new BuilderException("Mapper's namespace cannot be empty");
            }
            builderAssistant.setCurrentNamespace(namespace);
            //5.配置resultMap(高级功能)
            // resultMapElements(context.evalNodes("/mapper/resultMap"));
            //7.配置select|insert|update|delete TODO
            buildStatementFromContext(context.evalNodes("select|insert|update|delete"));
        } catch (Exception e) {
            throw new BuilderException("Error parsing Mapper XML. Cause: " + e, e);
        }
    }

    //7.配置select|insert|update|delete
    private void buildStatementFromContext(List<XNode> list) {
        //调用7.1构建语句
        if (configuration.getDatabaseId() != null) {
            buildStatementFromContext(list, configuration.getDatabaseId());
        }
        buildStatementFromContext(list, null);
    }

    //7.1构建语句
    private void buildStatementFromContext(List<XNode> list, String requiredDatabaseId) {
        for (XNode context : list) {
            //构建所有语句,一个mapper下可以有很多select
            //语句比较复杂，核心都在这里面，所以调用XMLStatementBuilder
            final XMLStatementBuilder statementParser = new XMLStatementBuilder(configuration, builderAssistant, context, requiredDatabaseId);
            //核心XMLStatementBuilder.parseStatementNode
            statementParser.parseStatementNode();
        }
    }

    private void bindMapperForNamespace() {
        String namespace = builderAssistant.getCurrentNamespace();
        if (namespace != null) {
            Class<?> boundType = null;
            try {
                boundType = Resources.classForName(namespace);
            } catch (ClassNotFoundException e) {
                //ignore, bound type is not required
            }
            if (boundType != null) {
                // if (!configuration.hasMapper(boundType)) {
                // Spring may not know the real resource name so we set a flag
                // to prevent loading again this resource from the mapper interface
                // look at MapperAnnotationBuilder#loadXmlResource
                // configuration.addLoadedResource("namespace:" + namespace);
                // configuration.addMapper(boundType);
            }
        }
    }
}
