package com.example.learn.date.t0906;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CdlConcurrencyTest
 * 用countDownLatch模拟1000个线程并发,测试数据安全
 *
 * @author wcy
 */
public class CdlConcurrencyTest {

    public static void main(String[] args) throws Exception {
        int nums = 1000;
        final Member member = new Member();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(nums);
        final CountDownLatch countDownLatch2 = new CountDownLatch(nums);

        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < nums; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        System.out.println("开始执行 : ");
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    atomicInteger.incrementAndGet();
                    member.setAge(member.getAge() + 1);
                    countDownLatch2.countDown();
                }
            });
            countDownLatch.countDown();
            System.out.println("第" + i  + "次循环,countDownLatch的值为: " + countDownLatch.getCount());
        }
        countDownLatch2.await();
        int age = member.getAge();
        System.out.println("age = " + age);
        System.out.println("atomicInteger.get() = " + atomicInteger.get());
    }
}
