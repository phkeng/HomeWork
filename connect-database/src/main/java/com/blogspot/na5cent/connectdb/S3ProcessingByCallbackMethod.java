/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.model.Country;
import com.blogspot.na5cent.connectdb.printer.GenericReflectPrinter;
import com.blogspot.na5cent.connectdb.service.CountryService;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class S3ProcessingByCallbackMethod {

    public static void main(String[] args) throws Exception {
        System.out.println("======================== Asia ========================");
        List<Country> asia = CountryService.findInAsia();
        GenericReflectPrinter.prints(asia);
        
        System.out.println("======================= Europe =======================");
        List<Country> europe = CountryService.findInEurope();
        GenericReflectPrinter.prints(europe);
    }
}
