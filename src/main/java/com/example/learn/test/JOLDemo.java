// package com.example.learn.test;
//
// import org.openjdk.jol.info.ClassLayout;
//
// public class JOLDemo {
//
//     public static void main(String[] args) {
//         // Car car = Car.builder()
//         //         .id(1)
//         //         .type("SUV")
//         //         .level('A')
//         //         .price(22.22)
//         //         .build();
//         //
//         //
//         // System.out.println( ClassLayout.parseInstance(car).toPrintable() );
//         //
//         // int[] array = new int[3];
//         // array[0] = 11;
//         // array[1] = 22;
//         // array[2] = 33;
//         // System.out.println( ClassLayout.parseInstance(array).toPrintable() );
//
//         // 声明一枚长度为3306的数组
//         int[] intArr = new int[3306];
//         // 使用jol的ClassLayout工具分析对象布局
//         System.out.println(ClassLayout.parseInstance(intArr).toPrintable());
//
//     }
// }
