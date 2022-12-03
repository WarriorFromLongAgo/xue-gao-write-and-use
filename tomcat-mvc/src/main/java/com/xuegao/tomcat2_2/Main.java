package com.xuegao.tomcat2_2;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Main {

    public static void main(String[] args) throws LifecycleException {
        //自己写Tomcat的启动源码
        Tomcat tomcat = new Tomcat();


        tomcat.setPort(8888);
        tomcat.setHostname("localhost");
        tomcat.setBaseDir(".");

        Context context = tomcat.addWebapp("/boot", System.getProperty("user.dir") + "/src/main");

        tomcat.start(); //启动tomcat 注解版MVC利用Tomcat SPI机制

        tomcat.getServer().await(); //服务器等待

    }

}