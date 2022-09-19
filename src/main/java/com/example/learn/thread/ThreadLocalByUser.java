package com.example.learn.thread;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/24 14:48
 */
public class ThreadLocalByUser {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                // 初始化用户信息
                User user = new User("小明" + finalI);
                // 将 User 对象存储在 ThreadLocal 中
                UserStorage.setUser(user);
                // 调用订单系统
                OrderSystem orderSystem = new OrderSystem();
                // 添加订单（方法内获取用户信息）
                orderSystem.add();
                // 调用仓储系统
                RepertorySystem repertory = new RepertorySystem();
                // 减库存（方法内获取用户信息）
                repertory.decrement();
            }).start();

        }

    }
}

