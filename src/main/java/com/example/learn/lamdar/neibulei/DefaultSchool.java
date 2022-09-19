package com.example.learn.lamdar.neibulei;

import com.example.learn.lamdar.neibulei.StudyWarp;

/**
 * DefaultSchool
 *
 * @author wcy
 * @date 2022/8/10
 */
public class DefaultSchool implements StudyWarp.GOSchool{
    @Override
    public boolean hasCar() {
        return true;
    }
}
