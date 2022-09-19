package com.example.learn.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyIHandler implements InvocationHandler {

    private Object target;

    public MyIHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理前");
        Object invoke = method.invoke(target, args);
        System.out.println("动态代理后");
        return invoke;
    }
}
