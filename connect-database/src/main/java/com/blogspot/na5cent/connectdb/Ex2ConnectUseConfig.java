/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anonymous
 */
public class Ex2ConnectUseConfig {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName(C1DBConfig.DRIVER);

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    C1DBConfig.URL,
                    C1DBConfig.USERNAME,
                    C1DBConfig.PASSWORD
            );

            //do something...
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
