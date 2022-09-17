# 工程简介

# 延伸阅读

```dockerfile
FROM openjdk:8
#VOLUME /tmp
ADD target/xuegao-spring-docker-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]
```


```dockerfile
# docker build -f dockerfile1 -t demo1:1.0 .
# docker run -itd --name xuegao-springboot -p 10000:8080 219508153580

FROM maven:3.8.3-openjdk-8 as build
# 设置维护者
MAINTAINER xuegao
# 将整个项目 copy 到项目内部
COPY xuegao-spring-docker xuegao-spring-docker
# 将setting文件copy到容器内部
COPY settings.xml xuegao-spring-docker/settings.xml
# 设置镜像内部的工作目录，也就是run运行的目录
WORKDIR xuegao-spring-docker
# maven指定配置文件 编译项目
RUN mvn -s settings.xml -DskipTests=true install

FROM openjdk:8
# 将上面构建的镜像里面的jar，复制到下面的当前目录来
COPY --from=build xuegao-spring-docker/target/xuegao-spring-docker-0.0.1-SNAPSHOT.jar app.jar
# 运行这个jar
CMD ["java","-jar","app.jar"]

# 进入容器内部
# docker run -it --entrypoint=/bin/bash 021fbe4b4b91
# docker exec -it 666927b25d2f /bin/bash
```