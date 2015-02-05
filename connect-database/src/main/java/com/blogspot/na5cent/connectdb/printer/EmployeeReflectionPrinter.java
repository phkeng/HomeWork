/*
 * Employee2o change this license header, choose License Headers in Project Properties.
 * Employee2o change this template file, choose Employee2ools | Employee2emplates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.printer;

import com.blogspot.na5cent.connectdb.model.EmployeeMap;
import static com.blogspot.na5cent.connectdb.util.CollectionUtils.isEmpty;
import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class EmployeeReflectionPrinter {

    private static String getFieldName(Method method) {
        String name = method.getName().replace("get", "");
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

    public static void print(EmployeeMap object) throws Exception {
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

    public static void prints(List<EmployeeMap> objects) throws Exception {
        if (isEmpty(objects)) {
            return;
        }

        for (int i = 0; i < objects.size(); i++) {
            System.out.println((i + 1) + ") --------------------------");
            print(objects.get(i));
        }
    }
}
