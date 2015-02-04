/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.printer;

import static com.blogspot.na5cent.connectdb.util.CollectionUtils.isEmpty;
import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class GenericPrinter {

    private static String getFieldName(Method method) {
        String name = method.getName().replace("get", "");
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

    public static <T> void print(T object) throws Exception {
        if (object == null) {
            return;
        }

        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                System.out.println(getFieldName(method) + " = " + method.invoke(object));
            }
        }
    }

    public static <T> void prints(List<T> objects) throws Exception {
        if (isEmpty(objects)) {
            return;
        }

        for (T object : objects) {
            print(object);
            System.out.println("-------------------------------------------------");
        }
    }
}
