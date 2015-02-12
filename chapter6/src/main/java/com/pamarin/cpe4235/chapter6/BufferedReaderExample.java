/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author redcrow
 */
public class BufferedReaderExample {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;
        Reader reader = null;
        try {
            reader = new FileReader("C:/temp/my-file.txt");
            bufferedReader = new BufferedReader(reader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                System.out.println("char --> " + data);
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (reader != null) {
                reader.close();
            }
        }
    }
}
