package com.example.learn.proxydemo;

import java.lang.reflect.Proxy;

public class DTest {
    public static void main(String[] args) {
        IUserService target = new UserServiceImpl();

        MyIHandler myIHandler = new MyIHandler(target);
        IUserService o = (IUserService) Proxy.newProxyInstance(DTest.class.getClassLoader(), target.getClass().getInterfaces(), myIHandler);
        o.add("哈哈");
    }
}
