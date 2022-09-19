package com.example.learn.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 15:44
 */
public class Demo01 {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, str -> str.startsWith("J"));

        System.out.println("==============================");

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("==============================");

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);


        System.out.println("==============================");

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("==============================");

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);

        System.out.println("==============================");
    }

    public static void filter(List<String> names, Predicate<String> condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }


    // 更好的办法
//    public static void filter(List<String> names, Predicate<String> condition) {
//        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
//            System.out.println(name + " ");
//        });
//    }



}
