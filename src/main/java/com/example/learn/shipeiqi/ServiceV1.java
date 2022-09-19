package com.example.learn.shipeiqi;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/30 17:40
 */
@Service
public class ServiceV1 {


    public void froOrderMap(Map map) {
        for (int i = 0; i < map.size(); i++) {
            // 使用I作为MapKey获取数据
            System.out.println("i = " + i);
            Object o = map.get(i);
            System.out.println("o = " + o);

            String value = o+"";
            System.out.println("value:" + value);
        }
    }
}
