package com.example.learn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

/**
 * DateUser
 *
 * @author wcy
 * @date 2022/8/3
 */

public class DateUser {
    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //适用formdata类型接收
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateUser dateUser = (DateUser) o;
        return Objects.equals(birthday, dateUser.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthday);
    }
}
