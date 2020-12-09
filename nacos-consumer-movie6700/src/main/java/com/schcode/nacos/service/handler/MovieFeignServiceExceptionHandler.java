package com.schcode.nacos.service.handler;


import com.schcode.nacos.bean.Movie;
import com.schcode.nacos.service.feign.MovieFeignClient;
import org.springframework.stereotype.Service;

        @Service
        public class MovieFeignServiceExceptionHandler implements MovieFeignClient {
            @Override
            public Movie getNewMovie() {
                Movie movie = new Movie();
                movie.setId(-100);
                movie.setMovieName("熔断成功，请刷新重试");
                return movie;
    }
}
