package org.springframework.boot.context.properties.source;


import com.xuegao.common.XueGaoConstant;
import com.xuegao.config.XueGaoProperties;
import com.xuegao.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.Map;

public class TestConfigurationPropertySource {
    private static final Logger log = LoggerFactory.getLogger(TestConfigurationPropertySource.class);


    @Test
    public void testMapConfigurationPropertySourceV1() {
        XueGaoProperties xueGaoProperties = new XueGaoProperties();
        log.info("[xueGaoProperties=1={}]", JsonUtil.toJsonString(xueGaoProperties));

        Map<String, Object> oldProperties = new HashMap<>(10);
        oldProperties.put("xue-gao.tool.enabled", false);
        oldProperties.put("spring.tomcat.size", 100);
        oldProperties.put("xue-gao.tool.name", "1111");
        oldProperties.put("xue-gao.tool.tomcat.name", "tomcat_1111");
        log.info("[oldProperties={}]", JsonUtil.toJsonString(oldProperties));

        Map<String, Object> newProperties = new HashMap<>(10);
        newProperties.put("xue-gao.tool.enabled", true);
        newProperties.put("spring.tomcat.size", 200);
        newProperties.put("xue-gao.tool.name", "一一一一");
        newProperties.put("xue-gao.tool.tomcat.name", "tomcat_一一一一");
        log.info("[newProperties={}]", JsonUtil.toJsonString(newProperties));

        ConfigurationPropertySource oldSource = new MapConfigurationPropertySource(oldProperties);
        Binder oldBinder = new Binder(oldSource);
        ResolvableType oldType = ResolvableType.forClass(XueGaoProperties.class);
        Bindable<?> oldTarget = Bindable.of(oldType).withExistingValue(xueGaoProperties);
        oldBinder.bind(XueGaoConstant.XueGaoProperties.PROPERTIES_PREFIX, oldTarget);
        log.info("[xueGaoProperties=2={}]", JsonUtil.toJsonString(xueGaoProperties));

        ConfigurationPropertySource newSource = new MapConfigurationPropertySource(newProperties);
        Binder newBinder = new Binder(newSource);
        ResolvableType newType = ResolvableType.forClass(XueGaoProperties.class);
        Bindable<?> newTarget = Bindable.of(newType).withExistingValue(xueGaoProperties);
        newBinder.bind(XueGaoConstant.XueGaoProperties.PROPERTIES_PREFIX, newTarget);
        log.info("[xueGaoProperties=3={}]", JsonUtil.toJsonString(xueGaoProperties));

        // [xueGaoProperties=1={"enabled":true,"enabledBanner":true}]
        // [oldProperties={"spring.tomcat.size":100,"xue-gao.tool.name":"1111","xue-gao.tool.enabled":false,"xue-gao.tool.tomcat.name":"tomcat_1111"}]
        // [newProperties={"spring.tomcat.size":200,"xue-gao.tool.name":"一一一一","xue-gao.tool.enabled":true,"xue-gao.tool.tomcat.name":"tomcat_一一一一"}]
        // [xueGaoProperties=2={"enabled":false,"enabledBanner":true,"name":"1111"}]
        // [xueGaoProperties=3={"enabled":true,"enabledBanner":true,"name":"一一一一"}]

        // 结论，
        // 1，只会处理第一层的数据，"enabled":false,"enabledBanner":true,"name":"1111"
        //     1.1，如果是第一层的数据，那么就会覆盖原来的数据
        // 2，不会处理第二层的数据，"tomcat":{"name":"tomcat_1111"}
        //     如果是第二层的数据，压根不会处理


    }


}
