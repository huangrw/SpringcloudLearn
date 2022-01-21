package com.tnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月20日 19:27:00
 */
@SpringBootApplication
@EnableDiscoveryClient  // 开启服务注册中心
@EnableFeignClients    //  开启openfein客户端调用  负载均衡和通信
@EnableCircuitBreaker  // 开启Hystrix服务熔断
public class HystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class,args);
    }
}
