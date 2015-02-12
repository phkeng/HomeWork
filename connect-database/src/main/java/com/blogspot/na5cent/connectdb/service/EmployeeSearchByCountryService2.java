/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.service;

import com.blogspot.na5cent.connectdb.exception.SQLUncheckedException;
import com.blogspot.na5cent.connectdb.util.IOUtils;
import java.io.IOException;

/**
 *
 * @author anonymous
 */
public class EmployeeSearchByCountryService2 extends AbstractEmployeeSearchService {

    @Override
    protected String getSQLCode() {
        try {
            return IOUtils.toString(
                    getClass().getResourceAsStream("/db/sql/searchByCountry.sql")
            );
        } catch (IOException ex) {
            throw new SQLUncheckedException("can't read sql file.");
        }
    }

}
