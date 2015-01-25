package com.pamarin.cpe4235.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author anonymous
 */
public class WebReader {

    private final String REGEX_LINK_PATTERN = "(\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])";
    private final String PAGE_TITLE = "\\<title\\>(.*?)\\<\\/title\\>";
    private final String url;
    private String html;

    private WebReader(String url) {
        this.url = url;
    }

    public static WebReader fromURL(String url) {
        return new WebReader(url);
    }

    public WebReader reloadHtml() throws IOException {
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

            html = builder.toString();
        }

        return this;
    }

    public String getHtml() throws IOException {
        if (html == null) {
            reloadHtml();
        }

        return html;
    }

    private Set<String> findGroupMatches(String pattern) throws IOException {
        Set<String> set = new HashSet<>();
        Pattern compiled = Pattern.compile(pattern);
        Matcher matcher = compiled.matcher(getHtml());
        while (matcher.find()) {
            set.add(matcher.group(1));
        }

        return set;
    }

    public Set<String> getLinks() throws IOException {
        return findGroupMatches(REGEX_LINK_PATTERN);
    }

    public String getPageTile() throws IOException {
        Set<String> set = findGroupMatches(PAGE_TITLE);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            return iterator.next();
        }

        return null;
    }
}
