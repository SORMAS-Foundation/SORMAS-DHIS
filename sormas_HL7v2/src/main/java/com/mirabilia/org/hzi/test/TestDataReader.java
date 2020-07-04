package com.mirabilia.org.hzi.test;


    import java.io.FileReader;
    import java.io.IOException;
    import java.io.Reader;
    import java.io.FileWriter;

   import org.json.simple.JSONArray;
   import org.json.simple.JSONObject;
   import org.json.simple.parser.JSONParser;
   import org.json.simple.parser.ParseException;

   @SuppressWarnings("unchecked")
   public class TestDataReader {

    public static void main(String[] args) {        

    try (Reader reader = new FileReader("c:\\Intel\\TC_11.json")) {
        // Read JSON file
        JSONParser parser = new JSONParser();
        JSONObject data = (JSONObject) parser.parse(reader);
        
        System.out.println(data.toString());
      /** 
        @SuppressWarnings("resource")
        FileWriter file = new FileWriter("c:\\Intel\\TC_11.json");
        file.write(data.toJSONString());
        file.flush();
**/
    } catch (IOException e) {
        e.printStackTrace();
       } catch (ParseException e1) {
            e1.printStackTrace();
       }
   }

   }