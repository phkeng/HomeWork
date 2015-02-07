/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

/**
 *
 * @author anonymous
 */
public class EmployeeSearchByDepartmentService extends AbstractEmployeeSearchService {

    @Override
    protected String getSQLCode() {
        return "SELECT e.* "
                + "FROM Employees e "
                + ""
                + "INNER JOIN Departments d "
                + "ON (e.department_id = d.department_id) "
                + ""
                + "WHERE LOWER(d.department_name) LIKE ?";
    }

}
