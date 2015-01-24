/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author anonymous
 */
public class ExceptionExample {

    public static void main(String[] args) throws IOException {
        throw new IOException("has IOException");
    }
}
