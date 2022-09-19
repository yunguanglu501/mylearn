package com.example.learn.date.t0902;

import java.util.Collection;

/**
 * ThreadException
 *
 * @author wcy
 * @date 2022/9/2
 */
public class ThreadException {
    /**
     * 需求：主线程独立执行，无需等待子线程执行完毕，子线程如有异常抛出可自行catch
     * 网上介绍的方法一般是
     * 1，在线程内部进行try/catch捕获异常。
     * 2，通过线程池的submit方法，获取Future对象，然后try/catch Future.get()方法来处理异常。
     * 第一种，线程内部try/catch，有时候可能不希望在编写子线程的时候直接进行异常处理，而是将异常抛出，交由调用者处理。
     * 第二种，会造成线程等待问题。调用Future.get()方法需要等待子线程完成，如果是耗时较长的子线程任务，会严重影响主线程速度。
     * 解决方案：利用Thread.setUncaughtExceptionHandler()方法，保证主线程的独立执行，并且能处理子线程异常。
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int A = 10;
        int B = 0;
        

        System.out.println("start");


        Thread t1 = new Thread(() -> {
            System.out.println("t1");
            int result = A / B;
        });

        t1.setUncaughtExceptionHandler(((t, e) -> {
            try {
                t.sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(t + ":" + e);
        }));

        Thread t2 = new Thread(() -> {
            System.out.println("t2");
            int result = A / B;
        });

        t1.start();
        t2.start();

        System.out.println("end");
    }
}
