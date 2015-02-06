/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

import com.blogspot.na5cent.connectdb.model.Location;
import com.blogspot.na5cent.connectdb.query.QueryUtils1;
import com.blogspot.na5cent.connectdb.query.QueryUtils2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anonymous
 */
public class LocationService {

    public static List<Location> findAll() throws Exception {
        return QueryUtils1.executeReturnList(
                "SELECT * FROM Locations",
                Location.class
        );
    }

    public static List<Location> findInAmerica() throws Exception {
        return QueryUtils1.executeReturnList(
                "SELECT * FROM Locations WHERE country_id = 'US'",
                Location.class
        );
    }

    public static List<Location> searchByStreetAddress(String term) throws Exception {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, term == null ? "%%" : "%" + term.toLowerCase() + "%");

        return QueryUtils2.executeReturnList(
                "SELECT * FROM Locations WHERE LOWER(street_address) LIKE ?",
                Location.class,
                params
        );
    }
}
