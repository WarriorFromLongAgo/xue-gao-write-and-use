@DependsOn：指定当前bean依赖的bean
用法
前面有篇文章中介绍了bean xml中depend-on的使用，建议先看一下：Spring系列第9篇：depend-on到底是干什么的？
@DependsOn等效于bean xml中的bean元素中的depend-on属性。
spring在创建bean的时候，如果bean之间没有依赖关系，那么spring容器很难保证bean实例创建的顺序，如果想确保容器在创建某些bean之前，需要先创建好一些其他的bean，可以通过@DependsOn来实现， @DependsOn可以指定当前bean依赖的bean，通过这个可以确保@DependsOn指定的bean在当前bean创建之前先创建好

作者：鼓楼丶
链接：https://juejin.cn/post/7094055529768550408
来源：稀土掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。