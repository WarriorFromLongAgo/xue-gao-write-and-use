package com.xuegao.test.builder;

import com.xuegao.mybatis.builder.xml.XMLConfigBuilder;
import com.xuegao.mybatis.io.Resources;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class XmlConfigBuilderTest {

    @Test
    public void loadXMLConfigFile() {
        String resource = "org/apache/ibatis/builder/MinimalMapperConfig.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            XMLConfigBuilder builder = new XMLConfigBuilder(inputStream);

        } catch (Exception e) {

        }
    }
}
