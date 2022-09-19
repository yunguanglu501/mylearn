package com.example.learn.demo;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Operation
 *
 * @author wcy
 */
public class Operation {

    // Fcuntion接口是对接受一个T类型参数,返回R类型的结果的方法的抽象,通过调用apply方法执行内容。
    /*
            下面这个方法接受一个int类型参数a,返回a+1,符合我上面说的接受一个参数,返回一个值
            所以呢这个方法就符合Function接口的定义,那要怎么用呢,继续看例子
        */
    public static final int addOne(int a) {
        return a + 1;
    }

    public static final int subOne(int a) {
        return a - 1;
    }

    /*
     * 该方法第二个参数接受一个function类型的行为,然后调用apply，对a执行这段行为
     */
    public static int oper(int a, Function<Integer, Integer> action) {
        return action.apply(a);
    }

    /* 下面调用这个oper方法,将addOne方法作为参数传递 */
    public static void main(String[] args) {
        // int x = 10;
        //
        // int y = oper(x,Operation::addOne);//这里可以换成方法引用的写法 int y = oper(x,Operation::addOne)
        // System.out.printf("x= %d, y = %d", x, y); // 打印结果 x=1, y=2
        //
        // int z = oper(x,Operation::subOne);//这里可以换成方法引用的写法 int y = oper(x,Operation::addOne)
        // System.out.printf("x= %d, y = %d", x, z); // 打印结果 x=1, y=2

        Consumer<String> printString = s -> System.out.println(s);
        printString.accept("helloWorld!");
        String xx = "哈哈大笑";
        oper2(xx,Operation::myPrintln);

    }

    public static void oper2(String a, Consumer<String> action) {
        action.accept(a);
    }

    public static void myPrintln(String x) {

        System.out.println("x的值为: " + x);
    }
}
