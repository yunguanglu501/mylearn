package com.example.learn.date.t0906;

import java.util.concurrent.TimeUnit;

/**
 * VolatileExample
 *
 * @author wcy
 */
public class VolatileExample {


    private static volatile boolean flag = false;
    private static int i = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                flag = true;
                System.out.println("flag 被修改成 true");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        while (!flag) {
            System.out.println("i="+i);
            i++;
        }
        System.out.println("程序结束,i=" + i);
    }
}