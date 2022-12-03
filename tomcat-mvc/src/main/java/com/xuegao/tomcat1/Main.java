package com.xuegao.tomcat1;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class Main {

    public static void main(String[] args) throws LifecycleException {
        //自己写Tomcat的启动源码
        Tomcat tomcat = new Tomcat();


        tomcat.setPort(8888);
        tomcat.setHostname("localhost");
        tomcat.setBaseDir(".");

        Context context = tomcat.addWebapp("/boot", System.getProperty("user.dir") + "/src/main");

        //给Tomcat里面添加一个Servlet
        Wrapper hello = tomcat.addServlet("/boot", "hello", new HelloServlet());
        hello.addMapping("/66"); //指定处理的请求

        tomcat.start(); //启动tomcat 注解版MVC利用Tomcat SPI机制

        tomcat.getServer().await(); //服务器等待


        // 直接运行main方法，在浏览器中输入 http://localhost:8888/boot/66 ，输出为：
        // hello tomcat
        // 以上只是一个Tomcat的启动并使用HelloServlet处理一个请求的案例。下面我们结合SpringMVC，看如何优雅的启动。

    }
}