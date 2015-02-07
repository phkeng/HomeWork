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
import com.blogspot.na5cent.connectdb.util.SqlUtils;

/**
 *
 * @author anonymous
 */
public class EmployeeSearchByJobTitleService implements EmployeeSearchService {

    private static final String SQL_CODE
            = "SELECT e.* "
            + "FROM Employees e "
            + "INNER JOIN JOBS j "
            + "ON (e.job_id = j.job_id) "
            + "WHERE LOWER(j.job_title) LIKE ?";

    @Override
    public Page<EmployeeMap> search(String keyword, Pagination pagination) {
        keyword = SqlUtils.wrapKeywordLike(keyword);
        return QueryBuilder3.fromSQL(SQL_CODE)
                .addParam(keyword)
                .withPagination(pagination)
                .executeforPage(EmployeeMap.class);
    }

}
