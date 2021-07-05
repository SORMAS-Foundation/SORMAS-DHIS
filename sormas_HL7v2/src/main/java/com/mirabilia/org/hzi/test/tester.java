package com.mirabilia.org.hzi.test;

import java.text.SimpleDateFormat;
import org.json.simple.parser.ParseException;

public class tester {

    public static void main(String[] args) throws ParseException {
       String dd = "2021-06-05 02:09:42.171";
       
       SimpleDateFormat frnmt = new SimpleDateFormat("yyyy-MM-dd");

            System.out.println(dd.substring( 0, dd.indexOf(" ")));
        }
    }


