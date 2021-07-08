package com.mirabilia.org.hzi.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;



public class tester_ {
   public static void main(String[] args) throws ParseException {
     JSONObject json = new JSONObject();

        JSONArray array = new JSONArray();


                JSONObject item1 = new JSONObject();
                item1.put("dataElement", "XxNsLxPryII");
                item1.put("value", "");
                array.add(item1);
            

               JSONObject item2 = new JSONObject();
                item2.put("dataElement", "VqXyuGhuxuE");
                item2.put("value", "");
                array.add(item2);
 
                
                JSONObject item3 = new JSONObject();
                item3.put("dataElement", "tsHJlIHk7KX");
                item3.put("value", "");
                array.add(item3);
 
                
                JSONObject item4 = new JSONObject();
                item4.put("dataElement", "dfgND0rAxwx");
                item4.put("value", "");
                array.add(item4);
 
                
                JSONObject item5 = new JSONObject();
                item5.put("dataElement", "eYE9Ys4Pv13");
                item5.put("value", "");
                array.add(item5);
 
                
                
                JSONObject item6 = new JSONObject();
                item6.put("dataElement", "mLZi1qXO2pQ");
                item6.put("value", "");
                array.add(item6);
  

            json.put("dataValues", array);

            //enrollment data
         
            json.put("program", "m0lmvyTblN0");
            json.put("orgUnit", "");
            json.put("eventDate", "");
            json.put("status", "m0lmvyTblN0");
            json.put("completedDate", "m0lmvyTblN0");
            json.put("program", "m0lmvyTblN0");

            System.out.println(json);
}
}

