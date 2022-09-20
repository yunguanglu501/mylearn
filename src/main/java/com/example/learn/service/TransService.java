package com.example.learn.service;

import com.example.learn.entity.MoneyDO;
import com.example.learn.entity.ScoreDO;
import com.example.learn.mapper.MoneyMapper;
import com.example.learn.mapper.RoomMapper;
import com.example.learn.mapper.ScoreMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
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
public class TransService {

    @Autowired
    TransService1 transService1;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    ScoreMapper scoreMapper;

    @Autowired
    MoneyMapper moneyMapper;


    public void testTrans2(Integer num) {

        roomMapper.updateRoom(num);
        transService1.update(num);


    }

    public void testTrans(Integer num) {

        roomMapper.updateRoom(num);
        TransService o = (TransService) AopContext.currentProxy();
        o.update(num);
        // try {
        //     int i = 1 / 0;
        // } catch (Exception e) {
        //     throw new RuntimeException("算数异常");
        // }


    }

    @Transactional(rollbackFor = Throwable.class)
    public void update(Integer num) {
        moneyMapper.updateMoney(num);
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            throw new RuntimeException("算数异常");
        }
        scoreMapper.updateScore(num);

    }

    @Transactional(rollbackFor = Throwable.class)
    public void save() {
        save1();
        save2();
    }

    private void save2() {
        try {
            MoneyDO moneyDO = new MoneyDO();
            moneyDO.setName("张师傅白师傅李师傅小明师傅嘻嘻哈哈");
            moneyDO.setMoney(10);
            moneyMapper.insert(moneyDO);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    private void save1() {
        ScoreDO scoreDO = new ScoreDO();
        scoreDO.setName("黄晓明黄晓明黄晓明黄晓明黄晓明黄晓明黄晓明黄晓明黄晓明黄晓明");
        scoreDO.setScore(20);
        scoreMapper.insert(scoreDO);
    }
}
