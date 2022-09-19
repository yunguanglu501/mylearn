package com.example.learn.proxydemo;

/**
 * CalculatorImpl
 *
 * @author wcy
 * @date 2022/8/20
 */
public class CalculatorImpl  implements Calculator{
    @Override
    public int add(int i, int j) {
        return i+j;
    }
    @Override
    public int sub(int i, int j) {
        return i-j;
    }
    @Override
    public int mul(int i, int j) {
        return i*j;
    }
    @Override
    public double div(int i, int j) {
        return  (i/j);
    }
}
