package com.example.learn.jichu;

/**
 * InitializationDemo2
 *
 * @author wcy
 * @date 2022/8/25
 */
class Grandpa2 {
    static {
        System.out.println("爷爷在静态代码块");
    }

    public Grandpa2() {
        System.out.println("我是爷爷~");
    }
}

class Father2 extends Grandpa2 {
    static {
        System.out.println("爸爸在静态代码块");
    }

    public Father2() {
        System.out.println("我是爸爸~");
    }
}

class Son2 extends Father2 {
    static {
        System.out.println("儿子在静态代码块");
    }

    public Son2() {
        System.out.println("我是儿子~");
    }
}

public class InitializationDemo2 {
    public static void main(String[] args) {
        new Son2();     // 入口
    }
}
