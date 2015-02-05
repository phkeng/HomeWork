/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.query;

import com.blogspot.na5cent.connectdb.C3DBConfig;
import com.blogspot.na5cent.connectdb.mapping.GenericAnnotationMapping;
import java.sql.Connection;
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
public class QueryUtils2 {

    private static void setParameters(PreparedStatement statement, Map<Integer, Object> parameters) throws SQLException {
        for (Map.Entry<Integer, Object> entry : parameters.entrySet()) {
            statement.setObject(entry.getKey(), entry.getValue());
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
