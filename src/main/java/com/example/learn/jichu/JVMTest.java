package com.example.learn.jichu;

/**
 * JVMTest
 *
 * @author wcy
 * @date 2022/8/16
 */
public class JVMTest {
    /**
     * 1.类从顶至底的顺序初始化，所以声明在顶部的字段的早于底部的字段初始化
     * 2.超类早于子类和衍生类的初始化
     * 3.如果类的初始化是由于访问静态域而触发，那么只有声明静态域的类才被初始化，而不会触发超类的初始化或者子类的
     * 4.初始化即使静态域被子类或子接口或者它的实现类所引用。
     * 5.接口初始化不会导致父接口的初始化。
     * 6.静态域的初始化是在类的静态初始化期间，非静态域的初始化时在类的实例创建期间。这意味这静态域初始化在非静态域之前。
     * 7.非静态域通过构造器初始化，子类在做任何初始化之前构造器会隐含地调用父类的构造器，他保证了非静态或实例变量（父类）初始化早于子类
     * @param args
     */
    public static void main(String[] args) {
        // demo01();
        //1:SingleTon singleTon = SingleTon.getInstance();
        // 调用了类的SingleTon调用了类的静态方法，触发类的初始化
        SingleTon2.getInstance();
        System.out.println(SingleTon2.count1);
        System.out.println(SingleTon2.count2);
    }

    private static void demo01() {
        SingleTon.getInstance();
        System.out.println(SingleTon.count1);
        System.out.println(SingleTon.count2);
    }
}
