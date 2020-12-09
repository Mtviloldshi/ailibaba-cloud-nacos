package com.schcode.nacos.service;

import com.schcode.nacos.bean.User;
import com.schcode.nacos.dao.UserDao;
import com.schcode.nacos.service.feign.MovieFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    MovieFeignClient movieFeignClient;

    public User getUserById(Integer id){
        User user = userDao.getUser(id);
        return user;
    }
    public Map<String, Object> getUserAndMovie (Integer id){
        Map<String, Object> result = new HashMap<>();
//1、查询用户信息
        User user = getUserById(id);
//2、查到最新电影票
        result.put("user", user);
        result.put("movie", null);//暂时为null
        return result;
    }
}