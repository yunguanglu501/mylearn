package com.example.learn.fenye;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * MemPageHelper
 *
 * @author wcy
 * @date 2022/8/23
 */
public class MemPageHelper {
    public static void pageHelper(Integer pageSize,
                                  List list,
                                  Consumer consumer) {
        // 默认 100 分页
        if (pageSize == null || pageSize == 0) {
            pageSize = 100;
        }
        Integer totalSize = list.size();
        Integer totalPage = totalSize / pageSize;
        if (totalSize % pageSize != 0) {
            totalPage += 1;
            if (totalSize < pageSize) {
                pageSize = totalSize;
            }
        }

        for (int pageNum = 1; pageNum < totalPage + 1; pageNum++) {
            int starNum = (pageNum - 1) * pageSize;
            int endNum = pageNum * pageSize > totalSize ? (totalSize) : pageNum * pageSize;
            consumer.accept(list.subList(starNum, endNum));
        }

    }

    public static void main(String[] args) {
        List list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        pageHelper(5, list, pageList -> {
                    System.out.println(pageList);
                }

        );
    }
}
