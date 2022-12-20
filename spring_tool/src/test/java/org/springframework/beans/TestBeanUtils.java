package org.springframework.beans;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.xuegao.config.XueGaoProperties;
import com.xuegao.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.Objects;

public class TestBeanUtils {
    private static final Logger log = LoggerFactory.getLogger(TestBeanUtils.class);

    @Test
    public void testCopyProperties() {
        XueGaoProperties oldXueGaoProperties = new XueGaoProperties();
        oldXueGaoProperties.setName("1111");
        XueGaoProperties.SimpleTpProperties oldTomcat = new XueGaoProperties.SimpleTpProperties();
        oldTomcat.setSimpleName("tomcat_1111");
        log.info("[oldXueGaoProperties={}]", JsonUtil.toJsonString(oldXueGaoProperties));

        XueGaoProperties newXueGaoProperties = new XueGaoProperties();
        newXueGaoProperties.setName("一一一一");
        newXueGaoProperties.setEnabled(false);
        newXueGaoProperties.setEnabledBanner(false);
        XueGaoProperties.SimpleTpProperties newTomcat = new XueGaoProperties.SimpleTpProperties();
        newTomcat.setSimpleName("tomcat_一一一一");
        log.info("[newXueGaoProperties={}]", JsonUtil.toJsonString(newXueGaoProperties));

        BeanUtils.copyProperties(oldXueGaoProperties, newXueGaoProperties);

        // 不写例子了，直接上结论：
        // source会覆盖掉target中原有的值

        // 1、属性名相同，类型相同 可以被复制
        // 2、基本类型 与 其对应的封装类型 可以被复制
        // 3、封装类型 与 其对应的基本类型 可以被复制
        // 4、其他统统不行
        // 例如：
        // Integer -> Long
        // int     -> long
        // Date    -> String
        // 等

        // 如果希望哪个属性不被复制，使用重载方法
        // public static void copyProperties(Object source, Object target, String... ignoreProperties) throws BeansException
        // source 与 target 都是不能为null的，会报错。
        // 复制实现是靠set、get，所以实体中的字段要有这两个方法，没有是不会被复制赋值的。

    }

    @Test
    public void testSourceFieldNull() {
        XueGaoProperties oldXueGaoProperties = new XueGaoProperties();
        oldXueGaoProperties.setName("1111");
        XueGaoProperties.SimpleTpProperties oldTomcat = new XueGaoProperties.SimpleTpProperties();
        oldTomcat.setSimpleName("tomcat_1111");
        log.info("[oldXueGaoProperties={}]", JsonUtil.toJsonString(oldXueGaoProperties));

        XueGaoProperties newXueGaoProperties = new XueGaoProperties();
        newXueGaoProperties.setName(null);
        newXueGaoProperties.setEnabled(false);
        newXueGaoProperties.setEnabledBanner(false);
        log.info("[newXueGaoProperties={}]", JsonUtil.toJsonString(newXueGaoProperties));

        log.info("=====================================================================");
        BeanUtils.copyProperties(newXueGaoProperties, oldXueGaoProperties);
        log.info("[oldXueGaoProperties=1={}]", JsonUtil.toJsonString(oldXueGaoProperties));
        log.info("[newXueGaoProperties=2={}]", JsonUtil.toJsonString(newXueGaoProperties));

        // [oldXueGaoProperties={"enabled":true,"enabledBanner":true,"name":"1111"}]
        // [newXueGaoProperties={"enabled":false,"enabledBanner":false}]
        // =====================================================================
        // [oldXueGaoProperties=1={"enabled":false,"enabledBanner":false}]
        // [newXueGaoProperties=2={"enabled":false,"enabledBanner":false}]

        // 结论，如果 Source 字段为空，那么也会被过滤

    }

