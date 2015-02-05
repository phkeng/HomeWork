/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.query;

import com.blogspot.na5cent.connectdb.C3DBConfig;
import com.blogspot.na5cent.connectdb.mapping.GenericAnnotationMapping;
import static com.blogspot.na5cent.connectdb.util.CollectionUtils.isEmpty;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class Query4 {

    private final String sqlCode;
    private final List<Object> params;

    private Query4(String sqlCode) {
        this.sqlCode = sqlCode;
        params = new LinkedList<>();
    }

    public static Query4 fromSQL(String sqlCode) {
        return new Query4(sqlCode);
    }

    public Query4 addParam(Object value) {
        params.add(value);
        return this;
    }

    private void setParameters(PreparedStatement statement, List<Object> parameters) throws SQLException {
        if (isEmpty(parameters)) {
            return;
        }

        for (int i = 0; i < parameters.size(); i++) {
            statement.setObject(i + 1, parameters.get(i));
        }
    }

    public <T> List<T> executeforList(final Class<T> clazz) throws Exception {
        final List<T> results = new LinkedList<>();
        execute(new Callback() {

            @Override
            public void processing(ResultSet resultSet) throws Exception {
                results.addAll(GenericAnnotationMapping.fromResultSet(resultSet, clazz));
            }
        });

        return results;
    }

    private void execute(String sqlCode, Callback callback, List<Object> params) throws Exception {
        Class.forName(C3DBConfig.getDriver());

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
            setParameters(statement, params);
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

    public void execute(Callback callback) throws Exception {
        execute(sqlCode, callback, params);
    }

    public static interface Callback {

        void processing(ResultSet resultSet) throws Exception;
    }

}
