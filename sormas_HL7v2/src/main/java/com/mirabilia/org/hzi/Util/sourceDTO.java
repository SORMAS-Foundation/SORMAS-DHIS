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

import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mathew Official
 */
public class sourceDTO {

    public static String ListSourcestoJSON(String control_data) throws ClassNotFoundException {

        String jsonString = "";

        PreparedStatement ps;
        ResultSet rx;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        String str = "";
        try {
            ps = conn.prepareStatement("SELECT * FROM _sources;");
            rx = ps.executeQuery();
            while (rx.next()) {
                String status = "";

                if ("deactivated".equals(rx.getString("status"))) {
                    //  System.out.println(rx.getString("status"));
                    status = "times";
                } else {
                    status = "check";
                    //      System.out.println(rx.getString("status")+"2");
                }

                str = str + "{\"url\":\"" + rx.getString("url") + "\",\"title\":\"" + rx.getString("title") + "\",\"desc\":\"" + rx.getString("desc") + "\",\"source_dest_switch\":\"" + rx.getString("source_dest_switch") + "\",\"status\":\"" + status + "\",\"uuid\":\"" + rx.getString("uuid") + "\"},";
                //{"source":[{"url":"+rx.getString("url")+","title":"+rx.getString("title")+","desc":"+rx.getString("desc")+","source_dest_switch":"+rx.getString("source_dest_switch")+","status":"+rx.getString("status")+","created":"+rx.getString("created")+","last_update":"+rx.getString("last_update")+"}"

            }
            conn.close();

            String strr = str + "@@";
            jsonString = "[" + strr.replace(",@@", "]");

            System.out.println(jsonString);
        } catch (SQLException ex) {
            Logger.getLogger(sourceDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonString;
    }

    public static String updateSourcesPairs(String source, String dest) throws ClassNotFoundException {

        String jsonString = "";

        PreparedStatement ps = null;
        ResultSet rx = null;
        
        PreparedStatement psx = null;
        ResultSet rxx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();

        try {
            psx = conn.prepareStatement("select UUID from source_pair");
            rxx = psx.executeQuery();
            if (rxx.next()) {
                
                ps = conn.prepareStatement("UPDATE source_pair SET source_id = ?, destination_id =?  WHERE UUID = ?");
                ps.setString(1, source);
                ps.setString(2, dest);
                ps.setString(3, rxx.getString(1));

                ps.executeUpdate();

                jsonString = "SUCCESSFUL : Upadted";

                System.out.println(jsonString);
                
            } else {

                ps = conn.prepareStatement("insert into source_pair SET source_id = ?, destination_id =?, uuid = uuid()");
                ps.setString(1, source);
                ps.setString(2, dest);

                ps.executeUpdate();

                jsonString = "SUCCESSFUL : Created";

                System.out.println(jsonString);
            }
        } catch (SQLException ex) {
            Logger.getLogger(sourceDTO.class.getName()).log(Level.SEVERE, null, ex);
            jsonString = ex.getMessage();
        }
        return jsonString;
    }

    public static String getSourcePaired() throws ClassNotFoundException {

        String jsonString = "";
        String jsonStringx = "";

        PreparedStatement ps;
        ResultSet rx;

        PreparedStatement psx;
        ResultSet rxx;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();

        try {
            ps = conn.prepareStatement("SELECT title FROM _sources WHERE _sources.uuid = ( SELECT source_id FROM source_pair LIMIT 1)");

            rx = ps.executeQuery();
            if (rx.next()) {
                jsonString = rx.getString("title");
                try {
                    psx = conn.prepareStatement("SELECT title FROM _sources WHERE _sources.uuid = ( SELECT destination_id FROM source_pair LIMIT 1)");

                    rxx = psx.executeQuery();
                    if (rxx.next()) {
                        jsonStringx = rxx.getString("title");
                    }

                } finally {

                }

                jsonString = "<strong>Master : </strong>" + jsonString + " | <strong> Destination : </strong>" + jsonStringx;

                conn.close();
            }
            //  System.out.println(jsonString);
        } catch (SQLException ex) {
            Logger.getLogger(sourceDTO.class.getName()).log(Level.SEVERE, null, ex);
            // jsonString = ex.getMessage();
        }
        return jsonString;
    }

    public static String totalORGinDB() throws ClassNotFoundException {

        String jsonString = "";

        PreparedStatement ps;
        ResultSet rx;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();

        try {
            ps = conn.prepareStatement("select count(*) from raw_");
            rx = ps.executeQuery();

            if (rx.next()) {

                jsonString = rx.getString(1);
            }
            System.out.println(jsonString);
        } catch (SQLException ex) {
            Logger.getLogger(sourceDTO.class.getName()).log(Level.SEVERE, null, ex);
            // jsonString = ex.getMessage();
        }
        return jsonString;
    }

    public static String totalDestDB() throws ClassNotFoundException {

        String jsonString = "";

        PreparedStatement ps;
        ResultSet rx;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();

        try {
            ps = conn.prepareStatement("select count(*) from sormas_local");
            rx = ps.executeQuery();

            if (rx.next()) {

                jsonString = rx.getString(1);
            }
            System.out.println(jsonString);
        } catch (SQLException ex) {
            Logger.getLogger(sourceDTO.class.getName()).log(Level.SEVERE, null, ex);
            // jsonString = ex.getMessage();
        }
        return jsonString;
    }
}
