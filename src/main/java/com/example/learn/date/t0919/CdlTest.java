package com.example.learn.date.t0919;

import com.example.learn.entity.MoneyDO;
import com.example.learn.fx.FxPerson;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CdlTest
 *
 * @author wcy
 */
public class CdlTest {

    public static void main(String[] args) throws Exception {

        // demo01();
        demo02();
    }


    private static void demo02() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        // 验证一千个线程自增
        MoneyDO fxPerson = new MoneyDO();
        fxPerson.setMoney(0);
        AtomicInteger atomicInteger = new AtomicInteger(0);

        ExecutorService threadPool = Executors.newFixedThreadPool(12);
        for (int i = 0; i < 1000; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    synchronized (countDownLatch){

                        fxPerson.setMoney(fxPerson.getMoney() + 1);
                    }
                    atomicInteger.incrementAndGet();
                    // System.out.println(Thread.currentThread().getName() + " 哈哈");
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("fxPerson.getMoney() = " + fxPerson.getMoney());
        System.out.println("atomicInteger的值为: " + atomicInteger.get());
        System.out.println(Thread.currentThread().getName() + " 结束了");
    }

    private static void demo01() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                long count = countDownLatch.getCount();
                System.out.println("count = " + count);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                System.out.println("countDownLatch.getCount() = " + countDownLatch.getCount());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
            }
        }).start();

        countDownLatch.await();
        System.out.println("结束了");
    }
}
