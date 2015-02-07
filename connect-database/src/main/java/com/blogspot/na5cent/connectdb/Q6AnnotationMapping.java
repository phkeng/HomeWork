/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.mapping.JobAnnotationMapping;
import com.blogspot.na5cent.connectdb.model.Job;
import com.blogspot.na5cent.connectdb.printer.JobReflectionPrinter;
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
public class Q6AnnotationMapping {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                C3DBConfig.getUrl(),
                C3DBConfig.getUsername(),
                C3DBConfig.getPassword()
        );
    }

    private static List<Job> findJobs() throws Exception {
        Class.forName(C3DBConfig.getDriver());

        List<Job> results = null;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Jobs");
            
            results = JobAnnotationMapping.fromResultSet(resultSet);
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

    public static void main(String[] args) throws Exception {
        List<Job> results = findJobs();
        JobReflectionPrinter.prints(results);
    }
}
