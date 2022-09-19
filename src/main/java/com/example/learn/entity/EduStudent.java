package com.example.learn.entity;

import com.alibaba.fastjson.JSON;import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
  * @Description:    
  * @Author:         wcy
  * @CreateDate:     2022/6/24 10:25
 */

/**
 * 学生表
 */
@Data
@TableName(value = "edu_student")
public class EduStudent {
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
     * 库存
     */
    @TableField(value = "stu_stock")
    private Integer stuStock;

    /**
     * 数量
     */
    @TableField(value = "num")
    private Integer num;

    public static void main(String[] args) {
        String tableName = JSON.toJSONString(null);
        System.out.println("tableName = " + tableName);
        long l = System.currentTimeMillis();
        System.out.println("l = " + l);
        System.out.println();
    }
}