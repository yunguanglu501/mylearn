package com.example.learn.thread;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/24 14:48
 */
/**
 * 订单类
 */
class OrderSystem {
    /**
     * 订单添加方法
     */
    public void add() {
        // 从ThreadLocal得到用户信息
        User user = UserStorage.USER.get();
        // 业务处理代码（忽略）...
        System.out.println(Thread.currentThread().getId() + String.format(" : 订单系统收到用户：%s 的请求。", user.getName()));
    }
}

