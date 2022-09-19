package com.example.learn.jichu;

/**
 * SingleTon
 *
 * @author wcy
 * @date 2022/8/16
 */
public class SingleTon2 {
    private static SingleTon2 instance = new SingleTon2();
    public static int count1;
    public static int count2 = 0;

    public SingleTon2() {
        count1++;
        count2++;
    }

    public static SingleTon2 getInstance() {
            return instance;
    }
}
