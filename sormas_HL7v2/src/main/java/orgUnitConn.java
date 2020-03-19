
import com.mirabilia.org.hzi.proj.sormas.DbConnector;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
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

        int initz = 0;
        int initzx = 0;
       

        if (request.getParameter("pg_counter") != null) {
            initz = Integer.parseInt((String) request.getParameter("pg_counter"));
        }
        
        if (request.getParameter("pg_counterx") != null) {
            initzx = Integer.parseInt((String) request.getParameter("pg_counterx"));
        }
       

        JSONParser jsonParser = new JSONParser();
        String base_url = "http://172.105.77.79:8080/dhis/api/organisationUnits.json?fields=lastUpdated,id,name,shortName,level,created,path&paging=true&maxLevel=4";
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
    
    public static int starter(int pg_counterd){
     if (pg_counterd > 1) {
         
        JSONParser jsonParser = new JSONParser();
        String base_url = "http://172.105.77.79:8080/dhis/api/organisationUnits.json?fields=lastUpdated,id,name,shortName,level,created,path&paging=true&maxLevel=4";
        String json_all = getDemAll(base_url);
        PreparedStatement pstmt;
        ResultSet rx;

        JSONObject jsonObjectx;

      //  System.out.println("XXXXX<<<<<<<<<<<<<<XXXXXXXXXXX = " + pg_counterd);
         
            try {
                jsonObjectx = (JSONObject) jsonParser.parse(json_all);
                Object pager_values = jsonObjectx.get("pager");

                JSONObject jsonObjectxx = (JSONObject) pager_values;

              
              
                    String base_urlx = "http://172.105.77.79:8080/dhis/api/organisationUnits.json?page=" + pg_counterd + "&maxLevel=4&paging=true&fields=lastUpdated%2Cid%2Cname%2CshortName%2Clevel%2Ccreated%2Cpath";
                    String nxtpg_url_val = getDemAll(base_urlx);
                    
                    gotoDB(nxtpg_url_val);
            } catch (ParseException ex) {
                Logger.getLogger(orgUnitConn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
     
    
    return pg_counterd;
    }

    public static String gotoDB(String json_all) {
        JSONParser jsonParser = new JSONParser();

        PreparedStatement pstmt;
        ResultSet rx;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DbConnector.getConnection();
            //Parsing the contents of the JSON file retrieved from DHIS2
            JSONObject jsonObject = (JSONObject) jsonParser.parse(json_all);
            //Retrieving the array
            JSONArray jsonArray = (JSONArray) jsonObject.get("organisationUnits");

            //Insert a row into the MyPlayers table
            pstmt = con.prepareStatement("INSERT ignore INTO raw_ (uuid, name, shortname, created, path_parent, level, updated_last, rec_created) values (?, ?, ?, ?, ?, ?,? , now())");
            for (Object object : jsonArray) {
                JSONObject record = (JSONObject) object;

                String idx = (String) record.get("id");
                String namex = (String) record.get("name");
                String created = (String) record.get("created");

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                java.sql.Timestamp datetime = new Timestamp(formatter.parse(created.replace("T", " ")).getTime());
                //     long datetimex = datetime.getTime();

                String path = (String) record.get("path");
                Long level = (Long) record.get("level");
                String levelx = level + "";
                String lastUpdated = (String) record.get("lastUpdated");

                java.sql.Timestamp lastUpdatedx = new Timestamp(formatter.parse(lastUpdated.replace("T", " ")).getTime());
                //  long lastUpdatedxx = lastUpdatedx.getTime();

                String shorName = (String) record.get("shortName");

                pstmt.setString(1, idx);
                pstmt.setString(2, namex);
                pstmt.setString(3, shorName);
                pstmt.setTimestamp(4, datetime);
                pstmt.setString(5, path);
                pstmt.setString(6, levelx);
                pstmt.setTimestamp(7, lastUpdatedx);
                //   System.out.println("inserting records..." + pstmt);
                pstmt.executeUpdate();
            }
            con.close();;
            System.out.println("Records inserted.....");
        } catch (ParseException e) {
        } catch (java.text.ParseException ex) {
            Logger.getLogger(jsonController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(orgUnitConn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(orgUnitConn.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static String getDemAll(String pg_url) {

        HttpURLConnection urlConnection = null;
        String name = "field";
        String password = "Passcode1!x";
        StringBuilder sb = new StringBuilder();

        String authString = name + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        try {
            URL url = new URL(pg_url);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("GET");
            urlConnection.setUseCaches(true);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            // urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            int HttpResult = urlConnection.getResponseCode();
            //debug  System.out.println("######cccccccccccc####Outreach Session HTTP Return Code = " + HttpResult);

            if (HttpResult == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                //debug  System.out.println("#########AAA###" + sb.toString());
                if (sb.toString().indexOf("success") >= 1) {
                    //      response.setStatus(200);
                    System.err.println("FIXED: Success!");
                    return sb.toString();
                }
                if (sb.toString().indexOf("warning") >= 1) {
                    //        response.setStatus(300);
                    System.err.println("FIXED: Warning!");
                    return sb.toString();
                }
                if ((sb.toString().indexOf("warning") >= 1) || (sb.toString().indexOf("success") >= 1)) {
                    //      response.setStatus(414);
                    System.err.println("Noticable Error:\n" + sb.toString());
                    return sb.toString();
                }
            } else {
                //response.setStatus(502, "DHIS2 Not there!");
                System.out.println("####CCCCCCCCCCCCCC" + urlConnection.getInputStream().toString());
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                System.out.println("#####XXX##" + sb.toString());
                System.out.println("OUT ERROR:>>>>" + urlConnection.getResponseMessage());
                return sb.toString();
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(jsonController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(jsonController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
if (1==2){
            try {
                String string = "2020-02-22 22:13:50.948";
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                java.sql.Timestamp datetime = new Timestamp(formatter.parse(string).getTime());
                //   System.out.println("DatedTime: " + datetime.toString());

                System.err.println("FIXED: Warning!");
            } catch (java.text.ParseException ex) {
                Logger.getLogger(jsonController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        }
        return sb.toString();
    }

}
