package com.xuegao.springcloudstarteroauth2demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsService kiteUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore redisTokenStore;

    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        super.configure(endpoints);
        /**
         * redis token 方式
         */
        endpoints
                // authenticationManage() 调用此方法才能支持 password 模式。
                .authenticationManager(authenticationManager)
                // authenticationManage() 调用此方法才能支持 password 模式。
                .userDetailsService(kiteUserDetailsService)
                // tokenStore() 指定 token 的存储方式。
                .tokenStore(redisTokenStore);

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // ClientId、Client-Secret：这两个参数对应请求端定义的 cleint-id 和 client-secret

        // authorizedGrantTypes 可以包括如下几种设置中的一种或多种：
        // authorization_code：授权码类型。
        // implicit：隐式授权类型。
        // password：资源所有者（即用户）密码类型。
        // client_credentials：客户端凭据（客户端ID以及Key）类型。
        // refresh_token：通过以上授权获得的刷新令牌来获取新的令牌。

        // accessTokenValiditySeconds：token 的有效期

        // scopes：用来限制客户端访问的权限，在换取的 token 的时候会带上 scope 参数，只有在 scopes 定义内的，才可以正常换取 token。

        clients.inMemory()

                .withClient("crm-service")
                .secret(passwordEncoder.encode("crm-123456"))
                // .secret("crm-123456")
                .authorizedGrantTypes("authorization_code", "password","client_credentials","implicit","refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(3600)
                .scopes("all")

                .and()

                .withClient("hr-service")
                .secret(passwordEncoder.encode("hr-123456"))
                // .secret("hr-123456")
                .authorizedGrantTypes("authorization_code", "password","client_credentials","implicit","refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(3600)
                .scopes("all");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // AuthorizationServerSecurityConfigurer

        // 第一行代码是允许客户端访问 OAuth2 授权接口，否则请求 token 会返回 401。
        // security.allowFormAuthenticationForClients();
        // 第二行和第三行分别是允许已授权用户访问 checkToken 接口和获取 token 接口。
        // security.checkTokenAccess("isAuthenticated()");
        // security.tokenKeyAccess("isAuthenticated()");

        super.configure(security);
        security
                .tokenKeyAccess("permitAll()")                    //oauth/token_key是公开
                .checkTokenAccess("permitAll()")                  //oauth/check_token公开
                .allowFormAuthenticationForClients()				//表单认证（申请令牌）
        ;

    }

// POST http://localhost:6001/oauth/token?grant_type=password&username=admin&password=123456&scope=all
// Accept: */*
// Cache-Control: no-cache
// Authorization: Basic dXNlci1jbGllbnQ6dXNlci1zZWNyZXQtODg4OA==

    // grant_type 是 password，表明这是使用 OAuth2 的密码模式。
    // username=admin 和 password=123456 就相当于在 web 端登录界面输入的用户名和密码，
    // 我们在认证服务端配置中固定了用户名是 admin 、密码是 123456，而线上环境中则应该通过查询数据库获取。
    // scope=all 是权限有关的，在认证服务的 OAuthConfig 中指定了 scope 为 all 。

    // Authorization 要加在请求头中，格式为 Basic 空格 base64(clientId:clientSecret)，
    // 这个微服务客户端的 client-id 是 user-client，
    // client-secret 是 user-secret-8888，将这两个值通过冒号连接，
    // 并使用 base64 编码(user-client:user-secret-8888)之后的值为 dXNlci1jbGllbnQ6dXNlci1zZWNyZXQtODg4OA==，
    // crm-service:crm-123456
    // Y3JtLXNlcnZpY2U6Y3JtLTEyMzQ1Ng==

    // 可以通过 https://www.sojson.com/base64.html 在线编码获取。

    // 运行请求后，如果参数都正确的话，获取到的返回内容如下，是一段 json 格式
    // {
    //     "access_token": "9f958300-5005-46ea-9061-323c9e6c7a4d",
    //     "token_type": "bearer",
    //     "refresh_token": "0f5871f5-98f1-405e-848e-80f641bab72e",
    //     "expires_in": 3599,
    //     "scope": "all"
    // }

}