package com.example.learn.demo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 16:09
 */
public class Operation {


    /*
        下面这个方法接受一个int类型参数a,返回a+1,符合我上面说的接受一个参数,返回一个值
        所以呢这个方法就符合Function接口的定义,那要怎么用呢,继续看例子
    */
    public static final int addOne(int a) {
        return a + 1;
    }

    public static final int subtractionOne(int a) {
        return a - 1;
    }

    //符合predicate函数
    public static Boolean judgeEvenNumber(int a) {
        return a % 2 == 0;
    }


    public static int handleOne(Function<Integer, Integer> function, Integer a) {
        return function.apply(a);
    }

    public static Boolean checkEven(Predicate<Integer> predicate, Integer a) {
        return predicate.test(a);
    }

    public static void main(String[] args) {

        int i = handleOne(a -> addOne(a), 3);
        System.out.println("i = " + i);

//        Boolean aBoolean = checkEven((a) -> judgeEvenNumber(a), 99);
//        System.out.println("aBoolean = " + aBoolean);

//        Boolean aBoolean = judgeEvenNumber(4);
//        System.out.println("aBoolean = " + aBoolean);
//        int i = handleOne((a) -> addOne(a), 3);
//        System.out.println("i = " + i);
//
//        int i1 = handleOne((a) -> subtractionOne(a), 100);
//        System.out.println("i1 = " + i1);
//
//        Consumer<String> printString = s -> System.out.println(s);
//        printString.accept("helloWorld!");
//        //控制台输出 helloWorld!
//
//        Supplier<String> getInstance = () -> "HelloWorld!";
//        System.out.println(getInstance.get());
        // 控偶值台输出 HelloWorld


    }
}
