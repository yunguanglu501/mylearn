package com.example.learn.service;

import com.example.learn.entity.MoneyDO;
import com.example.learn.mapper.MoneyMapper;
import com.example.learn.mapper.ScoreMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TransService
 *
 * @author wcy
 * @date 2022/8/29
 */
@Service
@Slf4j
public class TransService1 {

    @Autowired
    ScoreMapper scoreMapper;

    @Autowired
    MoneyMapper moneyMapper;
    @Transactional(rollbackFor = Throwable.class)
    public void update(Integer num) {
        moneyMapper.updateMoney(num);
        try {
            int i = 10/0;
        }catch (Exception e){
            throw new RuntimeException("算数异常");
        }
        scoreMapper.updateScore(num);

    }
}
