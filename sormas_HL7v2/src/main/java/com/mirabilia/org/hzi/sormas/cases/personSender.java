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
package com.mirabilia.org.hzi.sormas.cases;

import com.mirabilia.org.hzi.sormas.aggregate.SendToDHISServer;
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
public class personSender {

    private static String[] _url = ConffileCatcher.fileCatcher("passed");

    private static String httpx = _url[10].toString();

    public static void jsonDHISSender() {
        StringBuilder sb = new StringBuilder();

        //     System.out.println("URI in use: " + httpx);
        // String http = httpx + "/api/dataValueSets";
        HttpURLConnection urlConnection = null;
        String name = "admin";
        String password = "Test-123";

        String authString = name + ":" + password;

        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);

        JSONObject json = new JSONObject();

        JSONArray array = new JSONArray();

        String jsn = "";

        String ch = "";

        try {
            if (!"0".equals(personCasesUtilityClass.getAddress())) {
                JSONObject item1 = new JSONObject();
                item1.put("attribute", "XxNsLxPryII");
                item1.put("value", personCasesUtilityClass.getAddress());
                array.add(item1);
            }

            if (!"0".equals(personCasesUtilityClass.getAddtionaldetails())) {
                JSONObject item2 = new JSONObject();
                item2.put("attribute", "VqXyuGhuxuE");
                item2.put("value", personCasesUtilityClass.getAddtionaldetails());
                array.add(item2);
            }

            if (!"0".equals(personCasesUtilityClass.getApproximateage())) {
                JSONObject item3 = new JSONObject();
                item3.put("attribute", "tsHJlIHk7KX");
                item3.put("value", personCasesUtilityClass.getApproximateage());
                array.add(item3);
            }

            if (!"0".equals(personCasesUtilityClass.getApproximate_Age_Reference_Date())) {
                JSONObject item4 = new JSONObject();
                item4.put("attribute", "dfgND0rAxwx");
                item4.put("value", personCasesUtilityClass.getApproximate_Age_Reference_Date());
                array.add(item4);
            }

            if (!"0".equals(personCasesUtilityClass.getApproximateagetype())) {
                JSONObject item5 = new JSONObject();
                item5.put("attribute", "eYE9Ys4Pv13");
                item5.put("value", personCasesUtilityClass.getApproximateagetype());
                array.add(item5);
            }

            if (!"0".equals(personCasesUtilityClass.getArmedforcesrelationtype())) {
                JSONObject item6 = new JSONObject();
                item6.put("attribute", "mLZi1qXO2pQ");
                item6.put("value", personCasesUtilityClass.getArmedforcesrelationtype());
                array.add(item6);
            }

            if (!"0".equals(personCasesUtilityClass.getBirthcountry_Id())) {
                JSONObject item7 = new JSONObject();
                item7.put("attribute", "M3vZ3Mdnf6o");
                item7.put("value", personCasesUtilityClass.getBirthcountry_Id());
                array.add(item7);
            }

            if (!"0".equals(personCasesUtilityClass.getBirthdate())) {
                JSONObject item8 = new JSONObject();
                item8.put("attribute", "oCWV0f2sxis");
                item8.put("value", personCasesUtilityClass.getBirthdate());
                array.add(item8);
            }

            if (!"0".equals(personCasesUtilityClass.getBirthdate_Month())) {
                JSONObject item9 = new JSONObject();
                item9.put("attribute", "XPULLe1AlDb");
                item9.put("value", personCasesUtilityClass.getBirthdate_Month());
                array.add(item9);
            }

            if (!"0".equals(personCasesUtilityClass.getBirthdate_Year())) {
                JSONObject item10 = new JSONObject();
                item10.put("attribute", "o0Dyh5b05rp");
                item10.put("value", personCasesUtilityClass.getBirthdate_Year());
                array.add(item10);
            }

            if (!"0".equals(personCasesUtilityClass.getBirthname())) {
                JSONObject item11 = new JSONObject();
                item11.put("attribute", "Z5mheye9cnh");
                item11.put("value", personCasesUtilityClass.getBirthname());
                array.add(item11);
            }

            if (!"0".equals(personCasesUtilityClass.getBirthweight())) {
                JSONObject item12 = new JSONObject();
                item12.put("attribute", "ZGk5mKOzgiR");
                item12.put("value", personCasesUtilityClass.getBirthweight());
                array.add(item12);
            }

            if (!"0".equals(personCasesUtilityClass.getBurialconductor())) {
                JSONObject item13 = new JSONObject();
                item13.put("attribute", "HaslT0nEgnr");
                item13.put("value", personCasesUtilityClass.getBurialconductor());
                array.add(item13);
            }

            if (!"0".equals(personCasesUtilityClass.getBurialdate())) {
                JSONObject item14 = new JSONObject();
                item14.put("attribute", "hvtXOfmt4Qb");
                item14.put("value", personCasesUtilityClass.getBurialdate());
                array.add(item14);
            }

            if (!"0".equals(personCasesUtilityClass.getBurial_Place_Description())) {
                JSONObject item15 = new JSONObject();
                item15.put("attribute", "TJjrgmpChHz");
                item15.put("value", personCasesUtilityClass.getBurial_Place_Description());
                array.add(item15);
            }

            if (!"0".equals(personCasesUtilityClass.getCause_of_Death())) {
                JSONObject item16 = new JSONObject();
                item16.put("attribute", "MufojlUnIEd");
                item16.put("value", personCasesUtilityClass.getCause_of_Death());
                array.add(item16);
            }

            if (!"0".equals(personCasesUtilityClass.getCause_of_Death_Details())) {
                JSONObject item17 = new JSONObject();
                item17.put("attribute", "Hb4xpXS3TQu");
                item17.put("value", personCasesUtilityClass.getCause_of_Death_Details());
                array.add(item17);
            }

            if (!"0".equals(personCasesUtilityClass.getCause_of_Death_Disease())) {
                JSONObject item18 = new JSONObject();
                item18.put("attribute", "hg4gUcWErFp");
                item18.put("value", personCasesUtilityClass.getCause_of_Death_Disease());
                array.add(item18);
            }

            if (!"0".equals(personCasesUtilityClass.getChangedate())) {
                JSONObject item19 = new JSONObject();
                item19.put("attribute", "hFFqsqD4kT0");
                item19.put("value", personCasesUtilityClass.getChangedate());
                array.add(item19);
            }

            if (!"0".equals(personCasesUtilityClass.getChangedateofembeddedlists())) {
                JSONObject item20 = new JSONObject();
                item20.put("attribute", "TSgv8ZudO0f");
                item20.put("value", personCasesUtilityClass.getChangedateofembeddedlists());
                array.add(item20);
            }

            if (!"0".equals(personCasesUtilityClass.getCitizenship_Id())) {
                JSONObject item21 = new JSONObject();
                item21.put("attribute", "Sgs1VIgfX4j");
                item21.put("value", personCasesUtilityClass.getCitizenship_Id());
                array.add(item21);
            }

            if (!"0".equals(personCasesUtilityClass.getCovidcodedelivered())) {
                JSONObject item22 = new JSONObject();
                item22.put("attribute", "bWmjrf4AitB");
                item22.put("value", "f".equals(personCasesUtilityClass.getCovidcodedelivered()) ? "false" : "true");
                array.add(item22);
            }

            if (!"0".equals(personCasesUtilityClass.getCreationdate())) {
                JSONObject item23 = new JSONObject();
                item23.put("attribute", "WurCaUHAyBJ");
                item23.put("value", personCasesUtilityClass.getCreationdate());
                array.add(item23);
            }

            if (!"0".equals(personCasesUtilityClass.getDeathdate())) {
                JSONObject item24 = new JSONObject();
                item24.put("attribute", "I1ORM45qGbh");
                item24.put("value", personCasesUtilityClass.getDeathdate());
                array.add(item24);
            }

            if (!"0".equals(personCasesUtilityClass.getDeath_Place_Description())) {
                JSONObject item25 = new JSONObject();
                item25.put("attribute", "VTlWqzEIFSv");
                item25.put("value", personCasesUtilityClass.getDeath_Place_Description());
                array.add(item25);
            }

            if (!"0".equals(personCasesUtilityClass.getDeath_Place_Type())) {
                JSONObject item26 = new JSONObject();
                item26.put("attribute", "Pc2ldfKJtFy");
                item26.put("value", personCasesUtilityClass.getDeath_Place_Type());
                array.add(item26);
            }

            if (!"0".equals(personCasesUtilityClass.getEducation_Details())) {
                JSONObject item27 = new JSONObject();
                item27.put("attribute", "PD0SVt8XR4l");
                item27.put("value", personCasesUtilityClass.getEducation_Details());
                array.add(item27);
            }

            if (!"0".equals(personCasesUtilityClass.getEducation_Type())) {
                JSONObject item28 = new JSONObject();
                item28.put("attribute", "HZFAxasuJOI");
                item28.put("value", personCasesUtilityClass.getEducation_Type());
                array.add(item28);
            }

            if (!"0".equals(personCasesUtilityClass.getExternalid())) {
                JSONObject item29 = new JSONObject();
                item29.put("attribute", "fkVWF0svB4g");
                item29.put("value", personCasesUtilityClass.getExternalid());
                array.add(item29);
            }

            if (!"0".equals(personCasesUtilityClass.getExternaltoken())) {
                JSONObject item30 = new JSONObject();
                item30.put("attribute", "RWd5yoOeQjp");
                item30.put("value", personCasesUtilityClass.getExternaltoken());
                array.add(item30);
            }

            if (!"0".equals(personCasesUtilityClass.getFathersname())) {
                JSONObject item31 = new JSONObject();
                item31.put("attribute", "vgDMh9drlsV");
                item31.put("value", personCasesUtilityClass.getFathersname());
                array.add(item31);
            }

            if (!"0".equals(personCasesUtilityClass.getFirstname())) {
                JSONObject item32 = new JSONObject();
                item32.put("attribute", "x4Pp32qymyU");
                item32.put("value", personCasesUtilityClass.getFirstname());
                array.add(item32);
            }

            if (!"0".equals(personCasesUtilityClass.getGestationageatbirth())) {
                JSONObject item33 = new JSONObject();
                item33.put("attribute", "LKQ3J7Fvcfj");
                item33.put("value", personCasesUtilityClass.getGestationageatbirth());
                array.add(item33);
            }

            if (!"0".equals(personCasesUtilityClass.getHascovidapp())) {
                JSONObject item34 = new JSONObject();
                item34.put("attribute", "EXi1LHwoIH4");
                item34.put("value", "f".equals(personCasesUtilityClass.getHascovidapp()) ? "false" : "true");
                array.add(item34);
            }

            if (!"0".equals(personCasesUtilityClass.getMothersmaidenname())) {
                JSONObject item35 = new JSONObject();
                item35.put("attribute", "KuWNLbT59VK");
                item35.put("value", personCasesUtilityClass.getMothersmaidenname());
                array.add(item35);
            }

            if (!"0".equals(personCasesUtilityClass.getMothersname())) {
                JSONObject item36 = new JSONObject();
                item36.put("attribute", "GOXl2WRCvzk");
                item36.put("value", personCasesUtilityClass.getMothersname());
                array.add(item36);
            }

            if (!"0".equals(personCasesUtilityClass.getNameofguardians())) {
                JSONObject item37 = new JSONObject();
                item37.put("attribute", "Gce1HIZQSPi");
                item37.put("value", personCasesUtilityClass.getNameofguardians());
                array.add(item37);
            }

            if (!"0".equals(personCasesUtilityClass.getNationalhealth_Id())) {
                JSONObject item38 = new JSONObject();
                item38.put("attribute", "Knl5mCmHeoe");
                item38.put("value", personCasesUtilityClass.getNationalhealth_Id());
                array.add(item38);
            }

            if (!"0".equals(personCasesUtilityClass.getNickname())) {
                JSONObject item39 = new JSONObject();
                item39.put("attribute", "JW8GvhJ8WRE");
                item39.put("value", personCasesUtilityClass.getNickname());
                array.add(item39);
            }

            if (!"0".equals(personCasesUtilityClass.getOccupationdetails())) {
                JSONObject item40 = new JSONObject();
                item40.put("attribute", "y8q9aoPkS16");
                item40.put("value", personCasesUtilityClass.getOccupationdetails());
                array.add(item40);
            }

            if (!"0".equals(personCasesUtilityClass.getOccupationtype())) {
                JSONObject item41 = new JSONObject();
                item41.put("attribute", "RmIGQ2KKPli");
                item41.put("value", personCasesUtilityClass.getOccupationtype());
                array.add(item41);
            }

            if (!"0".equals(personCasesUtilityClass.getOthersalutation())) {
                JSONObject item42 = new JSONObject();
                item42.put("attribute", "I4HiyDM8ahe");
                item42.put("value", personCasesUtilityClass.getOthersalutation());
                array.add(item42);
            }

            if (!"0".equals(personCasesUtilityClass.getPassportnumber())) {
                JSONObject item43 = new JSONObject();
                item43.put("attribute", "pEAgbWScf1E");
                item43.put("value", personCasesUtilityClass.getPassportnumber());
                array.add(item43);
            }

            if (!"0".equals(personCasesUtilityClass.getPlaceofbirthcommunity_Id())) {
                JSONObject item44 = new JSONObject();
                item44.put("attribute", "PKxZ44UH1Cu");
                item44.put("value", personCasesUtilityClass.getPlaceofbirthcommunity_Id());
                array.add(item44);
            }

            if (!"0".equals(personCasesUtilityClass.getPlaceofbirthdistrict_Id())) {
                JSONObject item45 = new JSONObject();
                item45.put("attribute", "jEHukc3crc6");
                item45.put("value", personCasesUtilityClass.getPlaceofbirthdistrict_Id());
                array.add(item45);
            }

            if (!"0".equals(personCasesUtilityClass.getPlaceofbirthfacilitydetails())) {
                JSONObject item46 = new JSONObject();
                item46.put("attribute", "uXp1WM8rsUI");
                item46.put("value", personCasesUtilityClass.getPlaceofbirthfacilitydetails());
                array.add(item46);
            }

            if (!"0".equals(personCasesUtilityClass.getPlaceofbirthfacility_Id())) {
                JSONObject item47 = new JSONObject();
                item47.put("attribute", "ZrfExB7PUbh");
                item47.put("value", personCasesUtilityClass.getPlaceofbirthfacility_Id());
                array.add(item47);
            }

            if (!"0".equals(personCasesUtilityClass.getPlaceofbirthfacilitytype())) {
                JSONObject item48 = new JSONObject();
                item48.put("attribute", "Fh0oNLphfrL");
                item48.put("value", personCasesUtilityClass.getPlaceofbirthfacilitytype());
                array.add(item48);
            }

            if (!"0".equals(personCasesUtilityClass.getPlaceofbirthregion_Id())) {
                JSONObject item49 = new JSONObject();
                item49.put("attribute", "OB1sraeAT66");
                item49.put("value", personCasesUtilityClass.getPlaceofbirthregion_Id());
                array.add(item49);
            }

            if (!"0".equals(personCasesUtilityClass.getPresentcondition())) {
                JSONObject item50 = new JSONObject();
                item50.put("attribute", "BSi8EPzDB2Q");
                item50.put("value", personCasesUtilityClass.getPresentcondition());
                array.add(item50);
            }

            if (!"0".equals(personCasesUtilityClass.getSalutation())) {
                JSONObject item51 = new JSONObject();
                item51.put("attribute", "NrQFvxfQxBH");
                item51.put("value", personCasesUtilityClass.getSalutation());
                array.add(item51);
            }

            if (!"0".equals(personCasesUtilityClass.getSex())) {
                JSONObject item52 = new JSONObject();
                item52.put("attribute", "g35n9RVhyNR");
                item52.put("value", personCasesUtilityClass.getSex());
                array.add(item52);
            }

            if (!"0".equals(personCasesUtilityClass.getSormas_System_Period())) {
                JSONObject item53 = new JSONObject();
                item53.put("attribute", "tCkzllgpm5W");
                item53.put("value", personCasesUtilityClass.getSormas_System_Period());
                array.add(item53);
            }

            if (!"0".equals(personCasesUtilityClass.getSRM_Uuid())) {
                JSONObject item54 = new JSONObject();
                item54.put("attribute", "pNXLhx1ZgV6");
                item54.put("value", personCasesUtilityClass.getSRM_Uuid());
                array.add(item54);
            }

            if (!"0".equals(personCasesUtilityClass.getSymptomjournalstatus())) {
                JSONObject item55 = new JSONObject();
                item55.put("attribute", "XdX3y3Ghptq");
                item55.put("value", personCasesUtilityClass.getSymptomjournalstatus());
                array.add(item55);
            }

            json.put("attributes", array);

            json.put("orgUnit", personCasesUtilityClass.getExternal_id());
            json.put("trackedEntityType", "XBrd5VNB5j2");

            //enrollment data
            JSONArray arr_1 = new JSONArray();
            JSONObject js_1 = new JSONObject();
            js_1.put("orgUnit", personCasesUtilityClass.getExternal_id());
            js_1.put("program", "m0lmvyTblN0");
            js_1.put("enrollmentDate", personCasesUtilityClass.getCreationdate());
            //  js_1.put("incidentDate", "");
            arr_1.add(js_1);

            json.put("enrollments", arr_1);

            //System.out.println(json.toString());
        } finally {

            String pg_url = httpx + "/api/29/trackedEntityInstances";

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
                //  System.err.println(json_all);

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
                        SendToDHISServer.update_PSQL_oneParm_X("update person set externalid = ? where uuid = ?", ch, personCasesUtilityClass.getSRM_Uuid());

                        String wx = sb.toString();
                        System.err.println("Response: Successful! " + wx);
                        SendToDHISServer.update_oneParm_X("insert into sync_tracker set json_response = ?, datasource= '" + personCasesUtilityClass.getSRM_Uuid() + "', dataperiod = '" + personCasesUtilityClass.getCreationdate() + "', case_specific_detail = 'Person Table', status = 'ok', created = now()", sb.toString());
                        return;
                    }

                    if (sb.toString().contains("WARNING")) {
                        // response.setStatus(300);
                        String wx = sb.toString();
                        System.err.println("WARNING/CONFLICT Found " + sb.toString());
                        SendToDHISServer.update_oneParm_X("insert into sync_tracker set json_response = ?, datasource= '" + personCasesUtilityClass.getSRM_Uuid() + "', dataperiod = '" + personCasesUtilityClass.getCreationdate() + "', case_specific_detail = 'Person Table', status = 'WARNING', created = now()", sb.toString());
                        return;
                    }

                    if (sb.toString().contains("ERROR")) {
                        // response.setStatus(300);
                        String wx = sb.toString();
                        System.err.println("ERROR Found " + wx);
                        SendToDHISServer.update_oneParm_X("insert into sync_tracker set json_response = ?, datasource= '" + personCasesUtilityClass.getSRM_Uuid() + "', dataperiod = '" + personCasesUtilityClass.getCreationdate() + "', case_specific_detail = 'Person Table',  status = 'ERROR', created = now()", sb.toString());
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
                Logger.getLogger(personSender.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(personSender.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(personCasesToDHIS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
