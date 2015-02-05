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
public class Ex1AddTwoNumbers {

    public static void main(String[] args) throws Exception {
        Procedures.call("add_two_numbers(?, ?, ?)")
                .withParam(1)
                .withParam(2)
                .withOutput(new OutputCallback<Integer>() {

                    @Override
                    public void output(Integer value) {
                        System.out.println("value = " + value);
                    }
                })
                .execute();
    }
}
