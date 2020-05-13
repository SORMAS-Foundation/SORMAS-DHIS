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


import static com.mirabilia.org.hzi.Util.dbResolvers.gotoDB;
import static com.mirabilia.org.hzi.Util.dhis.DHIS2resolver.getDemAll;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mathew Official
 */
public class dhisOrgRetrival {
    public static int starter(int pg_counterd){
     if (pg_counterd > 1) {
         
        JSONParser jsonParser = new JSONParser();
        String base_url = "http://172.105.77.79:8080/dhis/api/organisationUnits.json?fields=lastUpdated,id,name,shortName,level,created,path&paging=true&maxLevel=4";
        String json_all = getDemAll(base_url);
        PreparedStatement pstmt;
        ResultSet rx;

        JSONObject jsonObjectx;

      //  System.out.println("XXXXX<<<<<<<<<<<<<<XXXXXXXXXXX = " + pg_counterd);
         
            try {
                jsonObjectx = (JSONObject) jsonParser.parse(json_all);
                Object pager_values = jsonObjectx.get("pager");

                JSONObject jsonObjectxx = (JSONObject) pager_values;

              
              
                    String base_urlx = "http://172.105.77.79:8080/dhis/api/organisationUnits.json?page=" + pg_counterd + "&maxLevel=4&paging=true&fields=lastUpdated%2Cid%2Cname%2CshortName%2Clevel%2Ccreated%2Cpath";
                    String nxtpg_url_val = getDemAll(base_urlx);
                    
                    gotoDB(nxtpg_url_val);
            } catch (ClassNotFoundException ex) { 
             Logger.getLogger(dhisOrgRetrival.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ParseException ex) {
             Logger.getLogger(dhisOrgRetrival.class.getName()).log(Level.SEVERE, null, ex);
         } 
        }
     
     
    
    return pg_counterd;
    }
}