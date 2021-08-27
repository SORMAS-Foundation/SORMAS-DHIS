
import com.mirabilia.org.hzi.Util.credentialsManagerUtil;
import com.mirabilia.org.hzi.sormas.doa.ConffileCatcher;
import com.mirabilia.org.hzi.sormas.doa.DbConnector;
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
import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonController {

    public static void main(String args[]) {
        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();
        String json_all = getDem();
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
            pstmt = con.prepareStatement("INSERT INTO `raw_` (`uuid`, `name`, `shortname`, `created`, `path_parent`, `level`, `updated_last`, `rec_created`) values (?, ?, ?, ?, ?, ? ,?, now())");
            for (Object object : jsonArray) {
                JSONObject record = (JSONObject) object;

                String idx = (String) record.get("id");
                String name = (String) record.get("name");
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
                pstmt.setString(2, name);
                pstmt.setTimestamp(3, datetime);
                pstmt.setString(4, path);
                pstmt.setString(5, levelx);
                pstmt.setTimestamp(6,  lastUpdatedx);
                pstmt.setString(7, shorName);
                System.out.println("inserting records..." + pstmt);
                pstmt.executeUpdate();
            }
          //  System.out.println("Records inserted.....");
        } catch (ParseException e) {
        } catch (ClassNotFoundException | SQLException e) {
        } catch (java.text.ParseException ex) {
            Logger.getLogger(jsonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   private static String[] _url = ConffileCatcher.fileCatcher("passed");

    private static String httpx = _url[10].toString(); //should come from config file


    public static String getDem() {

        String http = httpx+"/api/organisationUnits.json?fields=lastUpdated,id,name,shortName,level,created,path&paging=true&maxLevel=1";

        HttpURLConnection urlConnection = null;
        String name = credentialsManagerUtil.getDhis_User();
        String password = credentialsManagerUtil.getDhis_pawd();
        StringBuilder sb = new StringBuilder();

        String authString = name + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
        String authStringEnc = new String(authEncBytes);
        try {
            URL url = new URL(http);
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
            //System.out.println("######cccccccccccc####Outreach Session HTTP Return Code = " + HttpResult);

            if (HttpResult == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                System.out.println("#########AAA###" + sb.toString());

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

            try {
                String string = "2020-02-22 22:13:50.948";
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                java.sql.Timestamp datetime = new Timestamp(formatter.parse(string).getTime());
                System.out.println("DatedTime: " + datetime.toString());
                
                System.err.println("FIXED: Warning!");
            } catch (java.text.ParseException ex) {
                Logger.getLogger(jsonController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return sb.toString();
    }
}
