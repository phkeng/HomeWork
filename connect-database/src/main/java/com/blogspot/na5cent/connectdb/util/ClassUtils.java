/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.util;

import static com.blogspot.na5cent.connectdb.util.CollectionUtils.isEmpty;
import java.io.File;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class ClassUtils {

    public static List<Class> filterClassesByAnnotationProperty(
            List<Class> classes,
            Class annotation,
            String property,
            String value
    ) throws Exception {

        List<Class> results = new LinkedList<>();
        for (Class clazz : classes) {
            String propValue = AnnotationUtils.readProperty(
                    clazz.getAnnotation(annotation),
                    property
            );

            if (value.equals(propValue)) {
                results.add(clazz);
            }
        }

        return results;
    }

    public static Method findMethod(Class clazz, String methodName) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }

        return null;
    }

    private static List<String> readAllFullClassName() {
        List<String> repo = new LinkedList<>();
        File root = new File(ServiceUtils.class.getResource("/").getPath());
        walking(
                root,
                "",
                repo
        );

        return repo;
    }

    private static boolean isClassFile(File file) {
        return file.getName().endsWith(".class");
    }

    private static void walking(File parent, String parentName, List<String> repo) {
        File[] fiels = parent.listFiles();
        if (isEmpty(fiels)) {
            return;
        }

        for (File file : fiels) {
            String prefix = StringUtils.isEmpty(parentName) ? "" : (parentName + ".");
            String fileFullName = prefix + file.getName();
            if (file.isDirectory()) {
                walking(file, fileFullName, repo);
            } else {
                if (isClassFile(file)) {
                    repo.add(fileFullName.replace(".class", ""));
                }
            }
        }
    }

    public static List<Class> findClassesOfAnnoation(Class annotationClasss) throws ClassNotFoundException {
        List<Class> results = new LinkedList<>();
        List<String> classess = readAllFullClassName();
        for (String fullName : classess) {
            Class clazz = Class.forName(fullName);
            if (clazz.isAnnotationPresent(annotationClasss)) {
                results.add(clazz);
            }
        }

        return results;
    }
}
