/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anonymous
 */
public class ExceptionExample {

    public static void main(String[] args) {
        try {
            throw new NullPointerException("is Null");
        } catch(Exception ex){
            ///
        }
        
        System.out.println("chapter6 Exception Handling.");

    }
}
