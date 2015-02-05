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
                statement.registerOutParameter(i + 1, holder.getSqlType());
            }
        }
    }

    private void returnValue(CallableStatement statement) throws Exception {
        for (int i = 0; i < params.size(); i++) {
            ParameterHolder holder = params.get(i);
            if (holder.getType() == ParameterType.OUT) {
                holder.callback.output(statement.getObject(i + 1));
            }
        }
    }

    public void execute() throws Exception {
        Class.forName(C3DBConfig.getDriver());

        Connection connection = null;
        CallableStatement statement = null;
        try {
            connection = DriverManager.getConnection(
                    C3DBConfig.getUrl(),
                    C3DBConfig.getUsername(),
                    C3DBConfig.getPassword()
            );

            statement = connection.prepareCall("{ call " + sqlCode + " }");
            setParameters(statement);
            statement.execute();
            returnValue(statement);
        } finally {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
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
            Class clazz = ReflectionUtils.findMethod(
                    callback.getClass(),
                    "output"
            ).getParameterTypes()[0];

            Integer typ = typeMapping.get(clazz);
            return typ == null ? -1 : typ;
        }
    }

    private static enum ParameterType {

        IN, OUT
    }
}
