package com.example.learn.lamdar;

import java.util.ArrayList;
import java.util.List;

/**
 * MainDo
 *
 * @author wcy
 * @date 2022/8/9
 */
public class MainDo {
    public static List<Apple> appleList(List<Apple> apples, FormatApple formatApple){
        List<Apple> apples1 = new ArrayList<>();
        for (Apple apple:apples){
            if (formatApple.test(apple)){
                apples1.add(apple);
            }
        }
        return apples1;
    }

    public static void main(String[] args) {
        Apple a = new Apple();
        a.setColor("green");
        a.setWight("200");
        Apple a2 = new Apple();
        a2.setWight("100");
        a2.setColor("green");
        Apple a3 = new Apple();
        a3.setColor("red");
        a3.setWight("250");
        List alist = new ArrayList();
        alist.add(a);
        alist.add(a2);
        alist.add(a3);
        //筛选出绿色的苹果
        List<Apple> resultA1 = appleList(alist,new ColorAppleOp());
        //筛选出重量大于>150g的苹果
        List<Apple> resultA2 = appleList(alist,new WeightOp());
        for (Apple apple: resultA1){
            System.out.println(apple.getColor()+apple.getWight());
        }
        System.out.println("--------------------");
        for (Apple apple1: resultA2){
            System.out.println(apple1.getColor()+apple1.getWight());
        }
    }
}

