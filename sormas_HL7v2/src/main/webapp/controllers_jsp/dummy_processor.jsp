<%@page import="com.mirabilia.org.hzi.Util.analysisDTO"%>
<%
    //int seq = 1;
   int seq = analysisDTO.Cutter(); //this cuts the total into 500 per batch to manage server resources
    
    int frs = 0;
    int lst = 500;

    int total_cnt = seq * 500;

    for (int i = 0; i < seq; i++) {
          analysisDTO.fastSender(frs, lst); //we are pushing the sync to server in batches incrementally
        frs = lst;
        lst = lst + 500;
        %>
<h3>Total processed...<%=frs%></h3>
            <%
    }

%>

<script>
    
location.replace("../fhir_frontend/OrgToolOperation.jsp?doneanalyse=true");
</script>
