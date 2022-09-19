package com.example.learn.date.t0915;

/**
 * Demo01
 *
 * @author wcy
 */
public class Demo01 {

    public static void main(String[] args) throws Exception {
        // m1();
        m2();
    }

    public static void m2() {
        // retry:
        for (; ; ) {
            System.out.println("123");
            break ;
            // break retry;
        }
        System.out.println("out");

    }

    /**
     * 多重循环
     */
    private static void m1() {
        retry:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("i=" + i + ",j=" + j);
                if (i == 1) {
                    System.out.println("跳出本次循环......");
                    continue retry; // 跳出本次循环
                }
                if (i == 3 && j == 2) {
                    System.out.println("跳出多重循环......");
                    break retry; // 跳出循环
                }
            }
        }
        System.out.println("循环体执行结束......");
    }

}
