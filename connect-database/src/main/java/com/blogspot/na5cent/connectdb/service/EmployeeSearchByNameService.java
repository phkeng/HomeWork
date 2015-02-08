/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

import com.blogspot.na5cent.connectdb.annotation.Service;
import com.blogspot.na5cent.connectdb.model.EmployeeMap;
import com.blogspot.na5cent.connectdb.query.Page;
import com.blogspot.na5cent.connectdb.query.Pagination;
import com.blogspot.na5cent.connectdb.query.QueryBuilder3;
import com.blogspot.na5cent.connectdb.util.SqlUtils;

/**
 *
 * @author anonymous
 */
@Service(name = "searchByName")
public class EmployeeSearchByNameService implements EmployeeSearchService {

    private static final String SQL_CODE
            = "SELECT * "
            + "FROM Employees "
            + "WHERE LOWER(first_name) LIKE ? OR LOWER(last_name) LIKE ?";

    @Override
    public Page<EmployeeMap> search(String keyword, Pagination pagination) {
        keyword = SqlUtils.wrapKeywordLike(keyword);
        return QueryBuilder3.fromSQL(SQL_CODE)
                .addParam(keyword)
                .addParam(keyword)
                .withPagination(pagination)
                .executeforPage(EmployeeMap.class);
    }

}
