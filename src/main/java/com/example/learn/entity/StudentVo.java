package com.example.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/13 10:36
 */
@Data
public class StudentVo {
    /**
     * 学号
     */
    @TableId(value = "stu_id", type = IdType.AUTO)
    private String stuId;

    /**
     * 学生姓名
     */
    @TableField(value = "stu_name")
    private String stuName;

    /**
     * 年龄
     */
    @TableField(value = "stu_age")
    private Integer stuAge;

    @TableField(value = "is_del")
    private Integer isDel;

}
