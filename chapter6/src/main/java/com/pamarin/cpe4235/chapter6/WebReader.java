/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author anonymous
 */
public class WebReader {

    private String url;

    public WebReader(String url) {
        this.url = url;
    }

    public String getHtml() throws IOException {
        InputStream inputStream = null;
        Reader reader = null;
        BufferedReader bff = null;
        StringBuilder builder = new StringBuilder();

        try {
            URL urlObject = new URL(url);
            inputStream = urlObject.openStream();
            reader = new InputStreamReader(inputStream);
            bff = new BufferedReader(reader);
            String data;
            while ((data = bff.readLine()) != null) {
                builder.append(data);
            }
        } finally {
            if (bff != null) {
                bff.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }

        return builder.toString();
    }

    public Set<String> getLinks() throws IOException {
        Set<String> set = new HashSet<>();
        String pattern = "href=\"(.*?)\"";
        Pattern compiled = Pattern.compile(pattern);
        String html = getHtml();
        Matcher matcher = compiled.matcher(html);
        while (matcher.find()) {
            set.add(matcher.group(1));
        }

        return set;
    }
}
