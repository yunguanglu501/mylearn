package com.example.learn.date.t0906;

/**
 * ThreadTest
 *
 * @author wcy
 */
public class ThreadTest {
    public static void main(String[] args) throws Exception {
        MyThread a = new MyThread("线程A");
        MyThread b = new MyThread("线程B");
        MyThread c = new MyThread("线程C");
        MyThread d = new MyThread("线程D");
        a.start();
        b.start();
        c.start();
        d.start();
    }
}
