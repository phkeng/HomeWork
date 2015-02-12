/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

import com.blogspot.na5cent.connectdb.C3DBConfig;
import com.blogspot.na5cent.connectdb.mapping.GenericAnnotationMapping;
import com.blogspot.na5cent.connectdb.model.Job;
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
public class JobService {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                C3DBConfig.getUrl(),
                C3DBConfig.getUsername(),
                C3DBConfig.getPassword()
        );
    }

    public static List<Job> findAll() throws Exception {
        Class.forName(C3DBConfig.getDriver());

        List<Job> results = null;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Jobs");
            results = GenericAnnotationMapping.fromResultSet(resultSet, Job.class);
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
