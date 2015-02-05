/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.model.Location;
import com.blogspot.na5cent.connectdb.printer.GenericReflectPrinter;
import com.blogspot.na5cent.connectdb.service.LocationService;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class S2MoveQueryToQueryUtils {

    public static void main(String[] args) throws Exception {
//        List<Location> locations = LocationService.findAll();
//        GenericReflectPrinter.prints(locations);
//        
//        List<Location> locationInAmerica = LocationService.findInAmerica();
//        GenericReflectPrinter.prints(locationInAmerica);
//        
        List<Location> searchResults = LocationService.searchByStreetAddress("In");
        GenericReflectPrinter.prints(searchResults);
    }
}
