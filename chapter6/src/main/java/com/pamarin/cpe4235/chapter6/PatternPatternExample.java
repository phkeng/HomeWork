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
public class PatternPatternExample {

    public static void main(String[] args) {

        String patternString = "sep";
        Pattern pattern = Pattern.compile(patternString);

        String pattern2 = pattern.pattern();
        System.out.println("pattern --> " + pattern2);
    }
}
