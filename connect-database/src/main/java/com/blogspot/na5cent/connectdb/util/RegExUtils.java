/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author anonymous
 */
public class RegExUtils {

    public static int countPatternFromKeyword(String patternString, String keyword) {
        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(keyword);
        int counter = 0;
        while (matcher.find()) {
            counter = counter + 1;
        }

        return counter;
    }

    public static String findOneInPattern(String keyword, String patternString) {
        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(keyword);
        while (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }
}
