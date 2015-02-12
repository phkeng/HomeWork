/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.printer;

import com.blogspot.na5cent.connectdb.annotation.Column;
import static com.blogspot.na5cent.connectdb.util.CollectionUtils.isEmpty;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class GenericReflectPrinter {

    private static String getFieldName(Method method) {
        String name = method.getName().replace("get", "");
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

    public static <T> void print(T object) throws Exception {
        if (object == null) {
            return;
        }

        Class<T> clazz = (Class<T>) object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                String fieldName = getFieldName(method);
                Field field = clazz.getDeclaredField(fieldName);
                if (field.isAnnotationPresent(Column.class)) {
                    fieldName = field.getAnnotation(Column.class).name();
                }

                System.out.println(fieldName + " = " + method.invoke(object));
            }
        }
    }

    public static <T> void prints(List<T> objects) throws Exception {
        if (isEmpty(objects)) {
            return;
        }

        for (int i = 0; i < objects.size(); i++) {
            System.out.println("");
            System.out.println((i + 1) + ") --------------------------");
            print(objects.get(i));
        }
    }
}
