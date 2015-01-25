/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.File;

/**
 *
 * @author anonymous
 */
public class FileWalkerExample {

    public static void walking(File folder) {
        System.out.println("name -> " + folder.getName());
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                walking(file);
            }
        }
    }

    public static void main(String[] args) {
        walking(new File("c://temp"));

    }
}
