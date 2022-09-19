package com.example.learn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
  * @Description:    
  * @Author:         wcy
  * @CreateDate:     2022/6/15 17:19
 */
@Data
@TableName(value = "`order`")
public class Order {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单id
     */
    @TableField(value = "item_id")
    private Integer itemId;

    /**
     * 购买人姓名
     */
    @TableField(value = "buy_name")
    private String buyName;
}