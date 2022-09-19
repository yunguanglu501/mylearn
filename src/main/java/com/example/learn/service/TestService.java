package com.example.learn.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * TestService
 *
 * @author wcy
 */
@Service
@Slf4j
public class TestService {

    @Async("msgThreadTaskExecutor")
    public void doAsync(CountDownLatch countDownLatch, int i) {
        System.out.println(Thread.currentThread().getName() + "running");

        try {
            //todo
            Thread.sleep(2000);
            log.debug("异步方法执行了......" + "第" + i + "个任务");
        } catch (Exception e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();
        System.out.println("线程: "+Thread.currentThread().getName() + "over");

    }

}
