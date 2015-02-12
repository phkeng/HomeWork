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

/**
 *
 * @author anonymous
 */
public class WebReader2 {

    private String url;
    private String html;

    public WebReader2(String url) {
        this.url = url;
    }

    public void reloadHtml() throws IOException {
        InputStream inputStream = null;
        Reader reader = null;
        BufferedReader bfReader = null;
        try {
            URL urlObj = new URL(url);
            inputStream = urlObj.openStream();
            reader = new InputStreamReader(inputStream);
            bfReader = new BufferedReader(reader);
            String data;
            StringBuilder builder = new StringBuilder();
            while ((data = bfReader.readLine()) != null) {
                builder.append(data);
            }

            html = builder.toString();
        } finally {
            if (bfReader != null) {
                bfReader.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public String getHtml() throws IOException {
        if (html == null) {
            reloadHtml();
        }

        return html;
    }
    
    
    public static void main(String[] args) throws IOException {
        WebReader2 reader = new WebReader2("https://google.com");
        System.out.println("html -> " + reader.getHtml());
    }
}
