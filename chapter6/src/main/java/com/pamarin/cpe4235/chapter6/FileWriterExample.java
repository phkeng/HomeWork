/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author anonymous
 */
public class FileWriterExample {

    public static void main(String[] args) throws IOException {
        Writer writer = null;
        try {
            writer = new FileWriter("C:/temp/my-file.txt");
            writer.append('4');
            writer.append('2');
            writer.append('3');
            writer.append('5');
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
