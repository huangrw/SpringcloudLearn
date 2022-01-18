package com.tnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月19日 01:43:00
 */
@SpringBootApplication
@EnableEurekaClient // 让当前微服务作为一个eureka server客户端 进行服务注册
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class,args);
    }

}
