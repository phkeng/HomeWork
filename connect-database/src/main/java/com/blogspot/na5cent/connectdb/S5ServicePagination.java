/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.model.Department;
import com.blogspot.na5cent.connectdb.printer.GenericPrinter;
import com.blogspot.na5cent.connectdb.query.Page;
import com.blogspot.na5cent.connectdb.query.Pagination;
import com.blogspot.na5cent.connectdb.service.DepartmentService;

/**
 *
 * @author anonymous
 */
public class S5ServicePagination {

    public static void main(String[] args) throws Exception {
        Page<Department> page = DepartmentService.findAll(new Pagination(2, 5));
        
        System.out.println("total = " + page.getTotalElements());
        GenericPrinter.prints(page.getContents());
    }
}
