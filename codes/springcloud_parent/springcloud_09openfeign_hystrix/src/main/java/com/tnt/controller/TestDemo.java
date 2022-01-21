package com.tnt.controller;

import com.tnt.feignclients.Hystrixclients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月20日 23:27:00
 */
@RestController
public class TestDemo {

    private static final Logger log = LoggerFactory.getLogger(TestDemo.class);

    // 注入 openFeign 客户端
    @Autowired
    Hystrixclients hystrixclients;

    @GetMapping("/test/{id}")
    public String test(@PathVariable(value = "id") Integer id){
        String res = hystrixclients.deom(id);
        log.info("Test ok !!!");
        return "test Ok  " + res;
    }
}
