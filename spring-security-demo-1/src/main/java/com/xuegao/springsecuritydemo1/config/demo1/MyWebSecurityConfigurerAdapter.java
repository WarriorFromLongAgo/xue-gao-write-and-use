package com.xuegao.springsecuritydemo1.config.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 这是spring-security的核心配置类
 *
 * @author LiaoBaohong 2021/7/14
 */
@Slf4j
@Configuration
@EnableWebSecurity
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;

    @Autowired
    private MyUserDetailService myUserDetailService;

    // @Autowired
    // private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;


    /**
     * 这里用来验证权限
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        // 这里需要把我们自定义的核心验证方法装配进去使用
        //将自定的UserDetailsService装配到AuthenticationManagerBuilder
        auth
                .authenticationProvider(myAuthenticationProvider)
                .userDetailsService(myUserDetailService)
                .passwordEncoder(password());
    }

    /**
     * 这里用来配置我们自定义的登录页面
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                .formLogin()
                .loginPage("/login.html")   //自定义登录页面
                .loginProcessingUrl("/user/login") // 登录访问路径
                .failureUrl("/login/error") // 处理异常的controller
                // .authenticationDetailsSource(authenticationDetailsSource)  //自定义的资源要配置进去
                .defaultSuccessUrl("/login/index")
                .permitAll()  // 登录成功后默认页面

                .and()

                //设置哪些页面和请求不需要登录就能访问
                .authorizeRequests()
                .antMatchers("/", "/login/hello", "/user/login")
                .permitAll()

                // 其余的页面，都需要登录
                .anyRequest().authenticated()

                .and()

                .csrf().disable();  //关闭csrf防护
    }

    @Bean
    PasswordEncoder password() {
        // 前端传来的秘密通过这个加密方式加密后与数据库被加密的密码匹配 如果匹配, 那么就是登录成功 @TODO
        return new BCryptPasswordEncoder();
    }
}
