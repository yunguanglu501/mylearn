package com.example.learn.date.t0906;

import java.util.concurrent.CountDownLatch;

/**
 * RunnableTest
 *
 * @author wcy
 */
public class RunnableTest2 {
    public static void main(String[] args) throws Exception {
        // 案例一：教室里有六个人，当六个人全出去之后，关掉教室门
        // demo01();
        demo02();
        // demo03();
    }

    private static void demo02() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                /**
                 * 其他N 个线程必须引用闭锁对象，因为他们需要通知CountDownLatch对象，
                 * 他们已经完成了各自的任务。这种通知机制是通过 CountDownLatch.countDown()方法来完成的；
                 * 每调用一次这个方法，在构造函数中初始化的count值就减1。所以当N个线程都调 用了这个方法，
                 * count的值等于0，然后主线程就能通过await()方法，恢复执行自己的任务。
                 */
                System.out.println(Thread.currentThread().getName() + "Go out");
                countDownLatch.countDown(); // 数量减一
            }, String.valueOf(i)).start();
        }
        //与CountDownLatch的第一次交互是主线程等待其他线程。
        // 主线程必须在启动其他线程后立即调用CountDownLatch.await()方法。
        // 这样主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。
        countDownLatch.await();

        System.out.println("Close Door");
    }

    private static void demo01() throws InterruptedException {
        //不正确
        CountDownLatch countDownLatch = new CountDownLatch(6);
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "离开")).start();
        countDownLatch.countDown();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "离开")).start();
        countDownLatch.countDown();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "离开")).start();
        countDownLatch.countDown();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "离开")).start();
        countDownLatch.countDown();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "离开")).start();
        countDownLatch.countDown();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "离开")).start();
        countDownLatch.countDown();

        countDownLatch.await();
        System.out.println("人全部离开了");
    }

    private static void demo03() throws InterruptedException {
        //不正确
        CountDownLatch countDownLatch = new CountDownLatch(6);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "离开");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "离开");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "离开");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "离开");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "离开");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "离开");
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();
        System.out.println("人全部离开了");
    }
}
