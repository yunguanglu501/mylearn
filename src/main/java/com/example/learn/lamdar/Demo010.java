package com.example.learn.lamdar;

import com.example.learn.entity.DateUser;
import com.example.learn.entity.User;

import java.util.*;

/**
 * Demo010
 *
 * @author wcy
 * @date 2022/8/9
 */
public class Demo010 {
    public static void main(String[] args) {
        DateUser dateUser = new DateUser();
        System.out.println("dateUser.hashCode() = " + dateUser.hashCode());

        DateUser dateUser2 = new DateUser();
        System.out.println("dateUser2.hashCode() = " + dateUser2.hashCode());

        DateUser dateUser3 = new DateUser();
        dateUser3.setBirthday(new Date());
        System.out.println("dateUser3.hashCode() = " + dateUser3.hashCode());

        DateUser dateUser4 = new DateUser();
        dateUser4.setBirthday(new Date());
        System.out.println("dateUser4.hashCode() = " + dateUser4.hashCode());
        System.out.println("dateUser.equals(dateUser2) = " + dateUser.equals(dateUser2));
        boolean b = dateUser == dateUser2;
        System.out.println("b = " + b);
    }
}
