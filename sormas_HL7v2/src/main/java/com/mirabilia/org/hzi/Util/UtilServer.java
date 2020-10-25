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

import com.mirabilia.org.hzi.Strings.sql;
import com.mirabilia.org.hzi.sormas.cases.AggregrateController;
import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mathew Official
 */
@WebServlet(name = "iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678", urlPatterns = {"/iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678"})
public class UtilServer extends HttpServlet {

    private static String mat = "";
    private static int nox = 0;

    private static int re_g = 0;
    private static int ds_c = 0;
    private static int com_m = 0;
    private static int fac_l = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession(false);

        // System.out.println("Yes... hit the Sevlets DEBUG");
        if (request.getParameter("count") != null) {
            try {

                mat = counterX("SELECT COUNT(*) FROM sormas_local d WHERE d.externalid != 'null' AND d.duplicate_with IS NULL or d.duplicate_with = '';"); //counts all MATCHED

                mat = counterX("SELECT COUNT(*) FROM sormas_local d WHERE d.externalid != 'null' AND d.duplicate_with IS not NULL and d.duplicate_with != '';") + "," + mat; //counting all possible duplicate

                mat = counterX("SELECT COUNT(*) FROM sormas_local d WHERE d.externalid IS NULL AND d.duplicate_with != '';") + "," + mat; //counting real Duplicates

                mat = counterX("SELECT COUNT(*) FROM sormas_local d WHERE d.externalid IS NULL AND d.duplicate_with IS null or d.duplicate_with = '';") + "," + mat; //Unmachables

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //MATCHED
        //infrasstructure hirachy controller
        if (request.getParameter("parentx") != null && "3".contains(request.getParameter("levelx"))) {

            try {
                String parentx = request.getParameter("parentx");
                String levelx = request.getParameter("levelx");
System.err.println("_________+++++++++++++_________"+parentx);
                int xx = counterXint_withParameters(sql.count_by_level_using_parent, parentx); //total lgas from destination
                //total lgas from source
                
                String sub = counterXString_withParameters(sql.count_by_level_using_parent_source_q1, parentx); //subquery
             //   System.err.println("_________+++++++++++++_________"+sub);
                int xc = counterXint_withParameters(sql.count_by_level_using_parent_source_q2, sub);

                int xm = counterXint_withParameters(sql.count_by_level_using_parent_source_name, parentx); //total lgas matched

                String vc = counterXString_withParameters_(sql.count_by_level_using_parent_source_name_xx, parentx); //total lgas matched

                float seq = ((float) xm / xc);
                String str = String.format("%2.02f", (seq * 100));
                //    System.out.println(vc);
                mat = str + "%," + xx + "," + xc + "," + xm + ",@@@" + vc;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (request.getParameter("parentx") != null && "4".contains(request.getParameter("levelx"))) {
            //    System.out.println("ddddddddddddddd");

            try {
                String parentx = request.getParameter("parentx");
                String levelx = request.getParameter("levelx");

                int xx = counterXint_withParameters(sql.L4_count_by_level_using_parent, parentx); //total lgas from destination
                //total lgas from source
                //    System.out.println(xx);
                String sub = counterXString_withParameters(sql.L4_count_by_level_using_parent_source_q1, parentx); //subquery
                System.err.println("2____2_____+++++++++++++_________"+sub);
                int xc = counterXint_withParameters(sql.L4_count_by_level_using_parent_source_q2, sub);

                int xm = counterXint_withParameters(sql.L4_count_by_level_using_parent_source_name, parentx); //total lgas matched

                String vc = counterXString_withParameters_(sql.L4_count_by_level_using_parent_source_name_xx, parentx); //total lgas matched

                float seq = ((float) xm / xc);
                String str = String.format("%2.02f", (seq * 100));
                //    System.out.println(vc);
                mat = str + "%," + xx + "," + xc + "," + xm + ",@@@" + vc;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         if (request.getParameter("parentx") != null && "5".contains(request.getParameter("levelx"))) {
                System.out.println("ddddddddddddddd");

            try {
                String parentx = request.getParameter("parentx");
                String levelx = request.getParameter("levelx");

                int xx = counterXint_withParameters(sql.L5_count_by_level_using_parent, parentx); //total lgas from destination
                //total lgas from source
                //    System.out.println(xx);
                String sub = counterXString_withParameters(sql.L5_count_by_level_using_parent_source_q1, parentx); //subquery
                System.err.println("2____2_____+++++++++++++_________"+sub);
                int xc = counterXint_withParameters(sql.L5_count_by_level_using_parent_source_q2, sub);

                int xm = counterXint_withParameters(sql.L5_count_by_level_using_parent_source_name, parentx); //total lgas matched

                String vc = counterXString_withParameters_(sql.L5_count_by_level_using_parent_source_name_xx, parentx); //total lgas matched

                float seq = ((float) xm / xc);
                String str = String.format("%2.02f", (seq * 100));
                //    System.out.println(vc);
                mat = str + "%," + xx + "," + xc + "," + xm + ",@@@" + vc;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         

        //DUPLICATES
        //infrasstructure hirachy controller
        if (request.getParameter("dup_parentx") != null && "3".contains(request.getParameter("levelx"))) {
            //   System.out.println("ddddddddddddddddddddddd"+request.getParameter("levelx"));

            try {
                String parentx = request.getParameter("dup_parentx");
                String levelx = request.getParameter("levelx");

                int xx = counterXint_withParameters(sql.count_by_level_using_parent, parentx); //total lgas from sormas

                //total lgas from source
                String sub = counterXString_withParameters(sql.count_by_level_using_parent_source_q1, parentx); //subquery getting uid for ltr
                System.err.println("____3_____+++++++++++++_________"+sub);

                int xc = counterXint_withParameters(sql.count_by_level_using_parent_source_q2, sub); //number of lga from dhis

                int xm = counterXint_withParameters(sql.dup_count_by_level_using_parent_source_name, parentx); //total 100% duplicates

                String vc = counterXString_withParameters_(sql.cdup_ount_by_level_using_parent_source_name_xx, parentx); //lgas from state

                float seq = ((float) xm / xc);
                String str = String.format("%2.02f", (seq * 100));
                //  System.out.println(xc+"vc_____xm"+xm+"______"+sub+"_______"+vc);
                mat = str + "%," + xx + "," + xc + "," + xm + ",@@@" + vc;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (request.getParameter("dup_parentx") != null && "4".contains(request.getParameter("levelx"))) {
            //   System.out.println("ddddddddddddddddddddddd"+request.getParameter("levelx"));

            try {
                String parentx = request.getParameter("dup_parentx");
                String levelx = request.getParameter("levelx");

                int xx = counterXint_withParameters(sql.L4_count_by_level_using_parent, parentx); //total ward from sormas

                //total lgas from source
                String sub = counterXString_withParameters(sql.L4_count_by_level_using_parent_source_q1, parentx); //subquery getting uid for ltr
                System.err.println("____4_____+++++++++++++_________"+sub);

                int xc = counterXint_withParameters(sql.L4_count_by_level_using_parent_source_q2, sub); //number of ward from dhis

                int xm = counterXint_withParameters(sql.L4_dup_count_by_level_using_parent_source_name, parentx); //total 100% duplicates

                String vc = counterXString_withParameters_(sql.L4_cdup_ount_by_level_using_parent_source_name_xx, parentx); //wards from state 

                float seq = ((float) xm / xc);
                String str = String.format("%2.02f", (seq * 100));
                //  System.out.println(xc+"vc_____xm"+xm+"______"+sub+"_______"+vc);
                mat = str + "%," + xx + "," + xc + "," + xm + ",@@@" + vc;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

        if (request.getParameter("jsonparentx") != null && request.getParameter("jsonlevelx") != null) {

            try {
                String vc = "";
                String parentx = request.getParameter("jsonparentx");
                
                 System.out.println("nnnnnnnnnnnnnnnnnnnPP"+parentx);

                String leveld = request.getParameter("jsonlevelx");

                  System.out.println("nnnnnnnnnnnnnnnnnnnLL"+leveld);
                if ("nigeria_x".equalsIgnoreCase(leveld)) {

                    vc = counterXString_withParameters_x(sql.L2_count_by_level_using_parent_source_name_details, ""); //tables for states Matched

                } else if ("dup_nigeria_x".equalsIgnoreCase(leveld)) {
                    vc = counterXString_withParameters_x(sql.dup_L2_count_by_level_using_parent_source_name_details, ""); //tables for states Matched
                    System.out.println("nnnnnnnnnnnnnnnnnnn" + vc);
                } else if ("lga_x".equalsIgnoreCase(leveld)) {
                    vc = counterXString_withParameters_x(sql.L4_count_by_level_using_parent_source_name_details, parentx); //tables for Ward Matched
                    System.out.println("lglglglglglglg");
                } else if ("state_x".equalsIgnoreCase(leveld)) {
                    vc = counterXString_withParameters_x(sql.L3_count_by_level_using_parent_source_name_details, parentx); //tables for LGA Matched
                    System.out.println("statatatatatat = "+parentx);
                } else if ("dup_state_x".equalsIgnoreCase(leveld)) {
                    //  System.out.println("dupdupduo______stat dup ________" + parentx);
                    vc = counterXString_withParameters_seeded(sql.dup_L3_count_by_level_using_parent_source_name_details, parentx, sql.dup__SUB_count_by_level_using_parent_source_name_details); //tables for lga Matched

                } else if ("dup_lga_x".equalsIgnoreCase(leveld)) {
                    // System.out.println("dupdupduo______stat dup ________" + parentx);
                    vc = counterXString_withParameters_seeded(sql.L4_dup_L3_count_by_level_using_parent_source_name_details, parentx, sql.dup__SUB_count_by_level_using_parent_source_name_details); //tables for Ward Matched

                }
                JSONParser parser = new JSONParser();

                JSONObject json = (JSONObject) parser.parse(vc);

                //   System.out.println(json);
                // mat = vc;
                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                out.print(json);
                out.flush();

                return;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * JSONObject jsonObject = (JSONObject) jsonParser.parse(json_all);
         *
         * //Retrieving the array JSONArray jsonArray = (JSONArray)
         * jsonObject.get("organisationUnits");
         *
         *
         */
        //infrasstructure parent info controller
        if (request.getParameter("primer") != null) {

            try {
                String parentx = request.getParameter("primer");

                int xx = counterXint(sql.count_all_from_destination_no);
                int xc = counterXint(sql.count_all_from_source_no);
                int xv = counterXint(sql.count_matched_no);
                String vc = counterXmany(sql.count_matched_name);

                float seq = ((float) xv / xc);
                String str = String.format("%2.02f", (seq * 100));
                  System.out.println("matched dup "+vc);
                mat = str + "%," + xx + "," + xc + "," + xv + ",@@@" + vc;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //duplicate alogth
        if (request.getParameter("dup_primer") != null) {

            try {
                //String parentx = request.getParameter("dup_primer");

                int xx = counterXint(sql.dup_count_all_from_sorma_local);
                int xc = counterXint(sql.count_all_from_source_no);
                String vc = counterXmany(sql.dup_count_matched_name);

                float seq = ((float) xx / xc);
                String str = String.format("%2.02f", (seq * 100));
                  System.out.println("primer_ dup = "+vc);
                mat = str + "%," + xx + "," + xc + ",@@@" + vc;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //SEND Matched data to SORMAS 
        if (request.getParameter("pushavailable") != null) {

            try {
                //String parentx = request.getParameter("dup_primer");

                int xx = counterXint(sql.sync_count_all_synced);
                System.out.println("total before push : " + xx);
                sendDataX("");
                int xx_ = counterXint(sql.sync_count_all_synced);
                System.out.println("Push completed, total after push : " + xx_ + " total newly pushed = " + (xx_ - xx));

                // int xx = counterXint(sql.sync_count_all_matched);
                // float seq = ((float) xx);
                //    String str = String.format("%2.02f", (seq * 100));
                //  System.out.println(vc);
                mat = (xx_ - xx) + "";
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (request.getParameter("pushfreshavailable") != null) {
            try {
                sess.setAttribute("fav", "plus-square");
                sess.setAttribute("no", "1");
                sess.setAttribute("notf", "Pending Job Progress");
                int n = 6;
                // System.out.print("Even Numbers from 1 to " + n + " are: ");
                for (int i = 2; i < n; i++) {
                    sendDataX_(i);
                    sess.setAttribute("jobber", "Region Progress: "+re_g);
                    sess.setAttribute("jobber1", "District Progress: "+ds_c);
                    sess.setAttribute("jobber2", "Community Progress: "+com_m);
                    sess.setAttribute("jobber3", "Health Facility Progress: "+fac_l);
                }
                mat = ("done");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (request.getParameter(
                "aggregatToDHIS") != null) {

            AggregrateController.SormasAggregrator("2");
            mat = "Job done";
        }

        if (request.getParameter(
                "PUSHRESULTS") != null) {

            try {
                // System.out.println("Yes... hit the Sevlets DEBUG");

                mat = AggregrateController.MetadaJsonSender();

                // mat = "Job done";
            } catch (ParseException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        response.setContentType(
                "text/plain;charset=UTF-8");
        response.setStatus(
                200);
        ServletOutputStream sout = response.getOutputStream();

        sout.print(mat);
        mat = "";
    }

    public static String counterXmany(String sqq) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        String ret = "";
        try {

            ps = conn.prepareStatement(sqq);
            rx = ps.executeQuery();
            while (rx.next()) {

                ret = " <option value=\"" + rx.getString(2) + "\">" + rx.getString(1).toUpperCase() + "</option>" + ret;

            }

        } finally {
            conn.close();
        }
        return ret;
    }

    public static String counterXmany_withParameters(String sqq, String par1, String par2) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        String ret = "";
        try {

            ps = conn.prepareStatement(sqq);
            ps.setString(1, par1);
            ps.setString(2, par2);
            rx = ps.executeQuery();
            while (rx.next()) {

                ret = " <option value=\"" + rx.getString(1) + "\">" + rx.getString(1) + "</option>" + ret;

            }

        } finally {
            conn.close();
        }
        return ret;
    }

    public static String counterX(String sqq) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        String ret = "0";
        try {

            ps = conn.prepareStatement(sqq);
            rx = ps.executeQuery();
            if (rx.next()) {

                ret = rx.getString(1);

            }

        } finally {
            conn.close();
        }
        return ret;
    }

    public static int counterXint(String sqq) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        int ret = 0;
        try {

            ps = conn.prepareStatement(sqq);
            rx = ps.executeQuery();
            if (rx.next()) {

                ret = rx.getInt(1);

            }

        } finally {
            conn.close();
        }
        return ret;
    }

    public static void update_oneParm(String sqq, String sqq_) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        int ret = 0;
        try {

            ps = conn.prepareStatement(sqq);
            ps.setString(1, sqq_);
            ps.executeUpdate();

        } finally {
            conn.close();
        }
    }

    public static int counterXint_dup(String sqq) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        int ret = 0;
        try {

            ps = conn.prepareStatement("SELECT d.duplicate_with FROM sormas_local d WHERE d.duplicate_with is not null and duplicate_with != '' and d.`level` = 3;");
            rx = ps.executeQuery();
            while (rx.next()) {

                ret = rx.getInt(1);

            }

        } finally {
            conn.close();
        }
        return ret;
    }

    public static int counterXint_withParameters(String sqq, String par1) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        int ret = 0;
        try {

            ps = conn.prepareStatement(sqq);
            ps.setString(1, "%" + par1 + "%");

                 System.out.println("_______"+ps.toString());
            rx = ps.executeQuery();
            if (rx.next()) {

                ret = rx.getInt(1);

            }

        } finally {
            conn.close();
        }
        return ret;
    }

    public static String counterXString_withParameters(String sqq, String par1) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        String ret = "0";
        try {

            ps = conn.prepareStatement(sqq);
            ps.setString(1, "%" + par1 + "%");

                System.out.println("++++++++++++++++---"+ps.toString());
            rx = ps.executeQuery();
            while (rx.next()) {

                ret = rx.getString(1);

            }

        } finally {
            conn.close();
        }
        return ret;
    }

    public static void sendDataX(String sqq) throws ClassNotFoundException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Connection conn = DbConnector.getConnection();

        PreparedStatement ps_pg = null;
        ResultSet rx_pg = null;
        Connection conn_pg = DbConnector.getPgConnection();
        int ret = 0;

        try {

            ps = conn.prepareStatement(sql.sync_primer_all_matched);
            rx = ps.executeQuery();

            while (rx.next()) {
                UUID uuid = UUID.randomUUID();
                String randomUUIDString = uuid.toString().toUpperCase();

                try {
                    String dxs = "";
                    if ("2".equals(rx.getString(2))) {
                        dxs = "insert into region set uuid = ?, name = ?, externalid = ?, id = ?, changedate = now(), creationdate=?";
                    } else if ("3".equals(rx.getString(2))) {
                        dxs = "insert into district set uuid = ?, name = ?, externalid = ?, id = ?, changedate = now(), creationdate=?";
                    } else if ("4".equals(rx.getString(2))) {
                        dxs = "insert into community set uuid = ?, name = ?, externalid = ?, id = ?, changedate = now(), creationdate=?";
                    } else if ("5".equals(rx.getString(2))) {
                        dxs = "insert into facility set uuid = ?, name = ?, externalid = ?, id = ?, changedate = now(), creationdate=?";
                    }

                    ps_pg = conn_pg.prepareStatement(dxs);
                    ps_pg.setString(1, randomUUIDString);
                    ps_pg.setString(2, rx.getString(1));
                    ps_pg.setString(3, rx.getString(3));
                    ps_pg.setString(4, rx.getString(4));
                    ps_pg.setString(5, rx.getString(5));

                    // System.out.println(ps_pg);
                    ret = ps_pg.executeUpdate();

                } finally {
                    if (ret > 0) {
                        //    System.out.println("afected rows =" + ret + " setting " + rx.getString(1) + " with externalID " + rx.getString(3) + " status to synced");
                        update_oneParm(sql.sync_send_all_matched_My, rx.getString(4));
                    }
                    ret = 0;
                }
            }
            conn_pg.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UtilServer.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String counterXString_withParameters_(String sqq, String par1) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        String ret = "0";
        try {

            ps = conn.prepareStatement(sqq);
            ps.setString(1, "%" + par1 + "%");

               System.out.println("_)))))))))))_________3++++++ "+ps.toString());
            rx = ps.executeQuery();
            String jsonPrimer = "{\n"
                    + "  \"draw\": 1,\n"
                    + "  \"recordsTotal\": 57,\n"
                    + "  \"recordsFiltered\": 57,\n"
                    + "  \"data\": [";
            String jsonPrimerClose = "@@]";

            if (sqq.startsWith("SELECT d.uid")) {
                while (rx.next()) {

                    ret = " <option value=\"" + rx.getString(1) + "\">" + rx.getString(1) + "</option>" + ret;
                    String dd = "[\n"
                            + "      \"" + rx.getString(1) + "\",\n"
                            + "      \"" + rx.getString(2) + "\",\n"
                            + "      \"" + rx.getString(3) + "\",\n"
                            + "      \"" + rx.getString(4) + "\",\n"
                            + "      \"" + rx.getString(5) + "\",\n"
                            + "      \"" + rx.getString(6) + "\"\n"
                            + "    ],";

                    ret = dd + ret;
                  //  System.out.println("____________________________>>>>> "+ret);
                }
            } else {

                while (rx.next()) {
                    ret = " <option value=\"" + rx.getString(2) + "\">" + rx.getString(1).toUpperCase() + "</option>" + ret;
                 //    System.out.println("________2____________________>>>>> "+ret);
                }
            }

        } finally {
            conn.close();
        }
        return ret;
    }

    public static String counterXString_withParameters_x(String sqq, String par1) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        String ret = "";
        try {

            ps = conn.prepareStatement(sqq);
            ps.setString(1, "%" + par1 + "%");

            //    System.out.println("______________+_+___)+__))+_)+_)(+_) "+ps.toString());
            rx = ps.executeQuery();
            String jsonPrimer = "{\n"
                    + "  \"data\": [";
            String jsonPrimerClose = "@@]";

            while (rx.next()) {

                String dd = "[\n"
                        + "      \"" + rx.getString(1) + "\",\n"
                        + "      \"" + rx.getString(2) + "\",\n"
                        + "      \"" + rx.getString(3) + "\",\n"
                        + "      \"" + rx.getString(4) + "\",\n"
                        + "      \"" + rx.getString(5) + "\",\n"
                        + "      \"" + rx.getString(6) + "\"\n"
                        + "    ],";

                ret = dd + ret;
            }

            ret = jsonPrimer + ret + jsonPrimerClose;
        } finally {
            conn.close();
        }

        return ret.replaceAll(",@@", "") + "}";
    }

    public static String counterXString_withParameters_seeded(String sqq, String par1, String sqq_) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;

        PreparedStatement ps_ = null;
        ResultSet rx_ = null;

        PreparedStatement ps_x = null;
        ResultSet rx_x = null;

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        String ret = "";
        try {

            ps = conn.prepareStatement(sqq);
            ps.setString(1, "%" + par1 + "%");

            //   System.out.println(ps.toString());
            rx = ps.executeQuery();
            String jsonPrimer = "{\n"
                    + "  \"data\": [";
            String jsonPrimerClose = "@@]";

            while (rx.next()) {
                String dimp = rx.getString("duplicate_with").replaceAll(" ", "").replaceAll(",", "\",\"");
                String sss = sqq_ + "(\"" + dimp + "\")";

                //    System.out.println(sss);
                ps_ = conn.prepareStatement(sss);
                //    ps_.setString(1, dimp.replaceAll(" ", "").replaceAll(",", "\",\""));

                //  System.out.println(ps_.toString());
                rx_ = ps_.executeQuery();
                while (rx_.next()) {

                    ps_x = conn.prepareStatement("select r.name, r.uuid from raw_ r where r.uuid = '" + rx.getString("externalid") + "'");
                    //      System.out.println(ps_x.toString());
                    rx_x = ps_x.executeQuery();
                    // System.out.println("__________________________________________________");
                    String dd = "[\n"
                            + "      \"" + rx.getString("idx") + "\",\n"
                            + "      \"" + rx.getString("uuid") + "\",\n"
                            + "      \"" + rx.getString("namex") + "\",\n"
                            + "      \"" + rx_.getString("name") + "\",\n"
                            + "      \"" + rx_.getString("uuid") + "\",\n";
                    String dx = "";
                    String dduuid = "non";
                    if (rx_x.next()) {
                        // System.out.println("__________________________________________________");
                        dx = "      \"" + rx_x.getString("name") + "\",\n"
                                + "      \"" + rx_x.getString("uuid") + "\",\n";
                        dduuid = rx_x.getString("uuid");

                    } else {
                        dx = "      \"non\",\n"
                                + "      \"non\",\n";
                        dduuid = "non";
                    }
                    dd = dd + dx + "   \"" + rx.getString("adapter_cdate") + "\", \"<div class='tools'><a href='' data-uri='" + rx.getString("uuid") + "@@" + rx_.getString("uuid") + "@@" + dduuid + "'  data-toggle='modal' data-target='#deduplicate'><i class='fas fa-edit' aria-hidden='true'></i></a></div>\" ],";
                    //    System.out.println("__________________________________________________"+dx);
                    ret = dd + ret;
                    //       System.out.println("________>>>>\n"+ret);
                }

            }

            ret = jsonPrimer + ret + jsonPrimerClose;
        } finally {
            conn.close();
        }

        return ret.replaceAll(",@@", "") + "}";
    }

    public static void sendDataX_(int i) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        ResultSet rx = null;

        PreparedStatement ps_g = null;
        ResultSet s_x = null;

        Connection conn = DbConnector.getConnection();

        try {
            ps = conn.prepareStatement(sql.sync_primer_all_fresh);
            ps.setString(1, i + "");
            rx = ps.executeQuery();
               System.out.println("deugging fresh pusher >>>>>>>>>>>>>>>>>>>>>>>.."+ps);

            while (rx.next()) {
                String abx = rx.getString(1);
                String[] ab = abx.split("/");
                int ddx = ab.length;
                int ddx_ = ddx - 2;
                //    System.out.println(rx.getString(1));

                ps_g = conn.prepareStatement(sql.sync_primer_all_fresh_);
                ps_g.setString(1, ab[ddx_]);
                s_x = ps_g.executeQuery();

                //  System.out.println(ps_g);
                if (s_x.next()) {
                       System.out.println(ab[ddx_] + "   ____   " + rx.getString(1)+" >>>>>>>>>  "+s_x.getString(1)+"");

                    sendDataX_a(s_x.getString(1), ab[ddx_], i + "");

                } else {
                    // return;
                }

            }

        } finally {

        }

    }

    public static void sendDataX_a(String stt, String prnt, String numz) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Connection conn = DbConnector.getConnection();

        PreparedStatement ps_pg = null;
        ResultSet s = null;
        Connection conn_pg = DbConnector.getPgConnection();
        int ret = 0;

        try {

            ps = conn.prepareStatement("select name, uuid, idx, rec_created, level  from raw_ where level = ? and path_parent like '%" + prnt + "%'");
            ps.setString(1, numz);
            rx = ps.executeQuery();

            //   System.out.println(ps);
            while (rx.next()) {
                UUID uuid = UUID.randomUUID();
                String randomUUIDString = uuid.toString().toUpperCase();

                try {
                    String dxs = "";
                    int vk = 1;

                    if ("2".equals(rx.getString(5))) {
                        dxs = "insert into region (uuid,name,externalid,id,changedate,creationdate) values(?,?,?,?,now(),?) ON CONFLICT DO NOTHING";
                        re_g++;
                    } else if ("3".equals(rx.getString(5))) {
                        ds_c++;
                        dxs = "insert into district (uuid,name,externalid,id,changedate,creationdate,region_id) values(?,?,?,?,now(),?,'" + stt + "') ON CONFLICT DO NOTHING";
                    } else if ("4".equals(rx.getString(5))) {
                        com_m++;
                        dxs = "insert into community (uuid,name,externalid,id,changedate,creationdate, district_id) values(?,?,?,?,now(),?,'" + stt + "') ON CONFLICT DO NOTHING";
                    } else if ("5".equals(rx.getString(5))) {
                        fac_l++;
                        dxs = "insert into facility (uuid,name,externalid,id,changedate,creationdate, community_id) values(?,?,?,?,now(),?,'" + stt + "') ON CONFLICT DO NOTHING";
                    } else if ("1".equals(rx.getString(5))) {
                        vk = 0;
                    }
                    if (vk == 1) {
                        ps_pg = conn_pg.prepareStatement(dxs);
                        ps_pg.setString(1, randomUUIDString);
                        ps_pg.setString(2, rx.getString(1));
                        ps_pg.setString(3, rx.getString(2));
                        ps_pg.setInt(4, rx.getInt(3));
                        ps_pg.setDate(5, rx.getDate(4));

                        //    System.out.println(ps_pg);
                        ret = ps_pg.executeUpdate();
                    }
                } finally {
                    if (ret > 0) {
                        //    System.out.println("afected rows =" + ret + " setting " + rx.getString(1) + " with "
                        //          + "ID " + rx.getString(3) + " status to synced");
                        update_oneParm(sql.sync_send_all_matched_My, rx.getString(3));
                    }
                    ret = 0;
                }
            }
            conn_pg.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UtilServer.class
                    .getName()).log(Level.SEVERE, null, ex);
            conn_pg.close();
            conn.close();
        }

    }
}
