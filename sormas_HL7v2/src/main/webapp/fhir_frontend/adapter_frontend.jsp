<%@page import="com.mirabilia.org.hzi.Util.credentialsManagerUtil"%>
<%@page import="com.mirabilia.org.hzi.sormas.doa.DbConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.mirabilia.org.hzi.sormas.doa.ConffileCatcher"%>
<%@page import="com.mirabilia.org.hzi.sormas.getterSetters"%>
<%@page import="com.mirabilia.org.hzi.Util.sourceDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("xloggedx") == null || session.getAttribute("xloggedx") != "truet_" ){
    response.sendRedirect(request.getContextPath());
    }
        PreparedStatement ps;
        ResultSet rx;
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DbConnector.getConnection();
        String str = "";
        
try {
            ps = conn.prepareStatement("select url from _sources where title like '%dhis%';");
            rx = ps.executeQuery();
            if (rx.next()) {
            session.setAttribute("url_dhis",rx.getString(1));
            }
            
} 
finally{
    
}
 String[] _url = ConffileCatcher.fileCatcher("passed");
    session.setAttribute("fhir_url", _url[11].toString());

    session.setAttribute("country", _url[12].toString());
    session.setAttribute("country_code", _url[13].toString());

    String totalOrg = sourceDTO.totalORGinDB();
    String totalDest = sourceDTO.totalDestDB();
    String tablx = getterSetters.getNoLastUpdated();
    session.setAttribute("dhis_url", _url[10].toString());
    
credentialsManagerUtil.setDhis_User(_url[16].toString());
credentialsManagerUtil.setDhis_pawd(_url[17].toString());


%>

