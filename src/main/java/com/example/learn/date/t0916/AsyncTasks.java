package com.example.learn.date.t0916;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * AsyncTasks
 *
 * @author wcy
 */
@Slf4j
@Component
public class AsyncTasks {

    public static Random random = new Random();
    @Async
    public CompletableFuture<String> doTaskOne() throws Exception {
        log.info("开始做任务一Spring自带的线程池" + Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
        return CompletableFuture.completedFuture("任务一完成");
    }
    @Async
    public CompletableFuture<String> doTaskTwo() throws Exception {
        log.info("开始做任务二Spring自带的线程池" + Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
        return CompletableFuture.completedFuture("任务二完成");
    }
    @Async
    public CompletableFuture<String> doTaskThree() throws Exception {
        log.info("开始做任务三Spring自带的线程池" + Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒");
        return CompletableFuture.completedFuture("任务三完成");
    }
}