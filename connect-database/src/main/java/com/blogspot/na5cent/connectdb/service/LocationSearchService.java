/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

import com.blogspot.na5cent.connectdb.model.Location;
import com.blogspot.na5cent.connectdb.query.Page;
import com.blogspot.na5cent.connectdb.query.Pagination;
import com.blogspot.na5cent.connectdb.query.QueryBuilder2;
import com.blogspot.na5cent.connectdb.util.SqlUtils;

/**
 *
 * @author anonymous
 */
public class LocationSearchService {

    public static Page<Location> searchByStreetAddress(String keyword, Pagination pagination) throws Exception {
        keyword = SqlUtils.wrapKeywordLike(keyword);
        return QueryBuilder2.fromSQL("SELECT * FROM Locations WHERE LOWER(street_address) LIKE ?")
                .addParam(keyword)
                .withPagination(pagination)
                .executeforPage(Location.class);
    }

    public static Page<Location> searchByCity(String keyword, Pagination pagination) throws Exception {
        keyword = SqlUtils.wrapKeywordLike(keyword);
        return QueryBuilder2.fromSQL("SELECT * FROM Locations WHERE LOWER(city) LIKE ?")
                .addParam(keyword)
                .withPagination(pagination)
                .executeforPage(Location.class);
    }

    public static Page<Location> searchByStateProvince(String keyword, Pagination pagination) throws Exception {
        keyword = SqlUtils.wrapKeywordLike(keyword);
        return QueryBuilder2.fromSQL("SELECT * FROM Locations WHERE LOWER(state_province) LIKE ?")
                .addParam(keyword)
                .withPagination(pagination)
                .executeforPage(Location.class);
    }
}
