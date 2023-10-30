package com.xuegao.jwt_demo1;

import com.xuegao.jwt_demo1.framwork.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class JwtDemo1ApplicationTests {

    @Test
    void createJwt() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 1002);
        map.put("userName", "张晓明");
        map.put("age", 12);
        map.put("address", "山东省青岛市李沧区");
        String token = JwtUtil.createToken(map);
        System.out.println(token);
    }

    @Test
    void verifyToken() {
        String token = "1eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5NWZiMTczNS1mYmQ2LTQ5ODgtYjFmNC04ZTZmMGYwMTIwOTkiLCJpYXQiOjE2OTg2NjcyOTUsImV4cCI6MTY5ODY3MDg5NSwiYWRkcmVzcyI6IuWxseS4nOecgemdkuWym-W4guadjuayp-WMuiIsInVzZXJOYW1lIjoi5byg5pmT5piOIiwidXNlcklkIjoxMDAyLCJhZ2UiOjEyfQ.ijnIU8pQu9XRQ6pFTSKigobg_5s17cY-ba-RppKIlTk";
        int result = JwtUtil.verifyToken(token);
//        0 验证成功，1、2、3、4、5 验证失败
        System.out.println(result);
    }

    @Test
    void parseToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI5NWZiMTczNS1mYmQ2LTQ5ODgtYjFmNC04ZTZmMGYwMTIwOTkiLCJpYXQiOjE2OTg2NjcyOTUsImV4cCI6MTY5ODY3MDg5NSwiYWRkcmVzcyI6IuWxseS4nOecgemdkuWym-W4guadjuayp-WMuiIsInVzZXJOYW1lIjoi5byg5pmT5piOIiwidXNlcklkIjoxMDAyLCJhZ2UiOjEyfQ.ijnIU8pQu9XRQ6pFTSKigobg_5s17cY-ba-RppKIlTk";
        Map<String, Object> map = JwtUtil.parseToken(token);
        System.out.println(map);
    }
}
