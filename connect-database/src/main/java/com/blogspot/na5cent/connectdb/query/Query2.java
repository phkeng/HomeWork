/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.query;

import com.blogspot.na5cent.connectdb.C3DBConfig;
import com.blogspot.na5cent.connectdb.mapping.GenericAnnotationMapping;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anonymous
 */
public class Query2 {

    private static void setParameter(PreparedStatement statement, Map.Entry<Integer, Object> entry) throws SQLException {
        if (entry.getValue() instanceof String) {
            statement.setString(entry.getKey(), (String) entry.getValue());
        } else if (entry.getValue() instanceof Integer) {
            statement.setInt(entry.getKey(), (Integer) entry.getValue());
        } else if (entry.getValue() instanceof Long) {
            statement.setLong(entry.getKey(), (Long) entry.getValue());
        } else if (entry.getValue() instanceof Float) {
            statement.setFloat(entry.getKey(), (Float) entry.getValue());
        } else if (entry.getValue() instanceof Double) {
            statement.setDouble(entry.getKey(), (Double) entry.getValue());
        } else if (entry.getValue() instanceof Date) {
            statement.setDate(entry.getKey(), (Date) entry.getValue());
        }
    }

    private static void setParameters(PreparedStatement statement, Map<Integer, Object> parameters) throws SQLException {
        for (Map.Entry<Integer, Object> entry : parameters.entrySet()) {
            setParameter(statement, entry);
        }
    }

    public static <T> List<T> executeReturnList(String sqlCode, Class<T> clazz, Map<Integer, Object> parameters) throws Exception {
        Class.forName(C3DBConfig.getDriver());
        
        List<T> results = null;
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(
                    C3DBConfig.getUrl(),
                    C3DBConfig.getUsername(),
                    C3DBConfig.getPassword()
            );

            statement = connection.prepareStatement(sqlCode);
            setParameters(statement, parameters);
            resultSet = statement.executeQuery();
            results = GenericAnnotationMapping.fromResultSet(resultSet, clazz);
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
