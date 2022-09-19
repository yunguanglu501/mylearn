package com.example.learn.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.learn.entity.DateUser;
import com.example.learn.entity.Student;
import com.example.learn.entity.StudentDO;
import com.example.learn.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
public class DateTestController {

    @GetMapping("/date")
    public LocalDate showDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return date;
    }

    @GetMapping("/time")
    public LocalTime showTime(@RequestParam @DateTimeFormat(pattern = "HH:mm:ss") LocalTime time) {
        return time;
    }

    @GetMapping("/dateTime")
    public LocalDateTime showDateTime(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime) {
        return dateTime;
    }

    // @InitBinder
    // public void intDate(WebDataBinder dataBinder){
    //     dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    // }
    @Autowired
    StudentMapper studentMapper;
    @RequestMapping("test")
    @ResponseBody
    public StudentDO test(@RequestBody DateUser date) {
        StudentDO studentDO = studentMapper.selectOne(Wrappers.<StudentDO>lambdaQuery().eq(StudentDO::getStuName, "张三"));
        System.out.println("birthday: "+date);
        return studentDO;
    }
}
