/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.plsql;

import com.blogspot.na5cent.connectdb.query.OutputCallback;
import com.blogspot.na5cent.connectdb.query.Procedures;

/**
 *
 * @author anonymous
 */
public class Ex3ProcedureAddTwoNumbers {

    public static void main(String[] args) throws Exception {
        Procedures.call("add_two_numbers(?, ?, ?)")
                .withParam(10)
                .withParam(20)
                .withOutput(new OutputCallback<Integer>() {

                    @Override
                    public void output(Integer value) {
                        System.out.println("output value -> " + value);
                    }
                })
                .execute();
    }
}
