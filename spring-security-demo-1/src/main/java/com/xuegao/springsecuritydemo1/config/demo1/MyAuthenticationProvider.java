package com.xuegao.springsecuritydemo1.config.demo1;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 这里自定义了一个AuthenticationProvider来处理实际的认证业务逻辑，在这里可以方便的根据我们需要来进行自定义，
 * 做验证码校验、效期校验和验密，可以根据需要定制。认证成功就返回一个UsernamePasswordAuthenticationToken对象并配置好合适的权限
 * 如果认证失败，只需要抛出一个异常（AuthenticationException的子类），
 *
 * @author LiaoBaohong 2021/7/14
 */
@Component
@Slf4j
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // authentication = {"authenticated":false,"authorities":[],"credentials":"password123456","details":{"remoteAddress":"0:0:0:0:0:0:0:1","sessionId":"A393B2C7F77DC1B5B9868B5820EEAFCD"},"name":"xuegao","principal":"xuegao"}
        // authentication = {"authenticated":false,"authorities":[],"credentials":"213131","details":{"remoteAddress":"0:0:0:0:0:0:0:1"},"name":"xuegao","principal":"xuegao"}
        System.out.println("authentication = " + JSON.toJSONString(authentication));
        String username = authentication.getPrincipal().toString();
        Object credentials = authentication.getCredentials();
        String password = (credentials != null) ? credentials.toString() : null;

        String dbPassword = myUserDetailService.loadUserByUsername(username).getPassword();

        if (!dbPassword.equals(password)) {
            log.info("密码错误");
            throw new BadCredentialsException("密码错误");
        }

        // @TODO 赋予权限,后期改成数据库权限
        Collection<GrantedAuthority> auths = (Collection<GrantedAuthority>) myUserDetailService.loadUserByUsername(username).getAuthorities();
        return new UsernamePasswordAuthenticationToken(username, password, auths);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
