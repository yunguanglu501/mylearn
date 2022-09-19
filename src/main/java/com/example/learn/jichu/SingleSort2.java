package com.example.learn.jichu;

/**
 * SingleSort
 *
 * @author wcy
 * @date 2022/8/25
 */
public class SingleSort2 {
    public static int k = 0;
    public static SingleSort2 t1 = new SingleSort2("t1");


    public int j = print("j");

    {
        print("构造块");
    }

    static{
        print("静态块");
    }

    public SingleSort2(String str){
//        System.out.print("Test1: ");
        System.out.println("哈哈哈"+str);
    }

    public static int print(String str){
        System.out.println("嘿嘿"+str);
        return 1;
    }

    public static void main(String[] args) {
        SingleSort2 singleSort = new SingleSort2("init");//main方法触发类的初始化
    }
}

