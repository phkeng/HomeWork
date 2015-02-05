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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anonymous
 */
public class Query5 {

    private final String sqlCode;
    private final List<Object> params;
    private Pagination pagination;

    private Query5(String sqlCode) {
        this.sqlCode = sqlCode;
        params = new LinkedList<>();
    }

    public static Query5 fromSQL(String sqlCode) {
        return new Query5(sqlCode);
    }

    public Query5 addParam(Object value) {
        params.add(value);
        return this;
    }

    public Query5 withPagination(Pagination pagination) {
        this.pagination = pagination;
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
        execute((ResultSet resultSet) -> {
            results.addAll(GenericAnnotationMapping.fromResultSet(resultSet, clazz));
        });

        return results;
    }

    private String wrapBySQLCount(String sqlCode) {
        return "SELECT count(*) as cnt FROM (" + sqlCode + ")";
    }

    private String wrapBySQLPagination(String sqlCode, Pagination pagination) {
        int first = pagination.getPageNumber() * pagination.getPageSize();
        int last = (pagination.getPageNumber() + 1) * pagination.getPageSize();

        return new StringBuilder()
                .append("SELECT item.* ")
                .append("FROM ")
                .append("    ( ")
                .append("        SELECT item.*, ")
                .append("               ROWNUM rnum ")
                .append("        FROM ( ")
                .append("            ").append(sqlCode)
                .append("        ) item ")
                .append("        WHERE ROWNUM <= ").append(last)
                .append("    ) item ")
                .append("WHERE rnum > ").append(first)
                .toString();
    }

    public long executeCount() throws Exception {
        final Map<String, Long> map = new HashMap<>();
        execute(wrapBySQLCount(sqlCode), (ResultSet resultSet) -> {
            if (resultSet.next()) {
                map.put("count", resultSet.getLong("cnt"));
            }
        });

        return map.get("count") == null ? 0 : map.get("count");
    }

    private <T> Page createPage() throws Exception {
        Page<T> page = new Page<>();
        page.setPagination(pagination);
        page.setTotalElements(executeCount());

        return page;
    }

    public <T> Page<T> executeforPage(final Class<T> clazz) throws Exception {
        if (pagination == null) {
            throw new IllegalArgumentException("require pagination");
        }

        final Page<T> page = createPage();
        execute(wrapBySQLPagination(sqlCode, pagination), (ResultSet resultSet) -> {
            page.setContents(GenericAnnotationMapping.fromResultSet(resultSet, clazz));
        });

        return page;
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

    private void execute(String sqlCode, Callback callback) throws Exception {
        execute(sqlCode, callback, params);
    }

    public void execute(Callback callback) throws Exception {
        execute(sqlCode, callback, params);
    }

    public static interface Callback {

        void processing(ResultSet resultSet) throws Exception;
    }

}
