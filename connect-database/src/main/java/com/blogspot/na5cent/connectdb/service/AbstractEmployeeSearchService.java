/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

import com.blogspot.na5cent.connectdb.model.EmployeeMap;
import com.blogspot.na5cent.connectdb.query.Page;
import com.blogspot.na5cent.connectdb.query.Pagination;
import com.blogspot.na5cent.connectdb.query.QueryBuilder3;
import com.blogspot.na5cent.connectdb.util.RegExUtils;
import com.blogspot.na5cent.connectdb.util.SqlUtils;

/**
 *
 * @author anonymous
 */
public abstract class AbstractEmployeeSearchService implements EmployeeSearchService {

    private static final String QUESTIONMARK = "\\?";

    protected abstract String getSQLCode();

    private void addParameters(String keyword, QueryBuilder3 query, int count) {
        for (int i = 0; i < count; i++) {
            query.addParam(keyword);
        }
    }

    @Override
    public Page<EmployeeMap> search(String keyword, Pagination pagination) {
        keyword = SqlUtils.wrapKeywordLike(keyword);

        String sqlCode = getSQLCode();
        int count = RegExUtils.countPatternFromKeyword(QUESTIONMARK, sqlCode);

        QueryBuilder3 query = QueryBuilder3.fromSQL(sqlCode);
        addParameters(keyword, query, count);

        return query
                .withPagination(pagination)
                .executeforPage(EmployeeMap.class);
    }

}
