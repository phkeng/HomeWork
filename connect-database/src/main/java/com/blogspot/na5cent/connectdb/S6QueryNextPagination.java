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
public class S6QueryNextPagination {

    public static void main(String[] args) throws Exception {
        Pagination pagination = new Pagination(1, 5);
        Page<Department> page;
        do {
            page = DepartmentService.findAll(pagination);
            //GenericPrinter.prints(page.getContents());
            System.out.println("page = " + page.getCurrentPageNumber() + ", size = " + page.getCurrentPageSize());

            pagination = page.nextPagination();
        } while (page.hasNext());
    }
}
