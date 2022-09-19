package com.example.learn.entity;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/9 10:15
 */
public class GenericParadigm<T> {

    private String name;
    private Integer age;

    private T t;

    public GenericParadigm(String name, Integer age, T t) {
        this.name = name;
        this.age = age;
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public GenericParadigm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
