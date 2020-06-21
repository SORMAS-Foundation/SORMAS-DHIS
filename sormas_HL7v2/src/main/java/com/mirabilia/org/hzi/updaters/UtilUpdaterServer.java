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
package com.mirabilia.org.hzi.updaters;

import java.io.IOException;
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
 * @author Mathew
 */
@WebServlet(name = "4a24cf8b-fbcb-4554-b653-2b54a239be62", urlPatterns = {"/4a24cf8b-fbcb-4554-b653-2b54a239be62"})
public class UtilUpdaterServer extends HttpServlet {

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
        if(request.getParameter("dea_link") != null || request.getParameter("dea_link").equals("true")){ //deactivates url
            if(request.getParameter("url") != null){
            
                try {
                    
                    
                    Util.switcerh(request.getParameter("url"));
                    
                   
                    
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UtilUpdaterServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UtilUpdaterServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("./fhir_frontend/source_controller.jsp");
            }
        }
        
         if(request.getParameter("dea_link") != null || request.getParameter("dea_link").equals("true")){ //deduplicator url
            if(request.getParameter("url") != null){
            
                try {
                    
                    
                    Util.switcerh(request.getParameter("url"));
                    
                  //  response.sendRedirect("./fhir_frontend/source_controller.jsp");
                    return;
                    
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UtilUpdaterServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UtilUpdaterServer.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        }
        

    }

}
