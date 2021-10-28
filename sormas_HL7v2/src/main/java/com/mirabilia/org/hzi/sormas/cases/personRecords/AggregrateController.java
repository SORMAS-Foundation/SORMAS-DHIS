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
package com.mirabilia.org.hzi.sormas.cases.personRecords;

import com.mirabilia.org.hzi.Strings.sql;
import com.mirabilia.org.hzi.sormas.aggregate.SendToDHISServer;
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
import java.sql.Date;
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


    private static String confirmed_missing = "0";
    private static String confirmed_lab = "0";
    private static String incountry = "0";
    private static String imported = "0";
    private static String death = "0";
    private static String recover = "0";
    private static String not_det_rec = "0";
    private static String age_1 = "0";
    private static String age_2 = "0";
    private static String age_3 = "0";
    private static String age_4 = "0";
    private static String age_5 = "0";
    private static String age_6 = "0";
    private static String age_7 = "0";
    private static String Occupation_Health_Worker = "0";
    private static String Occupation_Lab_Staff = "0";
    private static String Occupation_unknow_missing = "0";
    private static String Male = "0";
    private static String female = "0";
    private static String gender_others = "0";
    private static String gender_missing = "0";
    private static String not_confirmed_lab = "0";
    
    private static String[] _url = ConffileCatcher.fileCatcher("passed");

    private static String httpx = _url[10].toString(); //should come from config file
    
    public static void SormasAggregrator(String lev) throws ClassNotFoundException {


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        try {
            Connection cox = DbConnector.getPgConnection();
            PreparedStatement pa = null;
            ResultSet ra = null;

            PreparedStatement pa_0 = null;
            ResultSet ra_0 = null;

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

            PreparedStatement pa_14 = null;
            ResultSet ra_14 = null;

            PreparedStatement pa_15 = null;
            ResultSet ra_15 = null;

            PreparedStatement pa_16 = null;
            ResultSet ra_16 = null;

            PreparedStatement pa_17 = null;
            ResultSet ra_17 = null;

            PreparedStatement pa_18 = null;
            ResultSet ra_18 = null;

            PreparedStatement pa_19 = null;
            ResultSet ra_19 = null;

            PreparedStatement pa_20 = null;
            ResultSet ra_20 = null;
            
            PreparedStatement pa_20_a = null;
            ResultSet ra_20_a = null;

            PreparedStatement pa_21 = null;
            ResultSet ra_21 = null;

            PreparedStatement pa_22 = null;
            ResultSet ra_22 = null;

            PreparedStatement pa_23 = null;
            ResultSet ra_23 = null;

            PreparedStatement pa_24 = null;
            ResultSet ra_24 = null;

            PreparedStatement pa_25 = null;
            ResultSet ra_25 = null;

            PreparedStatement pa_26 = null;
            ResultSet ra_26 = null;

            PreparedStatement pa_27 = null;
            ResultSet ra_27 = null;

            PreparedStatement pa_28 = null;
            ResultSet ra_28 = null;

            PreparedStatement pa_29 = null;
            ResultSet ra_29 = null;

            PreparedStatement pa_30 = null;
            ResultSet ra_30 = null;

            PreparedStatement pa_31 = null;
            ResultSet ra_31 = null;

            PreparedStatement pa_32 = null;
            ResultSet ra_32 = null;

            PreparedStatement pa_33 = null;
            ResultSet ra_33 = null;

            if ("2".equals(lev)) {
                //System.out.println("1111111111111111");
                pa = cox.prepareStatement(sql.getSROMAS_region_Aggregate_AllCases);
            }
            if ("3".equals(lev)) {
                pa = cox.prepareStatement(sql.getSROMAS_district_Aggregate_AllCases);
            }
            if ("4".equals(lev)) {
                pa = cox.prepareStatement(sql.getSROMAS_community_PG);
            }
            if ("5".equals(lev)) {
                pa = cox.prepareStatement(sql.getSROMAS_hf_PG);
            }

            ra = pa.executeQuery();
            while (ra.next()) {
                ////System.out.println("I am in DHIS2 pusher AggregrateController");
                String splitt = SendToDHISServer.update_oneParm("select concat(s.parm2,\",\", s.parm3) from transition_parameters s where s.parm1 = ?", ra.getString(2));

                if (!splitt.isEmpty()) {
                    if (ra.getString(4) != null) {
                        String region_id = ra.getString(5);
                        Date datee = ra.getDate(4);
                        String[] ad = splitt.split(",");
                        /*                     String all_cast = "0";
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
                        String Occupation_Health_Worker = "0";
                        String Occupation_Lab_Staff = "0";
                        String Occupation_unknow_missing = "0";
                        String Occupation_others = "0";
                        String Male = "0";
                        String female = "0";
                        String not_confirmed_lab = "0";
                        String gender_others = "0";
                        String gender_missing = "0";
                        
                        String SROMAS_community_PG = "0";
                        String SROMAS_hf_PG = "0";
                        String SROMAS_district_PG_outc = "0";
                        String SROMAS_region_PG_outc = "0";
                        String SROMAS_community_PG_outc = "0";
                        String SROMAS_hf_PG_outc = "0";
                        String SROMAS_district_PG_class = "0";
                        String SROMAS_region_PG_class = "0";
                        String SROMAS_community_PG_class = "0";
                        String SROMAS_hf_PG_class = "0";
                         */
                        //System.out.println("E3432221_:" + ra.getString(5));

                        // String incountry = "";
                        pa_1 = cox.prepareStatement(sql.getSORMAS_INCOUNTRY);
                        pa_1.setInt(1, Integer.parseInt(region_id));
                        pa_1.setDate(2, datee);
                        ra_1 = pa_1.executeQuery();
                        if (ra_1.next()) {
                            incountry = ra_1.getString(1);
                            //System.out.println("E3432221:" + ra_1.getString(1));
                        }
                        pa_2 = cox.prepareStatement(sql.getSORMAS_IMPORTED);
                        pa_2.setInt(1, Integer.parseInt(region_id));
                        pa_2.setDate(2, datee);
                        ra_2 = pa_2.executeQuery();
                        if (ra_2.next()) {
                            imported = ra_2.getString(1);
                            //System.out.println("E3432222:" + ra_2.getString(1));
                        }

                        pa_3 = cox.prepareStatement(sql.getSORMAS_DEATH);
                        pa_3.setInt(1, Integer.parseInt(region_id));
                        pa_3.setDate(2, datee);
                        ra_3 = pa_3.executeQuery();
                        if (ra_3.next()) {
                            death = ra_3.getString(1);
                            //System.out.println("E34333:" + ra_3.getString(1));
                        }

                        pa_4 = cox.prepareStatement(sql.getSORMAS_RECOVERED);
                        pa_4.setInt(1, Integer.parseInt(region_id));
                        pa_4.setDate(2, datee);
                        ra_4 = pa_4.executeQuery();
                        if (ra_4.next()) {
                            recover = ra_4.getString(1);
                            //System.out.println("E34324:" + ra_4.getString(1));
                        }

                        pa_5 = cox.prepareStatement(sql.getSORMAS_NOT_RECOVERED_AND_NOT_DEATH);
                        pa_5.setInt(1, Integer.parseInt(region_id));
                        pa_5.setDate(2, datee);
                        ra_5 = pa_5.executeQuery();
                        if (ra_5.next()) {
                            not_det_rec = ra_5.getString(1);
                            //System.out.println("E34325:" + ra_5.getString(1));
                        }

                        //AGE Disaggregation
                        pa_6 = cox.prepareStatement(sql.Age_LESS_5);
                        pa_6.setInt(1, Integer.parseInt(region_id));
                        pa_6.setDate(2, datee);
                        ra_6 = pa_6.executeQuery();
                        if (ra_6.next()) {
                            age_1 = ra_6.getString(1);
                            //System.out.println("E34326:" + ra_6.getString(1));
                        }

                        pa_7 = cox.prepareStatement(sql.Age_LESS5_GREATER_14);
                        pa_7.setInt(1, Integer.parseInt(region_id));
                        pa_7.setDate(2, datee);
                        ra_7 = pa_7.executeQuery();
                        if (ra_7.next()) {
                            age_2 = ra_7.getString(1);
                            //System.out.println("E34327:" + ra_7.getString(1));
                        }

                        pa_8 = cox.prepareStatement(sql.Age_greater_14_and_less_40);
                        pa_8.setInt(1, Integer.parseInt(region_id));
                        pa_8.setDate(2, datee);
                        ra_8 = pa_8.executeQuery();
                        if (ra_8.next()) {
                            age_3 = ra_8.getString(1);
                            //System.out.println("E34328:" + ra_8.getString(1));
                        }

                        pa_9 = cox.prepareStatement(sql.Age__grat40_less65);
                        pa_9.setInt(1, Integer.parseInt(region_id));
                        pa_9.setDate(2, datee);
                        ra_9 = pa_9.executeQuery();
                        if (ra_9.next()) {
                            age_4 = ra_9.getString(1);
                            //System.out.println("E34325:" + ra_9.getString(1));
                        }

                        pa_10 = cox.prepareStatement(sql.Age_grater65_less80yr);
                        pa_10.setInt(1, Integer.parseInt(region_id));
                        pa_10.setDate(2, datee);
                        ra_10 = pa_10.executeQuery();
                        if (ra_10.next()) {
                            age_5 = ra_10.getString(1);
                            //System.out.println("E3432_10:" + ra_10.getString(1));
                        }

                        pa_11 = cox.prepareStatement(sql.Age_above_80);
                        pa_11.setInt(1, Integer.parseInt(region_id));
                        pa_11.setDate(2, datee);
                        ra_11 = pa_11.executeQuery();
                        if (ra_11.next()) {
                            age_6 = ra_11.getString(1);
                            //System.out.println("E34325:" + ra_11.getString(1));
                        }

                        pa_12 = cox.prepareStatement(sql.Age_Missing_Unknown);
                        pa_12.setInt(1, Integer.parseInt(region_id));
                        pa_12.setDate(2, datee);
                        ra_12 = pa_12.executeQuery();
                        if (ra_12.next()) {
                            age_7 = ra_12.getString(1);
                            //System.out.println("E34325:" + ra_12.getString(1));
                        }

                        pa_13 = cox.prepareStatement(sql.Occupation_Health_Worker);
                        pa_13.setInt(1, Integer.parseInt(region_id));
                        pa_13.setDate(2, datee);
                        ra_13 = pa_13.executeQuery();
                        if (ra_13.next()) {
                            Occupation_Health_Worker = ra_13.getString(1);
                            //System.out.println("E34323++++++++++++++++:" + ra_13.getString(1));
                        }

                        pa_14 = cox.prepareStatement(sql.Occupation_Lab_Staff);
                        pa_14.setInt(1, Integer.parseInt(region_id));
                        pa_14.setDate(2, datee);
                        ra_14 = pa_13.executeQuery();
                        if (ra_14.next()) {
                            Occupation_Lab_Staff = ra_14.getString(1);
                            //System.out.println("E34323++++++++++++++++:" + ra_14.getString(1));
                        }

                        pa_15 = cox.prepareStatement(sql.Occupation_unknow_missing);
                        pa_15.setInt(1, Integer.parseInt(region_id));
                        pa_15.setDate(2, datee);
                        ra_15 = pa_15.executeQuery();
                        if (ra_15.next()) {
                            Occupation_unknow_missing = ra_15.getString(1);
                            //System.out.println("E34323++++++++++++++++:" + ra_15.getString(1));
                        }

                        pa_20 = cox.prepareStatement(sql.Occupation_others);
                        pa_20.setInt(1, Integer.parseInt(region_id));
                        pa_20.setDate(2, datee);
                        ra_20 = pa_20.executeQuery();
                        if (ra_20.next()) {
                            Occupation_unknow_missing = ra_20.getString(1);
                            //System.out.println("E34323++++++++++++++++:" + ra_20.getString(1));
                        }

                        pa_16 = cox.prepareStatement(sql.Male);
                        pa_16.setInt(1, Integer.parseInt(region_id));
                        pa_16.setDate(2, datee);
                        ra_16 = pa_16.executeQuery();
                        if (ra_16.next()) {
                            Male = ra_16.getString(1);
                            //System.out.println("E34323++++++++++++++++:" + ra_16.getString(1));
                        }

                        pa_17 = cox.prepareStatement(sql.female);
                        pa_17.setInt(1, Integer.parseInt(region_id));
                        pa_17.setDate(2, datee);
                        ra_17 = pa_17.executeQuery();
                        if (ra_17.next()) {
                            female = ra_17.getString(1);
                            //System.out.println("E34323++++++++++++++++:" + ra_17.getString(1));
                        }
                        pa_19 = cox.prepareStatement(sql.gender_others);
                        pa_19.setInt(1, Integer.parseInt(region_id));
                        pa_19.setDate(2, datee);
                        ra_19 = pa_19.executeQuery();
                        if (ra_19.next()) {
                            gender_others = ra_19.getString(1);
                            //System.out.println("E34323++++++++++++++++:" + ra_19.getString(1));
                        }

                        pa_20_a = cox.prepareStatement(sql.gender_missing);
                        pa_20_a.setInt(1, Integer.parseInt(region_id));
                        pa_20_a.setDate(2, datee);
                        ra_20_a = pa_20_a.executeQuery();
                        if (ra_20_a.next()) {
                            gender_missing = ra_20_a.getString(1);
                            //System.out.println("E34323++++++++++++++++:" + ra_20.getString(1));
                        }

                        pa_18 = cox.prepareStatement(sql.not_confirmed_lab);
                        pa_18.setInt(1, Integer.parseInt(region_id));
                        pa_18.setDate(2, datee);
                        ra_18 = pa_18.executeQuery();
                        if (ra_18.next()) {
                            not_confirmed_lab = ra_18.getString(1);
                            //System.out.println("E34323++++++++++++++++:" + ra_18.getString(1));
                        }

                        /* Iyanu to fix confirmed_lab*/
                        pa_19 = cox.prepareStatement(sql.confirmed_lab);
                        pa_19.setInt(1, Integer.parseInt(region_id));
                        pa_19.setDate(2, datee);
                        ra_19 = pa_19.executeQuery();
                        if (ra_19.next()) {
                            confirmed_lab = ra_19.getString(1);
                            //System.out.println("E34323++++++++++++++++:" + ra_19.getString(1));
                        }
                     


                        //System.out.println(ra.getString(5) + " " + ad[0] + " " + ra.getString(4) + " " + ad[1] + " " + ra.getString(1) + " " + dtf.format(now) + " " + ra.getString(4) + " " + ra.getString(3) + " " + imported + " " + incountry);

                        SendToDHISServer.SendCasesToDHIS(ra.getString(4), ad[0], ra.getString(3), ad[1], ra.getString(1), dtf.format(now), ra.getString(4) + " Aggregate", ra.getString(6), imported, incountry, death, recover, not_det_rec, age_1, age_2, age_3, age_4, age_5, age_6, age_7, Occupation_Health_Worker, Occupation_Lab_Staff, Occupation_unknow_missing, Male, female, not_confirmed_lab, gender_others, gender_missing, confirmed_lab, confirmed_missing);

                    }
                } else {

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AggregrateController.class.getName()).log(Level.SEVERE, null, ex);
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
