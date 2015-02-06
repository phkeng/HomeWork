/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.query;

import com.blogspot.na5cent.connectdb.C3DBConfig;
import com.blogspot.na5cent.connectdb.util.ReflectionUtils;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anonymous
 */
public class Procedures {

    private final String sqlCode;
    private final List<ParameterHolder> params;

    private static final Map<Class, Integer> typeMapping = new HashMap<>();

    static {
        typeMapping.put(String.class, java.sql.Types.VARCHAR);
        typeMapping.put(Integer.class, java.sql.Types.INTEGER);
        typeMapping.put(Double.class, java.sql.Types.DOUBLE);
        typeMapping.put(Date.class, java.sql.Types.DATE);
        typeMapping.put(Boolean.class, java.sql.Types.BOOLEAN);
    }

    private Procedures(String sqlCode) {
        this.sqlCode = sqlCode;
        params = new LinkedList<>();
    }

    public static Procedures call(String sqlCode) {
        return new Procedures(sqlCode);
    }

    public Procedures withParam(Object value) {
        params.add(new ParameterHolder(
                ParameterType.IN,
                value,
                null
        ));

        return this;
    }

    public Procedures withOutput(OutputCallback callback) {
        params.add(new ParameterHolder(
                ParameterType.OUT,
                null,
                callback
        ));

        return this;
    }

    private void setParameters(CallableStatement statement) throws Exception {
        for (int i = 0; i < params.size(); i++) {
            ParameterHolder holder = params.get(i);
            if (holder.getType() == ParameterType.IN) {
                statement.setObject(i + 1, holder.getValue());
            } else {
                int sqlType = holder.getSqlType();
                if (sqlType != 0) {
                    statement.registerOutParameter(i + 1, sqlType);
                }
            }
        }
    }

    private void returnValue2Callback(CallableStatement statement) throws Exception {
        for (int i = 0; i < params.size(); i++) {
            ParameterHolder holder = params.get(i);
            if (holder.getType() == ParameterType.OUT && holder.callback != null) {
                holder.callback.output(statement.getObject(i + 1));
            }
        }
    }

    private void registerOutputParameter(CallableStatement statement, Class clazz) throws Exception {
        Integer sqlType = typeMapping.get(clazz);
        if (sqlType != null) {
            params.add(0, new ParameterHolder(ParameterType.OUT, null, null));
            statement.registerOutParameter(1, sqlType);
            setParameters(statement);
        }
    }

    private CallableStatement createStatement(Connection connection, Class clazz) throws Exception {
        String returnValue = clazz == null ? "" : "? := ";
        CallableStatement statement = connection.prepareCall("{ call " + returnValue + sqlCode + " }");
        if (clazz == null) {
            setParameters(statement);
        } else {
            registerOutputParameter(statement, clazz);
        }

        return statement;
    }

    public <T> T execute(Class<T> clazz) throws Exception {
        Class.forName(C3DBConfig.getDriver());

        T value = null;

        Connection connection = null;
        CallableStatement statement = null;
        try {
            connection = DriverManager.getConnection(
                    C3DBConfig.getUrl(),
                    C3DBConfig.getUsername(),
                    C3DBConfig.getPassword()
            );

            statement = createStatement(connection, clazz);
            statement.execute();

            if (clazz == null) {
                returnValue2Callback(statement);
            } else {
                value = (T) statement.getObject(1);
            }
        } finally {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return value;
    }

    public void execute() throws Exception {
        execute(null);
    }

    private static class ParameterHolder {

        private final ParameterType type;
        private final Object value;
        private final OutputCallback callback;

        public ParameterHolder(ParameterType type, Object value, OutputCallback callback) {
            this.type = type;
            this.value = value;
            this.callback = callback;
        }

        public ParameterType getType() {
            return type;
        }

        public Object getValue() {
            return value;
        }

        public OutputCallback getOutputCallback() {
            return callback;
        }

        public int getSqlType() throws Exception {
            if (callback == null) {
                return 0;
            }

            Class clazz = ReflectionUtils.findMethod(
                    callback.getClass(),
                    "output"
            ).getParameterTypes()[0];

            Integer typ = typeMapping.get(clazz);
            return typ == null ? 0 : typ;
        }
    }

    private static enum ParameterType {

        IN, OUT
    }
}
