package com.mirabilia.org.hzi.test;


import com.mirabilia.org.hzi.sormas.doa.DbConnector;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class tester_ {

    private static List<String> fieldList = new ArrayList();

    public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        float seq = ((float)34 / 35);
        String str = String.format("%2.02f", seq);
        
       System.out.println(str);
        return;
    }

    
    
}
