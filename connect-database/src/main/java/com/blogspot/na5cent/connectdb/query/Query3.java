/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.query;

import com.blogspot.na5cent.connectdb.DBConfig;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author anonymous
 */
public class Query3 {

    private static void setParameter(PreparedStatement statement, int index, Object value) throws SQLException {
        if (value instanceof String) {
            statement.setString(index, (String) value);
        } else if (value instanceof Integer) {
            statement.setInt(index, (Integer) value);
        } else if (value instanceof Long) {
            statement.setLong(index, (Long) value);
        } else if (value instanceof Float) {
            statement.setFloat(index, (Float) value);
        } else if (value instanceof Double) {
            statement.setDouble(index, (Double) value);
        } else if (value instanceof Date) {
            statement.setDate(index, (Date) value);
        }
    }

    private static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    private static void setParameters(PreparedStatement statement, Object... parameters) throws SQLException {
        if (isEmpty(parameters)) {
            return;
        }

        for (int i = 0; i < parameters.length; i++) {
            setParameter(statement, i + 1, parameters[i]);
        }
    }

    public static void executeQuery(String sqlCode, Callback callback, Object... parameters) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(DBConfig.getDriver());
            connection = DriverManager.getConnection(
                    DBConfig.getUrl(),
                    DBConfig.getUsername(),
                    DBConfig.getPassword()
            );

            statement = connection.prepareStatement(sqlCode);
            setParameters(statement, parameters);
            resultSet = statement.executeQuery();
            callback.processing(resultSet);
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

    public static interface Callback {

        void processing(ResultSet resultSet) throws Exception;
    }

}
