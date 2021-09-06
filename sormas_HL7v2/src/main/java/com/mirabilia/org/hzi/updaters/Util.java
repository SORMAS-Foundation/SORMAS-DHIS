/*
 * Copyright (c) 2020, Mathew
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
package com.mirabilia.org.hzi.updaters;

import com.google.gson.JsonSyntaxException;
import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mathew
 */
public class Util {

    public static void switcerh(String dx) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();

        try {

            ps = conn.prepareStatement("delete from _sources where url = ?;");
            ps.setString(1, dx.replaceAll("'", ""));
            //   System.out.println("doneing _________________!"+ps);
            ps.executeUpdate();
        } finally {
            conn.close();
            return;
        }

    }

    public static String MetaFileGetter() {

        try {
            URL link = new URL("http://172.105.77.79/downlos/dhisMetadata.json");
            URLConnection uc1 = link.openConnection();
            BufferedReader in1 = new BufferedReader(new InputStreamReader(uc1.getInputStream()));
            StringBuilder miraFile = new StringBuilder();
            miraFile.append(in1.readLine() + "\n");
            String line = "0";

            while ((line = in1.readLine()) != null) {
                miraFile.append(line + "\n");
            }

            String result = miraFile.toString();
            JSONParser parser = new JSONParser();

            JSONObject obj = (JSONObject) parser.parse(result);

            /* JSONArray jarr = (JSONArray) obj.get("data");
            
            System.out.println(((JSONObject) jarr.get(0)).get("city"));
            System.out.println(((JSONObject) jarr.get(0)).get("country"));
            System.out.println(((JSONObject) jarr.get(0)).get("min_today"));
            System.out.println(((JSONObject) jarr.get(0)).get("max_today"));
            System.out.println(((JSONObject) jarr.get(0)).get("desc_today"));
            System.out.println(((JSONObject) jarr.get(0)).get("date"));
             */
            //System.out.println(obj);
            return obj.toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public static void main(String[] args) {
         System.out.println(MetaFileGetter());
    }

}
