/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.util;

import com.blogspot.na5cent.connectdb.annotation.Service;

/**
 *
 * @author anonymous
 */
public class ServiceUtils {

    public static <T> T findService(String serviceName, Class<T> interfc) {
        return BeanUtils.findBean(
                interfc,
                Service.class,
                "name",
                serviceName
        );
    }

    public static <T> T findService(Class<T> clazz) {
        return findService(null, clazz);
    }
}
