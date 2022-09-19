package com.example.learn.jichu;

/**
 * SingleTon
 *
 * @author wcy
 * @date 2022/8/16
 */
public class SingleTon {
    public static int count1;
    public static int count2 = 0;
    private static SingleTon instance = new SingleTon();

    public SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return instance;
    }
}
