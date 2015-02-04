/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author anonymous
 */
public class T2SelectFrom {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(
                    DBConfig.getUrl(),
                    DBConfig.getUsername(),
                    DBConfig.getPassword()
            );

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Employees");
            while (resultSet.next()) {
                System.out.println("employee_id = " + resultSet.getInt("employee_id"));
                System.out.println("first_name = " + resultSet.getString("first_name"));
                System.out.println("last_name = " + resultSet.getString("last_name"));
                System.out.println("email = " + resultSet.getString("email"));
                System.out.println("------------------------------------------");
            }
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
    }
}
