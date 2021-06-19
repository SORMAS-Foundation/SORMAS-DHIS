<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mirabilia.org.hzi.sormas.doa.DbConnector"%>
<%@page import="java.sql.PreparedStatement"%>
<%

    String lister = "";

    PreparedStatement ps;
    Class.forName("org.postgresql.Driver");
    Connection conn = DbConnector.getPgConnection();

    try {
        ps = conn.prepareStatement("truncate region cascade;");
        ps.executeQuery();
        
    } catch (SQLException ex) {
        out.print("SQLException: " + ex.getMessage());
        out.print("SQLState: " + ex.getSQLState());
        out.print("VendorError: " + ex.getErrorCode());
    }
%>