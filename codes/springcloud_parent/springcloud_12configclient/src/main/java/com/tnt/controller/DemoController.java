package com.tnt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月21日 17:55:00
 */
@RestController
@RefreshScope  // 作用:用来在不需要重启微服务的情况下,将当前 scope 域中信息刷新为最新配置信息
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);
    @Value("${name}")
    String name;

    @GetMapping("/demo")
    public String demo(){
        log.info("demo ok" );
        return "demo ok  " + name;
    }
}
