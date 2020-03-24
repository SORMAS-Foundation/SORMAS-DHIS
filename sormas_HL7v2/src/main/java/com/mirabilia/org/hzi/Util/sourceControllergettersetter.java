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

import com.mirabilia.org.hzi.sormas.switchHandlers;

import java.io.IOException;
import java.sql.SQLException;
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
 * @author Mathew
 */
@WebServlet(urlPatterns = {"/controller"})
public class sourceControllergettersetter extends HttpServlet {

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
        
        
        
         HttpSession sessionx = request.getSession(false);  

        int initz = 0;
        int initzx = 0;
       
//update active or not
        if (request.getParameter("insert_checker") != null) {
            String checkBox = (String) request.getParameter("insert_checker");
            String statusx = (String) request.getParameter("status");
            
             try {
                 
                 
                 
                 
                 switchHandlers.SourceButton("debug", checkBox, statusx,"", "", "creat");
                 
                 
                 
                 
                 
             } catch (SQLException ex) {
                 Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
       
        
        
         if (request.getParameter("title") != null) {
            String title = (String) request.getParameter("title");
            String url = (String) request.getParameter("url");
            String desc = (String) request.getParameter("desc");
            String active = (String) request.getParameter("active");
            if(active == null){
            active = "deactivated";
            } else {
            active = "active";
            }
            
             try {
                 
                 
                 
                 
                 switchHandlers.SourceButton("debug", title, url, desc, active,  "create");
                 
                 
                 
                 
                 
             } catch (SQLException ex) {
                 Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
         
          if (request.getParameter("getAllList") != null) {
        //      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
              try {
                  JSONParser jsonParser = new JSONParser();
                  JSONObject jsonObjectx;

                  String jsonRaw = getAlltoJSON.ListSources();

                  jsonObjectx = (JSONObject) jsonParser.parse(jsonRaw);
                  
                    response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(200);
                ServletOutputStream sout = response.getOutputStream();
                String content = ""+jsonObjectx;
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>"+jsonObjectx);

                sout.print(content);
                

              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ParseException ex) {
                 Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
             }
          
          }
        
     
    }


}