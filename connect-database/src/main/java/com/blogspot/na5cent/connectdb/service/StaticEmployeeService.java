/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

import com.blogspot.na5cent.connectdb.DBConfig;
import com.blogspot.na5cent.connectdb.mapping.GenericAnnotationMapping;
import com.blogspot.na5cent.connectdb.model.EmployeeMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class StaticEmployeeService {

    public static List<EmployeeMap> findEmployees() throws Exception {
        List<EmployeeMap> results = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(DBConfig.getDriver());
            connection = DriverManager.getConnection(
                    DBConfig.getUrl(),
                    DBConfig.getUsername(),
                    DBConfig.getPassword()
            );

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Employees");
            results = GenericAnnotationMapping.fromResultSet(resultSet, EmployeeMap.class);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return results;
    }
}
