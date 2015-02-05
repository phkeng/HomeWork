/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.model.Department;
import com.blogspot.na5cent.connectdb.printer.GenericPrinter;
import com.blogspot.na5cent.connectdb.service.DepartmentService;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class S4QueryBuilder {

    public static void main(String[] args) throws Exception {
        List<Department> departments = DepartmentService.findDepartmentsHasManagerInCitySeattle();
        GenericPrinter.prints(departments);
    }
}
