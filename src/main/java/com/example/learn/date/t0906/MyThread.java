package com.example.learn.date.t0906;

import org.jetbrains.annotations.NotNull;

/**
 * MyThread
 *
 * @author wcy
 */
public class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "执行了 " + i);
        }
    }
}
