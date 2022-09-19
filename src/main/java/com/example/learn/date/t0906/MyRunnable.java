package com.example.learn.date.t0906;

/**
 * MyRunnable
 *
 * @author wcy
 */
public class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(this.name + Thread.currentThread().getName() + "开始执行 " + i);
        }
    }
}
