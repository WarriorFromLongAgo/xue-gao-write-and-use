package com.xuegao.jwt_demo1;

import com.xuegao.jwt_demo1.framwork.util.JwtUtil;
import com.xuegao.jwt_demo1.user.domain.UserInfo;
import com.xuegao.jwt_demo1.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class JwtDemo1ApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void createJwt() {
        UserInfo byUsername = userService.getByUsername();

        Map<String, Object> map = new HashMap<>();
        map.put("userId", 1002);
        String token = JwtUtil.createToken(map, byUsername.getPassword());
        System.out.println(token);

        // https://jwt.io/

        // 获取id，然后根据id获取用户信息后，再进行验签。。确保用户更改密码后，验签失败
        // 也可以在redis中，维护一次jwt与userid的对应关系，然后再进行验签等等

    }

    @Test
    void verifyToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwZWFlZjZlYi1mOWZjLTQzODAtODZmOS1mNzMzMGI4ZTMzNjQiLCJpYXQiOjE2OTg2Nzg0ODgsImV4cCI6MTY5ODY4MjA4OCwidXNlcklkIjoxMDAyfQ.jvgb4eqkx06kz5AVWYvVAzfeFlwsjz3dE0Fd_3JfbOQ";
        int result = JwtUtil.verifyToken(token);
//        0 验证成功，1、2、3、4、5 验证失败
        System.out.println(result);
    }

    @Test
    void parseToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwZWFlZjZlYi1mOWZjLTQzODAtODZmOS1mNzMzMGI4ZTMzNjQiLCJpYXQiOjE2OTg2Nzg0ODgsImV4cCI6MTY5ODY4MjA4OCwidXNlcklkIjoxMDAyfQ.jvgb4eqkx06kz5AVWYvVAzfeFlwsjz3dE0Fd_3JfbOQ";
        Map<String, Object> map = JwtUtil.parseToken(token);
        System.out.println(map);
    }
}
