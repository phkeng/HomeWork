/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.mapping;

import com.blogspot.na5cent.connectdb.annotation.Column;
import com.blogspot.na5cent.connectdb.model.Job;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class JobAnnotationMapping {

    private static String firstChar2UpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static Method getSetterMethodOfField(Job job, Field field) throws Exception {
        String setterName = "set" + firstChar2UpperCase(field.getName());
        return job.getClass().getDeclaredMethod(setterName, field.getType());
    }

    private static String getColumnName(Field field) {
        if (field.isAnnotationPresent(Column.class)) {
            return field.getAnnotation(Column.class).name();
        } else {
            return field.getName();
        }
    }

    private static Job transformResultReset(ResultSet resultSet) throws Exception {
        Job job = new Job();
        Field[] fields = job.getClass().getDeclaredFields();
        for (Field field : fields) {
            String columnName = getColumnName(field);
            Method method = getSetterMethodOfField(job, field);
            
            if (String.class.equals(field.getType())) {
                method.invoke(job, resultSet.getString(columnName));
            } else if (Integer.class.equals(field.getType())) {
                method.invoke(job, resultSet.getInt(columnName));
            } else if (Long.class.equals(field.getType())) {
                method.invoke(job, resultSet.getLong(columnName));
            } else if (Float.class.equals(field.getType())) {
                method.invoke(job, resultSet.getFloat(columnName));
            } else if (Double.class.equals(field.getType())) {
                method.invoke(job, resultSet.getDouble(columnName));
            }
        }

        return job;
    }

    public static List<Job> fromResultSet(ResultSet resultSet) throws Exception {
        List<Job> list = new LinkedList<>();
        while (resultSet.next()) {
            list.add(transformResultReset(resultSet));
        }

        return list;
    }
}
