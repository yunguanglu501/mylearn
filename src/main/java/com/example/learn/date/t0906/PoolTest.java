package com.example.learn.date.t0906;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * PoolTest
 *
 * @author wcy
 */
public class PoolTest {

    public static void main(String[] args) throws Exception {
        // 1.创建一个线程池,指定线程的数量为4
        ExecutorService pools = Executors.newFixedThreadPool(4);
        // 2.添加线程任务
        Runnable target = new MyRunnable2();
        pools.submit(target); // 第一次提交任务，此时创建新线程
        pools.submit(target); // 第二次提交任务，此时创建新线程
        pools.submit(target); // 第三次提交任务，此时创建新线程
        pools.submit(target); // 第四次提交任务，此时创建新线程
        pools.submit(target); // 第五次提交任务，复用之前的线程
        pools.shutdown(); // 当所有任务全部完成后才关闭线程池
    }


}

class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "正在执行任务…  " + i);
        }
    }
}

