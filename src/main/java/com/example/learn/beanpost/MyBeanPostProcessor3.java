package com.example.learn.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/24 18:26
 */
// @Component
public class MyBeanPostProcessor3 implements SmartInstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean 初始化之前");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean 初始化之后");
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("bean 实例化之前");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("bean 实例化之后");
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        System.out.println("bean 变量处理");
        return null;
    }

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("预测 bean 类型" + beanClass);
        return null;
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName)
            throws BeansException {
        System.out.println("选择构造器");
        return null;
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        System.out.println("提前暴露引用");
        return bean;
    }


//    @Component
//    static class B {
//        @Autowired
//        A a;
//    }
//
//    @Component
//    static class A {
//        @Autowired
//        B b;
//    }
}
