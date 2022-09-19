package com.example.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
  * @Description:    
  * @Author:         wcy
  * @CreateDate:     2022/6/15 16:59
 */
@Data
@TableName(value = "product")
public class Product {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 库存
     */
    @TableField(value = "product_stock")
    private Integer productStock;
}