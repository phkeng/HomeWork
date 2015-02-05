/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.mapping;

import com.blogspot.na5cent.connectdb.annotation.Column;
import com.blogspot.na5cent.connectdb.model.EmployeeMap;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class EmployeeAnnotationMapping {

    private static String firstChar2UpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static Method getSetterMethodOfField(EmployeeMap employee, Field field) throws Exception {
        String setterName = "set" + firstChar2UpperCase(field.getName());
        return employee.getClass().getDeclaredMethod(setterName, field.getType());
    }

    private static String getColumnName(Field field) {
        if (field.isAnnotationPresent(Column.class)) {
            return field.getAnnotation(Column.class).name();
        } else {
            return field.getName();
        }
    }

    private static EmployeeMap transformResultReset(ResultSet resultSet) throws Exception {
        EmployeeMap employee = new EmployeeMap();
        Field[] fields = employee.getClass().getDeclaredFields();
        for (Field field : fields) {
            String columnName = getColumnName(field);
            Method method = getSetterMethodOfField(employee, field);
            
            if (String.class.equals(field.getType())) {
                method.invoke(employee, resultSet.getString(columnName));
            } else if (Integer.class.equals(field.getType())) {
                method.invoke(employee, resultSet.getInt(columnName));
            } else if (Long.class.equals(field.getType())) {
                method.invoke(employee, resultSet.getLong(columnName));
            } else if (Float.class.equals(field.getType())) {
                method.invoke(employee, resultSet.getFloat(columnName));
            } else if (Double.class.equals(field.getType())) {
                method.invoke(employee, resultSet.getDouble(columnName));
            }
        }

        return employee;
    }

    public static List<EmployeeMap> fromResultSet(ResultSet resultSet) throws Exception {
        List<EmployeeMap> list = new LinkedList<>();
        while (resultSet.next()) {
            list.add(transformResultReset(resultSet));
        }

        return list;
    }
}
