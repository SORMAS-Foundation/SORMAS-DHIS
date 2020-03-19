/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirabilia.org.hzi.proj.sormas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Mathew
 */
public class ConffileCatcher {

   // public static void main(String[] args) {
        public static String[] fileCatcher(String valx){
            String val_url = "";
            String val_host = "";
            String val_port = "";
            String val_name = "";
            String val_user = "";
            String val_passw = "";
            
            if(valx.equalsIgnoreCase("passed")){
        try {
            //retrieving database values from configuration file
            File myObj = new File(System.getProperty("user.home") + File.separator + "somars.conf");
            System.out.println(System.getProperty("user.home") + File.separator + "somars.conf");
            
            if(myObj.exists()){
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //clearing excesses and setting the values to the dbclass.
                if (data.contains("db_host")) {
                    String val = data.replaceAll("db_host", "").replaceAll(" ", "").replaceAll("=", "");
           //         System.out.println("host>>>>>>" + val);
                    val_host = val;
                }
                if (data.contains("db_port")) {
                   String val = data.replaceAll("db_port", "").replaceAll(" ", "").replaceAll("=", "");
            //        System.out.println("host>>>>>>" + val);
                    val_port = val;
                }
                if (data.contains("db_name =")) {
                   String val = data.replaceAll("db_name", "").replaceAll(" ", "").replaceAll("=", "");
             //       System.out.println("host>>>>>>" + val);
                    val_name = val;
                }
                if (data.contains("db_user =")) {
                    String val = data.replaceAll("db_user", "").replaceAll(" ", "").replaceAll("=", "");
              //      System.out.println("host>>>>>>" + val);
                    val_user = val;
                }
                if (data.contains("db_password =")) {
                   String val = data.replaceAll("db_password", "").replaceAll(" ", "").replaceAll("=", "");
             //       System.out.println("host>>>>>>" + val);
                    val_passw = val;
                }

            }

            myReader.close();
            }else{
            System.out.println("I need the configuration file to work, cant find it in your home directory");
            return null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred reading the configuration file.");
        }
            } else {
            
                System.out.println("UNAUTHORIZED ACCESS DETECTED");
            }
        //compossing db connection url and pass it back to dbclass

       // val_url = val_host + ":" + val_port + "/" + val_name + ", \'" + val_user + "\', \'" + val_passw + "\'";
        //System.out.println("jdbc:mysql://" + val_url);
        String[] arr = new String[5];
        arr[0] = val_host;
        arr[1] = val_port;
        arr[2] = val_name;
        arr[3] = val_user;
        arr[4] = val_passw;
        return arr;

    }

}
