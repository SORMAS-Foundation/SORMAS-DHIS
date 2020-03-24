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

import com.mirabilia.org.hzi.proj.sormas.DbConnector;
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
public class dbResolver {

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
            System.out.println("Records inserted.....");
        } catch (SQLException ex) {
            Logger.getLogger(dbResolver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(dbResolver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(dbResolver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
