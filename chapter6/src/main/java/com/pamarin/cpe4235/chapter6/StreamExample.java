/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author redcrow
 */
public class StreamExample {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("C:/temp/my-file.txt");
            outputStream = new FileOutputStream("C:/temp/my-file-copy.txt");
            byte[] bytes = new byte[1024];
            int index;
            while ((index = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, index);
            }

        } finally {
            if(outputStream != null){
                outputStream.close();
            }
            
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
