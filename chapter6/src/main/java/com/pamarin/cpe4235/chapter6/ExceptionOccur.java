/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author anonymous
 */
public class ExceptionOccur {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        Reader reader = null;
        BufferedReader bfReader = null;
        try {
            inputStream = new FileInputStream("C:/temp/my-file.txt"); //2048KB
            reader = new InputStreamReader(inputStream);
            bfReader = new BufferedReader(reader);
            String data;
            while ((data = bfReader.readLine()) != null) {         
                System.out.println(data);
            }
        } finally {
            if(bfReader != null){
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
}
