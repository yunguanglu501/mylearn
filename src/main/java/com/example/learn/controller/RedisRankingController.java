package com.example.learn.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/24 10:48
 */
@RestController
public class RedisRankingController {

    @Autowired
    RedisTemplate redisTemplate;

    public static final String SCORE_RANK = "score_rank";

    /**
     * 批量新增
     */
    @RequestMapping("batchAdd")
    public void batchAdd() {
        Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            DefaultTypedTuple<String> tuple = new DefaultTypedTuple<>("张三" + i, 1D + i);
            tuples.add(tuple);
        }
        System.out.println("循环时间:" + (System.currentTimeMillis() - start));
        Long num = redisTemplate.opsForZSet().add(SCORE_RANK, tuples);
        System.out.println("批量新增时间:" + (System.currentTimeMillis() - start));
        System.out.println("受影响行数：" + num);
    }


    /**
     * 获取排行列表
     */
    @RequestMapping("list")
    public void list() {

        Set<String> range = redisTemplate.opsForZSet().reverseRange(SCORE_RANK, 0, 10);
        System.out.println("获取到的排行列表:" + JSON.toJSONString(range));
        Set<ZSetOperations.TypedTuple<String>> rangeWithScores = redisTemplate.opsForZSet().reverseRangeWithScores(SCORE_RANK, 0, 10);
        System.out.println("获取到的排行和分数列表:" + JSON.toJSONString(rangeWithScores));
    }

    /**
     * 单个新增
     */
    @RequestMapping("add")
    public void add() {
        redisTemplate.opsForZSet().add(SCORE_RANK, "李四", 8899);
    }

    /**
     * 获取单个的排行
     */
    @RequestMapping("find")
    public void find() {
        Long rankNum = redisTemplate.opsForZSet().rank(SCORE_RANK, "李四");
        System.out.println("李四的个人排名：" + rankNum);

        Double score = redisTemplate.opsForZSet().score(SCORE_RANK, "李四");
        System.out.println("李四的分数:" + score);
    }

    /**
     * 统计两个分数之间的人数
     */
    @RequestMapping("count")
    public void count() {
        Long count = redisTemplate.opsForZSet().count(SCORE_RANK, 981, 9000);
        System.out.println("统计 991-9000之间的人数:" + count);
    }

    /**
     * 获取整个集合的基数(数量大小)
     */
    @RequestMapping("zCard")
    public void zCard() {
        Long aLong = redisTemplate.opsForZSet().zCard(SCORE_RANK);
        System.out.println("集合的基数为：" + aLong);
    }


    /**
     * 使用加法操作分数
     */
    @RequestMapping("incrementScore")
    public void incrementScore() {
        Double score = redisTemplate.opsForZSet().incrementScore(SCORE_RANK, "李四", 1000);
        System.out.println("李四分数+1000后：" + score);
    }
}
