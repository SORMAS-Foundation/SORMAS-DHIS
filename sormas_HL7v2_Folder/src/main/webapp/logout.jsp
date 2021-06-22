
<%
    session.invalidate();
    request.getSession();
    response.sendRedirect(request.getContextPath()+"/");
%>