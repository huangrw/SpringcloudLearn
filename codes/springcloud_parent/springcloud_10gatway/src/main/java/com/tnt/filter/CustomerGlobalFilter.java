package com.tnt.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

/**
 * @author huangrw
 * @program: codes
 * @Description
 * @createTime 2022年01月21日 15:12:00
 */
@Configuration
public class CustomerGlobalFilter implements GlobalFilter, Ordered {


    // exchange 封装了 request 和 response
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // httpReuqest 对象
        ServerHttpRequest request = exchange.getRequest();
        // httpResponse 对象
        ServerHttpResponse response = exchange.getResponse();
        System.out.println("经过全局 Filter 处理....");
        Mono<Void> filter = chain.filter(exchange);// 放行请求
        System.out.println("响应回来后 Filter 处理");
        return filter;
    }


    // order 排序  给过滤器排序  返回数字,
    // 指定 filter 执行顺序,默认按自然数数字进行排序
    // -1 在所有 filter 前执行
    @Override
    public int getOrder() {
        return 0;
    }
}
