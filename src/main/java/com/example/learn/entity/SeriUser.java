package com.example.learn.entity;

import java.io.Serializable;

/**
 * SeraUser
 *
 * @author wcy
 * @date 2022/8/25
 */
public class SeriUser implements Serializable {

    private static final long serialVersionUID = 1L;
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String name;
    private Integer age;

    private String sex;

    private String gender;

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

    @Override
    public String toString() {
        return "SeriUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
