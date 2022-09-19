package com.example.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * MoneyDO
 * 
 * @author wcy
 * @date 2022/8/29
 */

@Data
@TableName(value = "t_money")
public class MoneyDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "money")
    private Integer money;
}