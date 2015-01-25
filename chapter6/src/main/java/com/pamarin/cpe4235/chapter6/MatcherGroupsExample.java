/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author anonymous
 */
public class MatcherGroupsExample {

    public static void main(String[] args) {
String text = "John writes about this, and John Doe writes about that,"
        + " and John Wayne writes about everything.";
String patternString1 = "(John) (.+?) ";

Pattern pattern = Pattern.compile(patternString1);
Matcher matcher = pattern.matcher(text);

while (matcher.find()) {
    System.out.println("found: " + matcher.group(1)
            + " " + matcher.group(2));
}
    }
}
