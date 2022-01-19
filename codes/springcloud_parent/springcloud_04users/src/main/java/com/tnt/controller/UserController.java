package com.tnt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月19日 13:29:00
 */
@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired   // 服务注册于发现客户端对象
    private DiscoveryClient discoveryClient;

    @Autowired  // 负载均衡客户端对象
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("user")
    public String invokeDemo(){


        // 使用ribbon组件+RestTemplate实现负载均衡调用  1.Discoverclient  2.LoadBalanceClient @LoadBalance

        // 1.使用 Discoverclient 发现服务
        List<ServiceInstance> ordersServerInstances = discoveryClient.getInstances("ORDERS");
        for (ServiceInstance ordersServerInstance : ordersServerInstances) {
            log.info("服务主机:{},服务端口{},服务地址:{}",
                    ordersServerInstance.getHost(),
                    ordersServerInstance.getPort(),
                    ordersServerInstance.getUri());
        }

        // 2. 使用 LoadBalances  负载均衡调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("ORDERS");  // 默认是轮询策略
        log.info("服务主机:{},服务端口{},服务地址:{}",
               serviceInstance.getHost(),
               serviceInstance.getPort(),
               serviceInstance.getUri());

        // 3.使用RestTemplate进行调用
        // 调用订单服务的 order  服务地址：http://localhost:8085/order  接受返回值string
        //String orderResult = restTemplate.getForObject(serviceInstance.getUri()+"/order", String.class);

        // 使用@LoacalBalance注解可以使得对象具有Ribbon负载均衡的特性
        String orderResult =  restTemplate.getForObject("http://ORDERS/order",String.class);



        //log.info("调用订单服务成功:{}",orderResult);
        return "user demo ok" + orderResult;
    }
}
