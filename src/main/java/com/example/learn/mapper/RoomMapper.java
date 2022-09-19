package com.example.learn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.learn.entity.RoomDO;

/**
 * RoomMapper
 * 
 * @author wcy
 * @date 2022/8/29
 */

public interface RoomMapper extends BaseMapper<RoomDO> {


    void updateRoom(Integer num);
}