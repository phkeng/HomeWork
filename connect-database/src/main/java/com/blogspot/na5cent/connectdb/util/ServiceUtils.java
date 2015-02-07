/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.util;

import com.blogspot.na5cent.connectdb.annotation.Service;
import com.blogspot.na5cent.connectdb.service.EmployeeSearchService;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class ServiceUtils {

    private static List<String> fullClassNames;

    public static List<String> getFullClassNames() {
        if (fullClassNames == null) {
            fullClassNames = new LinkedList<>();
        }

        return fullClassNames;
    }

    private static List<Class> findServiceByName(String serviceName, List<Class> classes) throws Exception {
        List<Class> clazzez = new LinkedList<>();
        for (Class clazz : classes) {
            String str = clazz.getAnnotation(Service.class).toString();
            String name = RegExUtils.findInPattern(str, "\\(name\\=(.*?)\\)");
            if (serviceName.equals(name)) {
                clazzez.add(clazz);
            }
        }

        return clazzez;
    }

    private static void readClasses() {
        File root = new File(ServiceUtils.class.getResource("/").getPath());
        walking(root, "");
    }

    private static String message(String serviceName) {
        return serviceName == null
                ? ""
                : "\"" + serviceName + "\" ";
    }

    private static List<Class> findService(String serviceName, List<Class> serviceClasses) throws Exception {
        return serviceName == null
                ? serviceClasses
                : findServiceByName(serviceName, serviceClasses);
    }

    public static <T> T findService(String serviceName, Class<T> clazz) throws Exception {
        if (getFullClassNames().isEmpty()) {
            readClasses();
        }

        List<Class> serviceClasses = findClassesAnnoationPresent(Service.class);
        if (CollectionUtils.isEmpty(serviceClasses)) {
            throw new ClassNotFoundException(
                    "Undefine service " + message(serviceName) + "of interface \"" + clazz.getName() + "\""
            );
        }

        if (serviceName == null) {
            if (serviceClasses.size() > 1) {
                throw new IllegalArgumentException(
                        "Defined service of interface \"" + clazz.getName() + "\" more than one, "
                        + "please use method " + RegExUtils.class.getSimpleName() + ".findService(String serviceName, Class<T> clazz)"
                );
            }
        }

        serviceClasses = findService(serviceName, serviceClasses);
        if (CollectionUtils.isEmpty(serviceClasses)) {
            throw new ClassNotFoundException(
                    "Undefine service " + message(serviceName) + "of interface \"" + clazz.getName() + "\""
            );
        }

        if (serviceClasses.size() > 1) {
            throw new IllegalArgumentException(
                    "Defined service " + message(serviceName) + "of interface \"" + clazz.getName() + "\" more than one"
            );
        }

        Class serviceClass = serviceClasses.get(0);
        if (!clazz.isAssignableFrom(serviceClass)) {
            throw new ClassNotFoundException(
                    "Undefine service " + message(serviceName) + "of interface \"" + clazz.getName() + "\""
            );
        }

        return (T) serviceClass.newInstance();
    }

    public static <T> T findService(Class<T> clazz) throws Exception {
        return findService(null, clazz);
    }

    private static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    private static boolean isClassFile(File file) {
        return file.getName().endsWith(".class");
    }

    private static void walking(File parent, String parentName) {
        File[] fiels = parent.listFiles();
        if (isEmpty(fiels)) {
            return;
        }

        for (File file : fiels) {
            String prefix = StringUtils.isEmpty(parentName) ? "" : (parentName + ".");
            String fileFullName = prefix + file.getName();
            if (file.isDirectory()) {
                walking(file, fileFullName);
            } else {
                if (isClassFile(file)) {
                    getFullClassNames().add(fileFullName.replace(".class", ""));
                }
            }
        }
    }

    private static List<Class> findClassesAnnoationPresent(Class annotationClasss) throws ClassNotFoundException {
        List<Class> clazzez = new LinkedList<>();
        for (String fullName : getFullClassNames()) {
            Class clazz = Class.forName(fullName);
            if (clazz.isAnnotationPresent(annotationClasss)) {
                clazzez.add(clazz);
            }
        }

        return clazzez;
    }

    public static void main(String[] args) throws Exception {
        EmployeeSearchService service = findService("searchByCountry", EmployeeSearchService.class);
        System.out.println("service = " + service.getClass().getName());
    }
}
