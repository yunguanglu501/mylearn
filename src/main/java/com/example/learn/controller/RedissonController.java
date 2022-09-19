package com.example.learn.controller;

import org.redisson.api.RAtomicLong;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/15 15:48
 */
@RestController
public class RedissonController {


    @Autowired
    RedissonClient redissonClient;

    @GetMapping("/getOrderNumber")
    public String getOrderNumber() {

//        格式化格式为年月日
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        // 获取当前时间
        String now = LocalDate.now().format(dateTimeFormatter);
        // 通过redis的自增获取序号
        RAtomicLong atomicLong = redissonClient.getAtomicLong(now);
        atomicLong.expire(1, TimeUnit.DAYS);
        // 拼装订单号
        return now + "" + atomicLong.incrementAndGet();


    }

    @GetMapping("/test1")
    public String test1() {
        RBucket<String> nameRBucket = redissonClient.getBucket("name");
// 只设置value，key不过期
        nameRBucket.set("四哥");
// 设置value和key的有效期
        nameRBucket.set("四哥", 30, TimeUnit.SECONDS);
// 通过key获取value
        Object name = redissonClient.getBucket("name").get();
        return "" + name;

    }

}
