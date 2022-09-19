package com.example.learn.date.t0916;

import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Test1
 *
 * @author wcy
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
//         long before = System.currentTimeMillis();
//         for (int i = 0; i < 20000; i++) {
//             // doSomething里面睡眠一秒
//             new Thread(() -> doSomething()).start();
//         }
//         long after = System.currentTimeMillis();
// // 下面这行在我的电脑里输出6139
//         System.out.println(after - before);

        Executor executor = new ThreadPoolExecutor(2,2, 2,
                TimeUnit.MILLISECONDS,new SynchronousQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 3; i++) {
            long before = System.currentTimeMillis();
            executor.execute( () -> {
                // doSomething里面睡眠一秒
                doSomething();
            });
            long after = System.currentTimeMillis();
            // 下面这段代码，第三行会输出1001
            System.out.println("耗时"+(after - before));
        }
    }

    public static void doSomething(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // System.out.println("哈哈");
    }
}