<jsp:include page="update_url.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="en">
    <jsp:include page="template/head.jsp"></jsp:include>

        <body class="sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed control-sidebar-slide-open accent-purple">
            <div class="wrapper">


                <!-- Navbar -->
            <jsp:include page="template/nav.jsp"></jsp:include>
                <!-- /.navbar -->

                <!-- Main Sidebar Container -->
            <jsp:include page="template/aside.jsp"></jsp:include>

                <!-- Content Wrapper. Contains page content -->
                <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                    <div class="content-header">
                        <div class="container-fluid">
                            <div class="row mb-2">
                                <div class="col-sm-6">
                                    <h1 class="m-0 text-dark">Dashboard | OrgTool Module</h1>
                                </div><!-- /.col -->
                                <div class="col-sm-6">
                                    <ol class="breadcrumb float-sm-right">
                                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                                        <li class="breadcrumb-item active">Dashboard | OrgTool</li>
                                    </ol>
                                </div><!-- /.col -->
                            </div><!-- /.row -->
                        </div><!-- /.container-fluid -->
                    </div>
                    <!-- /.content-header -->

                    <!-- Main content -->
                    <section class="content">
                        <div class="container-fluid">
                            <!-- Info boxes -->
                            <div class="row">
                                <div class="col-12 col-sm-6 col-md-3">
                                    <div class="info-box">
                                        <span class="info-box-icon bg-info elevation-1"><i class="fa fa-hospital"></i></span>
                                       
                                    <div class="info-box-content" style="width:40%">
                                        <span class="info-box-text">Total imported from DHIS2</span>
                                        <span class="info-box-number">
                                            <%=totalOrg%> 
                                            <small>| Synced from DHIS2</small>
                                        </span>
                                    </div>
                                    <!-- /.info-box-content -->
                                </div>
                                <!-- /.info-box -->
                            </div>
                            <!-- /.col -->


                            <div class="col-12 col-sm-6 col-md-3">
                                <div class="info-box mb-3">
                                    <span class="info-box-icon bg-warning elevation-1"><i class="fas fa-sign-out-alt"></i></span>

                                    <div class="info-box-content">
                                        <span class="info-box-text">Total imported from SORMAS</span>
                                        <span class="info-box-text"><b> <%=totalDest%> </b>  <small>| Synced from SORMAS</small></span>

                                    </div>
                                    <!-- /.info-box-content -->
                                </div>
                                <!-- /.info-box -->
                            </div>
                                        

                            <!-- fix for small devices only -->
                            <div class="clearfix hidden-md-up"></div>

                            <div class="col-12 col-sm-6 col-md-3">
                                <div class="info-box mb-3">
                                    <span class="info-box-icon bg-success elevation-1"><i class="fas fa-sign-in-alt"></i></span>

                                    <div class="info-box-content">
                                        <span class="info-box-text">Total No of Org Unit on DHIS</span>
                                        <span class="info-box-text"><b id="DHIS">updating... ${sessionScope.total_org}</b></span>
                                    </div>
                                    <!-- /.info-box-content -->
                                </div>
                                <!-- /.info-box -->
                            </div>
                            <!-- /.col -->

                            <div class="col-12 col-sm-6 col-md-3">

                                <div class="info-box mb-3">

                                    <span class="info-box-icon bg-danger elevation-1"><i class="fas fa-sync-alt"></i></span>

                                    <div class="info-box-content">

                                        <span class="info-box-text">No of OrgUnits on SORMAS</span>
                                        <span class="info-box-number" id="SRMS">loading</span>
                                    </div>
                                    <!-- /.info-box-content -->
                                </div>
                                <!-- /.info-box -->
                            </div>
                            <!-- /.col -->

                            <!-- /.col -->
                        </div>
                        <!-- /.row -->

                    </div><!--/. container-fluid -->
                </section>



                <section class="content">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-title">Infrastructure Module Overview</h5>

                                    <div class="card-tools">
                                        <button type="button" class="btn btn-tool" data-card-widget="collapse">
                                            <i class="fas fa-minus"></i>
                                        </button>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-tool dropdown-toggle" data-toggle="dropdown">
                                                <i class="fas fa-wrench"></i>
                                            </button>
                                            <div class="dropdown-menu dropdown-menu-right" role="menu">
                                                <a href="#" class="dropdown-item">Action</a>
                                                <a href="#" class="dropdown-item">Another action</a>
                                                <a href="#" class="dropdown-item">Something else here</a>
                                                <a class="dropdown-divider"></a>
                                                <a href="#" class="dropdown-item">Separated link</a>
                                            </div>
                                        </div>
                                        <button type="button" class="btn btn-tool" data-card-widget="remove">
                                            <i class="fas fa-times"></i>
                                        </button>
                                    </div>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-8">
                                            <p class="text-center">
                                                <strong>Last Five Infrastructure log</strong>
                                            </p>

                                            <div class="chart">
                                                <!-- Sales Chart Canvas -->
                                                <div >
                                                    <table class="table table-hover table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th>Creation Date</th>
                                                                <th>Infrastructure Name</th>
                                                                <th>Last Update on Adapter</th>
                                                                <th>Action performed by</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%=tablx%>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                            <!-- /.chart-responsive -->
                                        </div>
                                        <!-- /.col -->
                                        <div class="col-md-4">
                                            <p class="text-center">
                                                <strong>Infrastructure Reconciliation Completion</strong>
                                            </p>

                                            <div class="progress-group">
                                                Unmatched infrastructure to be resolved
                                                <span class="float-right" id="att"></span>
                                                <div class="progress progress-sm">
                                                    <div class="progress-bar bg-danger" id="att_" style="width: 100%"></div>
                                                </div>
                                            </div>
                                            <!-- /.progress-group -->

                                            <div class="progress-group">
                                                Duplicates infrastructure to be resolved
                                                <span class="float-right" id="btt"></span>
                                                <div class="progress progress-sm">
                                                    <div class="progress-bar bg-primary" id="btt_"  style="width: 100%"></div>
                                                </div>
                                            </div>

                                            <!-- /.progress-group -->
                                            <div class="progress-group">
                                                <span class="progress-text">Possible Duplicates infrastructure to be resolved</span>
                                                <span class="float-right" id="ctt"></span>
                                                <div class="progress progress-sm">
                                                    <div class="progress-bar bg-warning" id="ctt_" style="width: 100%"></div>
                                                </div>
                                            </div>

                                            <!-- /.progress-group -->
                                            <div class="progress-group">
                                                Total Matched Infrastructure
                                                <span class="float-right" id="dtt"></span>
                                                <div class="progress progress-sm">
                                                    <div class="progress-bar bg-success" id="dtt_" style="width: 100%"></div>
                                                </div>
                                            </div>
                                            <!-- /.progress-group -->


                                            <%
                                                String dxe = "0";
                                                String dxex = "0";
                                                if(getterSetters.getNoGeoPoints() != null){
                                                dxe = getterSetters.getNoGeoPoints();
                                               dxex = getterSetters.getNoSynced();
                                                }


                                            %>
                                            <br>
                                            <div class="progress-group">
                                                Locations without GeoPoints
                                                <span class="float-right"><b><%=dxe%></span>
                                                <div class="progress progress-sm">
                                                    <div class="progress-bar bg-info" style="width: 1%"></div>
                                                </div>
                                            </div>

                                            <!-- /.progress-group
                                            <div class="progress-group">
                                              <span class="progress-text">Locations without phone no</span>
                                              <span class="float-right"><b>0</b>/11879</span>
                                              <div class="progress progress-sm">
                                                <div class="progress-bar bg-purple" style="width: 1%"></div>
                                              </div>
                                            </div>
                                            -->
                                            <!-- /.progress-group -->
                                            <div class="progress-group">
                                                Unclassified issues
                                                <span class="float-right"><b>0</b>/<%=totalOrg%></span>
                                                <div class="progress progress-sm">
                                                    <div class="progress-bar bg-dark" style="width: 1%"></div>
                                                </div>
                                            </div>
                                            <!-- /.progress-group -->
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                    <!-- /.row -->
                                </div>
                                <!-- ./card-body -->
                                <div class="card-footer">
                                    <div class="row" title="this section is under development, values are placeholder for now!!">
                                        <div class="col-sm-3 col-6">
                                            <div class="description-block border-right">
                                                <span class="description-percentage text-success"><i class="fas fa-caret-up"></i> 89%</span>
                                                <h5 class="description-header"><%=dxex%></h5>
                                                <span class="description-text">TOTAL SYNCED</span>
                                            </div>
                                            <!-- /.description-block -->
                                        </div>
                                        <!-- /.col -->
                                        <div class="col-sm-3 col-6">
                                            <div class="description-block border-right">
                                                <span class="description-percentage text-warning"><i class="fas fa-caret-left"></i> 0%</span>
                                                <h5 class="description-header">-</h5>
                                                <span class="description-text">TOTAL UNRESOLVED</span>
                                            </div>
                                            <!-- /.description-block -->
                                        </div>
                                        <!-- /.col -->
                                        <div class="col-sm-3 col-6">
                                            <div class="description-block border-right">
                                                <span class="description-percentage text-warning"><i class="fas fa-caret-left"></i> 0%</span>
                                                <h5 class="description-header">-</h5>
                                                <span class="description-text">TOTAL RESOLVED</span>
                                            </div>
                                            <!-- /.description-block -->
                                        </div>
                                        <!-- /.col -->
                                        <div class="col-sm-3 col-6">
                                            <div class="description-block">
                                                <span class="description-percentage text-warning"><i class="fas fa-caret-left"></i> 0%</span>
                                                <h5 class="description-header">-</h5>
                                                <span class="description-text">MY NEW TASKS</span>
                                            </div>
                                            <!-- /.description-block -->
                                        </div>
                                    </div>
                                    <!-- /.row -->
                                </div>
                                <!-- /.card-footer -->
                            </div>
                            <!-- /.card -->

                            <!--div class="card" style ="displat: none;">
                                                <div class="card-header">
                                                    <h3 class="card-title" id="678i">Milestone Analysis</h3>
                
                                                    <div class="card-tools">
                                                        <div class="input-group input-group-sm" style="width: 150px;">
                                                            <input type="text" name="table_search" class="form-control float-right" placeholder="Search">
                
                                                            <div class="input-group-append">
                                                                <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                              
                            
                                                <div class="card-body table-responsive p-0">
                                                    <table class="table table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th style="width: 10px">#</th>
                                                                <th style="width: 200px">Milestone</th>
                                                                <th style="width: 300px">Actual</th>
                                                                <th>Progress</th>
                                                                <th style="width: 40px">%</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td>1.</td>
                                                                <td>Facility Matching</td>
                                                                <td>232/12000</td>
                                                                <td>
                                                                    <div class="progress progress-xs">
                                                                        <div class="progress-bar bg-success"  style="width: 55%"></div>
                                                                    </div>
                                                                </td>
                                                                <td><span class="badge bg-danger">55%</span></td>
                                                            </tr>
                                                            <tr>
                                                                <td>2.</td>
                                                                <td>Source 1 Data Sync</td>
                                                                <td>9234/9234</td>
                                                                <td>
                                                                    <div class="progress progress-xs">
                                                                        <div class="progress-bar bg-success" style="width: 100%"></div>
                                                                    </div>
                                                                </td>
                                                                <td><span class="badge bg-warning">100%</span></td>
                                                            </tr>
                                                            <tr>
                                                                <td>3.</td>
                                                                <td>DHIS2 Data Sync</td>
                                                                <td>12210/12210</td>
                                                                <td>
                                                                    <div class="progress progress-xs progress-striped active">
                                                                        <div class="progress-bar bg-success" style="width: 100%"></div>
                                                                    </div>
                                                                </td>
                                                                <td><span class="badge bg-primary">100%</span></td>
                                                            </tr>
                                                            <tr>
                                                                <td>4.</td>
                                                                <td>Sources Reconciliation</td>
                                                                <td>9234/12210</td>
                                                                <td>
                                                                    <div class="progress progress-xs progress-striped active">
                                                                        <div class="progress-bar bg-success" style="width: 90%"></div>
                                                                    </div>
                                                                </td>
                                                                <td><span class="badge bg-success">90%</span></td>
                                                            </tr>
                                                            
                                                            <tr>
                                                                <td>5.</td>
                                                                <td>FHIR Data Published</td>
                                                                <td>9234/12210</td>
                                                                <td>
                                                                    <div class="progress progress-xs progress-striped active">
                                                                        <div class="progress-bar bg-success" style="width: 90%"></div>
                                                                    </div>
                                                                </td>
                                                                <td><span class="badge bg-success">90%</span></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                
                                                </div>
                                               
                                            </div-->
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->

                </section>





                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <!-- Control Sidebar -->
            <!-- /.control-sidebar -->

            <!-- Main Footer -->

        </div>





        <jsp:include page="template/scripts_footer.jsp"></jsp:include>



            <script>

                var ses_ = '<%= session.getAttribute("jobber")%>';
                var ses1_ = '<%= session.getAttribute("jobber1")%>';
                var ses2_ = '<%= session.getAttribute("jobber2")%>';
                var ses3_ = '<%= session.getAttribute("jobber3")%>';


                starterx("5050");

                function starterx(what) {
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../orggetter?pg_counter=' + what, true);
                    xhr.responseType = 'text';
                    var maxx = 0;
                    //starterx();

                    console.log("1 - total chunks to be process");
                    //get the total chunks

                    xhr.onload = function () {
                        if (xhr.readyState === xhr.DONE) {
                            if (xhr.status === 200) {
                                maxx = xhr.responseText;
                                console.log(what + " getting value= " + maxx);
                                document.getElementById("DHIS").innerHTML = "DHIS = " + xhr.responseText;


                            } else {
                                console.log("Server error while contacting main methods to get total number of chunks");
                                return;
                            }
                        }
                    };

                    xhr.send("");
                    xhr.DONE
                }
                starter();

                function starter() {
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../controller?getAllTotalfromSRMS=', true);
                    xhr.responseType = 'text';
                    var maxx = 0;

                    xhr.onload = function () {
                        if (xhr.readyState === xhr.DONE) {
                            if (xhr.status === 200) {
                                maxx = xhr.responseText;
                                //~~
                                const myArr = maxx.split("~~");
                                //console.log("SRMS getting value = " + xhr.responseText);
                                document.getElementById("SRMS").innerHTML = "SRMS = " + myArr[0];
                                document.getElementById("SRMS").title = myArr[1];


                            } else {
                                alert("ERROR MIR1242: Server error while contacting main methods to get total number of chunks");
                                return;
                            }
                        }
                    };

                    xhr.send("");
                    xhr.DONE
                }




                resx();


                function resx() {

                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?count=10', true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                        if (xhr.readyState === xhr.DONE) {
                            if (xhr.status === 200) {
                                intPerser(xhr.responseText);
                            } else {
                                alert("There is a problem retreiving analytics from server, please rerun Analytics 'Analyse' button");
                                return;
                            }
                        }
                    };
                    xhr.send(null);

                }

                function intPerser(e) {
                    const words = e.split(',');
                    var a = parseInt(words[0]);
                    var b = parseInt(words[1]);
                    var c = parseInt(words[2]);
                    var d = parseInt(words[3]);

                    var tt = a + b + c + d;
                    $('#att').html('<b>' + a + '</b>/' + tt + '')
                    $('#att_').css('width', '' + Math.floor((a / tt) * 100) + '%')

                    $('#btt').html('<b>' + b + '</b>/' + tt + '')
                    $('#btt_').css('width', '' + Math.floor((b / tt) * 100) + '%')

                    $('#ctt').html('<b>' + c + '</b>/' + tt + '')
                    $('#ctt_').css('width', '' + Math.floor((c / tt) * 100) + '%')

                    $('#dtt').html('<b>' + d + '</b>/' + tt + '')
                    $('#dtt_').css('width', '' + Math.floor((d / tt) * 100) + '%')



                }
        </script>

    </body>
</html>
