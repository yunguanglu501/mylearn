package com.example.learn.date.t0906;

/**
 * Test02
 *
 * @author wcy
 */
public class Test02 {
    public static void main(String[] args) throws Exception {
        double a = 10d;
        int aa = 10;
        int b = 0;
        System.out.println(calculate(aa,b));
    }

    private static double calculate(double a, int b){
        double v = a / b;
        System.out.println("v = " + v);
        return v;
    }
}
