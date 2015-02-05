/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

import com.blogspot.na5cent.connectdb.model.Department;
import com.blogspot.na5cent.connectdb.query.Page;
import com.blogspot.na5cent.connectdb.query.Pagination;
import com.blogspot.na5cent.connectdb.query.Query4;
import com.blogspot.na5cent.connectdb.query.Query5;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class DepartmentService {

    public static List<Department> findDepartmentsHasManagerInCitySeattle() throws Exception {
        return Query4.fromSQL("SELECT * FROM Departments WHERE (manager_id IS NOT NULL) AND location_id = ?")
                .addParam(1700)
                .executeforList(Department.class);
    }
    
    public static Page<Department> findDepartmentsHasManagerInCitySeattle(Pagination pagination) throws Exception {
        return Query5.fromSQL("SELECT * FROM Departments ORDER BY department_id")
                .withPagination(pagination)
                .executeforPage(Department.class);
    }
}
