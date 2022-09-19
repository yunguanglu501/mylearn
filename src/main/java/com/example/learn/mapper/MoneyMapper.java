package com.example.learn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.learn.entity.MoneyDO;

/**
 * MoneyMapper
 * 
 * @author wcy
 * @date 2022/8/29
 */

public interface MoneyMapper extends BaseMapper<MoneyDO> {
    void updateMoney(Integer num);
}