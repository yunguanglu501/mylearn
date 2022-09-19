package com.example.learn.fenye;

import cn.hutool.core.collection.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ListPageUtil
 *
 * @author wcy
 * @date 2022/8/23
 */
public class ListPageUtil {
    /**
     * 页码开始分页
     *
     * @param list
     * @param pageNum  页码
     * @param pageSize 每页多少条数据
     * @return
     */
    public static List startPage(List list, Integer pageNum, Integer pageSize) {
        if (list == null) {
            return null;
        }
        if (list.size() == 0) {
            return null;
        }
        Integer count = list.size(); // 记录总数
        Integer pageCount = 0; // 页数
        if (count % pageSize == 0) {
            pageCount = count / pageSize;
        } else {
            pageCount = count / pageSize + 1;
        }
        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引
        if (pageNum != pageCount.intValue()) {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = fromIndex + pageSize;
        } else {
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = count;
        }
        // subList方法有泄漏的风险
        // List pageList = list.subList(fromIndex, toIndex);
        List pageList = (List) list.stream().skip(fromIndex).limit(pageSize).collect(Collectors.toList());
        return pageList;
    }

    /**
     * offset开始分页
     *
     * @param list
     * @param offset 数据索引起始
     * @param limit  每页多少条数据
     * @return
     */
    public static List startPageByOffset(List list, Integer offset, Integer limit) {
        if (list == null) {
            return null;
        }
        if (list.size() == 0) {
            return list;
        }
        // subList方法有泄漏的风险
        // List pageList = list.subList(fromIndex, toIndex);
        List pageList = (List) list.stream().skip(offset).limit(limit).collect(Collectors.toList());
        return pageList;
    }

    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        // List<String> list1 = ListPageUtil.startPage(list, 1, 2);
        // // List<String> list1 = ListPageUtil.startPageByOffset(list, 0, 3);
        // for (String ad : list1) {
        //     System.out.println(ad);
        // }


        int pageNum = 0;
        int pageSize = 2;
        List<String> results = ListUtil.page(pageNum, pageSize, list);
        System.out.println("results = " + results);
    }
}
