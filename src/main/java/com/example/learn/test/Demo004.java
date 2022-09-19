package com.example.learn.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo004
 *
 * @author wcy
 * @date 2022/8/31
 */
public class Demo004 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add(null);
        for (String string : strings) {
            System.out.println("string = " + string.toString());
        }
        System.out.println("哈哈");
        System.out.println("哈哈2");
        System.out.println("哈哈3");
        System.out.println("哈哈4");
        System.out.println("哈哈5");
        System.out.println("哈哈6");
        add(1,2);
        System.out.println("哈哈7");
        System.out.println("哈哈8");
        System.out.println("哈哈9");
    }

    public static void add(Integer a,Integer b){
        int i = a + b;
        System.out.println(i);
    }
}
