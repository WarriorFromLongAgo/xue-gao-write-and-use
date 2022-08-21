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
package com.xuegao.minimybatis.builder.xml;

import com.xuegao.minimybatis.builder.BaseBuilder;
import com.xuegao.minimybatis.parsing.XNode;
import com.xuegao.minimybatis.parsing.XPathParser;
import com.xuegao.minimybatis.session.MiniConfiguration;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Clinton Begin
 */

/**
 * XML映射构建器，建造者模式,继承BaseBuilder
 */
public class XMLMapperBuilder extends BaseBuilder {

    private XPathParser parser;
    private String resource;


    public XMLMapperBuilder(InputStream inputStream, MiniConfiguration miniConfiguration, String resource) {
        this(new XPathParser(inputStream, true, new Properties(), new XMLMapperEntityResolver()),
                miniConfiguration, resource);
    }

    private XMLMapperBuilder(XPathParser parser, MiniConfiguration miniConfiguration, String resource) {
        super(miniConfiguration);
        this.parser = parser;
        this.resource = resource;
    }

    //解析
    public void parse() {
        XNode mapperNode = parser.evalNode("/mapper");
        //1.配置namespace
        String namespace = mapperNode.getStringAttribute("namespace");
        if (namespace.equals("")) {
            throw new RuntimeException("Mapper's namespace cannot be empty");
        }


    }
}
