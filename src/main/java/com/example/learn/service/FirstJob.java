package com.example.learn.service;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/28 13:57
 */
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FirstJob {

    @XxlJob(value = "firstJob", init = "init", destroy = "destroy")
    public ReturnT<String> execute(String param) {
        XxlJobLogger.log("XXL-JOB, firstJob. param: {}", param);
        log.info("XXL-JOB, firstJob. param: {}", param);
        return ReturnT.SUCCESS;
    }

    public void init() {
        log.info("init");
    }

    public void destroy() {
        log.info("destory");
    }
}
