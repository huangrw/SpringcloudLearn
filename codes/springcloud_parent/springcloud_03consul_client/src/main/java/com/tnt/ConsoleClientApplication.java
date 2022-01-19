package com.tnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月19日 09:30:00
 */
@SpringBootApplication
@EnableDiscoveryClient  // consule zookeeper nacos 服务中心通用注解
public class ConsoleClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsoleClientApplication.class,args);
    }
}
