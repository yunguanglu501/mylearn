package com.example.learn.test;

import cn.hutool.core.date.DateUtil;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Car {
    private int id;
    private String type;
    private double price;
    private char level;

    public static void main(String[] args) {
        Date date1 = null;
        // String dateStr = "2021-04-21 01:02:03";
        // Date date = DateUtil.parse(dateStr);
        // System.out.println("date = " + date);

        String yyyyMMdd = DateUtil.format(date1, "yyyyMMdd");
        System.out.println("yyyyMMdd = " + yyyyMMdd);
    }
}
