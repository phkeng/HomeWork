/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pamarin.cpe4235.chapter6;

/**
 *
 * @author anonymous
 */
public class LinkTest {
    
    public static void main(String[] args) {
        System.out.println("http://facebook.com".matches("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"));
    }
}
