package com.mirabilia.org.hzi.Util.dhis;

import static com.mirabilia.org.hzi.Util.dhis.DHIS2resolver.getDemAll;
import static com.mirabilia.org.hzi.Util.dhis.dhisOrgRetrival.starter;
import com.mirabilia.org.hzi.sormas.doa.ConffileCatcher;

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
@WebServlet(urlPatterns = {"/orggetter"})
public class orgUnitConn extends HttpServlet {

    private static String[] _url = ConffileCatcher.fileCatcher("passed");

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

        if (initz == 1989) {
            JSONParser jsonParser = new JSONParser();
            String urll = _url[10].toString();

            String base_url = urll + "/api/organisationUnits.json?fields=name&maxLevel=1";

            String json_all = getDemAll(base_url);

            JSONObject jsonObjectx;
            if (json_all.isEmpty()) {

                response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(500);
                ServletOutputStream sout = response.getOutputStream();
                String content = "DHIS2 Not Responding";
                sout.print(content);
                sessionx.setAttribute("err", "<div class=\"alert alert-danger\" role=\"alert\">  DHIS Instance Not available/not responding OR adapter timed-out, relogin</div>");
                return;
            }

            try {
                jsonObjectx = (JSONObject) jsonParser.parse(json_all);
                Object pager_values = jsonObjectx.get("pager");

                //System.out.println(pager_values);

                JSONObject jsonObjectxx = (JSONObject) pager_values;

                Long level = (Long) jsonObjectxx.get("pageCount");
                String conv = level + "";

                int page_count = Integer.parseInt((String) conv);
                int counter = 1;

                response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(200);
                ServletOutputStream sout = response.getOutputStream();
                String content = "" + page_count;

                //returning total number of available pages
                sessionx.setAttribute("total_org", content);
                sout.print(content);

                return;

            } catch (ParseException ex) {
                Logger.getLogger(orgUnitConn.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            }

        }

        if (initz == 5050) {
            JSONParser jsonParser = new JSONParser();
            String urll = _url[10].toString();

            String base_url = urll + "/api/organisationUnits.json?fields=name&maxLevel=1";

            String json_all = getDemAll(base_url);

            JSONObject jsonObjectx;
            if (json_all.isEmpty()) {

                response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(500);
                ServletOutputStream sout = response.getOutputStream();
                String content = "DHIS2 Not Responding";
                sout.print(content);
                  sessionx.setAttribute("err", "<div class=\"alert alert-danger\" role=\"alert\">  DHIS Instance Not available / not responding OR adapter timed-out, relogin</div>");
             
                return;
            } else {
             sessionx.setAttribute("err", "");
            }

            try {
                jsonObjectx = (JSONObject) jsonParser.parse(json_all);
                Object pager_values = jsonObjectx.get("pager");
                JSONObject jsonObjectxx = (JSONObject) pager_values;
                Long org_ttl = (Long) jsonObjectxx.get("total");
                String conv = org_ttl + "";

                Object org_values = jsonObjectx.get("organisationUnits");
                String nn = org_values.toString();
                String cnty_set = sessionx.getAttribute("country").toString();
                //System.out.println(cnty_set);

                if (!nn.contains(cnty_set)) {
                    sessionx.setAttribute("err", "<div class=\"alert alert-danger\" role=\"alert\">  DHIS Instance Country is different from the one set in control file or not set properly? please fix this problem!</div>");
                } else {
                    sessionx.setAttribute("err", "");
                }

                int page_count = Integer.parseInt((String) conv);

                response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(200);
                ServletOutputStream sout = response.getOutputStream();
                String content = "" + page_count;

                sessionx.setAttribute("total_org", content);
                sout.print(content);
                return;

            } catch (ParseException ex) {
                Logger.getLogger(orgUnitConn.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            }

        }

        if (initzx > 0) {

            try {
                String urll = _url[10].toString();
                //process each shunk and send the progress back to progress bar.
                
                //System.out.println("URL in USE >>>>>>>>>>>>>>>>>> "+urll);
                String ct_code = sessionx.getAttribute("country_code").toString();
                int pg_ = starter(initzx, urll, ct_code);
                
                response.setContentType("text/plain;charset=UTF-8");
                response.setStatus(200);
                ServletOutputStream sout = response.getOutputStream();
                String content = "" + pg_;
                sout.print(content);
                 //System.out.println("percentage been sent back to frontend"+content+"%");
            } catch (SQLException ex) {
                Logger.getLogger(orgUnitConn.class.getName()).log(Level.SEVERE, null, ex);
            }
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
