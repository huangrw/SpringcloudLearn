package com.tnt.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月20日 23:32:00
 */
@FeignClient(value = "HYSTRIX",fallback = HystrixClientsFallback.class)
public interface Hystrixclients{
    @GetMapping("demo/{id}")
    String deom(@PathVariable(value = "id") Integer id);
}
