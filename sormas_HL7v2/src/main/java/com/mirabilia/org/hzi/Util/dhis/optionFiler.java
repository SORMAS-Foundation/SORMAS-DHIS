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
package com.mirabilia.org.hzi.Util.dhis;

import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mathew Official
 */
@WebServlet(name = "asdfghjytrsfddsfkjshdgvgbhsrdtnjyunbshvagwcwgavetryjtbkuytjrhsevasfdcsdfgvhjybukretrsearstybjgk", urlPatterns = {"/asdfghjytrsfddsfkjshdgvgbhsrdtnjyunbshvagwcwgavetryjtbkuytjrhsevasfdcsdfgvhjybukretrsearstybjgk"})
public class optionFiler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            PreparedStatement ps;
            ResultSet rx;
            Connection conn = DbConnector.getConnection();
            ps = conn.prepareStatement("update optionfiles set server=?, case_data=?, sample_data=?, contact_data=?, with_aggregate=?, aggregate_only=?, r1x=?, r1=?, installer=?, created=now();");

            if (null != request.getParameter("server")) {
                ps.setString(1, "checked");
            } else {
                ps.setString(1, "");
            };
            if (null != request.getParameter("case_data")) {
                ps.setString(2, "checked");
            } else {
                ps.setString(2, "");
            };
            if (null != request.getParameter("sample_data")) {
                ps.setString(3, "checked");
            } else {
                ps.setString(3, "");
            };
            if (null != request.getParameter("contact_data")) {
                ps.setString(4, "checked");
            } else {
                ps.setString(4, "");
            };
            if (null != request.getParameter("with_aggregate")) {
                ps.setString(5, "checked");
            } else {
                ps.setString(5, "");
            };
            if (null != request.getParameter("aggregate_only")) {
                ps.setString(6, "checked");
            } else {
                ps.setString(6, "");
            };
            if (null != request.getParameter("r1x")) {
                ps.setString(7, request.getParameter("r1x"));
            } else {
                ps.setString(7, "");
            };
            if (null != request.getParameter("r1")) {
                ps.setString(8, request.getParameter("r1"));
            } else {
                ps.setString(8, "");
            };
            if (null != request.getParameter("installer")) {
                ps.setString(9, "checked");
            } else {
                ps.setString(9, "");
            };
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(optionFiler.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("./fhir_frontend/controller.jsp");
   

}}
