/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author anonymous
 */
public class BufferedInputStreamExample {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            inputStream = new FileInputStream("C:/temp/my-file.txt");
            bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[1024];
            int index;
            while ((index = bufferedInputStream.read(bytes)) != -1) {
                
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
