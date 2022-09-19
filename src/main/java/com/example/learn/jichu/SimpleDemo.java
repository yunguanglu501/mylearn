package com.example.learn.jichu;

/**
 * SimpleDemo
 *
 * @author wcy
 * @date 2022/8/25
 */
public class SimpleDemo {

    //一个静态变量
    private static int a = 10;

    //一个普通变量
    private int b = 20;

    //无参构造函数
    public SimpleDemo(){
        System.out.println("无参构造函数, a="+a+", b="+b);
        b = b + 1;
    }

    //构造代码块
    {
        System.out.println("构造代码块, a="+a+", b="+b);
        a = a + 1;
    }

    //静态代码块
    static{
        System.out.println("静态代码块, a = "+a);
    }

    //普通方法，其中包含一个普通的代码块
    public void say(){
        {
            System.out.println("普通代码块, a="+a+", b="+b);
        }
    }

    //普通方法
    public void show(){
        System.out.println("普通方法, a="+a+", b="+b);
    }

    public static void main(String[] args) {
        System.out.println("执行了main方法");
        System.out.println("---------------");

        SimpleDemo simple = new SimpleDemo();//触发类的初始化
        simple.say();
        System.out.println("---------------");
        SimpleDemo demo = new SimpleDemo();
        demo.show();
    }
}

