/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author anonymous
 */
public class WebCrawler {

    private final String url;
    private final Set<String> links;
    private int dept;

    private WebCrawler(String url) {
        this.url = url;
        links = new HashSet<>();
        dept = 10;
    }

    public static WebCrawler startFromURL(String url) {
        return new WebCrawler(url);
    }

    public WebCrawler withDept(int dept) {
        this.dept = dept;
        return this;
    }

    private boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    private boolean alreadyExist(String link) {
        return links.contains(link);
    }
    
    private Set<String> readLinks(String url){
        try {
            System.out.println("crawling on ... " + url);
            return WebReader.fromURL(url).getLinks();
        } catch (IOException ex) {
            return null;
        }
    }

    private void crawling(String url, int level) {
        links.add(url);
        if (level > dept) {
            return;
        }

        Set<String> lnks = readLinks(url);
        if (isEmpty(lnks)) {
            return;
        }

        for (String lnk : lnks) {
            if (!alreadyExist(lnk)) {
                crawling(lnk, level + 1);
            }
        }
    }

    public Set<String> crawl() {
        System.out.println("start from " + url);
        System.out.println("processing...");
        crawling(url, 0);
        System.out.println("success!");
        return links;
    }
}
