package com.schcode.nacos.service.feign;

import com.schcode.nacos.bean.Movie;
import com.schcode.nacos.service.handler.MovieFeignServiceExceptionHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-provider-movie6600",fallback = MovieFeignServiceExceptionHandler.class)//绑定Feign客户端要访问的服务。
public interface MovieFeignClient {
    // 获取最新电影
    @GetMapping("/movie/latest")
    public Movie getNewMovie();
}