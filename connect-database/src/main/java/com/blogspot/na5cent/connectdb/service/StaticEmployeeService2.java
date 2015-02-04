/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

import com.blogspot.na5cent.connectdb.model.EmployeeMap;
import com.blogspot.na5cent.connectdb.query.QueryUtil;
import com.blogspot.na5cent.connectdb.query.Querys;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author anonymous
 */
public class StaticEmployeeService2 {

    public static List<EmployeeMap> findEmployees() throws Exception {
        return Querys.executeReturnList(
                "SELECT * FROM Employees",
                EmployeeMap.class
        );
    }

    public static List<EmployeeMap> findProgrammers() throws Exception {
        return Querys.executeReturnList(
                "SELECT * FROM Employees WHERE JOB_ID = 'IT_PROG'",
                EmployeeMap.class
        );
    }

    public static List<EmployeeMap> findSalesManagers() throws Exception {
        Map<Integer, Object> params = new HashMap<>();
        params.put(1, "SA_MAN");
        params.put(2, 12000);

        return QueryUtil.executeReturnList(
                "SELECT * FROM Employees WHERE JOB_ID = ? AND SALARY >= ?",
                EmployeeMap.class,
                params
        );
    }
}
