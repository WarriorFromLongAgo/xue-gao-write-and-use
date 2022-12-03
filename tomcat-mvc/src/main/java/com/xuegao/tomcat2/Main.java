package com.xuegao.tomcat2;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.servlet.DispatcherServlet;

public class Main {

    public static void main(String[] args) throws LifecycleException {
        //自己写Tomcat的启动源码
        Tomcat tomcat = new Tomcat();


        tomcat.setPort(8888);
        tomcat.setHostname("localhost");
        tomcat.setBaseDir(".");

        Context context = tomcat.addWebapp("/boot", System.getProperty("user.dir") + "/src/main");

        //自己创建 DispatcherServlet 对象，并且创建ioc容器，DispatcherServlet里面有ioc容器
        DispatcherServlet servlet = new DispatcherServlet();
        Wrapper hello = tomcat.addServlet("/boot", "hello", servlet);

        tomcat.start(); //启动tomcat 注解版MVC利用Tomcat SPI机制

        tomcat.getServer().await(); //服务器等待
    }
}