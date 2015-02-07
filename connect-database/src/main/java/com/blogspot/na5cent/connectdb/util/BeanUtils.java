/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.util;

import java.util.List;

/**
 *
 * @author anonymous
 */
public class BeanUtils {

    private static void makeUndefineException(String value, Class bean) throws ClassNotFoundException {
        throw new ClassNotFoundException(
                "Undefine " + (bean.isInterface() ? "implementation" : "sub class") + " " + message(value)
                + "of " + (bean.isInterface() ? "interface" : "class") + " \"" + bean.getName() + "\""
        );
    }

    private static void makeFoundMoreThanOneException(String value, Class bean) {
        throw new IllegalArgumentException(
                "Defined " + (bean.isInterface() ? "implementation" : "sub class") + " " + message(value)
                + "of " + (bean.isInterface() ? "interface" : "class") + " \""
                + bean.getName() + "\" more than one"
        );
    }

    private static String message(String propValue) {
        return propValue == null
                ? ""
                : "\"" + propValue + "\" ";
    }

    public static <T> T findByAnnotationProperty(Class annotation, String property, String value, Class<T> bean) throws Exception {
        List<Class> classes = null;
        try {
            classes = ClassUtils.findClassesOfAnnotationProperty(annotation, property, value);
            if (classes.size() > 1) {
                makeFoundMoreThanOneException(value, bean);
            }

            Class foundClass = classes.get(0);
            if (!bean.isAssignableFrom(foundClass)) {
                throw new ClassNotFoundException();
            }

            return (T) foundClass.newInstance();
        } catch (ClassNotFoundException ex) {
            makeUndefineException(value, bean);
        }

        return null;
    }
}
