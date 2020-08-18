/*
 * Copyright (c) 2020, Mathew Official
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.mirabilia.org.hzi.Util.dhis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Mathew Official
 */
public class DHIS2resolver {
     public static String getDemAll(String pg_url) {

        HttpURLConnection urlConnection = null;
        String name = "admin";
        String password = "district";
        StringBuilder sb = new StringBuilder();

        String authString = name + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        try {
            URL url = new URL(pg_url);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("GET");
            urlConnection.setUseCaches(true);
            urlConnection.setConnectTimeout(20000);
            urlConnection.setReadTimeout(20000);
             urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            int HttpResult = urlConnection.getResponseCode();
            //debug  
           // System.out.println("######cccccccccccc####Outreach Session HTTP Return Code = " + HttpResult);

            if (HttpResult == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                //debug  System.out.println("#########AAA###" + sb.toString());
                if (sb.toString().indexOf("success") >= 1) {
                    //      response.setStatus(200);
                    System.err.println("FIXED: Success!");
                    return sb.toString();
                }
                if (sb.toString().indexOf("warning") >= 1) {
                    //        response.setStatus(300);
                    System.err.println("FIXED: Warning!");
                    return sb.toString();
                }
                if ((sb.toString().indexOf("warning") >= 1) || (sb.toString().indexOf("success") >= 1)) {
                    //      response.setStatus(414);
                    System.err.println("Noticable Error:\n" + sb.toString());
                    return sb.toString();
                }
            } else {
                //response.setStatus(502, "DHIS2 Not there!");
                System.out.println("####CCCCCCCCCCCCCC" + urlConnection.getInputStream().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                System.out.println("#####XXX##" + sb.toString());
                System.out.println("OUT ERROR:>>>>" + urlConnection.getResponseMessage());
                return sb.toString();
            }

        } 
         catch (IOException ex) {
             Logger.getLogger(DHIS2resolver.class.getName()).log(Level.SEVERE, null, ex);
            
         }        finally {
            
            /**
             * if (1==2){
            try {
                String string = "2020-02-22 22:13:50.948";
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                java.sql.Timestamp datetime = new Timestamp(formatter.parse(string).getTime());
                //   System.out.println("DatedTime: " + datetime.toString());

                System.err.println("FIXED: Warning!");
            } catch (ParseException ex) {
        Logger.getLogger(resolver.class.getName()).log(Level.SEVERE, null, ex);
    }

        }
        **/
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
     
     
      public static String getDemAllfromFHIR(String pg_url) {

        HttpURLConnection urlConnection = null;
        StringBuilder sb = new StringBuilder();
        /**
        String name = "field";
        String password = "Passcode1!x";
        

        String authString = name + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        **/
        try {
            URL url = new URL(pg_url);
            urlConnection = (HttpURLConnection) url.openConnection();
          //  urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("GET");
            urlConnection.setUseCaches(true);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            // urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            int HttpResult = urlConnection.getResponseCode();
            //debug  System.out.println("######cccccccccccc####Outreach Session HTTP Return Code = " + HttpResult);

            if (HttpResult == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

               
            } else {
                //response.setStatus(502, "DHIS2 Not there!");
                System.out.println("####CCCCCCCCCCCCCC" + urlConnection.getInputStream().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                System.out.println("#####XXX##" + sb.toString());
                System.out.println("OUT ERROR:>>>>" + urlConnection.getResponseMessage());
                return sb.toString();
            }

        } 
         catch (IOException ex) {
             Logger.getLogger(DHIS2resolver.class.getName()).log(Level.SEVERE, null, ex);
         }        finally {
          
        }
        return sb.toString();
    }
    
}
