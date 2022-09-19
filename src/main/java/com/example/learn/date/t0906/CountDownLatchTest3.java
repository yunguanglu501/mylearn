package com.example.learn.date.t0906;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CountDownLatchTest3
 *
 * @author wcy
 */
public class CountDownLatchTest3 {
    public static void main(String[] args) {
        // 模拟线程数
        int times = 1000;

        // 用于模拟线程安全
        final AtomicInteger atomicInteger = new AtomicInteger(0);

        // 用于模拟线程非安全
        final Member member = new Member();

        // 相当于计数器，当所有线程都准备好了，再一起执行，模仿多并发，保证并发量
        final CountDownLatch countDownLatch = new CountDownLatch(times);

        // 保证所有线程执行完了再打印atomicInteger、用户年龄的值
        final CountDownLatch countDownLatch2 = new CountDownLatch(times);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            for (int i = 0; i < times; i++) {
                executorService.submit(() -> {
                    try {
                        // 一直阻塞当前线程，直到计时器的值为0,保证同时并发
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("当前线程执行时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));

                    // 数量自增1：线程安全（执行n次，每次都是1000）
                    atomicInteger.incrementAndGet();

                    // 用户年龄自增1：线程不安全(执行n次，每次结果可能不一样)
                    member.setAge(member.getAge() + 1);

                    // 当前线程执行完，计数器减一
                    countDownLatch2.countDown();
                    System.out.println("countDownLatch2.countDown()值为: "+countDownLatch2.getCount());
                });
                countDownLatch.countDown();
                System.out.println("第" + i  + "次循环,countDownLatch的值为: " + countDownLatch.getCount() + "  Latch2的值为 " + countDownLatch2.getCount());
            }

            // 保证所有线程执行完
            countDownLatch2.await();

            // 打印结果
            System.out.println("atomicInteger = " + atomicInteger);
            System.out.println("age = " + member.getAge());

            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
