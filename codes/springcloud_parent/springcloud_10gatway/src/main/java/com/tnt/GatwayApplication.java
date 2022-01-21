package com.tnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月21日 01:14:00
 */
@SpringBootApplication
@EnableDiscoveryClient  // 注册中心
public class GatwayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatwayApplication.class,args);
    }
}
