package com.tnt.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author huangrw
 * @program: codes
 * @Description  创建工厂对象
 * @createTime 2022年01月19日 15:03:00
 */
@Configuration  // 代表这是一个配置类，相当于spring.xml  工厂：创建对象 bean id class=""
public class BeansConfig {

    // 在工厂中创建restTemplate
    @Bean
    @LoadBalanced  //使用@LoacalBalance注解可以使得对象具有Ribbon负载均衡的特性
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
