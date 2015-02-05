/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.model.EmployeeMap;
import com.blogspot.na5cent.connectdb.printer.EmployeeReflectionPrinter;
import com.blogspot.na5cent.connectdb.service.StaticEmployeeService;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class S1FindFromService {

    public static void main(String[] args) throws Exception {
        List<EmployeeMap> results = StaticEmployeeService.findEmployees();
        EmployeeReflectionPrinter.prints(results);
    }
}
