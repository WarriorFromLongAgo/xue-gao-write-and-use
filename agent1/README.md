# 配置文件

META-INF/MANIFEST.MF

```
Agent-Class: com.xuegao.agent.MyAgent 
Premain-Class: com.xuegao.agent.MyAgent 
Can-Redefine-Classes: true 
Can-Retransform-Classes: true

```

注意：末尾要空一行

E:\GitProject\TestProject\xue-gao-write-and-use\agent1\target\agent1-1.0.0.jar

# plugin构建

```xml

<plugin>
    <!-- https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-assembly-plugin -->
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-assembly-plugin</artifactId>
    <version>3.4.2</version>
    <configuration>
        <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
        <archive>
            <manifestEntries>
                <Agent-Class>com.xuegao.agent.MyAgent</Agent-Class>
                <Premain-Class>com.xuegao.agent.MyAgent</Premain-Class>
                <Can-Redefine-Classes>true</Can-Redefine-Classes>
                <Can-Retransform-Classes>true</Can-Retransform-Classes>
            </manifestEntries>
        </archive>
    </configuration>
</plugin>
```

mvn assembly:single

E:\GitProject\TestProject\xue-gao-write-and-use\agent1\target\agent1-1.0.0-jar-with-dependencies.jar

# 执行 javaagent

```
java -javaagent:E:\GitProject\TestProject\xue-gao-write-and-use\agent1\target\agent1-1.0.0.jar=com.xuegao.useagent1 -jar E:\GitProject\TestProject\xue-gao-write-and-use\useagent1\target\useagent1-0.0.1-SNAPSHOT.jar
```
```
java -javaagent:E:\GitProject\TestProject\xue-gao-write-and-use\agent1\target\agent1-1.0.0.jar=com.xuegao.useagent1 -jar E:\GitProject\TestProject\xue-gao-write-and-use\useagent1\target\useagent1-0.0.1-SNAPSHOT.jar
```


```
java -javaagent:E:\GitProject\TestProject\xue-gao-write-and-use\agent1\target\agent1-1.0.0-jar-with-dependencies.jar=com.xuegao.useagent1 -jar E:\GitProject\TestProject\xue-gao-write-and-use\useagent1\target\useagent1-0.0.1-SNAPSHOT.jar
```

在vm option里面加
```
-javaagent:E:\GitProject\TestProject\xue-gao-write-and-use\agent1\target\agent1-1.0.0-jar-with-dependencies.jar
```




