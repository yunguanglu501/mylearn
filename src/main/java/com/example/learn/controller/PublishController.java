package com.example.learn.controller;

import com.example.learn.date.t0916.ApplicationEventSender;
import com.example.learn.date.t0916.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PublishController
 *
 * @author wcy
 */
@RestController
public class PublishController {

    @Autowired
    private ApplicationEventSender sender;

    @RequestMapping("test/pub")
    public void testSpringWatch() {
        sender.saveUser(UserDTO.builder()
                .name("阿鹏从小就淘")
                .sex("男")
                .build());
    }

}
