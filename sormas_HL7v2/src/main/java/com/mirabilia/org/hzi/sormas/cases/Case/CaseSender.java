/*
 * Copyright (c) 2021, Mathew Official
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
package com.mirabilia.org.hzi.sormas.cases.Case;

import com.mirabilia.org.hzi.Util.credentialsManagerUtil;
import com.mirabilia.org.hzi.sormas.aggregate.SendToDHISServer;
import com.mirabilia.org.hzi.sormas.cases.Sample.SampleUtilityClass;
import com.mirabilia.org.hzi.sormas.doa.ConffileCatcher;
import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Mathew Official
 */
public class CaseSender {

    private static String[] _url = ConffileCatcher.fileCatcher("passed");

    private static String httpx = _url[10].toString();

    public static void jsonDHISSender() {
        StringBuilder sb = new StringBuilder();

        //     System.out.println("URI in use: " + httpx);
        // String http = httpx + "/api/dataValueSets";
        HttpURLConnection urlConnection = null;
        String name = credentialsManagerUtil.getDhis_User();
        String password = credentialsManagerUtil.getDhis_pawd();

        String authString = name + ":" + password;

        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);

        JSONObject json = new JSONObject();

        JSONArray array = new JSONArray();
        JSONArray arrayx = new JSONArray();

        String jsn = "";

        String ch = "";

        try {
            if (!"0".equals(CasesUtilityClass.getC_id())) {
                JSONObject item1 = new JSONObject();
                item1.put("dataElement", "eyoiseFH2aB");
                item1.put("value", CasesUtilityClass.getC_id());
                array.add(item1);
            }

            if (!"0".equals(CasesUtilityClass.getCaseage())) {
                JSONObject item2 = new JSONObject();
                item2.put("dataElement", "NtWkt9r3TJu");
                item2.put("value", CasesUtilityClass.getCaseage());
                array.add(item2);
            }

            if (!"0".equals(CasesUtilityClass.getCaseclassification())) {
                JSONObject item3 = new JSONObject();
                item3.put("dataElement", "prU4HZDrtYl");
                item3.put("value", CasesUtilityClass.getCaseclassification());
                array.add(item3);
            }

            if (!"0".equals(CasesUtilityClass.getCaseorigin())) {
                JSONObject item4 = new JSONObject();
                item4.put("dataElement", "x8etmrR5884");
                item4.put("value", CasesUtilityClass.getCaseorigin());
                array.add(item4);
            }

            if (!"0".equals(CasesUtilityClass.getDisease())) {
                JSONObject item5 = new JSONObject();
                item5.put("dataElement", "eKalSNxZYlq");
                item5.put("value", CasesUtilityClass.getDisease());
                array.add(item5);
            }

            if (!"0".equals(CasesUtilityClass.getOutcome())) {
                JSONObject item6 = new JSONObject();
                item6.put("dataElement", "QuvnkUXjRE0");
                item6.put("value", CasesUtilityClass.getOutcome());
                array.add(item6);
            }


            json.put("dataValues", array);
            /*
            if (!"0".equals(CasesUtilityClass.getCaseLat())) {
                JSONObject item6x = new JSONObject();
                item6x.put("dataElement", "VFo2tMYKJuP");
                item6x.put("value", CasesUtilityClass.getCaseLat());
                arrayx.add(item6x);
            }
            
            if (!"0".equals(CasesUtilityClass.getCaseLong())) {
                JSONObject item6n = new JSONObject();
                item6n.put("dataElement", "PNqDfIUdBb2");
                item6n.put("value", CasesUtilityClass.getCaseLong());
                arrayx.add(item6n);
            }
            
            json.put("geometry", arrayx);

            */
            
            
            
            //enrollment data
            json.put("program", "m0lmvyTblN0");
            json.put("orgUnit", CasesUtilityClass.getExternal_id());
            json.put("eventDate", CasesUtilityClass.getCreationdate());
            json.put("status", "m0lmvyTblN0");
            json.put("completedDate", "m0lmvyTblN0");
            json.put("program", "m0lmvyTblN0");
            
            
            
            json.put("program", "m0lmvyTblN0");
            json.put("orgUnit",  CasesUtilityClass.getRedgion_id());
            json.put("eventDate", CasesUtilityClass.getCreationdate());
            json.put("status", "COMPLETED");
            json.put("completedDate", CasesUtilityClass.getCreationdate());
            json.put("programStage", "cSlBpW1TXVQ");
            json.put("trackedEntityInstance", CasesUtilityClass.getTrackedentity_id());

        } finally {

            String pg_url = httpx + "/api/29/events";

            try {

                TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(
                                java.security.cert.X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(
                                java.security.cert.X509Certificate[] certs, String authType) {
                        }
                    }
                };

// Install the all-trusting trust manager
                try {
                    SSLContext sc = SSLContext.getInstance("SSL");
                    sc.init(null, trustAllCerts, new java.security.SecureRandom());
                    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                } catch (Exception e) {
                }

                // Now you can access an https URL without having the certificate in the truststore
                URL url = new URL(pg_url);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");
                urlConnection.setUseCaches(true);
                urlConnection.setConnectTimeout(10000);
                urlConnection.setReadTimeout(10000);
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.connect();

                String json_all = json.toString();
                jsn = json_all;
                  System.err.println(json_all);

                OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
                out.write(json_all);
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

                        String dd = sb.toString();
                        String dx = dd.substring(dd.indexOf("reference"));
                        String cl = dx.replaceAll("\"", "").replaceAll(",", "");
                        String dw = cl.substring(cl.indexOf(":"));
                        String du = dw.substring(0, dw.indexOf("href"));
                        //  System.out.println(dw.replaceAll(":", ""));
                        System.out.println(du.replaceAll(":", ""));

                        ch = du.replaceAll(":", "");
                        SendToDHISServer.update_PSQL_oneParm_XINT("update cases set externalid = ? where id = ?", ch, CasesUtilityClass.getC_id());

                        String wx = sb.toString();
                        System.err.println("Response: Successful! " + wx);
                        SendToDHISServer.update_oneParm_X("insert into sync_tracker set json_response = ?, datasource= '" + CasesUtilityClass.getC_id() + "', dataperiod = '" + CasesUtilityClass.getCreationdate() + "', case_specific_detail = 'Person Table', status = 'ok', created = now()", sb.toString());
                        return;
                    }

