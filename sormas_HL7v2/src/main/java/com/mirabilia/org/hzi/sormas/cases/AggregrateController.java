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
package com.mirabilia.org.hzi.sormas.cases;

import com.mirabilia.org.hzi.Strings.sql;
import com.mirabilia.org.hzi.sormas.doa.ConffileCatcher;
import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mathew
 */
public class AggregrateController {

    public static void SormasAggregrator(String lev) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        try {
            Connection cox = DbConnector.getPgConnection();
            PreparedStatement pa = null;
            ResultSet ra = null;

            if ("2".equals(lev)) {
                System.out.println("1111111111111111");
                pa = cox.prepareStatement(sql.getSROMAS_region_PG);
            }
            if ("3".equals(lev)) {
                pa = cox.prepareStatement(sql.getSROMAS_district_PG);
            }
            if ("4".equals(lev)) {
                pa = cox.prepareStatement(sql.getSROMAS_community_PG);
            }
            if ("5".equals(lev)) {
                pa = cox.prepareStatement(sql.getSROMAS_hf_PG);
            }

            pa = cox.prepareStatement(sql.getSROMAS_district_PG);

            ra = pa.executeQuery();
            while (ra.next()) {
                System.out.println("I am in DHIS2 pusher AggregrateController");
                String splitt = update_oneParm("select concat(s.parm2,\",\", s.parm3) from transition_parameters s where s.parm1 = ?", ra.getString(2));

                if (!splitt.isEmpty()) {
                    if (ra.getString(4) != null) {
                        String[] ad = splitt.split(",");

                        SendCasesToDHIS(ra.getString(5), ad[0], ra.getString(4), ad[1], ra.getString(1), dtf.format(now), ra.getString(4) + " Aggregate", ra.getString(3));
                        System.out.println(ra.getString(5) + " - " + ad[0] + " - " + ra.getString(4) + " - " + ad[1] + " - " + ra.getString(1) + " - " + dtf.format(now));
                    }
                } else {

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AggregrateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AggregrateController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void JsonPerser() {
        //$$dis$$ = disease_count
        //$$dis_sh$$ = disease_countshort

        //$$disX$$ = disease_name
        //$$dis_shX$$ = disease_shortname
        //$$dis_sh_x$$  = SRM Module Aggregate D1 Form
        //$$dis_sh_freq$$  =  freques(Daily, Weekly, Montly)
        //$$dis_sh_sec$$  =  section name
        JSONParser parser = new JSONParser();

        // JSONObject json = (JSONObject) parser.parse(vc);
    }
    private static String[] _url = ConffileCatcher.fileCatcher("passed");

    private static String httpx = _url[10].toString(); //should come from config file

    public static void SendCasesToDHIS(String cPer, String dSet, String OrgUnit, String dEle, String val, String tDay, String disC, String org_name) {
        StringBuilder sb = new StringBuilder();

        String http = httpx + "/api/dataValueSets";

        HttpURLConnection urlConnection = null;
        String name = "admin";
        String password = "district";

        String authString = name + ":" + password;

        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        try {
            URL url = new URL(http);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(true);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            JSONObject json = new JSONObject();
            json.put("dataSet", dSet);
            json.put("completeDate", tDay);

            json.put("period", cPer.replaceAll("-", ""));
            json.put("orgUnit", OrgUnit);

            JSONArray array = new JSONArray();

            JSONObject item = new JSONObject();
            item.put("dataElement", dEle);
            item.put("value", Integer.parseInt(val));
            array.add(item);

            /**
             * //if you need more dElemetn JSONObject item1 = new JSONObject();
             * item1.put("dataElement", "DUvcFmVdBVG"); item1.put("value",
             * Integer.valueOf(wkb)); array.add(item1);
             *
             */
            json.put("dataValues", array);

            System.out.println(json.toString());

            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(json.toString());
            out.close();

            int HttpResult = urlConnection.getResponseCode();

            if (HttpResult == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                if (sb.toString().contains("SUCCESS")) {
                    // response.setStatus(200);
                    String[] wx = sb.toString().split("description\":\"");
                    System.err.println("Response: Successful! " + wx[1]);
                    update_oneParm_X("insert into sync_tracker set json_response = ?, datasource= '" + org_name + "', dataperiod = '" + cPer + "', case_specific_detail = '" + disC + "', status = 'ok', created = now()", wx[1]);
                    return;
                }

                if (sb.toString().contains("WARNING")) {
                    // response.setStatus(300);
                    String[] wx = sb.toString().split("conflicts");
                    System.err.println("WARNING Found " + wx[1]);
                    update_oneParm_X("insert into sync_tracker set json_response = ?, datasource= '" + org_name + "', dataperiod = '" + cPer + "', case_specific_detail = '" + disC + "', status = 'WARNING', created = now()", wx[1]);
                    return;
                }

                if (sb.toString().contains("ERROR")) {
                    // response.setStatus(300);
                    String[] wx = sb.toString().split("ERROR");
                    System.err.println("ERROR Found " + wx[1]);
                    update_oneParm_X("insert into sync_tracker set json_response = ?, datasource= '" + org_name + "', dataperiod = '" + cPer + "', case_specific_detail = '" + disC + "',  status = 'ERROR', created = now()", wx[1]);
                    return;
                }

            } else {
                System.out.println(urlConnection.getResponseMessage());

                return;
            }
        } catch (MalformedURLException localMalformedURLException) {
        } catch (IOException e) {
            System.err.println("Pushers says..... DHIS2 not found or not working.");
            return;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AggregrateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AggregrateController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }

        }

    }

    public static String update_oneParm(String sqq, String sqq_) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        String ret = "";
        try {

            ps = conn.prepareStatement(sqq);
            ps.setString(1, sqq_);

            //System.out.println(ps.toString());
            rx = ps.executeQuery();

            if (rx.next()) {
                ret = rx.getString(1);
            }

        } finally {
            conn.close();
        }
        //System.out.println("ddddddd"+ret);
        return ret;
    }

    public static void update_oneParm_X(String sqq, String sqq_) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();

        try {

            ps = conn.prepareStatement(sqq);
            ps.setString(1, sqq_);

            ps.executeUpdate();

        } finally {
            conn.close();
        }

    }

