package com.example.learn.thread;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/24 14:57
 */
public class ThreadLocalTest2 {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("A");
        System.out.println(Thread.currentThread().getName() + "-getThreadLocal:" + threadLocal.get());
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "-getThreadLocal:" + threadLocal.get());
        }).start();
    }
}
