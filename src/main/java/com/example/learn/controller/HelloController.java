package com.example.learn.controller;

import com.example.learn.date.t0916.AsyncTasks;
import com.example.learn.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * HelloController
 *
 * @author wcy
 */
@RestController
public class HelloController {

    @Autowired
    private AsyncTasks asyncTasks;

    private Integer num = 0;

    @GetMapping("/hello")
    public String hello() throws Exception{

        // 将可以并行的处理逻辑，拆分成三个异步任务同时执行
        CompletableFuture<String> task1 = asyncTasks.doTaskOne();
        CompletableFuture<String> task2 = asyncTasks.doTaskTwo();
        CompletableFuture<String> task3 = asyncTasks.doTaskThree();

        CompletableFuture.allOf(task1, task2, task3).join();
        System.out.println("num的值为: "+num++);
        return "Hello World";
    }

    @Autowired
    TestService testService;

    @GetMapping("/test/async")
    public void testAsync() {

        CountDownLatch countDownLatch = new CountDownLatch(100);
        System.out.println("主线程执行开始");

        for (int i = 0; i < 100; i++) {
            testService.doAsync(countDownLatch,i);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程执行结束......");
    }

}
