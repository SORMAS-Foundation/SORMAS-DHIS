package com.mirabilia.org.hzi.test;

import com.mirabilia.org.hzi.sormas.cases.AggregrateController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.simple.parser.ParseException;

public class tester_ {

    private static List<String> fieldList = new ArrayList();
 public static void main(String[] args) {
        // Creating a random UUID (Universally unique identifier).
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString().toUpperCase();

        System.out.println("Random UUID String = " + randomUUIDString);
        System.out.println("UUID version       = " + uuid.version());
        System.out.println("UUID variant       = " + uuid.variant());
    }
    
   
}
