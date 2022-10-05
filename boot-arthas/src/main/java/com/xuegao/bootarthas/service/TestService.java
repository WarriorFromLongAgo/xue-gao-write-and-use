package com.xuegao.bootarthas.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {

    private static final String STATIC_STR = "TestService STATIC_STR";

    private static final Map<String, String> STATIC_MAP = new HashMap<>();

    private final String STR_1 = "str 1";

    static {
        STATIC_MAP.put("TestService STATIC_STR 1", "1111");
        STATIC_MAP.put("TestService STATIC_STR 2", "2222");
        STATIC_MAP.put("TestService STATIC_STR 3", "3333");
    }


    public String test1(String input) {
        System.out.println("mc 2");
        return "TestService test1 = " + input;
    }

    public static String staticTest1(String input) {
        System.out.println("mc");
        return "TestService staticTest1 = " + input;
    }
}
