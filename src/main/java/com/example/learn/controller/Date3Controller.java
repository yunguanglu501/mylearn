package com.example.learn.controller;

import com.example.learn.entity.DateUser;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * DateController
 *
 * @author wcy
 */
@RestController
@RequestMapping("haha2")
public class Date3Controller {
    // @InitBinder
    // public void intDate(WebDataBinder dataBinder) {
    //     dataBinder.addCustomFormatter(new DateFormatter("yyyy/MM/dd HH:mm:ss"),"birthday");
    // }

    @RequestMapping("test")
    @ResponseBody
    public DateUser test(DateUser date) {
        System.out.println(date);
        return date;
    }

}
