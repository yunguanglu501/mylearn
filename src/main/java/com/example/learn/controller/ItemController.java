package com.example.learn.controller;

import com.example.learn.entity.Item;
import com.example.learn.entity.Order;
import com.example.learn.mapper.ItemMapper;
import com.example.learn.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/15 17:01
 */
@RestController
@Slf4j
public class ItemController {

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    RedissonClient redissonClient;

    private static final String lockKey = "buyHatKey:";

    @RequestMapping("buyItem")
    public Boolean buyItem(Integer id) throws Exception {
        RLock lock = redissonClient.getLock(lockKey + id);
        try {
            boolean tryLock = lock.tryLock(1, 1, TimeUnit.SECONDS);
            if (tryLock) {
                Item item = itemMapper.selectById(id);
                if (item != null && item.getItemStock() > 0) {
                    item.setItemStock(item.getItemStock() - 1);
                    itemMapper.updateById(item);
                    //生成订单
                    Order order = new Order();
                    order.setItemId(id);
                    order.setBuyName("张三" + System.currentTimeMillis() + new Random().nextLong());
                    orderMapper.insert(order);
                    return Boolean.TRUE;
                } else {
                    return Boolean.FALSE;
                }
            } else {
                System.out.println("等待中....");
            }

        } catch (Exception e) {
            System.out.println("e = " + e);
        } finally {
            //判断要解锁的key是否被当前线程持有。
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }

        }
        return Boolean.TRUE;
    }


    @RequestMapping("buyItem2")
    public Boolean buyItem2(Integer id) throws Exception {
        synchronized (ItemController.class){
            Item item = itemMapper.selectById(id);
            if (item != null && item.getItemStock() > 0) {
                item.setItemStock(item.getItemStock() - 1);
                itemMapper.updateById(item);
                //生成订单
                Order order = new Order();
                order.setItemId(id);
                order.setBuyName("张三" + System.currentTimeMillis() + new Random().nextLong());
                orderMapper.insert(order);
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;
            }
        }

    }


}