                    if (sb.toString().contains("WARNING")) {
                        // response.setStatus(300);
                        String wx = sb.toString();
                        System.err.println("WARNING/CONFLICT Found " + sb.toString());
                        SendToDHISServer.update_oneParm_X("insert into sync_tracker set json_response = ?, datasource= '" + CasesUtilityClass.getC_id() + "', dataperiod = '" + CasesUtilityClass.getCreationdate() + "', case_specific_detail = 'Person Table', status = 'WARNING', created = now()", sb.toString());
                        return;
                    }

                    if (sb.toString().contains("ERROR")) {
                        // response.setStatus(300);
                        String wx = sb.toString();
                        System.err.println("ERROR Found " + wx);
                        SendToDHISServer.update_oneParm_X("insert into sync_tracker set json_response = ?, datasource= '" + CasesUtilityClass.getC_id() + "', dataperiod = '" + CasesUtilityClass.getCreationdate() + "', case_specific_detail = 'Person Table',  status = 'ERROR', created = now()", sb.toString());
                        return;
                    }

                } else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream(), "utf-8"));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    System.err.println("STATUS: ERROR!" + sb.toString());

                    System.out.println(urlConnection.getResponseMessage());

                    return;

                }

            } catch (IOException ex) {
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CaseSender.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CaseSender.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

            }
        }

        // addrecordsLS(jsn, ch);
        if (ch
                == "0" || "0".equals(ch)) {
            // session.setAttribute("prevacccc", "true");

            String senz = "Error Found: Please try again later.";

            System.out.println(senz);

            //    response.sendRedirect("VacRegError.jsp?qr=" + senz);
        }

    }

    private String CalDOBfromAge(int dobYear) {
        String jj = "";

        LocalDate now = LocalDate.now();
        LocalDate dob = now.minusYears(dobYear);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");//1953-08-06
        //System.out.println(dob.format(formatter));

        return dob.format(formatter);
    }

    public void addrecordsLS(String aa, String bb, String cc, String tm, String dt, String uid, String vacc, String jsn, String ch) {
        PreparedStatement ps;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DbConnector.getConnection();
            ps = conn.prepareStatement("insert into submisx (lname,fname,phonex,tim,dat,hf_uid,vaccno,datax, trackid) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, aa);
            ps.setString(2, bb);
            ps.setString(3, cc);
            ps.setString(4, tm);
            ps.setString(5, dt);
            ps.setString(6, uid);
            ps.setString(7, vacc);
            ps.setString(8, jsn);
            ps.setString(9, ch);
            ps.execute();
            //   System.out.print(ps.toString());
            conn.close();
        } catch (SQLException ex) {
            System.out.print("SQLException:------ " + ex.getMessage());
            System.out.print("SQLState:------" + ex.getSQLState());
            System.out.print("VendorError: " + ex.getErrorCode());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CaseSender.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
