package com.example.learn.fenye;


import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * PaginationUtil
 *
 * @author wcy
 * @date 2022/8/23
 */
public class PaginationUtil {

    /**
     * 通用分页工具类
     * @param data
     * @param pageSize
     * @param pageNum
     * @param <T>
     * @return
     */
    public static <T> PageModel<T> pagination(final List<T> data, final int pageSize, final int pageNum) {
        if (CollectionUtils.isEmpty(data)) {
            return PageModel.emptyPageModel();
        }
        List<List<T>> lists = Lists.partition(data, pageSize);
        int localPageNum = pageNum;
        if (localPageNum > lists.size()) {
            localPageNum = lists.size();
        }
        return PageModel.build(lists.get(localPageNum - 1), pageNum, data.size(), pageSize);
    }
}
