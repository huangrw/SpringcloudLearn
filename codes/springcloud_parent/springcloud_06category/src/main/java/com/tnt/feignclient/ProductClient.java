package com.tnt.feignclient;

import com.tnt.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangrw
 * @program: codes
 * @Description  调用商品服务接口
 * @createTime 2022年01月19日 18:50:00
 */
@FeignClient(value = "PRODUCT")   // value:用来书写调用服务id
public interface ProductClient {

    // 调用商品服务
    @GetMapping("/product")
    String product();

    // 声明调用商品服务中test接口中传递name，age
    @GetMapping("/test")
    String testQueryString(@RequestParam("name") String name, @RequestParam("age") Integer age);

    // 路径传参
     @GetMapping("/testPathParam/{id}/{name}")
     String testPathParam(@PathVariable(value = "id")int id, @PathVariable(value = "name")String name);


    // 传递对象
    @PostMapping ("testObject")
    String testObject(@RequestBody Product product);

    // 返回对象
    @GetMapping("/testRetrunObject/{id}")
    Product testReturnObject(@PathVariable(value = "id") Integer id);



    }
