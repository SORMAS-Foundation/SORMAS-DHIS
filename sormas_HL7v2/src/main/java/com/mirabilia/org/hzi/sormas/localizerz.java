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

import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "localizerz", urlPatterns = {"/localizerz"})
public class localizerz extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>now in localizer");
        try {
            String tkbck = "";

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

            //loop through sormas local and get infrastructure data by level into mysql local db for futher use by the adapter.
            try {
                if (request.getParameter("rg") != null && "true".equals(request.getParameter("rg"))) {
            //System.out.println("region? !"+request.getParameter("rg"));
                    ps = conn.prepareStatement("SELECT changedate, uuid, externalid, name FROM region;");
                    rx = ps.executeQuery();
                    while (rx.next()) {
                        String cf = "";
                        if (rx.getString(3) == null) {
                            cf = "0";
                        } else {
                            cf = rx.getString(3);
                        }
                        getterSetters.Localizer(rx.getString(1), rx.getString(2), cf, "2", rx.getString(4));

                    }
                    tkbck = "finised pulling state data... successful";
                    System.out.println(tkbck);
                }
                if (request.getParameter("ds") != null && "true".equals(request.getParameter("ds"))) {
            
                    ps1 = conn.prepareStatement("SELECT changedate, uuid, externalid, name FROM district;");
                    rx1 = ps1.executeQuery();
                    while (rx1.next()) {
                        String cv = "";
                        if (rx1.getString(3) == null) {
                            cv = "0";
                        } else {
                            cv = rx1.getString(3);
                        }
                        getterSetters.Localizer(rx1.getString(1), rx1.getString(2), cv, "3", rx1.getString(4));
                    }
                    tkbck = "finised pulling LGA / District data... successful";
                    System.out.println(tkbck);
                }

                if (request.getParameter("co") != null && "true".equals(request.getParameter("co"))) {
                    System.out.println("ward"+request.getParameter("co"));
                    ps2 = conn.prepareStatement("SELECT changedate, uuid, externalid, name FROM community;");
                    rx2 = ps2.executeQuery();
                    while (rx2.next()) {
                        String cz = "";
                        if (rx2.getString(3) == null) {
                            cz = "0";
                        } else {
                            cz = rx2.getString(3);
                        }
                        // getterSetters.Localizer(ch, cm, cc, cx, co);
                        getterSetters.Localizer(rx2.getString(1), rx2.getString(2), cz, "4", rx2.getString(4));
                    }
                    tkbck = "finised pulling Ward/Community data... successful";
                    System.out.println(tkbck);
                }

                if (request.getParameter("fa") != null && "true".equals(request.getParameter("fa"))) {
                    System.out.println("health facility !"+request.getParameter("fa"));
                    ps3 = conn.prepareStatement("SELECT changedate, uuid, externalid, name FROM facility;");
                    rx3 = ps3.executeQuery();
                    while (rx3.next()) {
                        String cq = "";
                        if (rx3.getString(3) == null) {
                            cq = "0";
                        } else {
                            cq = rx3.getString(3);
                        }
                        getterSetters.Localizer(rx3.getString(1), rx3.getString(2), cq, "5", rx3.getString(4));
                    }
                    tkbck = "finised pulling facility data... successful";
                    System.out.println(tkbck);
                }
                //  out.write("<script> var dd = document.getElementById('d_text').innerHTML = 'processing ward/community... done.';</script>");
                //  System.out.println(lister);
                conn.close();

                if (tkbck.isEmpty()) {
                    response.setContentType("text/plain;charset=UTF-8");
                    response.setStatus(200);
                    ServletOutputStream sout = response.getOutputStream();
                    

                    sout.print(tkbck);
                } else {
                response.setContentType("text/plain;charset=UTF-8");
                    response.setStatus(200);
                    ServletOutputStream sout = response.getOutputStream();

                    sout.print("something is wrong! in localizer");
                
                }

            } catch (SQLException ex) {
                out.print("SQLException: " + ex.getMessage());
                out.print("SQLState: " + ex.getSQLState());
                out.print("VendorError: " + ex.getErrorCode());
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(localizerz.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
