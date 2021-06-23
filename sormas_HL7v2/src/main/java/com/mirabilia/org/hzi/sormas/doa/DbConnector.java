/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mirabilia.org.hzi.sormas.doa;

/**
 *
 * @author Mathew
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnector {

    public static Connection getConnection() {

        String[] url = ConffileCatcher.fileCatcher("passed");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String d1 = url[0];
            String d2 = url[1];
            String d3 = url[2];
            String d4 = url[3];
            String d5 = url[4];

            // System.out.println("jdbc:mysql://" + d1 + ":" + d2 + "/" + d3 + ", " + d4 + ", " + d5);
            return DriverManager.getConnection("jdbc:mysql://" + d1 + ":" + d2 + "/" + d3 + "?useSSL=false", d4, d5);

        } catch (Exception ex) {
            System.out.println("Several!, Database mysql getConnection() has an Error -->" + ex.getMessage());
            System.out.println("Several!, Database mysql getConnection() has an Error -->" + ex.toString());
        }
        return null;
    }

    public static Connection getPgConnection() {

        String[] url = ConffileCatcher.fileCatcher("passed");

        try {
            Class.forName("org.postgresql.Driver");
            String d1 = url[5];
            String d2 = url[6];
            String d3 = url[7];
            String d4 = url[8];
            String d5 = url[9];

            String MySQLURL = "jdbc:mysql://localhost:3306/web?useSSL=false";
            String databseUserName = "root";
            String databasePassword = "123456";
            Connection con = null;

            // System.out.println("jdbc:postgresql://" + d1 + ":" + d2 + "/" + d3 +","+  d4+",_"+ d5);
             System.out.println("Connection Successful : PG using: jdbc:postgresql://" + d1 + ":" + d2 + "/" + d3+","+ d4+","+ d5);
            return DriverManager.getConnection("jdbc:postgresql://" + d1 + ":" + d2 + "/" + d3, d4, d5);
           

        } catch (Exception ex) {
            System.out.println("Several!, Postgresql Database getConnection() has an Error -->" + ex.getMessage());
        }
        return null;
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception localException) {
        }
    }
}
