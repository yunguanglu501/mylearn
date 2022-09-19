package com.example.learn.ioc;

import lombok.Data;

@Data
public class Programmer {

    private String name;

    private Integer age;

    private Boolean hasGirlFriend;

    public void showMaterial() {
        System.out.println("name: " + name + ", age: " + age + ", hasGirlFriend: " + hasGirlFriend);
    }
}
