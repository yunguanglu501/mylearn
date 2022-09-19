package com.example.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * StudentDO
 *
 * @author wcy
 * @date 2022/8/4
 */

@Data
@TableName(value = "student")
public class StudentDO {
    @TableId(value = "stu_id", type = IdType.AUTO)
    private Integer stuId;

    @TableField(value = "stu_name")
    private String stuName;

    @TableField(value = "stu_age")
    private Integer stuAge;

    @TableField(value = "is_del")
    private Integer isDel;

    @TableField(value = "birthday")
    private LocalDateTime birthday;
}