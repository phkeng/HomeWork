/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.plsql;

import com.blogspot.na5cent.connectdb.query.ProcedureBuilder;

/**
 *
 * @author anonymous
 */
public class Ex1AddTwoNumber {

    public static void main(String[] args) throws Exception {
        ProcedureBuilder.fromProcedure("add_two_number(?, ?, ?)")
                .addParam(1)
                .addParam(2)
                .registerOutput(new ProcedureBuilder.Callback<Integer>() {

                    @Override
                    public void result(Integer value) {
                        System.out.println("value = " + value);
                    }
                })
                .execute();
    }
}
