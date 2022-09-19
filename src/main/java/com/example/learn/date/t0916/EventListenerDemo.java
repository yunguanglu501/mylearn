package com.example.learn.date.t0916;

/**
 * EventListenerDemo
 *
 * @author wcy
 */

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class EventListenerDemo {

    @EventListener(condition = "#user.name!=null")
    public void watch(UserDTO user) {
        // 如果user的name是null的话,下边都不会执行
        System.out.println("姓名: "+user.getName());
        System.out.println("性别: "+user.getSex());
    }
}
