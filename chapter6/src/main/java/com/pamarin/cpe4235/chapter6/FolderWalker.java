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
public class FolderWalker {

    public static void walking(File folder) {
        System.out.println("name --> " + folder.getName());
        System.out.println("path --> " + folder.getAbsolutePath());
        System.out.println("size --> " + folder.length());
        System.out.println("");
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
        File file = new File("D:/home");
        walking(file);
    }
}
