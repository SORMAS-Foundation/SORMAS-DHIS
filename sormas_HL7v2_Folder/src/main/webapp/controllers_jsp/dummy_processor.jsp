<%@page import="com.mirabilia.org.hzi.Util.analysisDTO"%>
<%

    int frs = 0;
    for (int t = 1; t < 6;) {

        frs = 0;
        int lst = 500;

        System.out.println(t);

        int seq = analysisDTO.Cutter(t); //this cuts the total into 500 per batch to manage server resources

        for (int i = 0; i < seq; i++) {
            analysisDTO.fastSender(frs, lst, t, session.getAttribute("country_code").toString());
            frs = lst;
            lst = lst + 500;

        }

        t++;
    }
    analysisDTO.Deduplicate();

%>
<h3>Total processed...<%=frs%></h3>
<script>

    location.replace("../fhir_frontend/OrgToolOperation.jsp?doneanalyse=true");
</script>