    @Test
    public void testSourceFieldNull_Multilayer() {
        XueGaoProperties oldXueGaoProperties = new XueGaoProperties();
        oldXueGaoProperties.setName("1111");
        XueGaoProperties.SimpleTpProperties oldTomcat = new XueGaoProperties.SimpleTpProperties();
        oldTomcat.setSimpleName("tomcat_1111");
        oldXueGaoProperties.setTomcat(oldTomcat);
        log.info("[oldXueGaoProperties={}]", JsonUtil.toJsonString(oldXueGaoProperties));

        XueGaoProperties newXueGaoProperties = new XueGaoProperties();
        newXueGaoProperties.setName(null);
        XueGaoProperties.SimpleTpProperties newTomcat = new XueGaoProperties.SimpleTpProperties();
        oldTomcat.setSimpleName(null);
        newXueGaoProperties.setTomcat(newTomcat);
        log.info("[newXueGaoProperties={}]", JsonUtil.toJsonString(newXueGaoProperties));

        log.info("=====================================================================");
        BeanUtils.copyProperties(newXueGaoProperties, oldXueGaoProperties);
        log.info("[oldXueGaoProperties=1={}]", JsonUtil.toJsonString(oldXueGaoProperties));
        log.info("[newXueGaoProperties=2={}]", JsonUtil.toJsonString(newXueGaoProperties));

        // [oldXueGaoProperties={"enabled":true,"enabledBanner":true,"name":"1111","tomcat":{"name":"tomcat_1111"}}]
        // [newXueGaoProperties={"enabled":true,"enabledBanner":true,"tomcat":{}}]
        // =====================================================================
        // [oldXueGaoProperties=1={"enabled":true,"enabledBanner":true,"tomcat":{}}]
        // [newXueGaoProperties=2={"enabled":true,"enabledBanner":true,"tomcat":{}}]

        // 结论，如果 Source 字段为空，如果是多层嵌套，那么也会被过滤
    }

    @Test
    public void testSourceFieldNull_Multilayer_V2() {
        XueGaoProperties oldXueGaoProperties = new XueGaoProperties();
        oldXueGaoProperties.setName("1111");
        XueGaoProperties.SimpleTpProperties oldTomcat = new XueGaoProperties.SimpleTpProperties();
        oldTomcat.setSimpleName("tomcat_1111");
        oldXueGaoProperties.setTomcat(oldTomcat);
        log.info("[oldXueGaoProperties={}]", JsonUtil.toJsonString(oldXueGaoProperties));

        XueGaoProperties newXueGaoProperties = new XueGaoProperties();
        newXueGaoProperties.setName(null);
        XueGaoProperties.SimpleTpProperties newTomcat = new XueGaoProperties.SimpleTpProperties();
        oldTomcat.setSimpleName(null);
        newXueGaoProperties.setTomcat(newTomcat);
        log.info("[newXueGaoProperties={}]", JsonUtil.toJsonString(newXueGaoProperties));

        log.info("=====================================================================");
        // BeanUtil.copyProperties(newXueGaoProperties, oldXueGaoProperties, true);
        BeanUtil.copyProperties(newXueGaoProperties, oldXueGaoProperties,
                CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        log.info("[oldXueGaoProperties=1={}]", JsonUtil.toJsonString(oldXueGaoProperties));
        log.info("[newXueGaoProperties=2={}]", JsonUtil.toJsonString(newXueGaoProperties));

        // [oldXueGaoProperties={"enabled":true,"enabledBanner":true,"name":"1111","tomcat":{"simpleName":"tomcat_1111"}}]
        // [newXueGaoProperties={"enabled":true,"enabledBanner":true,"tomcat":{}}]
        // =====================================================================
        // [oldXueGaoProperties=1={"enabled":true,"enabledBanner":true,"name":"1111","tomcat":{}}]
        // [newXueGaoProperties=2={"enabled":true,"enabledBanner":true,"tomcat":{}}]

    }

    // 这个也没用，都只能处理一层
    public static String[] getNullNameArr(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        String[] nullNameArr = Arrays.stream(pds)
                .map(propertyDescriptor -> {
                    Object srcValue = src.getPropertyValue(propertyDescriptor.getName());
                    if (Objects.nonNull(srcValue)) {
                        return propertyDescriptor.getName();
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .toArray(String[]::new);
        if (log.isDebugEnabled()){
            log.debug("DynamicTp PropertiesBinder, nullNameArr: {}", Arrays.toString(nullNameArr));
        }
        return nullNameArr;
    }
}
