package com.mirabilia.org.hzi.Util.dhis;



import static com.mirabilia.org.hzi.Util.dhis.DHIS2resolver.getDemAll;
import static com.mirabilia.org.hzi.Util.dhis.dhisOrgRetrival.starter;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(urlPatterns = {"/orggetter"})
public class orgUnitConn extends HttpServlet {

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
       

        if (request.getParameter("pg_counter") != null) {
            initz = Integer.parseInt((String) request.getParameter("pg_counter"));
        }
        
        if (request.getParameter("pg_counterx") != null) {
            initzx = Integer.parseInt((String) request.getParameter("pg_counterx"));
        }
       

        JSONParser jsonParser = new JSONParser();
        String base_url = "http://172.105.77.79:8080/dhis/api/organisationUnits.json?fields=lastUpdated,id,closedDate,openingDate,name,shortName,level,created,path&paging=true&maxLevel=4";
        String json_all = getDemAll(base_url);
        PreparedStatement pstmt;
        ResultSet rx;

        JSONObject jsonObjectx;

        System.out.println("initial target = " + initz);
        System.out.println("number to process = " + initzx);

        if (initz == 1) {
            //getting initializer

            try {
                jsonObjectx = (JSONObject) jsonParser.parse(json_all);
                Object pager_values = jsonObjectx.get("pager");
                
                System.out.println(pager_values);

                JSONObject jsonObjectxx = (JSONObject) pager_values;

                Long level = (Long) jsonObjectxx.get("pageCount");
                String conv = level + "";

                int page_count = Integer.parseInt((String) conv);
                int counter = 1;
                
                
                response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(200);
                ServletOutputStream sout = response.getOutputStream();
                String content = ""+page_count;
                
                //returning total number of available pages
              //  sessionx.setAttribute("total_org", content);

                sout.print(content);

            //    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                return;

            } catch (ParseException ex) {
                Logger.getLogger(orgUnitConn.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            }

        }
        
        
        
         if (initz == 5050) {
            //getting initializer
 
            try {
                jsonObjectx = (JSONObject) jsonParser.parse(json_all);
                Object pager_values = jsonObjectx.get("pager");
                
                System.out.println(pager_values);

                JSONObject jsonObjectxx = (JSONObject) pager_values;

                Long level = (Long) jsonObjectxx.get("total");
                String conv = level + "";

                int page_count = Integer.parseInt((String) conv);
                int counter = 1;
                
                
                response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(200);
                ServletOutputStream sout = response.getOutputStream();
                String content = ""+page_count;
                
                //returning total number of available pages
                sessionx.setAttribute("total_org", content);

                sout.print(content);

            //    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                return;

            } catch (ParseException ex) {
                Logger.getLogger(orgUnitConn.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            }

        }
        
        
        
        if(initzx > 0){
            
        //process each shunk and send the progress back to progress bar.
        int pg_ = starter(initzx);
        
        response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(200);
                ServletOutputStream sout = response.getOutputStream();
                String content = ""+pg_;
                sout.print(content);
        System.out.println("percentage been sent back to frontend"+content+"%");
        }
     
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}