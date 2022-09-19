package com.example.learn.fx;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public class MainTest<T> {


    public static void main(String[] args) throws Exception {
        MainTest<String> str = new MainTest<String>();
        Class variable = str.getClass();
        Type genType1 = variable.getGenericSuperclass();
        System.out.println("genType1 = " + genType1);
    }

}
