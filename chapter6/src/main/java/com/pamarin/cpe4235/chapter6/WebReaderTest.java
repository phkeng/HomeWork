/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.IOException;
import java.util.Set;

/**
 *
 * @author anonymous
 */
public class WebReaderTest {

    public static void main(String[] args) throws IOException {
        WebReader reader = WebReader.fromURL("https://google.com");
        Set<String> links = reader.getLinks();
        for (String link : links) {
            System.out.println("link = " + link);
        }
    }
}
