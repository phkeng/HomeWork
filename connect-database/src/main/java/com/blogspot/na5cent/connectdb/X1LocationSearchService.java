/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.model.Location;
import com.blogspot.na5cent.connectdb.printer.GenericReflectPrinter;
import com.blogspot.na5cent.connectdb.query.Page;
import com.blogspot.na5cent.connectdb.query.Pagination;
import com.blogspot.na5cent.connectdb.service.LocationSearchService;

/**
 *
 * @author anonymous
 */
public class X1LocationSearchService {
    
    public static void main(String[] args) throws Exception {
        Page<Location> location = LocationSearchService.searchByStateProvince("tex", new Pagination(1, 10));
        GenericReflectPrinter.prints(location.getContents());
    }
}
