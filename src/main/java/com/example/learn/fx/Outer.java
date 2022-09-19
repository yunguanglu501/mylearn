package com.example.learn.fx;

public class Outer {
    private String outerName = "Tony";
    //非静态内部类和匿名内部类容易引起内存泄漏,可以用静态内部类替代.要用到外部类的参数时,可以用弱引用
    static class Inner{
        private String name;

        public Inner() {
            // this.name = outerName;
        }
    }

    Inner createInner() {
        return new Inner();
    }

}
