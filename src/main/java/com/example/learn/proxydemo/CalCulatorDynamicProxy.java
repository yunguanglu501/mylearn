package com.example.learn.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * CalCulatorDynamicProxy
 *
 * @author wcy
 * @date 2022/8/20
 */
// 动态代理类
public class CalCulatorDynamicProxy {
    // 要代理的对象
    private Calculator calculator;

    public CalCulatorDynamicProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    public Calculator getCalculator() {
        Calculator proxy = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),
                calculator.getClass().getInterfaces(),
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始计算了");
                Object invoke = method.invoke(calculator, args);
                System.out.println("执行结果为: " + invoke);
                System.out.println("计算结束了");
                return invoke;
            }
        });
        return proxy;
    }
}