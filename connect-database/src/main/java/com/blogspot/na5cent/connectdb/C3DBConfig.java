/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.util.PropertiesUtils;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anonymous
 */
public class C3DBConfig {

    private static final Logger LOG = Logger.getLogger(C3DBConfig.class.getName());

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            reloadConfig();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

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

    public static void reloadConfig() throws IOException {
        Properties prop = PropertiesUtils.load("/db/conf.properties");
        driver = prop.getProperty("connection.driver");
        url = prop.getProperty("connection.url");
        username = prop.getProperty("connection.username");
        password = prop.getProperty("connection.password");
        
        LOG.log(Level.INFO, "driver = {0}", driver);
        LOG.log(Level.INFO, "url = {0}", url);
        LOG.log(Level.INFO, "username = {0}", username);
        LOG.log(Level.INFO, "password = {0}", password);
    }
}
