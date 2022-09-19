package com.example.learn.jichu;

/**
 * TestBao
 *
 * @author wcy
 * @date 2022/8/16
 */
public class TestBao {

    public static void main(String[] args) {
        Integer i1 = 33;
        Integer i2 = 33;
        System.out.println(i1 == i2);// 输出true
        Integer i11 = 333;
        Integer i22 = 333;
        System.out.println(i11 == i22);// 输出false
        Double i3 = 1.2;
        Double i4 = 1.2;
        System.out.println(i3 == i4);// 输出false

        Boolean b1 = false;
        Boolean b2 = false;
        System.out.println("b1 == b2 = " + (b1 == b2));
    }
}
