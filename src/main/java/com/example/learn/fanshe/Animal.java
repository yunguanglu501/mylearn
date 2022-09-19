package com.example.learn.fanshe;


public class Animal {

    public void print(String color) {
        System.out.println("Animal.print() 颜色" + color);
    }

    public void print(int age) {
        System.out.println("Animal.print() 年龄" + age);
    }

    static class inner{

        public String getInnerName(){
            return name;
        }
        private String name;
        private Integer age;

        public inner() {
        }

        public inner(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

}

