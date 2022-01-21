package com.tnt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月19日 13:26:00
 */
@RestController
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("order")
    public String demo(){
        log.info("order demo ......");
        return "order demo ok!";
    }
}
