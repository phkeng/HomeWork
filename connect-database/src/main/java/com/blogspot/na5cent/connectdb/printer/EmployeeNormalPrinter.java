/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.printer;

import com.blogspot.na5cent.connectdb.model.Employee;
import static com.blogspot.na5cent.connectdb.util.CollectionUtils.isEmpty;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class EmployeeNormalPrinter {

    public static void print(Employee employee) throws Exception {
        if (employee == null) {
            return;
        }

        System.out.println("employeeId = " + employee.getEmployeeId());
        System.out.println("firstName = " + employee.getFirstName());
        System.out.println("lastName = " + employee.getLastName());
        System.out.println("email = " + employee.getEmail());
    }

    public static void prints(List<Employee> employees) throws Exception {
        if (isEmpty(employees)) {
            return;
        }

        for (Employee employee : employees) {
            print(employee);
            System.out.println("-------------------------------------------------");
        }
    }
}
