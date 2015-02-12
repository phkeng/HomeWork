/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.controller.EmployeeSearchCtrl;
import com.blogspot.na5cent.connectdb.service.EmployeeSearchByDepartmentService;
import com.blogspot.na5cent.connectdb.service.EmployeeSearchService;

/**
 *
 * @author anonymous
 */
public class X3EmployeeSearchServiceAbstraction {

    public static void main(String[] args) throws Exception {
        EmployeeSearchService service = new EmployeeSearchByDepartmentService();

        EmployeeSearchCtrl controller = new EmployeeSearchCtrl(service);
        controller.setKeyword("IT");
        controller.onSearch(1);
    }
}
