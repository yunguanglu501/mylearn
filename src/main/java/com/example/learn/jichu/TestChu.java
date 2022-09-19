package com.example.learn.jichu;

/**
 * TestChu
 *
 * @author wcy
 * @date 2022/8/25
 */
public class TestChu {
    public static void main(String[] args) {
        // System.out.println(SubClass.value);// 被动应用1
        System.out.println(SubClass.value2);// 被动应用1
    }
}

class SuperClass {



    public static final int value = 123;//为final时,不会进行类的初始化,SubClass.value不会触发static静态代码块.
    public static int value2 = 1234;//不为final时,调用类的静态方法或变量,会触发类的初始化,SubClass.value2会触发static静态代码块.
    static {
        System.out.println("superclass init");
    }
    static {
        System.out.println("superclass init2");
    }
}

class SubClass extends SuperClass {
    static {
        System.out.println("subclass init");
    }
}


