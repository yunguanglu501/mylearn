package com.example.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/15 17:01
 */
@Data
@TableName(value = "item")
public class Item {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名
     */
    @TableField(value = "item_name")
    private String itemName;

    /**
     * 库存
     */
    @TableField(value = "item_stock")
    private Integer itemStock;
}