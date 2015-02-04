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
public class DBConfig {

    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:cpe4235";
    private static final String USERNAME = "HR";
    private static final String PASSWORD = "HR";
    
    public static String getDriver(){
        return DRIVER;
    }

    public static String getUrl() {
        return URL;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
