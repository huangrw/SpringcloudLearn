package com.tnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月19日 17:48:00
 */
@SpringBootApplication
@EnableDiscoveryClient  // 开启服务注册
@EnableFeignClients    //  开启openfein客户端调用
public class CategoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategoryApplication.class,args);
    }
}
