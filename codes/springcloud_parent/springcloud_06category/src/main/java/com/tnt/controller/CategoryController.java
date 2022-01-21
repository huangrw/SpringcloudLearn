package com.tnt.controller;

import com.tnt.entity.Product;
import com.tnt.feignclient.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月19日 18:24:00
 */
@RestController
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    ProductClient productClient;

    @GetMapping("category")
    public String category(){
        // 1.RestTemplate 2.Ribbon+RestTemplate 4.OpenFeign
        String res = productClient.product();
        log.info("category service....");
        return "catygory ok!!!"+res;
    }

    @GetMapping("/catagorys/test")
    public String catagoryTest(){
        String returnres = productClient.testQueryString("tnt", 23);
        return "/ catagory  test ok !!!!" + returnres;
    }


    @GetMapping("testPathParam")
    public String testPathParam(){
        String tnt = productClient.testPathParam(12, "tnt");
        return tnt;
    }

    @PostMapping("/testObject")
    public String testObject(){
        String restnt = productClient.testObject(new Product(001, "tnt", 144.0, new Date()));
        return "testPbject  Ok  ====>  "+restnt;

    }

    @GetMapping("testReturnObject/{id}")
    public Product testreturnObjective(@PathVariable(value = "id") Integer id){
        Product res = productClient.testReturnObject(id);
        return res;
    }


}
