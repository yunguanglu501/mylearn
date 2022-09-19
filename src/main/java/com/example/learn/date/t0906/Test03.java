package com.example.learn.date.t0906;

/**
 * Test03
 *
 * @author wcy
 */
public class Test03 {
    static{
        i = 20;  //这里的i， 是不能被用作运算的， 因为本质上 i 还未被定义
    }
    public static int i = 1; //但是如果我们给静态的i附上一个初始值后，那么结果就变了。
    //
    public static void main(String[] args) throws Exception {
        System.out.println(i);
    }
}
