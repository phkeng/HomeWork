/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author anonymous
 */
public class OutputStreamWriterExample {

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = null;
        Writer writer = null;
        try {
            outputStream = new FileOutputStream("C:/temp/my-file.txt");
            writer = new OutputStreamWriter(outputStream);
            writer.append('C');
            writer.append('P');
            writer.append('E');
        } finally {
            if (writer != null) {
                writer.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
