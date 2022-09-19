package com.example.learn.config;

/**
 * DateConverter
 *
 * @author wcy
 * @date 2022/8/4
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换类
 * 将标准日期、标准日期时间、时间戳转换成Date类型
 */
@Slf4j
public class DateConverter implements Converter<String, Date> {


    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String shortDateFormat = "yyyy-MM-dd";
    private static final String timeStampFormat = "^(\\d{1,4})(-|\\/)(\\d{1,2})\\2(\\d{1,2})$";

    @Override
    public Date convert(String value) {
        log.info("转换日期：" + value);

        if (value == null || value.trim().equals("") || value.equalsIgnoreCase("null")) {
            return null;
        }

        value = value.trim();

        try {
            if (value.contains("-")) {
                SimpleDateFormat formatter;
                if (value.contains(":")) {
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                    formatter = new SimpleDateFormat(shortDateFormat);
                }
                return formatter.parse(value);
            } else if (value.matches(timeStampFormat)) {
                Long lDate = new Long(value);
                return new Date(lDate);
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", value));
        }
        throw new RuntimeException(String.format("parser %s to Date fail", value));
    }
}
