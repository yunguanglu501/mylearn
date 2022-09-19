package com.example.learn.loader;

import com.example.learn.entity.User;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/30 16:20
 */
public class TestUserLoader {
    public static void main(String[] args) {
        System.out.println("String.class.getClassLoader() = " + String.class.getClassLoader());
        System.out.println("User.class.getClassLoader() = " + User.class.getClassLoader());
    }
}
