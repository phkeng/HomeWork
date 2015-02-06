/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.plsql;

import com.blogspot.na5cent.connectdb.query.Procedures;

/**
 *
 * @author anonymous
 */
public class Ex2FunctionAddTwoNumbers {

    public static void main(String[] args) throws Exception {
        Integer value = Procedures.call("multiply_two_numbers(?, ?)")
                .withParam(5)
                .withParam(2)
                .execute(Integer.class);

        System.out.println("value = " + value);

    }
}
