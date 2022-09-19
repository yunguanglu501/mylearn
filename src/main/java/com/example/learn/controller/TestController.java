package com.example.learn.controller;

import com.example.learn.fx.FxPerson;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
public class TestController {

    @RequestMapping("test1")
    public FxPerson test1(@RequestBody FxPerson fxPerson) throws Exception {
        Thread.sleep(1000L);
        return fxPerson;
    }

    @GetMapping("/testDate/date")
    public LocalDate showDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return date;
    }

    @GetMapping("/testDate/time")
    public LocalTime showTime(@RequestParam @DateTimeFormat(pattern = "HH:mm:ss") LocalTime time) {
        return time;
    }
    @GetMapping("/testDate/dateTime")
    public LocalDateTime showDateTime(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime) {
        return dateTime;
    }
}
