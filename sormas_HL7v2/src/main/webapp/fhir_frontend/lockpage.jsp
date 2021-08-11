<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

if(session.getAttribute("xloggedx") != null && "truet_".equals(session.getAttribute("xloggedx").toString())){
    
response.sendRedirect("adapter_frontend.jsp");

} else{
%>
<jsp:include page="locked/index.html"></jsp:include>
<%
}

%>
