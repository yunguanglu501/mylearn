package com.example.learn.proxydemo;

/**
 * CalculatorTest
 *
 * @author wcy
 * @date 2022/8/20
 */
public class CalculatorTest {
    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        CalCulatorDynamicProxy dynamicProxy = new CalCulatorDynamicProxy(calculator);
        Calculator calculator1 = dynamicProxy.getCalculator();
        int add = calculator1.add(1, 2);
        System.out.println("add = " + add);
    }
}
