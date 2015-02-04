/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.model.EmployeeMap;
import com.blogspot.na5cent.connectdb.printer.EmployeeReflectionPrinter;
import com.blogspot.na5cent.connectdb.service.StaticEmployeeService2;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class T5SelectFromService2 {

    public static void main(String[] args) throws Exception {
        //List<EmployeeMap> employees = StaticEmployeeService2.findEmployees();
        //EmployeeReflectionPrinter.prints(employees);
        //
        //List<EmployeeMap> programmers = StaticEmployeeService2.findProgrammers();
        //EmployeeReflectionPrinter.prints(programmers);
        //
        List<EmployeeMap> salesManagers = StaticEmployeeService2.findSalesManagers();
        EmployeeReflectionPrinter.prints(salesManagers);
        //
    }
}
