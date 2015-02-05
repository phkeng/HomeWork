/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.query;

import java.util.List;

/**
 *
 * @author anonymous
 */
public class Page<T> {

    private Pagination pagination;
    private long totalElements;
    private List<T> contents;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getContents() {
        return contents;
    }

    public void setContents(List<T> contents) {
        this.contents = contents;
    }

    public int getTotolPages() {
        if (pagination.getPageSize() == 0) {
            return 0;
        }

        return (int) Math.ceil(totalElements / (float)pagination.getPageSize());
    }
}
