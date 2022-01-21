package com.tnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月20日 23:22:00
 */
@SpringBootApplication
@EnableDiscoveryClient   // 开启服务注册客户端
@EnableFeignClients      // 开启 openfeign 的调用:服务调用  负载均衡
public class OpenfeignHystrix {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignHystrix.class,args);
    }
}
