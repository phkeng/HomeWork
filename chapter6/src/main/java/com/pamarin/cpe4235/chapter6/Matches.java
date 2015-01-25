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
public class Matches {

    public static void main(String[] args) {
        String text = "089-124-5225";
        String pattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
        System.out.println(text.matches(pattern));

    }
}
