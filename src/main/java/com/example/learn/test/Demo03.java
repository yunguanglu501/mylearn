package com.example.learn.test;

import com.example.learn.entity.Student;

import java.util.HashMap;
import java.util.Map;

public class Demo03 {

    final static Map<String, Object> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Student student = new Student();
        student.setStuId("1");
        student.setStuName("aa");
        student.setStuAge(10);
        student.setIsDel(0);
        hashMap.put("student1",student);
        test001();


    }

    private static void test001(){
        System.out.println("hashMap = " + hashMap);
    }

}
