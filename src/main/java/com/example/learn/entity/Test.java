package com.example.learn.entity;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<StDemo> demos = new ArrayList<>();
        StDemoS stDemoS = new StDemoS();
        stDemoS.setStDemos(demos);
        System.out.println("stDemoS = " + stDemoS);
        StDemo stDemo = new StDemo();
        stDemo.setAge(11);
        demos.add(stDemo);
        System.out.println("stDemoS = " + stDemoS);

        System.out.println("Thread.currentThread().getId() = " + Thread.currentThread().getId());

    }
}
