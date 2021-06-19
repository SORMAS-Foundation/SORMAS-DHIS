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
package com.mirabilia.org.hzi.Util;

import com.mirabilia.org.hzi.Util.fhir.PusttoFHIR;
import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mathew Official
 */
public class dbResolvers {

    public static String gotoDB(String json_all) throws ClassNotFoundException {
        JSONParser jsonParser = new JSONParser();

        PreparedStatement pstmt;
        ResultSet rx;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DbConnector.getConnection();
            //Parsing the contents of the JSON file retrieved from DHIS2
            JSONObject jsonObject = (JSONObject) jsonParser.parse(json_all);
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("organisationUnits");

            //Insert a row into the MyPlayers table
            pstmt = con.prepareStatement("INSERT ignore INTO raw_ (uuid, name, shortname, created, path_parent, level, updated_last, rec_created) values (?, ?, ?, ?, ?, ?,? , now())");
            for (Object object : jsonArray) {
                JSONObject record = (JSONObject) object;

                String idx = (String) record.get("id");
                String namex = (String) record.get("name");
                String created = (String) record.get("created");

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                java.sql.Timestamp datetime = new Timestamp(formatter.parse(created.replace("T", " ")).getTime());
                //     long datetimex = datetime.getTime();

                String path = (String) record.get("path");
                Long level = (Long) record.get("level");
                String levelx = level + "";
                String lastUpdated = (String) record.get("lastUpdated");

                java.sql.Timestamp lastUpdatedx = new Timestamp(formatter.parse(lastUpdated.replace("T", " ")).getTime());
                //  long lastUpdatedxx = lastUpdatedx.getTime();

                String shorName = (String) record.get("shortName");

                pstmt.setString(1, idx);
                pstmt.setString(2, namex);
                pstmt.setString(3, shorName);
                pstmt.setTimestamp(4, datetime);
                pstmt.setString(5, path);
                pstmt.setString(6, levelx);
                pstmt.setTimestamp(7, lastUpdatedx);
                //   System.out.println("inserting records..." + pstmt);
                pstmt.executeUpdate();
            }
            con.close();;
           // System.out.println("Records inserted.....");
        } catch (SQLException ex) {
            Logger.getLogger(dbResolvers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(dbResolvers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(dbResolvers.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
    
    
    public static String getAllOrgFromDB(int uuid) throws ClassNotFoundException{


        PreparedStatement pstmt = null;
        ResultSet rx = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DbConnector.getConnection();
            
            if(uuid  == 1){
            //retrieving all new orgunits from staging db.
            pstmt = con.prepareStatement("SELECT UUID, NAME, shortname, path_parent, LEVEL, updated_last, created, geopoint_ FROM raw_ WHERE fhiruuid IS null limit 2;");
            } else if(uuid == 2){
                 //retrieving all updateable orgunits from staging db.
            pstmt = con.prepareStatement("SELECT UUID, NAME, shortname, path_parent, LEVEL, updated_last, created, geopoint_, fhiruuid FROM raw_ WHERE fhiruuid IS not null limit 2;");
            }
            
            rx = pstmt.executeQuery();
            while (rx.next()){
            String uuidx = rx.getString(1);
            String name = rx.getString(2);;
            String shortname = rx.getString(3);;
            String path = rx.getString(4);
            String level = rx.getString(5);;
            String updated = rx.getString(6);;
            String created = rx.getString(7);;
            String geopoint = "";
            //taking care of null geopoint entry on state, lga and ward level + hf with no geoloc
            if (rx.getString(8) == null){
                geopoint = "0";
            }else{
            geopoint = rx.getString(8);
            }
            String phone = "";
            String fhirID = "";
            
            if (uuid == 2){
            fhirID = PusttoFHIR.fireDB(uuidx, name, shortname, path, level, updated, created, geopoint, phone, rx.getString(9));
            } else{
            //sending each orguint to fhir and retriving the created id for further porcessing at on the staging DB
            fhirID = PusttoFHIR.fireDB(uuidx, name, shortname, path, level, updated, created, geopoint, phone, "x");
            }
            if(fhirID.contains("#######")){
            try{
                PreparedStatement pstmtx;
                ResultSet rxx;
                
                pstmtx = con.prepareStatement("update raw_ set fhiruuid_history = ? where uuid = ?");
                pstmtx.setString(1, fhirID.replaceAll("#######", ""));
                pstmtx.setString(2, uuidx);
                
                pstmtx.executeUpdate();
                
            }finally{
            fhirID = "";
            uuidx = "";
            
            }
            
            }else{
            try{
                PreparedStatement pstmtx;
                ResultSet rxx;
                
                pstmtx = con.prepareStatement("update raw_ set fhiruuid = ? where uuid = ?");
                pstmtx.setString(1, fhirID);
                pstmtx.setString(2, uuidx);
                
                pstmtx.executeUpdate();
                
            }finally{
            fhirID = "";
            uuidx = "";
            
            }}
            }
            con.close();
           // System.out.println("Records inserted.....");
        } catch (SQLException ex) {
            Logger.getLogger(dbResolvers.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
        
   
}

