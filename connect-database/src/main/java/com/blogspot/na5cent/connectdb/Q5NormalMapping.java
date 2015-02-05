/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.mapping.EmployeeNormalMapping;
import com.blogspot.na5cent.connectdb.model.Employee;
import com.blogspot.na5cent.connectdb.printer.EmployeeNormalPrinter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class Q5NormalMapping {

    private static List<Employee> findEmployees() throws SQLException, ClassNotFoundException {
        Class.forName(C3DBConfig.getDriver());
        
        List<Employee> results = null;
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null; 
        try { 
            connection = DriverManager.getConnection(
                    C3DBConfig.getUrl(),
                    C3DBConfig.getUsername(),
                    C3DBConfig.getPassword()
            );

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Employees");
            results = EmployeeNormalMapping.fromResultSet(resultSet);
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

    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
        List<Employee> results = findEmployees();
        EmployeeNormalPrinter.prints(results);
    }
}