    public static String MetadaJsonSender(String paths_, String usn, String psw) throws ParseException {
        
        String ret = "opps... Something not right";

        StringBuilder sb = new StringBuilder();
        String http = httpx+"/api/metadata";

        HttpURLConnection urlConnection = null;
        String name = usn;
        String password = psw;

        String authString = name + ":" + password;

        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        try {
            URL url = new URL(http);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(true);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            //  System.out.println();
            JSONParser parser = new JSONParser();

            JSONObject json = (JSONObject) parser.parse(paths_);

             System.out.println(json.toString());
            //  File file = new File(this.getClass().getClassLoader().getResource("someName.json").getFile());
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(json.toString());
            out.close();

            int HttpResult = urlConnection.getResponseCode();
            System.err.println("done...");
            System.out.println("response Code : " + HttpResult);

            if (HttpResult == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                System.err.println(sb.toString());
                ret = sb.toString();

            } else {
                System.out.println("finally : " + urlConnection.getResponseMessage());
                System.out.println("finally Code : " + HttpResult);
                if (HttpResult == 401) {
                    System.out.println("Username and Pass not working");
                    
                    ret = "Username and Pass not working";

                     return ret;
                }
            }
        } catch (MalformedURLException localMalformedURLException) {
        } catch (IOException e) {
            System.err.println("Pushers says..... DHIS2 not found or not working.");
            return "Pushers says..... DHIS2 not found or not working.";
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }

        }
        return ret;
    }

    //Read file content into string with - Files.readAllBytes(Path path)
    private static String readAllBytesJava7(String filePath) {
        String content = "";

        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

}
