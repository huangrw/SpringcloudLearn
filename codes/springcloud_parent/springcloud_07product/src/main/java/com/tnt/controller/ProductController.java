package com.tnt.controller;

import com.tnt.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月19日 18:19:00
 */
@RestController
public class ProductController {

    @Value("${server.port}")
    private int port;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("product")
    public String product(String color){
        log.info("接收到的color 参数{}",color);
        log.info("进入商品服务.....");
        return "product ok,当前提供服务端口：" + port;
    }

    // 定义一个接受零散类型参数接口 queryString
    @GetMapping("/test")
    public String testQueryString(@RequestParam("name") String name, @RequestParam("age") Integer age){
        log.info("name:{},    age:{}",name,age);
        return "testQueryString ok" + port;
    }

    // 路径传参
    @GetMapping("/testPathParam/{id}/{name}")
    public String testPathParam(@PathVariable(value = "id")int id,@PathVariable(value = "name")String name){

        log.info("id是{},名字是{}",id,name);

        return "testPathParam Ok";
    }

    // 传递对象
    @PostMapping("/testObject")
    public String testObject(@RequestBody Product product){
        log.info("product:{}",product);

        return "testObject ok~~~~~ 当前服务端口为:"+port;
    }

    // 返回对象
    @GetMapping("/testRetrunObject/{id}")
    public Product testReturnObject(@PathVariable(value = "id") Integer id){
        log.info("接受到的参数{}",id);
        return (new Product(002, "tnt", 144.0, new Date()));
    }
}
