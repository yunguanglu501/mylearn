package com.example.learn.lamdar;

/**
 * WeightOp
 *
 * @author wcy
 * @date 2022/8/9
 */
public class WeightOp implements FormatApple {
    @Override
    public boolean test(Apple apple) {
        return Integer.parseInt(apple.getWight())>150;
    }
}

