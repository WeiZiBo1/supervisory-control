package com.chint.supervisorycontrol.demo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zhouying3
 */
@RestController
@RequestMapping("/redis")
@AllArgsConstructor
public class RedisControllerDemo {


    private final RedisTemplate redisTemplate;

    @RequestMapping("/add")
    public String insertRedis() {
        redisTemplate.boundValueOps("a").set("b");
        return "add success";
    }

    @RequestMapping("/addExpire")
    public String insertExpireRedis() {
        redisTemplate.boundValueOps("c").set(111, 222222, TimeUnit.SECONDS);
        return "addExpire success";
    }

    @RequestMapping("/delete")
    public String deleteRedis() {
        Boolean a = redisTemplate.delete("a");
        return "delete success " + a.toString();
    }

    @RequestMapping("/get")
    public String getRedis() {
        Object a = redisTemplate.boundValueOps("a").get();
        return "get success " + a.toString();
    }
}

