/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.model.EmployeeMap;
import com.blogspot.na5cent.connectdb.printer.GenericReflectPrinter;
import com.blogspot.na5cent.connectdb.query.Page;
import com.blogspot.na5cent.connectdb.query.Pagination;
import com.blogspot.na5cent.connectdb.service.EmployeeSearchByCountryService;
import com.blogspot.na5cent.connectdb.service.EmployeeSearchService;

/**
 *
 * @author anonymous
 */
class EmployeeSearchCtrl2 {

    private final EmployeeSearchService service;
    private String keyword;

    public EmployeeSearchCtrl2(EmployeeSearchService service) {
        this.service = service;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void onSearch(int pageNumber) throws Exception {
        Page<EmployeeMap> page = service.search(keyword, new Pagination(pageNumber, 10));
        render(page);
    }

    private void render(Page<EmployeeMap> page) throws Exception {
        System.out.println("total elements = " + page.getTotalElements());
        System.out.println("total pages = " + page.getTotalPages());
        System.out.println("page size = " + page.getPageRequestSize());
        System.out.println("");

        System.out.println("page = " + page.getCurrentPageNumber() + ", size = " + page.getCurrentPageSize());
        GenericReflectPrinter.prints(page.getContents());
    }
}

public class X3EmployeeSearchServiceCtrl {

    public static void main(String[] args) throws Exception {
        EmployeeSearchService service = new EmployeeSearchByCountryService();

        EmployeeSearchCtrl2 controller = new EmployeeSearchCtrl2(service);
        controller.setKeyword("America");
        controller.onSearch(1);
    }
}
