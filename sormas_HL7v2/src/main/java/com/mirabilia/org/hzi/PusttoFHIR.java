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

package com.mirabilia.org.hzi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class PusttoFHIR implements Serializable {
    public static HttpURLConnection urlConnection;
  //  public static URL url;

     public static String http = "http://172.105.77.79:3447/fhir/Location";

//    String name = "field";
//    String password = "Passcode1!x";http://172.105.77.79:3447/fhir/Location
    

//    String authString = name + ":" + password;
 //   byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
 //   String authStringEnc = new String(authEncBytes);

    
 public static String fireDB(){   
     StringBuilder sb = new StringBuilder();
     JSONObject json = new JSONObject();
            json.put("resourceType", "Location");

            JSONArray identifier_array = new JSONArray();
            JSONObject identifier_json = new JSONObject();
            identifier_json.put("type", "http://dhis2.org/id");
            identifier_json.put("value", "Jyy0N0IrLoy");
            identifier_array.add(identifier_json);
            json.put("identifier", identifier_array);

            json.put("name", "za Gusami Hayi Ward");
            json.put("alias", "Gusami Hayi Ward");
            json.put("description", "");
            json.put("mode", "instance");

            JSONArray type_array = new JSONArray();
            JSONObject type_json = new JSONObject();
            type_json.put("system", "http://hl7.org/fhir/v3/RoleCode");
            type_json.put("code", "PROFF");
            type_array.add(type_json);
            JSONObject type_json1 = new JSONObject();
            type_json1.put("coding", type_array);
            json.put("type", type_json1);

            JSONArray telecom_array = new JSONArray();
            JSONObject telecom_json = new JSONObject();
            telecom_json.put("value", "07031252904");
            telecom_array.add(telecom_json);
            json.put("telecom", telecom_array);

            JSONArray physicalType_array = new JSONArray();
            JSONObject physicalType_json = new JSONObject();
            physicalType_json.put("system", "http://hl7.org/fhir/location-physical-type");
            physicalType_json.put("code", "bu");
            physicalType_array.add(physicalType_json);
            JSONObject physicalType_json1 = new JSONObject();
            physicalType_json1.put("coding", physicalType_array);
            json.put("physicalType", physicalType_json1);

            JSONArray position_array = new JSONArray();
            JSONObject position_json = new JSONObject();
            position_json.put("longitude", "07031252904");
            position_json.put("latitude", "07031252904");
            position_array.add(position_json);
            json.put("position", position_array);

            JSONObject managingOrganization_json = new JSONObject();
            managingOrganization_json.put("reference", "Location/Jyy0N0IrLoy");
            json.put("managingOrganization", managingOrganization_json);

            JSONObject address_json = new JSONObject();
            address_json.put("city", "");
            address_json.put("postalCode", "");

            JSONArray address_array = new JSONArray();
            address_array.add("6060 Green Park Avenue");
            address_array.add("Abuja");
            address_json.put("line", address_array);
            json.put("address", address_json);

            JSONArray tag_arrary = new JSONArray();
            JSONObject tag_json = new JSONObject();
            tag_json.put("system", "http://dhis2.org/organistionUnitLevels");
            tag_json.put("code", "Jyy0N0IrLoy");
            tag_json.put("display", "Ward");
            tag_arrary.add(tag_json);
            json.put("physicalType", tag_arrary);

            System.out.println(json.toString());
     
        try {
            
            URL url = new URL(http);
            urlConnection = (HttpURLConnection) url.openConnection();
        //    urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(true);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            
            
            urlConnection.connect();
            
            
            
      OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
      out.write(json.toString());
      out.close();
      
      int HttpResult = urlConnection.getResponseCode();
      System.out.println("FHIR Response = " + HttpResult);
      if (HttpResult == 200)
      {
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
        String line = null;
        while ((line = br.readLine()) != null) {
          sb.append(line + "\n");
        }
        br.close();
       System.out.println("FHIR RAW = "+sb);
      } else {
          String resp = HttpResult+"";
      System.err.append(resp);
      }
            
            
        } catch (IOException ex) {
            Logger.getLogger(PusttoFHIR.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
        return null;
    }

}
