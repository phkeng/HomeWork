/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 *
 * @author anonymous
 */
public class FileExample {

    public static void main(String[] args) throws IOException {
        Reader reader = null;
        try {
            File file = new File("C:/temp/my-file.txt");
            reader = new FileReader(file);
            System.out.println((char)reader.read());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
