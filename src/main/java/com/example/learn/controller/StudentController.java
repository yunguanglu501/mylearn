package com.example.learn.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.learn.entity.StudentDO;
import com.example.learn.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StudentController
 *
 * @author wcy
 * @date 2022/8/2
 */
@RestController
@Slf4j
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("findOne")
    public StudentDO findOne() {
        StudentDO aDo = new StudentDO();
        StudentDO studentDO = studentMapper.selectOne(Wrappers.<StudentDO>lambdaQuery()
                .eq(StudentDO::getStuName, "张三")
                .eq(StudentDO::getStuAge,aDo.getStuAge()));
        return studentDO;
    }
}
