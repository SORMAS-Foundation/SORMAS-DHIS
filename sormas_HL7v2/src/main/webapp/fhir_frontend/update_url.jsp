<%@page import="com.mirabilia.org.hzi.sormas.getterSetters"%>
<%@page import="com.mirabilia.org.hzi.Util.sourceDTO"%>
<%@page import="com.mirabilia.org.hzi.sormas.doa.ConffileCatcher"%>
<%@page import="com.mirabilia.org.hzi.sormas.doa.DbConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%

    String[] _url = ConffileCatcher.fileCatcher("passed");
    PreparedStatement ps;
    ResultSet rx;
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DbConnector.getConnection();

    try {
        ps = conn.prepareStatement("update _sources set url = '" + _url[10].toString() + "' where title like '%dhis%';");
        System.out.println(ps.toString());
        ps.execute();
    } finally {

    }
%>