/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.cpe4235.chapter6;

import java.io.IOException;
import java.util.Set;

/**
 *
 * @author anonymous
 */
public class WebReaderTest {

    public static void main(String[] args) throws IOException {
        WebReader reader = WebReader.fromURL("https://google.com");
        System.out.println("title = " + reader.getPageTile());
        System.out.println("");
        Set<String> links = reader.getLinks();
        for (String link : links) {
            System.out.println("link = " + link);
        }
    }
}

/**
title = Google  
 
link = https://www.google.co.th/setprefs?sig=0_wvQ_0lQVw4QtGGQ3mbC8ACyfkRw%3D&amp;hl=en&amp;source=homepage
link = https://translate.google.co.th/?hl=th&tab=wT
link = https://www.google.com/calendar?tab=wc
link = https://drive.google.com/?tab=wo
link = https://www.google.co.th/imghp?hl=th&tab=wi
link = http://schema.org/WebPage
link = https://maps.google.co.th/maps?hl=th&tab=wl
link = http://www.google.co.th/intl/th/ads/index.html
link = https://plus.google.com/100395172310311078898
link = https://www.google.co.th/setprefdomain?prefdom=US&amp;sig=0_MIr3_Q82AfXphSo3eoGPJm3Oo0k%3D
link = http://www.google.co.th/intl/th/options/
link = https://www.youtube.com/?gl=TH&tab=w1
link = https://accounts.google.com/ServiceLogin?hl=th&continue=https://www.google.co.th/%3Fgws_rd%3Dcr%26ei%3DfuPEVJU9wu3wBb7MgsgL
link = http://www.google.co.th/history/optout?hl=th
link = https://mail.google.com/mail/?tab=wm
*/
