package com.example.learn;

import com.example.learn.date.t0916.AsyncTasks;
import com.example.learn.fx.Test01;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBootLearnApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;


    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("k123","v124");
    }

    @Test
    void test01(){
        stringRedisTemplate.opsForValue().set("cloud-hospital"+ ":hospitalId" + 1 + ":departmentId" + 3,"11");
    }

    @Test
    public void test02(){
        // Long longValue = 123L;
        // redisTemplate.opsForValue().set("k11",longValue);

        Object k11 = redisTemplate.opsForValue().get("k11");
        // System.out.println("k11 = " + k11);
        System.out.println("k11 = " + k11.getClass());
        Long y = (Long)k11;
        System.out.println("y = " + y);
    }

    @Autowired
    private AsyncTasks asyncTasks;

    @Test
    public void test() throws Exception {
        asyncTasks.doTaskOne();
        asyncTasks.doTaskTwo();
        asyncTasks.doTaskThree();
    }



}
