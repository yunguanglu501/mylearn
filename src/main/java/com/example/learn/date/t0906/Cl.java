package com.example.learn.date.t0906;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Cl
 *
 * @author wcy
 */
public class Cl {
    public static void main(String[] args) throws Exception {
        // demo01();
        // demo02();

        demo03();
    }

    private static void demo03() throws InterruptedException {
        //程序计数器
        CountDownLatch countDownLatch = new CountDownLatch(2);

        //2个线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < 10000; i++) {

            executorService.submit(() -> {
                count.getAndIncrement();//自增
                System.out.println(Thread.currentThread().getName() + " : " + count.get());
                countDownLatch.countDown();
                long count1 = countDownLatch.getCount();
                System.out.println("count1 = " + count1);
            });
        }


        //线程池 等待10s
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        //关闭线程 其实是将线程状态设置为中断标志  必须等待所有线程处理完任务,才能完全关闭
        executorService.shutdown();

        //必须等待两个线程执行完   会一直等待下去，当然也可以设置指定时间等待超时 await(timeout);
        countDownLatch.await();

        System.out.println("完成了");
    }

    private static void  demo02() {
        //案例二：简单模拟刘关张桃园三结义
        CountDownLatch countDownLatch=new CountDownLatch(2);
        new Thread(()->{
            System.out.println("刘备--》在等待");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("刘关张桃园三结义");
        }).start();

        new Thread(()->{
            System.out.println("张飞--》骑马而来");
            // try {
            //     Thread.sleep(1000);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            countDownLatch.countDown();
            System.out.println("张飞拜见大哥");
        }).start();

        new Thread(()->{
            System.out.println("关羽--》骑马而来");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
            System.out.println("关羽拜见大哥");
        }).start();
    }

    private static void demo01() throws InterruptedException {
        // 案例一：教室里有六个人，当六个人全出去之后，关掉教室门
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println("线程" + Thread.currentThread().getName() + "离开");
                countDownLatch.countDown();
            }, "" + i).start();
        }

        countDownLatch.await();
        System.out.println("全部人离开,关门");
    }
}
