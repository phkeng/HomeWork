/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.util;

import com.blogspot.na5cent.connectdb.annotation.Service;
import com.blogspot.na5cent.connectdb.exception.UncheckedException;

/**
 *
 * @author anonymous
 */
public class ServiceUtils {

    public static <T> T findService(String serviceName, Class<T> interfc) {
        try {
            return BeanUtils.findByAnnotationPropertyName(
                    Service.class,
                    serviceName,
                    interfc
            );
        } catch (Exception ex) {
            throw new UncheckedException(ex);
        }
    }

    public static <T> T findService(Class<T> clazz) {
        return findService(null, clazz);
    }
}
