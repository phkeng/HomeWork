/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb;

import com.blogspot.na5cent.connectdb.model.Job;
import com.blogspot.na5cent.connectdb.printer.JobReflectionPrinter;
import com.blogspot.na5cent.connectdb.service.JobService;
import java.util.List;

/**
 *
 * @author anonymous
 */
public class S1MoveQueryToService {

    public static void main(String[] args) throws Exception {
        List<Job> results = JobService.findAll();
        JobReflectionPrinter.prints(results);
    }
}
