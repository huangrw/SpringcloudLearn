package com.tnt.feignclients;

import org.springframework.context.annotation.Configuration;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月20日 23:48:00
 */
@Configuration  // spring.xml
public class HystrixClientsFallback implements Hystrixclients{
    @Override
    public String deom(Integer id) {
        return "当前服务不可用,请稍后再试 "+id;
    }
}
