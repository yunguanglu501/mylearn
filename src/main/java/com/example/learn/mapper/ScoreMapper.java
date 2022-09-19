package com.example.learn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.learn.entity.ScoreDO;

/**
 * ScoreMapper
 * 
 * @author wcy
 * @date 2022/8/29
 */

public interface ScoreMapper extends BaseMapper<ScoreDO> {
    void updateScore(Integer num);
}