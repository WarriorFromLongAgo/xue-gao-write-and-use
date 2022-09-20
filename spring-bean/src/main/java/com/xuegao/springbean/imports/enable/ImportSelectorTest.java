package com.xuegao.springbean.imports.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ImportSelectorTest implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.xuegao.springbean.imports.implement.ImportTestService2"};

        // 这里的importingClassMetadata针对的是使用@EnableService的非注解类
        // 因为`AnnotationMetadata`是`Import`注解所在的类属性，如果所在类是注解类，则延伸至应用这个注解类的非注解类为止
        // Map<String, Object> map = importingClassMetadata.getAnnotationAttributes(EnableService.class.getName(), true);
        // String name = (String) map.get("name");
        // if (Objects.equals(name, "B")) {
        //     return new String[]{"com.test.ConfigB"};
        // }
        // return new String[0];
    }
}
