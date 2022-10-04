package com.xuegao.springbean.util;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OnlyPrintUtil {
    private static final Map<String, String> CLASS_NAME_MAP = new HashMap<>();
    private static final String STR_SEPARATE = "===";

    /**
     * 只打印一次
     * print
     *
     * @param className:
     * @author xuegao
     * @date 2022/10/4 14:18
     */
    public static void print(String className, String methodName) {
        if (!StringUtils.hasText(className)) {
            throw new RuntimeException("className不能为空");
        }
        if (StringUtils.hasText(methodName)) {
            String tempKey = className + STR_SEPARATE + methodName;
            CLASS_NAME_MAP.computeIfAbsent(tempKey, s -> {
                System.out.println(tempKey);
                return tempKey;
            });
            return;
        }
        CLASS_NAME_MAP.computeIfAbsent(className, s -> {
            System.out.println(className);
            return className;
        });
    }

    public static void print(Class<?> cClass, String methodName) {
        if (Objects.isNull(cClass)) {
            throw new RuntimeException("class不能为空");
        }
        print(cClass.getSimpleName(), methodName);
    }
}
