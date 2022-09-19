package com.example.learn.test;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/24 13:52
 */
public class TestThread {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();//创建 ThreadLocal 对象
    /**
     * 打印线程中的 ThreadLocal 值
     */
    private static void print(String threadName) {
        try {
            String result = threadLocal.get(); // 得到 ThreadLocal 中取出值
            System.out.println(threadName + " 取出值：" + result);
        } finally {
            threadLocal.remove(); // 移除 ThreadLocal 中的值（防止内存溢出）
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " 存入值：" + threadName);
                threadLocal.set(threadName); // 向 ThreadLocal 中设置值
                print(threadName);
            }
        };
        new Thread(runnable, "MyThread-1").start();
        new Thread(runnable, "MyThread-2").start();
    }

}
