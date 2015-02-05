/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

/**
 *
 * @author anonymous
 */
public class C2DBConfig {

    private static final String driver = "oracle.jdbc.OracleDriver";
    private static final String url = "jdbc:oracle:thin:@localhost:1521:cpe4235";
    private static final String username = "HR";
    private static final String password = "HR";

    public static String getDriver() {
        return driver;
    }

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
