package com.example.learn.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/9 16:14
 */
@Service
@Slf4j
public class BizService {

    /**
     * 传统的 if else 解决方法
     * 当每个业务逻辑有 3 4 行时，用传统的策略模式不值得，直接的if else又显得不易读
     */
    public String getCheckResult(String order) {
        if ("校验1".equals(order)) {
            return "执行业务逻辑1";
        } else if ("校验2".equals(order)) {
            return "执行业务逻辑2";
        } else if ("校验3".equals(order)) {
            return "执行业务逻辑3";
        } else if ("校验4".equals(order)) {
            return "执行业务逻辑4";
        } else if ("校验5".equals(order)) {
            return "执行业务逻辑5";
        } else if ("校验6".equals(order)) {
            return "执行业务逻辑6";
        } else if ("校验7".equals(order)) {
            return "执行业务逻辑7";
        } else if ("校验8".equals(order)) {
            return "执行业务逻辑8";
        } else if ("校验9".equals(order)) {
            return "执行业务逻辑9";
        }
        return "不在处理的逻辑中返回业务错误";
    }


    public int addOne(Integer num) {
        return num + 1;
    }

    public int subOne(Integer num) {
        return num - 1;
    }


    public int mulOne(Integer num) {
        return num * 1;
    }


    public int divOne(Integer num) {
        return num / 1;
    }

    public int addTwo(Integer num) {
        return num + 2;
    }

    public int subTwo(Integer num) {
        return num - 2;
    }


    public int mulTwo(Integer num) {
        return num * 2;
    }


    public int divTwo(Integer num) {
        return num / 2;
    }

    /**
     * 业务逻辑分派Map
     * Function为函数式接口，下面代码中 Function<String, String> 的含义是接收一个Stirng类型的变量，返回一个String类型的结果
     */
    private Map<String, Function<Integer, Integer>> checkResultDispatcher = new HashMap<>();

    /**
     * 初始化 业务逻辑分派Map 其中value 存放的是 lambda表达式
     */
    @PostConstruct
    public void checkResultDispatcherInit() {
        checkResultDispatcher.put("加1", this::addOne);
        checkResultDispatcher.put("减1", this::subOne);
        checkResultDispatcher.put("乘1", this::mulOne);
        checkResultDispatcher.put("除1", this::divOne);
        checkResultDispatcher.put("加2", this::addTwo);
        checkResultDispatcher.put("减2", this::subTwo);
        checkResultDispatcher.put("乘2", this::mulTwo);
        checkResultDispatcher.put("除2", this::divTwo);

        log.info("checkResultDispatcher的值为: {}", JSON.toJSONString(checkResultDispatcher));
    }

    public String getCheckResultSuper(String order, int num) {
        //从逻辑分派Dispatcher中获得业务逻辑代码，result变量是一段lambda表达式
        Function<Integer, Integer> result = checkResultDispatcher.get(order);
        if (result != null) {
            //执行这段表达式获得String类型的结果
            return "" + result.apply(num);
        }
        return "不在处理的逻辑中返回业务错误";
    }
}
