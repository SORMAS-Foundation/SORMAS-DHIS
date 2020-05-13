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
import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mathew Official
 */
@WebServlet(name = "iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678", urlPatterns = {"/iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678"})
public class UtilServer extends HttpServlet {

    private static String mat = "";
    private static int nox = 0;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("count") != null) {
            try {
                //System.out.println(request.getParameter("count"));
                int counter = Integer.parseInt(request.getParameter("count"));

                mat = counterX("SELECT COUNT(*) FROM sormas_local d WHERE d.externalid != 'null' AND d.duplicate_with IS NULL;");

                mat = counterX("SELECT COUNT(*) FROM sormas_local d WHERE d.externalid != 'null' AND d.duplicate_with IS not NULL and d.duplicate_with != '';") + "," + mat;

                mat = counterX("SELECT COUNT(*) FROM sormas_local d WHERE d.externalid IS NULL AND d.duplicate_with != '';") + "," + mat;

                mat = counterX("SELECT COUNT(*) FROM sormas_local d WHERE d.externalid IS NULL AND d.duplicate_with IS null;") + "," + mat;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //infrasstructure hirachy controller
        if (request.getParameter("parentx") != null && "3".contains(request.getParameter("levelx"))) {

            try {
                String parentx = request.getParameter("parentx");
                String levelx = request.getParameter("levelx");

                int xx = counterXint_withParameters(sql.count_by_level_using_parent, parentx); //total lgas from destination
                //total lgas from source
                String sub = counterXString_withParameters(sql.count_by_level_using_parent_source_q1, parentx); //subquery
                int xc = counterXint_withParameters(sql.count_by_level_using_parent_source_q2, sub);

                int xm = counterXint_withParameters(sql.count_by_level_using_parent_source_name, parentx); //total lgas matched

                String vc = counterXString_withParameters_(sql.count_by_level_using_parent_source_name_xx, parentx); //total lgas matched

                float seq = ((float) xx / xc);
                String str = String.format("%2.02f", (seq * 100));
                System.out.println(vc);
                mat = str + "%," + xx + "," + xc + "," + xm + ",@@@" + vc;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        
        if (request.getParameter("parentx") != null && "4".contains(request.getParameter("levelx"))) {

            try {
                String parentx = request.getParameter("parentx");
                String levelx = request.getParameter("levelx");

                int xx = counterXint_withParameters(sql.L4_count_by_level_using_parent, parentx); //total lgas from destination
                //total lgas from source
                String sub = counterXString_withParameters(sql.L4_count_by_level_using_parent_source_q1, parentx); //subquery
                int xc = counterXint_withParameters(sql.L4_count_by_level_using_parent_source_q2, sub);

                int xm = counterXint_withParameters(sql.L4_count_by_level_using_parent_source_name, parentx); //total lgas matched

                String vc = counterXString_withParameters_(sql.L4_count_by_level_using_parent_source_name_xx, parentx); //total lgas matched

                float seq = ((float) xx / xc);
                String str = String.format("%2.02f", (seq * 100));
                System.out.println(vc);
                mat = str + "%," + xx + "," + xc + "," + xm + ",@@@" + vc;

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
        
        /**
          JSONObject jsonObject = (JSONObject) jsonParser.parse(json_all);

            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("organisationUnits");
            * 
         **/
         //infrasstructure parent info controller
        if (request.getParameter("primer") != null) {
           
            try {
                String parentx = request.getParameter("primer");
                
                int xx = counterXint(sql.count_all_from_destination_no);
                int xc = counterXint(sql.count_all_from_source_no);
                int xv = counterXint(sql.count_matched_no);
                String vc = counterXmany(sql.count_matched_name);
                
                float seq = ((float)xv / xc);
                String str = String.format("%2.02f", (seq * 100));
                System.out.println(vc);
                mat = str+"%,"+xx+","+xc+","+xv+",@@@"+vc;
                
              } catch (ClassNotFoundException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UtilServer.class.getName()).log(Level.SEVERE, null, ex);
            }  
            }
            
            
        response.setContentType("text/plain;charset=UTF-8");
        response.setStatus(200);
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

                ret = " <option value=\""+rx.getString(1)+"\">"+ret;

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

                ret = " <option value=\""+rx.getString(1)+"\">"+ret;

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
     public static int counterXint_withParameters(String sqq, String par1) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        int ret = 0;
        try {

            ps = conn.prepareStatement(sqq);
            ps.setString(1, "%"+par1+"%");
            
            System.out.println(ps.toString());
            
            
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
            ps.setString(1, "%"+par1+"%");
            
            System.out.println(ps.toString());
            
            
            rx = ps.executeQuery();
            while (rx.next()) {

                ret = rx.getString(1);

            }

        } finally {
            conn.close();
        }
        return ret;
    }
     
     public static String counterXString_withParameters_(String sqq, String par1) throws ClassNotFoundException, SQLException {

        PreparedStatement ps = null;
        ResultSet rx = null;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        String ret = "0";
        try {

            ps = conn.prepareStatement(sqq);
            ps.setString(1, "%"+par1+"%");
            
            System.out.println(ps.toString());
            
            
            rx = ps.executeQuery();
            while (rx.next()) {

                ret = " <option value=\""+rx.getString(1)+"\">"+ret;

            }

        } finally {
            conn.close();
        }
        return ret;
    }

}
