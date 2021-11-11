package com.mirabilia.org.hzi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.json.simple.parser.ParseException;



public class tester_ {
   public static void main(String[] args) throws ParseException {
     List<String> lst = new ArrayList<>();
     lst.add("aaaaa");
     lst.add("aadddaaa");
     lst.add("aassssaaa");
     
     ListIterator<String> lstItems = lst.listIterator();
     int i = 1;
        while (lstItems.hasNext()) {
            System.out.println(lstItems.next() + i++);
          
        }
     }
     
     

}

