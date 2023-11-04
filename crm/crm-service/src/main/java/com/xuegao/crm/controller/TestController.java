package com.xuegao.crm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port:0}")
    private String serverPort;

    @Value("${spring.application.name:0}")
    private String applicationName;

    @RequestMapping(path = "/test/get")
    public String get() {
        return "hello this is " + applicationName + ", port = " + serverPort;
    }

    @RequestMapping(path = "/test/get/hasAnyRole")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object get(Authentication authentication) {
        Authentication authenticationV2 = SecurityContextHolder.getContext().getAuthentication();
        Object credentials = authenticationV2.getCredentials();

        Object credentials1 = authentication.getCredentials();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        String token = details.getTokenValue();
        return token;
    }
}