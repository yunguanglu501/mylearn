package com.example.learn.date.t0906;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TestMs1
 *
 * @author wcy
 */
public class TestMs1 {
    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            for (int i = 0; i < 1000000000; i++) {
                num.getAndAdd(1);
                if (i%1000==0){
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println(Thread.currentThread().getName()+"执行结束!");
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println("num = " + num);
    }
}
