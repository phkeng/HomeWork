/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.util;

import com.blogspot.na5cent.connectdb.exception.UncheckedException;
import static com.blogspot.na5cent.connectdb.util.CollectionUtils.isEmpty;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class BeanUtils {

    private static void makeUndefiendException(String value, Class bean) throws ClassNotFoundException {
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

    public static <T> T findBean(Class<T> bean, Class annotation, String property, String value) {
        try {
            // 1. read all classes which match Annotation 
            List<Class> classes = ClassUtils.findClassesOfAnnotation(annotation);

            if (isEmpty(classes)) {
                makeUndefiendException(value, bean);
            }

            // 2. filter classes by Annotation property and Value
            classes = value == null
                    ? classes
                    : ClassUtils.filterClassesByAnnotationProperty(
                            classes,
                            annotation,
                            property,
                            value
                    );

            if (isEmpty(classes)) {
                makeUndefiendException(value, bean);
            }

            if (classes.size() > 1) {
                makeFoundMoreThanOneException(value, bean);
            }

            // 3. check Inheritance or Implementation
            Class foundClass = classes.get(0);
            if (!bean.isAssignableFrom(foundClass)) {
                makeUndefiendException(value, bean);
            }

            return (T) foundClass.newInstance();
        } catch (Exception ex) {
            throw new UncheckedException(ex);
        }
    }
}
