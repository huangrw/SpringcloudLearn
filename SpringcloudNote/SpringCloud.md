# 什么微服务

![image-20220118215944206](SpringCloud.assets/image-20220118215944206.png)



# 为什么要有微服务呢（和单体应用架构的区别）

![image-20220118220345697](SpringCloud.assets/image-20220118220345697.png)

# 微服务架构的演变过程

dubbo：优秀的rpc框架

rpc：远程调用，（传输层），效率远高于应用层的http

![image-20220118221423777](SpringCloud.assets/image-20220118221423777.png)

# 微服务架构的解决方案

 ![image-20220118222312082](SpringCloud.assets/image-20220118222312082.png)

![image-20220118222437383](SpringCloud.assets/image-20220118222437383.png)

# 什么是SpringCloud

快速构建分布式系统的工具 （含有众多微服务的工具集）

服务注册中心  zookeeper

负载均衡  Nginx

服务熔断 

配置管理

网关组件

![image-20220118223622591](SpringCloud.assets/image-20220118223622591.png)

# SpringCloud 命名和版本选择（重要）

![image-20220118224322924](SpringCloud.assets/image-20220118224322924.png)

# SpringCloud环境搭建

![image-20220118230746131](SpringCloud.assets/image-20220118230746131.png)

```properties
<!--父项目只用来维护版本号-->

    <!--继承springboot的父项目-->
    <parent>
        <artifactId>spring-boot-parent</artifactId>
        <groupId>org.springframework.boot</groupId>
        <version>2.2.5.RELEASE</version>
    </parent>

    <!--自定义properties-->
    <properties>
        <!--<maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>-->
        <spring.cloud-version>Hoxton.SR6</spring.cloud-version>
    </properties>

    <!--维护版本 -->
    <dependencyManagement>
        <dependencies>

            <!--维护springcloud版本 -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring.cloud-version}</version>
                <type>pom</type>
                <scope>import</scope>
           </dependency> 
        </dependencies>

    </dependencyManagement>
```

# 微服务组件 

## 服务注册中心（eureca server（netflix））

![image-20220118232936861](SpringCloud.assets/image-20220118232936861.png)

 ![image-20220119005255201](SpringCloud.assets/image-20220119005255201.png)

- 引入依赖

```xml
<!--引入Eureka-server-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
```

- 编写配置文件

  ```xml
  # eureka默认端口号  8761
  server.port=8761
  # 指定服务名称 注意：服务名不区分大小写，但推荐大写 不能出现下划线
  spring.application.name=EUREKASERVER
  #eureka server 服务注册中心地址
  eureka.client.service-url.defaultZone=http://localhost:8761/eureka
  
  ```

- 在入口加入注解

  ```java
  @SpringBootApplication
  @EnableEurekaServer
  public class EurekaServerApplication {
      public static void main(String[] args) {
          SpringApplication.run(EurekaServerApplication.class,args);
      }
  }
  ```

### eureka server 细节问题

![image-20220119012953730](SpringCloud.assets/image-20220119012953730.png)

### eureka server 集群搭建

![image-20220119021722902](SpringCloud.assets/image-20220119021722902.png)

## eurka client(客户端)

日后的一个个微服务如用户管理 订单信息

![image-20220119015610993](SpringCloud.assets/image-20220119015610993.png)

### eureka的自我保护机制![image-20220119021106926](SpringCloud.assets/image-20220119021106926.png)

![image-20220119021100345](SpringCloud.assets/image-20220119021100345.png)

 









