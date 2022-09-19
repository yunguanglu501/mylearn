package com.example.learn.lamdar.neibulei;

import com.example.learn.lamdar.neibulei.StudyWarp;

/**
 * DefaultStudy
 *
 * @author wcy
 * @date 2022/8/10
 */
public class DefaultStudy implements StudyWarp.XiaoMing{
    @Override
    public String getToSchool() {
        return "我去上学！";
    }
}
