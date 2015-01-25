/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author anonymous
 */
public class FileReaderExample {

    public static void main(String[] args) throws IOException {
        Reader reader = null;
        try {
            reader = new FileReader("C:/temp/my-file.txt");
            int data;
            while ((data = reader.read()) != -1) {
                System.out.println("char --> " + (char) data);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
