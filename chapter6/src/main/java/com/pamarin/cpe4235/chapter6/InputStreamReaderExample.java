/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author anonymous
 */
public class InputStreamReaderExample {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        Reader reader = null;
        try {
            inputStream = new FileInputStream("C:/temp/my-file.txt");
            reader = new InputStreamReader(inputStream);
            int data;
            while ((data = reader.read()) != -1) {
                System.out.println("char --> " + (char) data);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
