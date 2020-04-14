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
package com.mirabilia.org.hzi.Util.EntryControllers;

import static com.mirabilia.org.hzi.Util.dbResolvers.getAllOrgFromDB;
import static com.mirabilia.org.hzi.Util.dhis.DHIS2resolver.getDemAllfromFHIR;
import com.mirabilia.org.hzi.Util.sourceDTO;
import static com.mirabilia.org.hzi.Util.sourceDTO.updateSourcesPairs;
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

                switchHandlers.SourceButton("debug", checkBox, statusx, "", "", "creat");

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
            if (active == null) {
                active = "deactivated";
            } else {
                active = "active";
            }

            try {

                switchHandlers.SourceButton("debug", title, url, desc, active, "create");

            } catch (SQLException ex) {
                Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (request.getParameter("getAllList") != null) {
            
            String multi_ = request.getParameter("getAllList");
            
             JSONParser jsonParser = new JSONParser();
                JSONObject jsonObjectx;
            //      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            try {
               

                String jsonRaw = sourceDTO.ListSourcestoJSON(multi_);

             //   jsonObjectx = (JSONObject) jsonParser.parse(jsonRaw);
                
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+jsonRaw.toString());

                response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(200);
                ServletOutputStream sout = response.getOutputStream();
                String content = "" + jsonRaw;
                   System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>"+jsonRaw);

                sout.print(content);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
         //This method syncs orgunits into fhir server.
         //TO-DO Implement method to sort last update

        if (request.getParameter("getAllListfromDBtoFHIR") != null) {

            String dxd = "tyui";

            try {

               System.out.println("I am here o");
                 //This method syncs orgunits into fhir server.
            //send 1 to create and 2 to update.
                getAllOrgFromDB(2);
                

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        if (request.getParameter("getAllTotalfromFHIR") != null) {
            
            try {
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObjectx;
                String base_url = "http://172.105.77.79:3447/fhir/Location";
                String json_all = getDemAllfromFHIR(base_url);
                
                System.out.println(json_all);
                
                jsonObjectx = (JSONObject) jsonParser.parse(json_all);
                Object total_values_onFHIR = jsonObjectx.get("total");
                ;
                response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(200);
                ServletOutputStream sout = response.getOutputStream();
                String content = "" + total_values_onFHIR;

                sout.print(content);
                
            } catch (ParseException ex) {
                Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(request.getParameter("getupdateStarted") != null){
         if (request.getParameter("from") != null && request.getParameter("to") != null) {
             
             
         System.out.println(request.getParameter("from")+" = source and dest = "+request.getParameter("to"));
         
            try {
                String from = request.getParameter("from");
                String to = request.getParameter("to");
                
                
                
                 ServletOutputStream sout = response.getOutputStream();
                 
                String content = "" + updateSourcesPairs(from, to);
                
                sout.print(content);
                
                
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
            }
         
         
         } else{
             
              ServletOutputStream sout = response.getOutputStream();
                 
                String content = "FAILED! please select appropriate pairing";
                
                sout.print(content);
             
         }
        
    }}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dxd = "";

        try {
            //This method syncs orgunits into fhir server.
            //send 1 to create and 2 to update.
            getAllOrgFromDB(1);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sourceControllergettersetter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
