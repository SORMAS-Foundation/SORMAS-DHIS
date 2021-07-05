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
package com.mirabilia.org.hzi.Util.EntryControllers;

import com.mirabilia.org.hzi.sormas.doa.ConffileCatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mathew
 */

@WebServlet(name = "drtyuioihgfdsdtyuiojhfdrtyuiokjhgfde5678ijhvde5678iokjhgfr56789ijhgfde45678uij", urlPatterns = {"/drtyuioihgfdsdtyuiojhfdrtyuiokjhgfde5678ijhvde5678iokjhgfr56789ijhgfde45678uij"})
public class credentialAccess extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("upass")+ " Method in use..."+ request.getParameter("usern"));

        response.sendRedirect(request.getContextPath());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("upass")+ " Method in use..."+ request.getParameter("usern"));

        HttpSession sessionx = request.getSession();
        
        String[] paramx = ConffileCatcher.fileCatcher("passed");
        String usrnm = paramx[14];
        String passwd = paramx[15];
        
        

        if (request.getParameter("usern") != null && request.getParameter("upass") != null) {
            
            

            if (request.getParameter("usern").equals(usrnm)) {
                if (request.getParameter("upass").equals(passwd)) {

                    Logger.getLogger(credentialAccess.class.getName()).log(Level.INFO, "User Logged in was successful: ADMINISTRATOR");
                    sessionx.setAttribute("xloggedx", "true");
                    response.sendRedirect("fhir_frontend/adapter_frontend.jsp");
                    
                } else {
                    Logger.getLogger(credentialAccess.class.getName()).log(Level.INFO, "User Logged in was denialed: password/username not match");
                    response.sendRedirect("logout.jsp");

                }
            } else {

                Logger.getLogger(credentialAccess.class.getName()).log(Level.INFO, "User Logged in was denailed: password/username not match");
                response.sendRedirect("logout.jsp");

            }

        } else {
            Logger.getLogger(credentialAccess.class.getName()).log(Level.INFO, "User Logged in was denailed: password/username not match");
            response.sendRedirect("logout.jsp");
        }
    }

}
