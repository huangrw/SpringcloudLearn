package com.tnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月21日 19:47:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigserverApplication.class,args);
    }
}
