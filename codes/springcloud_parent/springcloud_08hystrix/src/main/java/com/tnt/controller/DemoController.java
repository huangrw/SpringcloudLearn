package com.tnt.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月20日 19:48:00
 */
@RestController
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("demo/{id}")
    @HystrixCommand(defaultFallback = "defaultFallBack") // 熔断之后进行的处理
    public String deom(@PathVariable(value = "id") Integer id) {
        log.info("demo is ok !!! ");
        if (id<1){
            throw new RuntimeException("无效id！！！！");
        }
        return "demo ok";
    }

    public String demoFallback(Integer id){
        return "当前活动过于火爆，已经被熔断";
    }

    public String defaultFallBack(){
        return "网络连接失败,请重试";
    }

}
