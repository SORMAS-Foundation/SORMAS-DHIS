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

            PreparedStatement pa_1 = null;
            ResultSet ra_1 = null;

            PreparedStatement pa_2 = null;
            ResultSet ra_2 = null;

            PreparedStatement pa_3 = null;
            ResultSet ra_3 = null;

            PreparedStatement pa_4 = null;
            ResultSet ra_4 = null;

            PreparedStatement pa_5 = null;
            ResultSet ra_5 = null;
            
              PreparedStatement pa_6 = null;
            ResultSet ra_6 = null;

            PreparedStatement pa_7 = null;
            ResultSet ra_7 = null;

            PreparedStatement pa_8 = null;
            ResultSet ra_8 = null;

            PreparedStatement pa_9 = null;
            ResultSet ra_9 = null;

            PreparedStatement pa_10 = null;
            ResultSet ra_10 = null;
            
            PreparedStatement pa_11 = null;
            ResultSet ra_11 = null;
            
            PreparedStatement pa_12 = null;
            ResultSet ra_12 = null;
            
            PreparedStatement pa_13 = null;
            ResultSet ra_13 = null;

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

            ra = pa.executeQuery();
            while (ra.next()) {
                System.out.println("I am in DHIS2 pusher AggregrateController");
                String splitt = update_oneParm("select concat(s.parm2,\",\", s.parm3) from transition_parameters s where s.parm1 = ?", ra.getString(2));

                if (!splitt.isEmpty()) {
                    if (ra.getString(4) != null) {
                        String region_id = ra.getString(6);
                        String[] ad = splitt.split(",");
                        String incountry = "0";
                        String imported = "0";
                        String death = "0";
                        String recover = "0";
                        String not_det_rec = "0";
                        //Age
                        String age_1 = "0";
                        String age_2 = "0";
                        String age_3 = "0";
                        String age_4 = "0";
                        String age_5 = "0";
                        String age_6 = "0";
                        String age_7 = "0";
                        String age_8 = "0";
                       

                        System.out.println("E3432221_:" + ra.getString(6));
                        // String incountry = "";

                        pa_1 = cox.prepareStatement(sql.getSORMAS_INCOUNTRY);
                        pa_1.setInt(1, Integer.parseInt(region_id));
                        ra_1 = pa_1.executeQuery();
                        if (ra_1.next()) {
                            incountry = ra_1.getString(1);
                            System.out.println("E3432221:" + ra_1.getString(1));
                        }
                        pa_2 = cox.prepareStatement(sql.getSORMAS_IMPORTED);
                        pa_2.setInt(1, Integer.parseInt(region_id));
                        ra_2 = pa_2.executeQuery();
                        if (ra_2.next()) {
                            imported = ra_2.getString(1);
                            System.out.println("E3432222:" + ra_2.getString(1));
                        }

                        pa_3 = cox.prepareStatement(sql.getSORMAS_DEATH);
                        pa_3.setInt(1, Integer.parseInt(region_id));
                        ra_3 = pa_3.executeQuery();
                        if (ra_3.next()) {
                            death = ra_3.getString(1);
                            System.out.println("E34333:" + ra_3.getString(1));
                        }

                        pa_4 = cox.prepareStatement(sql.getSORMAS_RECOVERED);
                        pa_4.setInt(1, Integer.parseInt(region_id));
                        ra_4 = pa_4.executeQuery();
                        if (ra_4.next()) {
                            recover = ra_4.getString(1);
                            System.out.println("E34324:" + ra_4.getString(1));
                        }

                        pa_5 = cox.prepareStatement(sql.getSORMAS_NOT_RECOVERED_AND_NOT_DEATH);
                        pa_5.setInt(1, Integer.parseInt(region_id));
                        ra_5 = pa_5.executeQuery();
                        if (ra_5.next()) {
                            not_det_rec = ra_5.getString(1);
                            System.out.println("E34325:" + ra_5.getString(1));
                        }
                        
                        //AGE Disaggregation
                        pa_6 = cox.prepareStatement(sql.Age_LESS_5);
                        pa_6.setInt(1, Integer.parseInt(region_id));
                        ra_6 = pa_6.executeQuery();
                        if (ra_6.next()) {
                            age_1 = ra_6.getString(1);
                            System.out.println("E34326:" + ra_6.getString(1));
                        }
                        
                        pa_7 = cox.prepareStatement(sql.Age_LESS5_GREATER_14);
                        pa_7.setInt(1, Integer.parseInt(region_id));
                        ra_7 = pa_7.executeQuery();
                        if (ra_7.next()) {
                            age_2 = ra_7.getString(1);
                            System.out.println("E34327:" + ra_7.getString(1));
                        }
                        
                        pa_8 = cox.prepareStatement(sql.Age_greater_14_and_less_40);
                        pa_8.setInt(1, Integer.parseInt(region_id));
                        ra_8 = pa_8.executeQuery();
                        if (ra_8.next()) {
                            age_3 = ra_8.getString(1);
                            System.out.println("E34328:" + ra_8.getString(1));
                        }
                        
                        pa_9 = cox.prepareStatement(sql.Age__grat40_less65);
                        pa_9.setInt(1, Integer.parseInt(region_id));
                        ra_9 = pa_9.executeQuery();
                        if (ra_9.next()) {
                            age_4 = ra_9.getString(1);
                            System.out.println("E34325:" + ra_9.getString(1));
                        }
                        
                        pa_10 = cox.prepareStatement(sql.Age_grater65_less80yr);
                        pa_10.setInt(1, Integer.parseInt(region_id));
                        ra_10 = pa_10.executeQuery();
                        if (ra_10.next()) {
                            age_5 = ra_10.getString(1);
                            System.out.println("E3432_10:" + ra_10.getString(1));
                        }
                        
                        pa_11 = cox.prepareStatement(sql.Age_above_80);
                        pa_11.setInt(1, Integer.parseInt(region_id));
                        ra_11 = pa_11.executeQuery();
                        if (ra_11.next()) {
                            age_6 = ra_11.getString(1);
                            System.out.println("E34325:" + ra_11.getString(1));
                        }
                        
                        pa_12 = cox.prepareStatement(sql.Age_Missing_Unknown);
                        pa_12.setInt(1, Integer.parseInt(region_id));
                        ra_12 = pa_12.executeQuery();
                        if (ra_12.next()) {
                            age_7 = ra_12.getString(1);
                            System.out.println("E34325:" + ra_12.getString(1));
                        }
                        
                        pa_13 = cox.prepareStatement(sql.Occupation_Health_Worker);
                        pa_13.setInt(1, Integer.parseInt(region_id));
                        ra_13 = pa_13.executeQuery();
                        if (ra_13.next()) {
                            age_8 = ra_13.getString(1);
                            System.out.println("E34323++++++++++++++++:" + ra_13.getString(1));
                        }
                        
                        
                        
                        System.out.println(ra.getString(5) + " " + ad[0] + " " + ra.getString(4) + " " + ad[1] + " " + ra.getString(1) + " " + dtf.format(now) + " " + ra.getString(4) + " " + ra.getString(3) + " " + imported + " " + incountry);

                        SendCasesToDHIS(ra.getString(5), ad[0], ra.getString(4), ad[1], ra.getString(1), dtf.format(now), ra.getString(4) + " Aggregate", ra.getString(3), imported, incountry,death, recover, not_det_rec, age_1);

                        System.out.println("1______date:" + ra.getString(5) + " , dataset" + ad[0] + " , org_" + ra.getString(4) + " , element" + ad[1] + " , count" + ra.getString(1) + " , pero" + dtf.format(now) + " , " + ra.getString(4) + " Aggregate" + " , " + ra.getString(3));
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

    public static void SendCasesToDHIS(String cPer, String dSet, String OrgUnit, String dEle, String val, String tDay, String disC, String org_name, String incount, String impor, String death, String recover, String no_outcome, String age_1) {
        StringBuilder sb = new StringBuilder();
        System.out.println("URI in use: " + httpx);

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

            JSONObject item1 = new JSONObject();
            item1.put("categoryOptionCombo", "yr9KCcp24dI");
            item1.put("dataElement", "LwLDycsBaSC");
            item1.put("value", Integer.valueOf(incount));
            array.add(item1);

            JSONObject item2 = new JSONObject();
            item2.put("categoryOptionCombo", "CqhKacjKIyG");
            item2.put("dataElement", "LwLDycsBaSC");
            item2.put("value", Integer.valueOf(impor));
            array.add(item2);
            
            //OUTCOME
            JSONObject item3 = new JSONObject();
            item3.put("categoryOptionCombo", "HEVkjakWadt");
            item3.put("dataElement", "ObwbuybGqev");
            item3.put("value", Integer.valueOf(death));
            array.add(item3);
            
            JSONObject item4 = new JSONObject();
            item4.put("categoryOptionCombo", "SNwVO65yKLD");
            item4.put("dataElement", "ObwbuybGqev");
            item4.put("value", Integer.valueOf(recover));
            array.add(item4);
            
            JSONObject item5 = new JSONObject();
            item5.put("categoryOptionCombo", "ziGYcHoUlxG");
            item5.put("dataElement", "ObwbuybGqev");
            item5.put("value", Integer.valueOf(no_outcome));
            array.add(item5);
            
            //AGE
            JSONObject item6 = new JSONObject();
            item6.put("categoryOptionCombo", "ziGYcHoUlxG");
            item6.put("dataElement", "ObwbuybGqev");
            item6.put("value", Integer.valueOf(no_outcome));
            array.add(item6);
            
            JSONObject item7 = new JSONObject();
            item7.put("categoryOptionCombo", "ziGYcHoUlxG");
            item7.put("dataElement", "ObwbuybGqev");
            item7.put("value", Integer.valueOf(no_outcome));
            array.add(item7);
            
             JSONObject item8 = new JSONObject();
            item8.put("categoryOptionCombo", "ziGYcHoUlxG");
            item8.put("dataElement", "ObwbuybGqev");
            item8.put("value", Integer.valueOf(no_outcome));
            array.add(item8);
            
            //age_1
             JSONObject item9 = new JSONObject();
            item9.put("categoryOptionCombo", "ziGYcHoUlxG");
            item9.put("dataElement", "ObwbuybGqev");
            item9.put("value", Integer.valueOf(age_1));
            array.add(item9);
            
            
            
            

            /*  JSONObject item2 = new JSONObject();
            item1.put("categoryOptionCombo", "CqhKacjKIyG");
             item1.put("dataElement", "LwLDycsBaSC");
            item1.put("value", Integer.valueOf(impor));
            array.add(item2);*/
            json.put("dataValues", array);

            System.out.println("E8765: " + json.toString());

            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(json.toString());
            out.close();

            int HttpResult = urlConnection.getResponseCode();

            System.out.println(HttpResult);

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

            System.out.println("E234: " + ps.toString());
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
        String http = httpx + "/api/metadata";

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
