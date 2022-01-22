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

# 微服务中的重要概念

服务雪崩   服务熔断 服务降级

![image-20220120122705920](SpringCloud.assets/image-20220120122705920.png)

![image-20220120123936318](SpringCloud.assets/image-20220120123936318.png)



![  ](SpringCloud.assets/image-20220120125700153.png)

![image-20220120125801881](SpringCloud.assets/image-20220120125801881.png)

![image-20220120130000390](SpringCloud.assets/image-20220120130000390.png)

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

# 服务注册中心组件（eureca server（netflix））

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

 

## consul注册中心

![image-20220119080320181](SpringCloud.assets/image-20220119080320181.png)



![image-20220119080812609](SpringCloud.assets/image-20220119080812609.png)

### consul client 服务客户端开发（微服务）

![image-20220119094204681](SpringCloud.assets/image-20220119094204681.png)

![image-20220119095008780](SpringCloud.assets/image-20220119095008780.png)

# 微服务通信组件

http   使用http协议传递的是JSON数据   工作在应用层

rpc    传送二进制数据    工作在传输层   dubbo：优秀的rpc框架，使用rpc但要求所有都要用java

springcloud 使用http协议传递数据

rpc效率比http高，但rpc存在一些限制

![image-20220119132117478](SpringCloud.assets/image-20220119132117478.png)

![image-20220119134555745](SpringCloud.assets/image-20220119134555745.png)

## 使用RestTemplate实现服务间的调用

RestTemplate  Java提供的http调用方法

```java
// 调用订单服务的 order  服务地址：http://localhost:8085/order  接受返回值string
        RestTemplate restTemplate = new RestTemplate();  // java提供的对象，相当于浏览器
        String orderResult = restTemplate.getForObject("http://localhost:8085/order", String.class);
        log.info("调用订单服务成功:{}",orderResult)
```

### RestTemplate存在的问题

# ![image-20220119141624977](SpringCloud.assets/image-20220119141624977.png)

## Ribbon组件（微服务通信组件）

负载均衡组件，通信还是由TestTemplate执行

### Ribbon原理

![image-20220119145224821](SpringCloud.assets/image-20220119145224821.png)



### 使用Ribbon组件实现负载调用

- 注入 DiscoverClient对象和LoadBalanceClient对象

```java
    @Autowired   // 服务注册于发现客户端对象
    private DiscoveryClient discoveryClient;

    @Autowired  // 负载均衡客户端对象
    private LoadBalancerClient loadBalancerClient;
```


- 使用 Discoverclient 发现服务

```java
List<ServiceInstance> ordersServerInstances = discoveryClient.getInstances("ORDERS");
for (ServiceInstance ordersServerInstance : ordersServerInstances) {
            log.info("服务主机:{},服务端口{},服务地址:{}",
                    ordersServerInstance.getHost(),
                    ordersServerInstance.getPort(),
                    ordersServerInstance.getUri());
        }
```

- 使用 LoadBalances  负载均衡调用

```java
ServiceInstance serviceInstance = loadBalancerClient.choose("ORDERS");  // 默认是轮询策略
log.info("服务主机:{},服务端口{},服务地址:{}",
               serviceInstance.getHost(),
               serviceInstance.getPort(),
               serviceInstance.getUri());
```

-  使用RestTemplate进行调用

```java
RestTemplate restTemplate = new RestTemplate();  // java提供的对象，相当于浏览器
String orderResult = restTemplate.getForObject(serviceInstance.getUri()+"/order", String.class);
```

![image-20220119152118658](SpringCloud.assets/image-20220119152118658.png)

- 工厂中创建生成RestTemplate方法

```java
@Configuration  // 代表这是一个配置类，相当于spring.xml  工厂：创建对象 bean id class=""
public class BeansConfig {

    // 在工厂中创建restTemplate
    @Bean
    @LoadBalanced  //使用@LoacalBalance注解可以使得对象具有Ribbon负载均衡的特性
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
```

- 直接使用RestTemplate进行负载均衡调用

```java
 // 使用@LoacalBalance注解可以使得对象具有Ribbon负载均衡的特性
   String orderResult =  restTemplate.getForObject("http://ORDERS/order",String.class);

```

### Ribbon原理详解（面试会问）

![image-20220119152726211](SpringCloud.assets/image-20220119152726211.png)

![image-20220119152840370](SpringCloud.assets/image-20220119152840370.png)

![image-20220119153013892](SpringCloud.assets/image-20220119153013892.png)

## 回顾注册中心和Ribbon组件

![image-20220119172531126](SpringCloud.assets/image-20220119172531126.png)

![image-20220119172554858](SpringCloud.assets/image-20220119172554858.png)

