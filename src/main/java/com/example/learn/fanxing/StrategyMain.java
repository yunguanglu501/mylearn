package com.example.learn.fanxing;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/9 13:41
 */
public class StrategyMain {
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategyA();
        strategy.algorithmInterface();
    }
}
