/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.connectdb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author anonymous
 */
public class IOUtils {

    public static String toString(InputStream inputStream) throws IOException {
        StringBuilder builder = new StringBuilder();

        Reader reader = null;
        BufferedReader bff = null;
        try {
            reader = new InputStreamReader(inputStream);
            bff = new BufferedReader(reader);
            String line;
            while ((line = bff.readLine()) != null) {
                builder.append(line).append(" ");
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
}
