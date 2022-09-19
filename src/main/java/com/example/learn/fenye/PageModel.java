package com.example.learn.fenye;


import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * PageModel
 *
 * @author wcy
 * @date 2022/8/23
 */
@Data
public class PageModel<T> {

    /**
     * 当前页
     */
    private int currentPage;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 页面容量
     */
    private int pageSize;

    /**
     * 总数据数
     */
    private int totalRecordCount;

    /**
     * 当前页数据集
     */
    private List<T> records = Collections.emptyList();


    public static <T> PageModel<T> build(List<T> records, int current, int totalRecordCount, int pageSize) {
        PageModel<T> pageModel = new PageModel<T>();
        pageModel.setCurrentPage(current);
        pageModel.setPageSize(pageSize);
        pageModel.setRecords(records);
        pageModel.setTotalRecordCount(totalRecordCount);
        int pages = totalRecordCount / pageSize;
        pageModel.setTotalPage((totalRecordCount) % pageSize == 0 ? pages : (pages + 1));
        return pageModel;
    }

    public static<T> PageModel<T> emptyPageModel() {
        return new PageModel();
    }
}
