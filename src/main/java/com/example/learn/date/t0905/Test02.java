package com.example.learn.date.t0905;

import java.util.ArrayList;
import java.util.List;

/**
 * Test02
 *
 * @author wcy
 */
public class Test02 {
    public static void main(String[] args) throws Exception {
        // demo01();
        // demo02();
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        List<String> list2 = new ArrayList<>();
        list2.addAll(list1);
        System.out.println("移除第一个值前:");
        System.out.println("list1:"+list1);
        System.out.println("list2:"+list2);
        list2.remove(list2.get(0));
        System.out.println("移除第一个值后:");
        System.out.println("list1:"+list1);
        System.out.println("list2:"+list2);



    }

    private static void demo02() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        List<String> list2 = new ArrayList<>(list1);
        System.out.println("移除第一个值前:");
        System.out.println("list1:"+list1);
        System.out.println("list2:"+list2);
        list2.remove(list2.get(0));
        System.out.println("移除第一个值后:");
        System.out.println("list1:"+list1);
        System.out.println("list2:"+list2);
    }

    private static void  demo01() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        List<String> list2 = new ArrayList<>();
        list2 = list1;
        System.out.println("移除第一个值前:");
        System.out.println("list1:"+list1);
        System.out.println("list2:"+list2);
        list2.remove(list2.get(0));
        System.out.println("移除第一个值后:");
        System.out.println("list1:"+list1);
        System.out.println("list2:"+list2);
    }
}
