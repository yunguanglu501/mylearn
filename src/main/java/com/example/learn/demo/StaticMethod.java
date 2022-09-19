package com.example.learn.demo;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/8 17:25
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;

public class StaticMethod {

    public static void main(String[] args) {
        System.out.println(test("aaaaa"));  //aaaaa  基本用法
        System.out.println(test1("aa").get(0).equals("aa"));    //true  用于内部包装
        System.out.println(test1(new HashMap()).get(0).put("", ""));    //比上一句更能说明用处的例子
        System.out.println(test2(new HashSet(), Collection.class).size());  //0 用于强制转换类型
        System.out.println(test3("bbbbb")); //bbbbb   装神弄鬼

        HashSet ss = test(new HashSet());	//省去了强制转换类型
        ss.size();

        test(new HashSet()).size();		//可以看出与句柄无关，是静态方法自动做出的判断

        //在方法中自动进行强制类型转换，语法很特别。
        //（这个语句毫无疑问会报错，只是subList这个ArrayList有，而HashSet没有的方法能更明确的展示这个语法）
        test2(new HashSet(), ArrayList.class).subList(1, 1);
    }


    public static<T> T test(T obj){
        return obj;
    }

    public static<T> List<T> test1(T obj){
        List<T> list = new ArrayList();
        list.add(obj);
        return list;
    }

    public static<T> T test2(Object str, Class<T> obj){
        return (T)str;
    }

    public static<T> T test2(Object obj){
        return (T)obj;
    }

    public static<T, A, B, C, D> B test3(B obj){
        return obj;
    }

}

