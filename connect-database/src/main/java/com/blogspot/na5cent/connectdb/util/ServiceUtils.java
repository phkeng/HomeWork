/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.util;

import com.blogspot.na5cent.connectdb.annotation.Service;
import com.blogspot.na5cent.connectdb.service.EmployeeSearchService;
import static com.blogspot.na5cent.connectdb.util.CollectionUtils.isEmpty;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class ServiceUtils {

    private static void makeUndefiendException(String serviceName, Class serviceInterface) throws ClassNotFoundException {
        throw new ClassNotFoundException(
                "Undefine service " + message(serviceName)
                + "of interface \"" + serviceInterface.getName() + "\""
        );
    }

    private static String message(String serviceName) {
        return serviceName == null
                ? ""
                : "\"" + serviceName + "\" ";
    }

    private static List<Class> filterByName(String serviceName, List<Class> serviceClasses) throws Exception {
        return serviceName == null
                ? serviceClasses
                : ClassUtils.filterClassesByAnnotationProperty(
                        serviceClasses,
                        Service.class,
                        "name",
                        serviceName
                );
    }

    public static <T> T findService(String serviceName, Class<T> serviceInterface) throws Exception {
        // 1. read classes by Service annotation 
        List<Class> classes = ClassUtils.findClassesOfAnnoation(Service.class);

        if (isEmpty(classes)) {
            makeUndefiendException(serviceName, serviceInterface);
        }

        // 2. filter classes by Service annotation name()
        classes = filterByName(serviceName, classes);
        if (isEmpty(classes)) {
            makeUndefiendException(serviceName, serviceInterface);
        }

        if (classes.size() > 1) {
            throw new IllegalArgumentException(
                    "Defined service " + message(serviceName) + "of interface \""
                    + serviceInterface.getName() + "\" more than one"
            );
        }

        // 3. check Implementation
        Class serviceImplementation = classes.get(0);
        if (!serviceInterface.isAssignableFrom(serviceImplementation)) {
            makeUndefiendException(serviceName, serviceInterface);
        }

        return (T) serviceImplementation.newInstance();
    }

    public static <T> T findService(Class<T> clazz) throws Exception {
        return findService(null, clazz);
    }

    public static void main(String[] args) throws Exception {
        EmployeeSearchService service = findService(EmployeeSearchService.class);
        System.out.println("service = " + service.getClass().getName());
    }
}
