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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Mathew Official
 */
@WebServlet(name = "extractor_Validatorx", urlPatterns = {"/seRtyTreSDfrEwertrfDrTyuiOlmNbvcdfGhyUiOLKMNbVCxDfgHJkIuytRd"})
public class casesToDHIS extends HttpServlet {

    private static String[] _url = ConffileCatcher.fileCatcher("passed");

    private static String httpx = _url[10].toString(); //should come from config file

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            casesExtractor.SormasCasePull("2");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(casesToDHIS.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
        
        

        StringBuilder sb = new StringBuilder();
        System.out.println("URI in use: " + httpx);

        String http = httpx + "/api/dataValueSets";

        HttpURLConnection urlConnection = null;
        String name = "admin";
        String password = "district";

        String authString = name + ":" + password;

        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);

        JSONObject json = new JSONObject();

        HttpSession session = request.getSession(false);

        JSONArray array = new JSONArray();

        String jsn = "";

        String ch = "";
        try {
            if (!"0".equals(casesUtilityClass.getAddress())) {
                JSONObject item1 = new JSONObject();
                item1.put("attribute", "XxNsLxPryII");
                item1.put("value", casesUtilityClass.getAddress());
                array.add(item1);
            }

            if (!"0".equals(casesUtilityClass.getAddtionaldetails())) {
                JSONObject item2 = new JSONObject();
                item2.put("attribute", "VqXyuGhuxuE");
                item2.put("value", casesUtilityClass.getAddtionaldetails());
                array.add(item2);
            }

            if (!"0".equals(casesUtilityClass.getApproximateage())) {
                JSONObject item3 = new JSONObject();
                item3.put("attribute", "tsHJlIHk7KX");
                item3.put("value", casesUtilityClass.getApproximateage());
                array.add(item3);
            }

            if (!"0".equals(casesUtilityClass.getApproximate_Age_Reference_Date())) {
                JSONObject item4 = new JSONObject();
                item4.put("attribute", "dfgND0rAxwx");
                item4.put("value", casesUtilityClass.getApproximate_Age_Reference_Date());
                array.add(item4);
            }

            if (!"0".equals(casesUtilityClass.getApproximateagetype())) {
                JSONObject item5 = new JSONObject();
                item5.put("attribute", "eYE9Ys4Pv13");
                item5.put("value", casesUtilityClass.getApproximateagetype());
                array.add(item5);
            }

            if (!"0".equals(casesUtilityClass.getArmedforcesrelationtype())) {
                JSONObject item6 = new JSONObject();
                item6.put("attribute", "mLZi1qXO2pQ");
                item6.put("value", casesUtilityClass.getArmedforcesrelationtype());
                array.add(item6);
            }

            if (!"0".equals(casesUtilityClass.getBirthcountry_Id())) {
                JSONObject item7 = new JSONObject();
                item7.put("attribute", "M3vZ3Mdnf6o");
                item7.put("value", casesUtilityClass.getBirthcountry_Id());
                array.add(item7);
            }

            if (!"0".equals(casesUtilityClass.getBirthdate())) {
                JSONObject item8 = new JSONObject();
                item8.put("attribute", "oCWV0f2sxis");
                item8.put("value", casesUtilityClass.getBirthdate());
                array.add(item8);
            }

            if (!"0".equals(casesUtilityClass.getBirthdate_Month())) {
                JSONObject item9 = new JSONObject();
                item9.put("attribute", "XPULLe1AlDb");
                item9.put("value", casesUtilityClass.getBirthdate_Month());
                array.add(item9);
            }

            if (!"0".equals(casesUtilityClass.getBirthdate_Year())) {
                JSONObject item10 = new JSONObject();
                item10.put("attribute", "o0Dyh5b05rp");
                item10.put("value", casesUtilityClass.getBirthdate_Year());
                array.add(item10);
            }

            if (!"0".equals(casesUtilityClass.getBirthname())) {
                JSONObject item11 = new JSONObject();
                item11.put("attribute", "Z5mheye9cnh");
                item11.put("value", casesUtilityClass.getBirthname());
                array.add(item11);
            }

            if (!"0".equals(casesUtilityClass.getBirthweight())) {
                JSONObject item12 = new JSONObject();
                item12.put("attribute", "ZGk5mKOzgiR");
                item12.put("value", casesUtilityClass.getBirthweight());
                array.add(item12);
            }

            if (!"0".equals(casesUtilityClass.getBurialconductor())) {
                JSONObject item13 = new JSONObject();
                item13.put("attribute", "HaslT0nEgnr");
                item13.put("value", casesUtilityClass.getBurialconductor());
                array.add(item13);
            }

            if (!"0".equals(casesUtilityClass.getBurialdate())) {
                JSONObject item14 = new JSONObject();
                item14.put("attribute", "hvtXOfmt4Qb");
                item14.put("value", casesUtilityClass.getBurialdate());
                array.add(item14);
            }

            if (!"0".equals(casesUtilityClass.getBurial_Place_Description())) {
                JSONObject item15 = new JSONObject();
                item15.put("attribute", "TJjrgmpChHz");
                item15.put("value", casesUtilityClass.getBurial_Place_Description());
                array.add(item15);
            }

            if (!"0".equals(casesUtilityClass.getCause_of_Death())) {
                JSONObject item16 = new JSONObject();
                item16.put("attribute", "MufojlUnIEd");
                item16.put("value", casesUtilityClass.getCause_of_Death());
                array.add(item16);
            }

            if (!"0".equals(casesUtilityClass.getCause_of_Death_Details())) {
                JSONObject item17 = new JSONObject();
                item17.put("attribute", "Hb4xpXS3TQu");
                item17.put("value", casesUtilityClass.getCause_of_Death_Details());
                array.add(item17);
            }

            if (!"0".equals(casesUtilityClass.getCause_of_Death_Disease())) {
                JSONObject item18 = new JSONObject();
                item18.put("attribute", "hg4gUcWErFp");
                item18.put("value", casesUtilityClass.getCause_of_Death_Disease());
                array.add(item18);
            }

            if (!"0".equals(casesUtilityClass.getChangedate())) {
                JSONObject item19 = new JSONObject();
                item19.put("attribute", "hFFqsqD4kT0");
                item19.put("value", casesUtilityClass.getChangedate());
                array.add(item19);
            }

            if (!"0".equals(casesUtilityClass.getChangedateofembeddedlists())) {
                JSONObject item20 = new JSONObject();
                item20.put("attribute", "TSgv8ZudO0f");
                item20.put("value", casesUtilityClass.getChangedateofembeddedlists());
                array.add(item20);
            }

            if (!"0".equals(casesUtilityClass.getCitizenship_Id())) {
                JSONObject item21 = new JSONObject();
                item21.put("attribute", "Sgs1VIgfX4j");
                item21.put("value", casesUtilityClass.getCitizenship_Id());
                array.add(item21);
            }

            if (!"0".equals(casesUtilityClass.getCovidcodedelivered())) {
                JSONObject item22 = new JSONObject();
                item22.put("attribute", "bWmjrf4AitB");
                item22.put("value", casesUtilityClass.getCovidcodedelivered());
                array.add(item22);
            }

            if (!"0".equals(casesUtilityClass.getCreationdate())) {
                JSONObject item23 = new JSONObject();
                item23.put("attribute", "WurCaUHAyBJ");
                item23.put("value", casesUtilityClass.getCreationdate());
                array.add(item23);
            }

            if (!"0".equals(casesUtilityClass.getDeathdate())) {
                JSONObject item24 = new JSONObject();
                item24.put("attribute", "I1ORM45qGbh");
                item24.put("value", casesUtilityClass.getDeathdate());
                array.add(item24);
            }

            if (!"0".equals(casesUtilityClass.getDeath_Place_Description())) {
                JSONObject item25 = new JSONObject();
                item25.put("attribute", "VTlWqzEIFSv");
                item25.put("value", casesUtilityClass.getDeath_Place_Description());
                array.add(item25);
            }

            if (!"0".equals(casesUtilityClass.getDeath_Place_Type())) {
                JSONObject item26 = new JSONObject();
                item26.put("attribute", "Pc2ldfKJtFy");
                item26.put("value", casesUtilityClass.getDeath_Place_Type());
                array.add(item26);
            }

            if (!"0".equals(casesUtilityClass.getEducation_Details())) {
                JSONObject item27 = new JSONObject();
                item27.put("attribute", "PD0SVt8XR4l");
                item27.put("value", casesUtilityClass.getEducation_Details());
                array.add(item27);
            }

            if (!"0".equals(casesUtilityClass.getEducation_Type())) {
                JSONObject item28 = new JSONObject();
                item28.put("attribute", "HZFAxasuJOI");
                item28.put("value", casesUtilityClass.getEducation_Type());
                array.add(item28);
            }

            if (!"0".equals(casesUtilityClass.getExternalid())) {
                JSONObject item29 = new JSONObject();
                item29.put("attribute", "fkVWF0svB4g");
                item29.put("value", casesUtilityClass.getExternalid());
                array.add(item29);
            }

            if (!"0".equals(casesUtilityClass.getExternaltoken())) {
                JSONObject item30 = new JSONObject();
                item30.put("attribute", "RWd5yoOeQjp");
                item30.put("value", casesUtilityClass.getExternaltoken());
                array.add(item30);
            }

            if (!"0".equals(casesUtilityClass.getFathersname())) {
                JSONObject item31 = new JSONObject();
                item31.put("attribute", "vgDMh9drlsV");
                item31.put("value", casesUtilityClass.getFathersname());
                array.add(item31);
            }

            if (!"0".equals(casesUtilityClass.getFirstname())) {
                JSONObject item32 = new JSONObject();
                item32.put("attribute", "x4Pp32qymyU");
                item32.put("value", casesUtilityClass.getFirstname());
                array.add(item32);
            }

            if (!"0".equals(casesUtilityClass.getGestationageatbirth())) {
                JSONObject item33 = new JSONObject();
                item33.put("attribute", "LKQ3J7Fvcfj");
                item33.put("value", casesUtilityClass.getGestationageatbirth());
                array.add(item33);
            }

            if (!"0".equals(casesUtilityClass.getHascovidapp())) {
                JSONObject item34 = new JSONObject();
                item34.put("attribute", "EXi1LHwoIH4");
                item34.put("value", casesUtilityClass.getHascovidapp());
                array.add(item34);
            }

            if (!"0".equals(casesUtilityClass.getMothersmaidenname())) {
                JSONObject item35 = new JSONObject();
                item35.put("attribute", "KuWNLbT59VK");
                item35.put("value", casesUtilityClass.getMothersmaidenname());
                array.add(item35);
            }

            if (!"0".equals(casesUtilityClass.getMothersname())) {
                JSONObject item36 = new JSONObject();
                item36.put("attribute", "GOXl2WRCvzk");
                item36.put("value", casesUtilityClass.getMothersname());
                array.add(item36);
            }

            if (!"0".equals(casesUtilityClass.getNameofguardians())) {
                JSONObject item37 = new JSONObject();
                item37.put("attribute", "Gce1HIZQSPi");
                item37.put("value", casesUtilityClass.getNameofguardians());
                array.add(item37);
            }

            if (!"0".equals(casesUtilityClass.getNationalhealth_Id())) {
                JSONObject item38 = new JSONObject();
                item38.put("attribute", "Knl5mCmHeoe");
                item38.put("value", casesUtilityClass.getNationalhealth_Id());
                array.add(item38);
            }

            if (!"0".equals(casesUtilityClass.getNickname())) {
                JSONObject item39 = new JSONObject();
                item39.put("attribute", "JW8GvhJ8WRE");
                item39.put("value", casesUtilityClass.getNickname());
                array.add(item39);
            }

            if (!"0".equals(casesUtilityClass.getOccupationdetails())) {
                JSONObject item40 = new JSONObject();
                item40.put("attribute", "y8q9aoPkS16");
                item40.put("value", casesUtilityClass.getOccupationdetails());
                array.add(item40);
            }

            if (!"0".equals(casesUtilityClass.getOccupationtype())) {
                JSONObject item41 = new JSONObject();
                item41.put("attribute", "RmIGQ2KKPli");
                item41.put("value", casesUtilityClass.getOccupationtype());
                array.add(item41);
            }

            if (!"0".equals(casesUtilityClass.getOthersalutation())) {
                JSONObject item42 = new JSONObject();
                item42.put("attribute", "I4HiyDM8ahe");
                item42.put("value", casesUtilityClass.getOthersalutation());
                array.add(item42);
            }

            if (!"0".equals(casesUtilityClass.getPassportnumber())) {
                JSONObject item43 = new JSONObject();
                item43.put("attribute", "pEAgbWScf1E");
                item43.put("value", casesUtilityClass.getPassportnumber());
                array.add(item43);
            }

            if (!"0".equals(casesUtilityClass.getPlaceofbirthcommunity_Id())) {
                JSONObject item44 = new JSONObject();
                item44.put("attribute", "PKxZ44UH1Cu");
                item44.put("value", casesUtilityClass.getPlaceofbirthcommunity_Id());
                array.add(item44);
            }

            if (!"0".equals(casesUtilityClass.getPlaceofbirthdistrict_Id())) {
                JSONObject item45 = new JSONObject();
                item45.put("attribute", "jEHukc3crc6");
                item45.put("value", casesUtilityClass.getPlaceofbirthdistrict_Id());
                array.add(item45);
            }

            if (!"0".equals(casesUtilityClass.getPlaceofbirthfacilitydetails())) {
                JSONObject item46 = new JSONObject();
                item46.put("attribute", "uXp1WM8rsUI");
                item46.put("value", casesUtilityClass.getPlaceofbirthfacilitydetails());
                array.add(item46);
            }

            if (!"0".equals(casesUtilityClass.getPlaceofbirthfacility_Id())) {
                JSONObject item47 = new JSONObject();
                item47.put("attribute", "ZrfExB7PUbh");
                item47.put("value", casesUtilityClass.getPlaceofbirthfacility_Id());
                array.add(item47);
            }

            if (!"0".equals(casesUtilityClass.getPlaceofbirthfacilitytype())) {
                JSONObject item48 = new JSONObject();
                item48.put("attribute", "Fh0oNLphfrL");
                item48.put("value", casesUtilityClass.getPlaceofbirthfacilitytype());
                array.add(item48);
            }

            if (!"0".equals(casesUtilityClass.getPlaceofbirthregion_Id())) {
                JSONObject item49 = new JSONObject();
                item49.put("attribute", "OB1sraeAT66");
                item49.put("value", casesUtilityClass.getPlaceofbirthregion_Id());
                array.add(item49);
            }

            if (!"0".equals(casesUtilityClass.getPresentcondition())) {
                JSONObject item50 = new JSONObject();
                item50.put("attribute", "BSi8EPzDB2Q");
                item50.put("value", casesUtilityClass.getPresentcondition());
                array.add(item50);
            }

            if (!"0".equals(casesUtilityClass.getSalutation())) {
                JSONObject item51 = new JSONObject();
                item51.put("attribute", "NrQFvxfQxBH");
                item51.put("value", casesUtilityClass.getSalutation());
                array.add(item51);
            }

            if (!"0".equals(casesUtilityClass.getSex())) {
                JSONObject item52 = new JSONObject();
                item52.put("attribute", "g35n9RVhyNR");
                item52.put("value", casesUtilityClass.getSex());
                array.add(item52);
            }

            if (!"0".equals(casesUtilityClass.getSormas_System_Period())) {
                JSONObject item53 = new JSONObject();
                item53.put("attribute", "tCkzllgpm5W");
                item53.put("value", casesUtilityClass.getSormas_System_Period());
                array.add(item53);
            }

            if (!"0".equals(casesUtilityClass.getSRM_Uuid())) {
                JSONObject item54 = new JSONObject();
                item54.put("attribute", "pNXLhx1ZgV6");
                item54.put("value", casesUtilityClass.getSRM_Uuid());
                array.add(item54);
            }

            if (!"0".equals(casesUtilityClass.getSymptomjournalstatus())) {
                JSONObject item55 = new JSONObject();
                item55.put("attribute", "XdX3y3Ghptq");
                item55.put("value", casesUtilityClass.getSymptomjournalstatus());
                array.add(item55);
            }

            json.put("attributes", array);

            json.put("orgUnit", "");
            json.put("trackedEntityType", "ag6Yk7fwUEe");

            //enrollment data
            JSONArray arr_1 = new JSONArray();
            JSONObject js_1 = new JSONObject();
            js_1.put("orgUnit", "");
            js_1.put("program", "gWuxRU2yJ1x");
            js_1.put("enrollmentDate", "");
            js_1.put("incidentDate", "");
            arr_1.add(js_1);

            json.put("enrollments", arr_1);

            //System.out.println(json.toString());
        } finally {

            String pg_url = "https://nphcdaict.com.ng/dhis2/api/29/trackedEntityInstances";

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
                    sb = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();

                    //debu
                    //  //System.out.println("data sent to DHIS2" + sb.toString());
                    if (sb.toString().indexOf("conflict") >= 1) {
                        //      response.setStatus(200);
                        System.err.println("STATUS: CONFLICTS!" + sb.toString());

                        String dd = sb.toString();
                        String dx = dd.substring(dd.indexOf("reference"));
                        String cl = dx.replaceAll("\"", "").replaceAll(",", "");
                        String dw = cl.substring(cl.indexOf(":"));
                        String du = dw.substring(0, dw.indexOf("href"));
                        ////System.out.println(du.replaceAll(":", ""));

                        // getDemAllENROLLMENT_REG("", du.replaceAll(":", ""));
                        ch = du.replaceAll(":", "");
                    } else if (sb.toString().indexOf("success") >= 1) {
                        //      response.setStatus(200);
                        System.err.println("STATUS: Success!");

                        String dd = sb.toString();
                        String dx = dd.substring(dd.indexOf("reference"));
                        String cl = dx.replaceAll("\"", "").replaceAll(",", "");
                        String dw = cl.substring(cl.indexOf(":"));
                        String du = dw.substring(0, dw.indexOf("href"));
                        //  System.out.println(dw.replaceAll(":", ""));
                        System.out.println(du.replaceAll(":", ""));

                        ch = du.replaceAll(":", "");
                    } else if (sb.toString().indexOf("warning") >= 1) {
                        //        response.setStatus(300);
                        System.err.println("STATUS: Warning!" + sb.toString());
                        String dd = sb.toString();
                        String dx = dd.substring(dd.indexOf("reference"));
                        String cl = dx.replaceAll("\"", "").replaceAll(",", "");
                        String dw = cl.substring(cl.indexOf(":"));
                        String du = dw.substring(0, dw.indexOf("href"));
                        //  System.out.println(dw.replaceAll(":", ""));
                        System.out.println(du.replaceAll(":", ""));

                        ch = du.replaceAll(":", "");
                    }

                } else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream(), "utf-8"));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    System.err.println("STATUS: ERROR!" + sb.toString());

                    ch = "0";
                }

            } catch (IOException ex) {
            } finally {

            }
        }

        // addrecordsLS(jsn, ch);
        if (ch == "0" || "0".equals(ch)) {
            // session.setAttribute("prevacccc", "true");

            String senz = "Error Found: Please try again later.";

            System.out.println(senz);

            //    response.sendRedirect("VacRegError.jsp?qr=" + senz);
        }

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
            System.out.print("SQLException:_________________________________________________________________________________ " + ex.getMessage());
            System.out.print("SQLState: ________________________________________________________________ " + ex.getSQLState());
            System.out.print("VendorError: " + ex.getErrorCode());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(casesToDHIS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
