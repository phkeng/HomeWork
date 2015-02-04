/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

import com.blogspot.na5cent.connectdb.mapping.GenericAnnotationMapping;
import com.blogspot.na5cent.connectdb.model.Country;
import com.blogspot.na5cent.connectdb.query.QueryUtils;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class CountryService {

    public static List<Country> findInRegion(Integer regionId) throws Exception {
        final List<Country> countries = new LinkedList<>();
        QueryUtils.executeQuery("SELECT * FROM Countries WHERE region_id = ?", new QueryUtils.Callback() {

            @Override
            public void processing(ResultSet resultSet) throws Exception {
                countries.addAll(GenericAnnotationMapping.fromResultSet(resultSet, Country.class));
            }
        }, regionId);

        return countries;
    }

    public static List<Country> findInAsia() throws Exception {
        return findInRegion(3);
    }
}
