package com.example.learn.test;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StopWatch;

/**
 * @Author: wcy
 * @Date: 2022/7/7 18:11
 * @Version 1.0
 */
public class Demo02 {

    public static void main(String[] args) throws Exception{

        //使用 StopWatch
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("任务1");
        Thread.sleep(3000L);
        stopWatch.stop();
        stopWatch.start("任务2");
        Thread.sleep(2000L);
        stopWatch.stop();
        StopWatch.TaskInfo[] taskInfo = stopWatch.getTaskInfo();
        System.out.println("JSON.toJSONString(taskInfo) = " + JSON.toJSONString(taskInfo));
        System.out.println("最后一个任务耗时：" + stopWatch.getLastTaskTimeMillis() + "毫秒");
        System.out.println("最后一个任务名称：" + stopWatch.getLastTaskName());
        System.out.println("所有任务耗时：" + stopWatch.getTotalTimeMillis() + "毫秒");
        System.out.println("所有任务耗时：" + stopWatch.getTotalTimeSeconds() + "秒");
        System.out.println("stopWatch.shortSummary()"+stopWatch.shortSummary());
        //打印每个任务执行时间，以及占总时间百分比
        System.out.println("stopWatch.prettyPrint()"+stopWatch.prettyPrint());
        System.out.println(stopWatch.toString());

    }

}
