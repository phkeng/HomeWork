/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.htmlcssjs.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.servlet.jsp.JspWriter;

/**
 *
 * @author anonymous
 */
public class JspUtils {

    private static String escape(String str) {
        return str.replace("<", "&lt;").replace(">", "&gt;");
    }

    public static void readContent(InputStream inputStream, JspWriter writer) throws IOException {
        fromInputStream2JspWriter(inputStream, writer, new String[]{"\n"});
    }

    public static void fromInputStream2JspWriter(InputStream inputStream, JspWriter writer, String... newLine) throws IOException {
        Reader reader = null;
        BufferedReader bff = null;
        try {
            reader = new InputStreamReader(inputStream);
            bff = new BufferedReader(reader);
            String line;
            while ((line = bff.readLine()) != null) {
                writer.println(escape(line));
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
    }
}
