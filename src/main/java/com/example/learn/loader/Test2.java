package com.example.learn.loader;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/30 16:25
 */
public class Test2 {
    public static void main(String[] args) throws Exception{


        //demo1();


        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.findClass("com.example.learn.loader.User1");
        // 实例化User对象
        Object o = aClass.newInstance();
        Method show = aClass.getDeclaredMethod("show");
        // 执行show方法
        show.invoke(o);

    }

    //private static void //demo1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    //    // 默认加载器加载的  HotUserModel
    //    HotUserModel hotUserModel = null;
    //
    //    // 使用自定义加载器加载 HotUserModel
    //    MyClassLoader myClassLoader = new MyClassLoader();
    //    Class<?> aClass =myClassLoader.findClass("com.example.learn.loader.HotUserModel");
    //    Object o = aClass.newInstance();
    //
    //
    //    System.out.println("普通 HotUserModel 使用的类加载器为：" + HotUserModel.class.getClassLoader());
    //    System.out.println();
    //    System.out.println("使用自动义类加载器的 HotUserModel 使用的加载器为：" + o.getClass().getClassLoader());
    //    System.out.println();
    //    // 以下语句赋值会报错
    //    hotUserModel = (HotUserModel) o;
    //}
}
