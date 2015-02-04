/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.mapping;

import com.blogspot.na5cent.connectdb.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class EmployeeNormalMapping {

    private static Employee transformResultReset(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getInt("employee_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setEmail(resultSet.getString("email"));

        return employee;
    }

    public static List<Employee> fromResultSet(ResultSet resultSet) throws SQLException {
        List<Employee> list = new LinkedList<>();
        while (resultSet.next()) {
            list.add(transformResultReset(resultSet));
        }

        return list;
    }
}
