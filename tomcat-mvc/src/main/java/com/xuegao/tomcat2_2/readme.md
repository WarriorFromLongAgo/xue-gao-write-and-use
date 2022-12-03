

利用tomcat的SPI启动机制，SPI机制下 QuickAppStarter生效创建 ioc容器配置DispatcherServlet等各种组件。可以参考Spring5源码14-SpringMVC入口及启动流程。代码如下：

启动后，在浏览器访问http://localhost:8888/boot/hello66 ，输出为：
66666666~~~~~

SpringBoot就是采用上面的这种方式来启动Tomcat的。SpringBoot封装了功能的自动配置,导入各种starter依赖，SpringBoot封装了很多的自动配置，帮我们给容器中放了很多组件。