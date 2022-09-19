package com.example.learn.fanxing;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/9 10:37
 */
public class FruitGenerator2 implements Generator<String>{

    /**
     * 在实现类实现泛型接口时，如已将泛型类型传入实参类型，则所有使用泛型的地方都会替换成传入的实参类型
     * 即：Generator<T>，public T next();中的的T都要替换成传入的String类型。
     */
    @Override
    public String next() {
        return null;
    }
}
