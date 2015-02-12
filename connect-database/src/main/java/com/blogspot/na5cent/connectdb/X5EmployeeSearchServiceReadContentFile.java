/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.controller.EmployeeSearchCtrl;
import com.blogspot.na5cent.connectdb.service.EmployeeSearchByCountryService2;
import com.blogspot.na5cent.connectdb.service.EmployeeSearchService;

/**
 *
 * @author anonymous
 */
public class X5EmployeeSearchServiceReadContentFile {

    public static void main(String[] args) throws Exception {
        EmployeeSearchService service = new EmployeeSearchByCountryService2();

        EmployeeSearchCtrl controller = new EmployeeSearchCtrl(service);
        controller.setKeyword("Canada");
        controller.onSearch(1);
    }
}
