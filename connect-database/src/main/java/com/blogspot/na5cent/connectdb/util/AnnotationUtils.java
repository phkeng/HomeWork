/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.util;

import java.lang.annotation.Annotation;

/**
 *
 * @author anonymous
 */
public class AnnotationUtils {

    public static String readProperty(Annotation annotation, String property) {
        return RegExUtils.findInPattern(
                annotation.toString(),
                "\\(" + property + "\\=(.*?)\\)"
        );
    }
}
