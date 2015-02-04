/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.mapping;

import com.blogspot.na5cent.connectdb.annotation.Column;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class GenericAnnotationMapping {

    private static String firstChar2UpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static Method getSetterMethodOfField(Object object, Field field) throws Exception {
        String setterName = "set" + firstChar2UpperCase(field.getName());
        return object.getClass().getDeclaredMethod(setterName, field.getType());
    }

    private static String getColumnName(Field field) {
        if (field.isAnnotationPresent(Column.class)) {
            return field.getAnnotation(Column.class).name();
        } else {
            return field.getName();
        }
    }

    private static <T> T getValue(ResultSet resultSet, String columnName, Class<T> clazz) throws SQLException {
        if (String.class.equals(clazz)) {
            return (T) resultSet.getString(columnName);
        } else if (Integer.class.equals(clazz)) {
            return (T) Integer.valueOf(resultSet.getInt(columnName));
        } else if (Long.class.equals(clazz)) {
            return (T) Long.valueOf(resultSet.getLong(columnName));
        } else if (Float.class.equals(clazz)) {
            return (T) Float.valueOf(resultSet.getFloat(columnName));
        } else if (Double.class.equals(clazz)) {
            return (T) Double.valueOf(resultSet.getDouble(columnName));
        }

        return null;
    }

    private static <T> T transformResultReset(ResultSet resultSet, Class<T> clazz) throws Exception {
        T object = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String columnName = getColumnName(field);
            Method method = getSetterMethodOfField(object, field);
            method.invoke(object, getValue(resultSet, columnName, field.getType()));
        }

        return object;
    }

    public static <T> List<T> fromResultSet(ResultSet resultSet, Class<T> clazz) throws Exception {
        List<T> list = new LinkedList<>();
        while (resultSet.next()) {
            list.add(transformResultReset(resultSet, clazz));
        }

        return list;
    }
}
