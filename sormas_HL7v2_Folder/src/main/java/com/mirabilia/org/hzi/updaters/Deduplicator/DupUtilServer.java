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
package com.mirabilia.org.hzi.updaters.Deduplicator;

import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * @author Mathew
 */
@WebServlet(name = "4a24cf8b-fbcb-4554-b676-2b54a239be62", urlPatterns = {"/4a24cf8b-fbcb-4554-b676-2b54a239be62"})
public class DupUtilServer extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("accept") != null) {
            try {
                String dx = "update sormas_local set externalid = '" + request.getParameter("accept") + "', duplicate_with = null, resolved_by = 'logged_in_user' where uuid = '" + request.getParameter("wht") + "';";
                //    System.out.println("jkjhgfdswedrftghjuytrewdfghjjhgtfd++++++++++++++ " + dx);
                DTOx(dx);
                //        response.sendRedirect("./fhir_frontend/OrgToolOperation.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DupUtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {

                response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(202);
                ServletOutputStream sout = response.getOutputStream();

                sout.print(ex.getMessage());

                Logger.getLogger(DupUtilServer.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }

        }

        if (request.getParameter("current") != null) {
            try {
                String dx = "update sormas_local set externalid = '" + request.getParameter("current") + "', duplicate_with = null, resolved_by = 'logged_in_user' where uuid = '" + request.getParameter("wht") + "';";
                //  System.out.println("jkjhgfdswedrftghjuytrewdfghjjhgtfd++++++++++++++ " + dx);
                DTOx(dx);
                //     response.sendRedirect("./fhir_frontend/OrgToolOperation.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DupUtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
               response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(202);
                ServletOutputStream sout = response.getOutputStream();

                sout.print(ex.getMessage());

                Logger.getLogger(DupUtilServer.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }

        if (request.getParameter("reset") != null) {
            try {
                String dx = "update sormas_local set externalid = null, duplicate_with = null, resolved_by = 'logged_in_user' where uuid = '" + request.getParameter("wht") + "';";
                // System.out.println("jkjhgfdswedrftghjuytrewdfghjjhgtfd++++++++++++++ " + dx);
                DTOx(dx);
                //  response.sendRedirect("./fhir_frontend/OrgToolOperation.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DupUtilServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(202);
                ServletOutputStream sout = response.getOutputStream();

                sout.print(ex.getMessage());

                Logger.getLogger(DupUtilServer.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
        }
        response.setContentType("text/plain;charset=UTF-8");
        response.setStatus(200);
        ServletOutputStream sout = response.getOutputStream();

        sout.print("stored");

    }

    private static void DTOx(String sql_q) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();

        try {

            ps = conn.prepareStatement(sql_q);
            System.out.println(ps);
            ps.executeUpdate();

        } finally {
            conn.close();
        }

    }

}
