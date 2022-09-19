package com.example.learn.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/24 14:27
 */
public class SimpleDateFormatTest {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final ThreadLocal<DateFormat> SAFE_SIMPLE_DATE_FORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    public static void main(String[] args) {

//        demo01();

//        demo02();

//        demo03();


//        demo04();
    }


    private static void demo04() {
        for (int i = 0; i < 20; ++i) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "--" + SAFE_SIMPLE_DATE_FORMAT.get().parse("2020-06-01 11:35:00"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i);
            thread.start();
        }
    }

    private static void demo03() {
        for (int i = 0; i < 20; ++i) {
            Thread thread = new Thread(() -> {
                try {
                    synchronized (SIMPLE_DATE_FORMAT) {
                        System.out.println(Thread.currentThread().getName() + "--" + SIMPLE_DATE_FORMAT.parse("2020-06-01 11:35:00"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i);
            thread.start();
        }
    }

    private static void demo02() {
        for (int i = 0; i < 20; ++i) {
            Thread thread = new Thread(() -> {
                try {
                    // 每个线程都new一个
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    System.out.println(Thread.currentThread().getName() + "--" + simpleDateFormat.parse("2020-06-01 11:35:00"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i);
            thread.start();
        }
    }

    private static void demo01() {
        /**
         * SimpleDateFormat线程不安全，没有保证线程安全(没有加锁)的情况下，禁止使用全局SimpleDateFormat,否则报错 NumberFormatException
         *
         * private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         */
        for (int i = 0; i < 20; ++i) {
            Thread thread = new Thread(() -> {
                try {
                    // 错误写法会导致线程安全问题
                    System.out.println(Thread.currentThread().getName() + "--" + SIMPLE_DATE_FORMAT.parse("2020-06-01 11:35:00"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i);
            thread.start();
        }
    }
}
