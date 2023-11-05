// package com.xuegao.springsecuritydemo1.config;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
// // 配置类注解
// @Configuration
// // 开启 Security 服务
// @EnableWebSecurity
// public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//     // /**
//     //  *  注入自定义认证类
//     //  */
//     // @Autowired
//     // @Qualifier("userDetailsService")
//     // private MyUserDetailsServiceImpl userDetailsService;
//     //
//     // /**
//     //  * 密码的转码解码
//     //  * @param auth
//     //  * @throws Exception
//     //  */
//     // @Override
//     // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//     //     auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
//     //         @Override
//     //         public String encode(CharSequence charSequence) {
//     //             return charSequence.toString();
//     //         }
//     //         @Override
//     //         public boolean matches(CharSequence charSequence, String s) {
//     //             return s.equals(charSequence.toString());
//     //         }
//     //     });
//     // }
//
//     /**
//      * 定义具体的路径资源对应的权限
//      * authorizeRequests所有security全注解配置实现的开端，表示开始说明需要的权限。
//      * 需要的权限分两部分，第一部分是拦截的路径，第二部分访问该路径需要的权限。
//      * antMatchers表示拦截什么路径，permitAll任何权限都可以访问，直接放行所有。
//      * anyRequest()任何的请求，authenticated认证后才能访问
//      */
//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//
//         http.authorizeRequests()
//                 // 如果有允许匿名的url，填在下面
//                 .antMatchers("/anon").permitAll()
//                 //  /admin资源需要ROLE_ADMIN角色才能访问
//                 .antMatchers("/admin").hasRole("ADMIN")
//                 //  /user 资源需要有ROLE_USER才能访问
//                 .antMatchers("/user").hasRole("USER")
//                 //释放静态资源
//                 .antMatchers("/js/**", "/css/**", "/images/*", "/fonts/**", "/**/*.png", "/**/*.jpg").permitAll()
//                 // 所有请求都需要认证后才能访问
//                 .anyRequest().authenticated()
//                 .and()
//                 // 设置登陆
//                 .formLogin()
//                 // 设置登陆页面
//                 // .loginPage("/login")
//                 // 设置登陆成功页
//                 .defaultSuccessUrl("/").permitAll()
//                 // 自定义登陆用户名和密码参数，默认为username和password
//                 .usernameParameter("username")
//                 .passwordParameter("password")
// //                 .and()
// //                 .logout().permitAll()
//         ;
//
//         // 关闭CSRF跨域
//         http.csrf().disable();
//     }
//
//     /**
//      * 设置拦截忽略文件夹，可以对静态资源放行  与上边的一样 用那个都可以：
//      *
//      * @param web
//      */
//     @Override
//     public void configure(WebSecurity web) throws Exception {
//         // 忽略URL
//         web.ignoring()
//                 .antMatchers(
//                         "/**/*.js",
//                         "/image/*.jepg",
//                         "/**/*.css",
//                         "/**/*.js",
//                         "/**/*.map",
//                         "/**/*.html",
//                         "/**/*.png");
//     }
// }