package com.mirabilia.org.hzi.sormas.doa;

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
            
            //pg
            String pg_val_url = "";
            String pg_val_host = "";
            String pg_val_port = "";
            String pg_val_name = "";
            String pg_val_user = "";
            String pg_val_passw = "";
            
            
            String dhis_url = "";
            String fhir_url = "";
            
            String instance_country = "";
            String instance_code = "";
            String instance_Language = "";
            
            if(valx.equalsIgnoreCase("passed")){
        try {
            File myObj = new File(System.getProperty("user.home") + File.separator + "sormas.conf");
            if(myObj.exists()){
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //clearing excesses and setting the values to the dbclass.
                if (data.contains("db-host")) {
                    String val = data.replaceAll("db-host", "").replaceAll(" ", "").replaceAll("=", "");
                    val_host = val;
                }
                if (data.contains("db-port")) {
                   String val = data.replaceAll("db-port", "").replaceAll(" ", "").replaceAll("=", "");
                    val_port = val;
                }
                if (data.contains("db-name =")) {
                   String val = data.replaceAll("db-name", "").replaceAll(" ", "").replaceAll("=", "");
                    val_name = val;
                }
                if (data.contains("db-user =")) {
                    String val = data.replaceAll("db-user", "").replaceAll(" ", "").replaceAll("=", "");
              //      System.out.println("host>>>>>>" + val);
                    val_user = val;
                }
                if (data.contains("db-password =")) {
                   String val = data.replaceAll("db-password", "").replaceAll(" ", "").replaceAll("=", "");
                    val_passw = val;
                }
                
                
                //pg pg_values for sormas
                 if (data.contains("pg_db_host")) {
                    String val = data.replaceAll("pg_db_host", "").replaceAll(" ", "").replaceAll("=", "");
                    pg_val_host = val;
                }
                if (data.contains("pg_db_port")) {
                   String val = data.replaceAll("pg_db_port", "").replaceAll(" ", "").replaceAll("=", "");
                    pg_val_port = val;
                }
                if (data.contains("pg_db_name =")) {
                   String val = data.replaceAll("pg_db_name", "").replaceAll(" ", "").replaceAll("=", "");
                    pg_val_name = val;
                }
                if (data.contains("pg_db_user =")) {
                    String val = data.replaceAll("pg_db_user", "").replaceAll(" ", "").replaceAll("=", "");
                    pg_val_user = val;
                }
                if (data.contains("pg_db_password =")) {
                   String val = data.replaceAll("pg_db_password", "").replaceAll(" ", "").replaceAll("=", "");
                    pg_val_passw = val;
                }
                
                if (data.contains("dhis_url =")) {
                   String val = data.replaceAll("dhis_url", "").replaceAll(" ", "").replaceAll("=", "");
                    dhis_url = val;
                    System.out.println(dhis_url);
                }
                
                //instance_country
                if (data.contains("instance_country =")) {
                   String val = data.replaceAll("instance_country", "").replaceAll(" ", "").replaceAll("=", "");
                    instance_country = val;
                }
                
                //instance_code
                if (data.contains("instance_country_code =")) {
                   String val = data.replaceAll("instance_country_code", "").replaceAll(" ", "").replaceAll("=", "");
                    instance_code = val;
                            }
                
                if (data.contains("fhir_url =")) {
                   String val = data.replaceAll("fhir_url", "").replaceAll(" ", "").replaceAll("=", "");
                    fhir_url = val;
                }

            }

            myReader.close();
            
            }else{
            System.out.println("I need the configuration file to work, cant find it @ "+System.getProperty("user.home") + File.separator + "sormas.conf");
            return null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred reading the configuration file.");
        }
            } else {
            
                System.out.println("UNAUTHORIZED ACCESS DETECTED");
            }
            
        String[] arr = new String[14];
        arr[0] = val_host;
        arr[1] = val_port;
        arr[2] = val_name;
        arr[3] = val_user;
        arr[4] = val_passw;
        
        arr[5] = pg_val_host;
        arr[6] = pg_val_port;
        arr[7] = pg_val_name;
        arr[8] = pg_val_user;
        arr[9] = pg_val_passw;
        arr[10] = dhis_url;
        arr[11] = fhir_url;
        arr[12] = instance_country;
        arr[13] = instance_code;
        
        return arr;

    }

}
