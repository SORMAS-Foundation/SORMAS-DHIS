package com.mirabilia.org.hzi.test;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

   @SuppressWarnings("unchecked")
   public class TestDataReader {

    public static void main(String[] args) {   
        try {
            JSONParser jsonParser = new JSONParser();
            String json_all = "{\"organisationUnits\":[{\"lastUpdated\":\"2021-09-18T11:25:26.911\",\"code\":\"NG-LG1\",\"level\":2,\"created\":\"2021-08-12T11:12:01.352\",\"name\":\"Lagos State\",\"id\":\"GwPcX4nwChj\",\"shortName\":\"LGSTATE\",\"path\":\"/lF9JYZn7kfV/GwPcX4nwChj\",\"geometry\":{\"type\":\"Point\",\"coordinates\":[28.0,6.333333]}},{\"lastUpdated\":\"2021-09-16T11:12:17.394\",\"code\":\"BNJ\",\"level\":2,\"created\":\"2021-09-16T11:12:16.972\",\"name\":\"New One\",\"id\":\"fiXsGYYGk27\",\"shortName\":\"New\",\"path\":\"/lF9JYZn7kfV/fiXsGYYGk27\"},{\"lastUpdated\":\"2021-08-12T11:22:26.515\",\"code\":\"EK-NG\",\"level\":2,\"created\":\"2021-08-12T01:05:19.930\",\"name\":\"Ondo State\",\"id\":\"WzXMqomNEAd\",\"shortName\":\"ondo\",\"path\":\"/lF9JYZn7kfV/WzXMqomNEAd\"},{\"lastUpdated\":\"2021-09-09T19:27:58.665\",\"code\":\"BNN\",\"level\":2,\"created\":\"2021-09-09T19:27:58.481\",\"name\":\"One_Two\",\"id\":\"Q93ZY38wK5e\",\"shortName\":\"ONe\",\"path\":\"/lF9JYZn7kfV/Q93ZY38wK5e\"}]}";
            
            JSONObject jsonObject = (JSONObject) jsonParser.parse(json_all);
            JSONArray jsonArray = (JSONArray) jsonObject.get("organisationUnits"); 
            JSONObject jsonObj = (JSONObject) jsonArray.get(3);
            
            System.out.println(jsonObj);
            
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(TestDataReader.class.getName()).log(Level.SEVERE, null, ex);
        }

   }}