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
package com.mirabilia.org.hzi.sormas;

import com.mirabilia.org.hzi.Strings.sql;
import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mathew Official
 */
public class getterSetters {

    public static String analyseSormas() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        String lister = "";

        PreparedStatement ps;
        ResultSet rx;

        PreparedStatement ps1;
        ResultSet rx1;

        PreparedStatement ps2;
        ResultSet rx2;

        PreparedStatement ps3;
        ResultSet rx3;
        Class.forName("org.postgresql.Driver");
        Connection conn = DbConnector.getPgConnection();
        String str = "";

        try {
           
            ps = conn.prepareStatement("SELECT count(*) FROM region;");
            rx = ps.executeQuery();
            if (rx.next()) {
                //System.out.println(rx.getString(1));
                lister = rx.getString(1);

                ps1 = conn.prepareStatement("SELECT count(*) FROM district;");
                rx1 = ps1.executeQuery();
                if (rx1.next()) {
                    //System.out.println(rx1.getString(1));
                    lister = lister + "@" + rx1.getString(1);

                    ps2 = conn.prepareStatement("SELECT count(*) FROM community;");
                    rx2 = ps2.executeQuery();
                    if (rx2.next()) {
                        //System.out.println(rx2.getString(1));
                        lister = lister + "@" + rx2.getString(1);

                        ps3 = conn.prepareStatement("SELECT count(*) FROM facility;");
                        rx3 = ps3.executeQuery();
                        if (rx3.next()) {
                            //System.out.println(rx3.getString(1));
                            lister = lister + "@" + rx3.getString(1);
                        }
                    }
                }
            }
            System.out.println(lister);
            String[] dd = lister.split("@");
            //System.out.println(dd[2]);

        } catch (SQLException ex) {
            out.print("SQLException: " + ex.getMessage());
            out.print("SQLState: " + ex.getSQLState());
            out.print("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    public static void Localizer(String ch, String cm, String cc, String cx, String co, String gf, String gh, String gb) throws ClassNotFoundException, SQLException {
        System.out.println(ch + "-" + cm + "-" + cc);

        PreparedStatement ps;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();

        String str = "";
        try {
            ps = conn.prepareStatement("insert into sormas_local set changedate = ?, uuid = ?, externalid = ?, level = ?, namex = ?, uid = ?, parent_id = ?,  ext_cdate = ?;");
            ps.setString(1, ch);
            ps.setString(2, cm);
            ps.setString(3, cc);
            ps.setString(4, cx);
            ps.setString(5, co);
            ps.setString(6, gf);
            ps.setString(7, gh);
            ps.setString(8, gb);
            System.out.println(ps.toString());
            ps.execute();
        } finally {
            conn.close();
        }

    }

    public static void Localizer_Deleter() throws ClassNotFoundException, SQLException {

        PreparedStatement ps;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();

        String str = "";
        try {
            ps = conn.prepareStatement("delete from sormas_local");
            ps.execute();
        } finally {
            conn.close();
        }
    }
    
    public static void Localizer_DHIS_Deleter() throws ClassNotFoundException, SQLException {

        PreparedStatement ps;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();

        String str = "";
        try {
            ps = conn.prepareStatement("delete from raw_");
            ps.execute();
        } finally {
            conn.close();
        }
    }
            

    public static String getNoGeoPoints() {
        String ret = "";
        try {
            PreparedStatement ps;
            ResultSet rx;
            Class.forName("org.postgresql.Driver");
            Connection conn = DbConnector.getPgConnection();

            try {
                ps = conn.prepareStatement("SELECT count(*) FROM facility where latitude is null");
                rx = ps.executeQuery();
                if (rx.next()) {
                    ret = rx.getString(1);
                }

                ps = conn.prepareStatement("SELECT count(*) FROM facility");

                rx = ps.executeQuery();
                if (rx.next()) {
                    ret = ret + "</b> / " + rx.getString(1);
                }

            } catch (SQLException ex) {
                Logger.getLogger(getterSetters.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getterSetters.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    
    
     public static String getNoLastUpdated() {
        String ret = "";
        try {
            PreparedStatement ps;
            ResultSet rx;
            Class.forName("org.postgresql.Driver");
            Connection conn = DbConnector.getConnection();

           
                ps = conn.prepareStatement(sql.dash_table_counter);
                rx = ps.executeQuery();
                while (rx.next()) { 
                    //todo: add rx.getString(4) to last colomn
                    ret = "<tr> <td>"+rx.getString(1)+"</td><td>"+rx.getString(2)+"</td><td>"+rx.getString(3)+"</td><td>Mathew Official</td> </tr>"+ret;
                    //System.out.println("dddddddddddddddd");
                }

          //  System.out.println("ddddddddddddddddddddddddddddddddddddddddddddddddddddd"+ret);
          
        
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(getterSetters.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(getterSetters.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return ret;
     }
     
     
     
         
     
     
         
     
     
         
     
     
    
    public static String getNoSynced() {
        String ret = "";
        PreparedStatement ps;
        ResultSet rx;
        Connection conn = DbConnector.getConnection();
        try {
            ps = conn.prepareStatement("SELECT count(*) FROM sormas_local where synced = 1");
            rx = ps.executeQuery();
            if (rx.next()) {
                ret = rx.getString(1);
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(getterSetters.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    
}
