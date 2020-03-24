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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.StringUtils;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Mathew Official
 */
public class getAlltoJSON {
    public static String ListSources() throws ClassNotFoundException{
        
     
        
        String jsonString = "";
    
            PreparedStatement ps;
            ResultSet rx;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DbConnector.getConnection();
            String str = "";
            try {
            ps = conn.prepareStatement("SELECT * FROM _sources;");
            rx = ps.executeQuery();
            while (rx.next()){
            
            str = str + "{\"url\":\""+rx.getString("url")+"\",\"title\":\""+rx.getString("title")+"\",\"desc\":\""+rx.getString("desc")+"\",\"source_dest_switch\":\""+rx.getString("source_dest_switch")+"\",\"status\":\""+rx.getString("status")+"\",\"created\":\""+rx.getString("created")+"\",\"last_update\":\""+rx.getString("last_update")+"\"},";
            //{"source":[{"url":"+rx.getString("url")+","title":"+rx.getString("title")+","desc":"+rx.getString("desc")+","source_dest_switch":"+rx.getString("source_dest_switch")+","status":"+rx.getString("status")+","created":"+rx.getString("created")+","last_update":"+rx.getString("last_update")+"}"
            
          
           
            }
            
                String strr = str+"@@";
                jsonString = "{\"product\":["+strr.replace(",@@", "]}");
            
             System.out.println(jsonString);
            } catch (SQLException ex) {
            Logger.getLogger(getAlltoJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonString;
    }
}
