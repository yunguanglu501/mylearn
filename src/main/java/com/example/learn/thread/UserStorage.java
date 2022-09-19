package com.example.learn.thread;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/24 14:47
 */
/**
 * 用户信息存储类
 */
class UserStorage {
    public static ThreadLocal<User> USER = new ThreadLocal(); // 存储用户信息

    public static void setUser(User user) {
        USER.set(user);
    }
}

