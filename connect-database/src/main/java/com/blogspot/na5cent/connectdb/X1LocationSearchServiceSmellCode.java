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
public class X1LocationSearchServiceSmellCode {

    public static void main(String[] args) throws Exception {
        String keyword = "tex";
        String searchBy = "province";
        
        Pagination pagination = new Pagination(1, 10);
        Page<Location> location = null;
        
        switch (searchBy) {
            case "address":
                location = LocationSearchService.searchByStreetAddress(keyword, pagination);
                break;
            case "city":
                location = LocationSearchService.searchByCity(keyword, pagination);
                break;
            case "province":
                location = LocationSearchService.searchByStateProvince(keyword, pagination);
                break;
        }

        if (location != null) {
            GenericReflectPrinter.prints(location.getContents());
        }
    }
}
