package com.example.learn.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import cn.hutool.core.util.IdcardUtil;
import com.alibaba.fastjson.JSON;


import java.util.Date;

/**
 * @Author: wcy
 * @Date: 2022/7/5 15:56
 * @Version 1.0
 */
public class Demo01 {
    public static void main(String[] args) {
        //String s = GenderRelevantEnum.GenderOfHealthRecordsEnum.getCodeByChineseDesc("FEMALE");
        String s = GenderRelevantEnum.GenderOfHealthRecordsEnum.getCodeByEnglishDesc("MALE");
        System.out.println("s = " + s);
    }

    private static void demo01() {
        // 调用 values()
        Color[] arr = Color.values();
        System.out.println("arr = " + JSON.toJSONString(arr));

        // 迭代枚举
        for (Color col : arr) {
            // 查看索引
            System.out.println(col + " at index " + col.ordinal());
        }
        Color red = Color.valueOf("RED");
        System.out.println("red = " + red);
        Color white = Color.valueOf("WHITE");
        System.out.println("white = " + white);
        // 使用 valueOf() 返回枚举常量，不存在的会报错 IllegalArgumentException
        System.out.println(Color.valueOf("RED"));
        // System.out.println(Color.valueOf("WHITE"));
    }


}
