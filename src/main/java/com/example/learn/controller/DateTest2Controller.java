package com.example.learn.controller;

import com.example.learn.entity.DateUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * DateTestController
 *
 * @author wcy
 * @date 2022/8/3
 */
@RestController
@Slf4j
public class DateTest2Controller {

    // @GetMapping("/date")
    // public LocalDate showDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
    //     return date;
    // }
    //
    // @GetMapping("/time")
    // public LocalTime showTime(@RequestParam @DateTimeFormat(pattern = "HH:mm:ss") LocalTime time) {
    //     return time;
    // }
    // @GetMapping("/dateTime")
    // public LocalDateTime showDateTime(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime) {
    //     return dateTime;
    // }
    //
    @InitBinder
    public void intDate(WebDataBinder dataBinder){
        dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    @RequestMapping("test2")
    @ResponseBody
    public DateUser test(DateUser date){
        System.out.println(date);
        return date;
    }
}
