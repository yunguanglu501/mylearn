package com.example.learn.lamdar;

/**
 * ColorAppleOp
 *
 * @author wcy
 * @date 2022/8/9
 */
public class ColorAppleOp implements FormatApple {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}

