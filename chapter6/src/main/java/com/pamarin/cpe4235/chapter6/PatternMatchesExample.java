/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.util.regex.Pattern;

/**
 *
 * @author anonymous
 */
public class PatternMatchesExample {

    private static boolean hasText(String source, String check) {
        return Pattern.matches(".*" + check + ".*", source); //".*program.*"
    }

    public static void main(String[] args) {
        System.out.println(hasText("java programmer", "program"));
        System.out.println(hasText("java web developer", "program"));
        System.out.println(hasText("program to an interface not an implementation", "program"));
    }
}
