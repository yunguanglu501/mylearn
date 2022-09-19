package com.example.learn.fanxing;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/9 10:36
 */
public class FruitGenerator<T> implements Generator<T>{
    /**
     *继承泛型接口的类 如果不给接口泛型指定类型 那么此类必须也是泛型类
     */
    @Override
    public T next() {
        return null;
    }
}
