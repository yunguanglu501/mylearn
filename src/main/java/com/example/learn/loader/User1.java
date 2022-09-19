package com.example.learn.loader;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/30 16:38
 */
public class User1 {
    public void show() {
        System.out.println("当前User1使用的类加载器为：" + this.getClass().getClassLoader());

        User1 user = new User1();
        System.out.println("新的User1对象使用的类加载器为：" + user.getClass().getClassLoader());

    }
}