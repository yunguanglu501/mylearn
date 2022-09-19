package com.example.learn.date.t0906;

/**
 * RunnableTest
 *
 * @author wcy
 */
public class RunnableTest {
    public static void main(String[] args) throws Exception {
        MyRunnable mr = new MyRunnable("线程一");
        MyRunnable mr2 = new MyRunnable("线程2");
        MyRunnable mr3 = new MyRunnable("线程3");
        MyRunnable mr4 = new MyRunnable("线程4");
        Thread thread = new Thread(mr);
        Thread thread2 = new Thread(mr2);
        Thread thread3 = new Thread(mr3);
        Thread thread4 = new Thread(mr4);
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
