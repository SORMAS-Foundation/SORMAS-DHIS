<%@page import="com.mirabilia.org.hzi.Util.analysisDTO"%>
<%

    int frs = 0;
    int t = 0;
    if (request.getParameter("levelX") != null) {
        t = Integer.parseInt(request.getParameter("levelX"));
   
        int lst = 500;

        int seq = analysisDTO.Cutter(t); //this cuts the total into 500 per batch to manage server resources
        seq = seq - 1;

        for (int i = 0; i < seq; i++) {
            analysisDTO.fastSender(frs, lst, t, session.getAttribute("country_code").toString());
            frs = lst;
            lst = lst + 500;
    }
    }
    analysisDTO.Deduplicate();

%>
<h3>Total processed...<%=frs%></h3>
<script>

    location.replace("../fhir_frontend/OrgToolOperation.jsp?doneanalyse=true");
</script>
