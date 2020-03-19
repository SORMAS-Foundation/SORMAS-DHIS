package com.mirabilia.org.hzi.sormas;

import com.mirabilia.org.hzi.proj.sormas.DbConnector;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 *
 * @author Mathew
 */
public class switchHandlers {

    public static void SourceButton(String debug, String uid, String what_Do) throws SQLException, ClassNotFoundException {

        try {

            PreparedStatement ps;
            ResultSet rx;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DbConnector.getConnection();

            try {

                ps = null;
                rx = null;
                //update data source
                if (what_Do.contains("update")) {
                    ps = conn.prepareStatement("UPDATE `sormas_`.`_sources` SET `url`=?, `title`=?, `desc`=?, `source_dest_switch`=?, `last_update`=now() WHERE  `uid`=?");
                }
                //create data source
                if (what_Do.contains("create")) {
                    uid = shortUUID(debug);
                    ps = conn.prepareStatement("insert into `sormas_`.`_sources` SET `url`=?, `title`=?, `desc`=?, `source_dest_switch`=?, `created`=now()");
                }
                ps.setString(1, ""); //url
                ps.setString(2, "");//title
                ps.setString(3, "");//descripton
                ps.setString(4, "");//destination
                ps.setString(5, uid);//uid

                ps.execute();
                if (debug.contains("debug")) {
                    System.out.println("Sources with the following uid updated!" + uid);
                }
                return;
            } finally {
                conn.close();
            }

        } finally {

        }
    }

    //
    public static void SormasPintch(String debug, String uid, String what_Do) throws SQLException, ClassNotFoundException {

        try {

            PreparedStatement ps;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DbConnector.getConnection();

            try {

                ps = null;
                //update data source
                if (what_Do.contains("update")) {
                    ps = conn.prepareStatement("UPDATE `sormas_`.`_useradmin` SET `namex`=?, `passw`=?, `fullname`=?, `lastlogin`=?, `active`=?, `rolex`=? WHERE  `uid`=?");
                }
                //create data source
                if (what_Do.contains("create")) {
                    uid = shortUUID(debug);
                    ps = conn.prepareStatement("insert into `uid`=?, `sormas_`.`_useradmin` SET `namex`=?, `passw`=?, `fullname`=?, `lastlogin`=?, `active`=?, `rolex`=?");
                }
                ps.setString(1, uid); //namex
                ps.setString(2, "");//passw
                ps.setString(3, "");//fullname
                ps.setString(4, "");//lastlogin
                ps.setString(5, "");//active
                ps.setString(6, "");//rolex
                ps.setString(7, "");//uid

                ps.execute();
                if (debug.contains("debug")) {
                    System.out.println("Sources with the following uid updated!" + uid);
                }
                return;
            } finally {
                conn.close();
            }

        } finally {

        }
    }

    public static String shortUUID(String debug) {
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        if (debug.contains("debug")) {
            System.out.println("Sources with the following uid created!" + Long.toString(l, Character.MAX_RADIX));
        }
        return Long.toString(l, Character.MAX_RADIX);
    }
}
