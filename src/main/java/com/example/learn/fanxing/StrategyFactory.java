package com.example.learn.fanxing;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/9 13:37
 */
public class StrategyFactory {

    private static final Map<String, Strategy> strategies = new HashMap<>();
    static {
        strategies.put("A", new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }
    // 根据 type 获取策略类
    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        System.out.println("strategies = " + JSON.toJSONString(strategies));
        return strategies.get(type);
    }

}
