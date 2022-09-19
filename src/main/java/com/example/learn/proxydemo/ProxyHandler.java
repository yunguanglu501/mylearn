package com.example.learn.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyHandler
 *
 * @author wcy
 * @date 2022/8/20
 */
public class ProxyHandler implements InvocationHandler {
    //被代理对象
    private Object target;

    public ProxyHandler(Object object) {
        this.target = object;
    }

    public Object getNewInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始数据库连接========");
        method.invoke(target,args);
        System.out.println("关闭数据库连接==========");
        return null;
    }
}
