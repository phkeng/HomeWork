/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.util.Set;

/**
 *
 * @author anonymous
 */
public class WebCrawlerTest {

    public static void main(String[] args) {
        Set<String> links = WebCrawler.startFromURL("http://na5cent.blogspot.com")
                .withDept(5)
                .crawl();

        System.out.println("size --> " + links.size());
        for (String link : links) {
            System.out.println("link = " + link);
        }
    }
}