# openFeign组件

## 什么是Feign组件？

作用于RestTemplate一致，都是一个http客户端

OpenFeignwei:伪HttpClient客户端对象，可以使服务间的通信变得更简单qqq

![image-20220119180130417](SpringCloud.assets/image-20220119180130417.png)

![image-20220119180249258](SpringCloud.assets/image-20220119180249258.png)

## 如何使用openFeign

待补充

## 服务间通信之参数传递和响应处理 

![image-20220120100426322](SpringCloud.assets/image-20220120100426322.png)

![image-20220120100521782](SpringCloud.assets/image-20220120100521782.png)

![image-20220120112003314](SpringCloud.assets/image-20220120112003314.png)

![image-20220120114745439](SpringCloud.assets/image-20220120114745439.png)

## 响应对象处理

![image-20220120120759034](SpringCloud.assets/image-20220120120759034.png)

## OpenFeign细节

### 配置超时时间

![image-20220120121747068](SpringCloud.assets/image-20220120121747068.png)

### 配置日志展示

![image-20220120121754812](SpringCloud.assets/image-20220120121754812.png)

# Hystrix 组件（防雪崩利器）

## Hystrix的使用

![image-20220120195328308](SpringCloud.assets/image-20220120195328308.png)

![image-20220120195352322](SpringCloud.assets/image-20220120195352322.png)

## Hystrix细节

![image-20220120230711667](SpringCloud.assets/image-20220120230711667.png)

## Hystrix和Openfeign结合使用

![image-20220120235928255](SpringCloud.assets/image-20220120235928255.png)

![image-20220120235932767](SpringCloud.assets/image-20220120235932767.png)

## Hyatrix DashBoard 的使用

![image-20220121002345908](SpringCloud.assets/image-20220121002345908.png)

![image-20220121002523507](SpringCloud.assets/image-20220121002523507.png)![image-20220121002752503](SpringCloud.assets/image-20220121002752503.png)

### Hystrix和 dashboard 的状态

![image-20220121003722343](SpringCloud.assets/image-20220121003722343.png)



# 回顾组件

![image-20220121003655694](SpringCloud.assets/image-20220121003655694.png)



# Gatway 网关组件 

## 简介

![image-20220121005507767](SpringCloud.assets/image-20220121005507767.png)

## Gateway 网关的使用

![image-20220121133220392](SpringCloud.assets/image-20220121133220392.png)

## 网关配置细节

 ![image-20220121133530007](SpringCloud.assets/image-20220121133530007.png)

![image-20220121133550878](SpringCloud.assets/image-20220121133550878.png)

![image-20220121133816449](SpringCloud.assets/image-20220121133816449.png) 

## 网关路由解析规则

![image-20220121134449323](SpringCloud.assets/image-20220121134449323.png)

![image-20220121134545397](SpringCloud.assets/image-20220121134545397.png)



##  网关配置实现负载均衡

![image-20220121135749063](SpringCloud.assets/image-20220121135749063.png)



## 网关断言（predicate）细节

![image-20220121145141207](SpringCloud.assets/image-20220121145141207.png)

## 网关filter 细节

![image-20220121152841541](SpringCloud.assets/image-20220121152841541.png)

![image-20220121152904125](SpringCloud.assets/image-20220121152904125.png)

![image-20220121153346655](SpringCloud.assets/image-20220121153346655.png)

# Config 组件  统一配置中心

## confi-server

![37.config组件介绍以及config server开发](SpringCloud.assets/37.config组件介绍以及config server开发.png)

## config-clientv

![image-20220121201201503](SpringCloud.assets/image-20220121201201503.png)

#  

![image-20220121201346604](SpringCloud.assets/image-20220121201346604.png)

## config的刷新

### 手动配置刷新

![image-20220121203601449](SpringCloud.assets/image-20220121203601449.png)

### 自动配置刷新

# Bus 组件        

![image-20220121211713900](SpringCloud.assets/image-20220121211713900.png) 

## configserver连接 mq

![image-20220121224200422](SpringCloud.assets/image-20220121224200422.png)

## configclient 连接 mq

![image-20220121234028433](SpringCloud.assets/image-20220121234028433.png)

# webHooks和内网穿透实现自动刷新



# Sringcloud 总结

![image-20220122105514464](SpringCloud.assets/image-20220122105514464.png)

![image-20220122105535414](SpringCloud.assets/image-20220122105535414.png)

# ToDo

- 项目Demo对应知识点

- 配置方法模板

- 总结 requestParam requestBody  requestpath   pathParm 注解的用法

-  Integer和int的关系

- dokcer 安装 rabbitmq  https://www.cnblogs.com/yufeng218/p/9452621.html

  

