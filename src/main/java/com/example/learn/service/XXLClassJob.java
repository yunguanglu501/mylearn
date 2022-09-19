package com.example.learn.service;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/28 13:57
 */
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
@Slf4j
public class XXLClassJob extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        log.info("XXLClassJob execute, param: {}", param);
        XxlJobLogger.log("XXLClassJob execute, param: {}", param);

        for (int i = 0; i < 5; i++) {
            log.info("XXLClassJob start, i: {} ", i);
            XxlJobLogger.log("XXLClassJob start, i: {} ", i);
            TimeUnit.SECONDS.sleep(2);
        }
        return ReturnT.SUCCESS;
    }
}