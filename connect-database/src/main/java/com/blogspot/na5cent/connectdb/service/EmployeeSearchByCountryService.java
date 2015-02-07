/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

import com.blogspot.na5cent.connectdb.annotation.Service;

/**
 *
 * @author anonymous
 */
@Service(name = "searchByCountry")
public class EmployeeSearchByCountryService extends AbstractEmployeeSearchService {

    @Override
    protected String getSQLCode() {
        return new StringBuilder()
                .append("SELECT e.* ")
                .append("FROM Employees e ")
                .append("INNER JOIN Departments d ")
                .append("ON (e.department_id = d.department_id) ")
                .append("INNER JOIN Locations l ")
                .append("ON (d.location_id = l.location_id) ")
                .append("INNER JOIN Countries c ")
                .append("ON (l.country_id = c.country_id) ")
                .append("WHERE LOWER(c.country_name) LIKE ?")
                .toString();
    }

}
