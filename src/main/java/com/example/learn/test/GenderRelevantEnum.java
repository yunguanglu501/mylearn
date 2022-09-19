package com.example.learn.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: wcy
 * @Date: 2022/7/6 14:41
 * @Version 1.0
 */
public class GenderRelevantEnum {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public enum GenderOfHealthRecordsEnum {
        /**
         * MALE
         */
        MALE(1, "男", "MALE"),
        /**
         * FEMALE
         */
        FEMALE(0, "女", "FEMALE");
        /**
         * 健康档案性别编码
         */
        private int healthRecordsCode;
        private String chineseDesc;
        private String englishDesc;

        public static String getCodeByChineseDesc(String chineseDesc) {
            for (GenderOfHealthRecordsEnum value : GenderOfHealthRecordsEnum.values()) {
                if (value.getChineseDesc().equals(chineseDesc)) {
                    return "" + value.getHealthRecordsCode();
                }
            }
            return null;
        }

        public static String getCodeByEnglishDesc(String englishDesc) {
            for (GenderOfHealthRecordsEnum value : GenderOfHealthRecordsEnum.values()) {
                if (value.getEnglishDesc().equals(englishDesc)) {
                    return "" + value.getHealthRecordsCode();
                }
            }
            return null;
        }
    }
}
