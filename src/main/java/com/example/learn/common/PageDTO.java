package com.example.learn.common;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/14 15:44
 */
public class PageDTO<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -8950203776384924406L;
    private Integer pageSize;
    private Integer totalSize;
    private Integer currentPage;
    private Integer totalPage;
    private T req;
    private List<T> results;

    public PageDTO() {
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Integer getTotalSize() {
        return this.totalSize;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public T getReq() {
        return this.req;
    }

    public List<T> getResults() {
        return this.results;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public void setReq(T req) {
        this.req = req;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String toString() {
        return "PageDTO(pageSize=" + this.getPageSize() + ", totalSize=" + this.getTotalSize() + ", currentPage=" + this.getCurrentPage() + ", totalPage=" + this.getTotalPage() + ", req=" + this.getReq() + ", results=" + this.getResults() + ")";
    }
}
