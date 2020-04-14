<%@page import="com.mirabilia.org.hzi.Util.sourceDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                    <h1 class="m-0 text-dark">Dashboard</h1>
                                </div><!-- /.col -->
                                <div class="col-sm-6">
                                    <ol class="breadcrumb float-sm-right">
                                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                                        <li class="breadcrumb-item active">Dashboard</li>
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
<%
String totalOrg = sourceDTO.totalORGinDB();

%>
                                        <div class="info-box-content" style="width:40%">
                                            <span class="info-box-text">Total Org Unit on Adapter</span>
                                            <span class="info-box-number">
                                                <%=totalOrg%> 
                                                <small>| Stored</small>
                                            </span>
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
                                          
                                            <span class="info-box-text">No of synced OrgUnits on FHIR</span>
                                            <span class="info-box-number" id="FHIR">loading</span>
                                        </div>
                                        <!-- /.info-box-content -->
                                    </div>
                                    <!-- /.info-box -->
                                </div>
                                <!-- /.col -->

                                <!-- fix for small devices only -->
                                <div class="clearfix hidden-md-up"></div>

                                <div class="col-12 col-sm-6 col-md-3">
                                    <div class="info-box mb-3">
                                        <span class="info-box-icon bg-success elevation-1"><i class="fas fa-sign-in-alt"></i></span>

                                        <div class="info-box-content">
                                            <span class="info-box-text">Total No of Org Unit on DHIS</span>
                                            <span class="info-box-text"><b id="DHIS">loading</b></span>
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
                                            <span class="info-box-text">Total No of Org Unit Synced</span>
                                            <span class="info-box-text"><b>External Destination not set</b></span>
                                        </div>
                                        <!-- /.info-box-content -->
                                    </div>
                                    <!-- /.info-box -->
                                </div>
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
                <h5 class="card-title">Monthly Recap Report</h5>

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
                      <strong>Infrastructure log (last month)</strong>
                    </p>

                    <div class="chart">
                      <!-- Sales Chart Canvas -->
                      <canvas id="salesChart" height="180" style="height: 180px;"></canvas>
                    </div>
                    <!-- /.chart-responsive -->
                  </div>
                  <!-- /.col -->
                  <div class="col-md-4">
                    <p class="text-center">
                      <strong>Infrastructure Reconciliation Completion</strong>
                    </p>

                    <div class="progress-group">
                      Possible duplicates to be resolved
                      <span class="float-right"><b>160</b>/200</span>
                      <div class="progress progress-sm">
                        <div class="progress-bar bg-primary" style="width: 80%"></div>
                      </div>
                    </div>
                    <!-- /.progress-group -->

                    <div class="progress-group">
                      Locations without GeoPoints
                      <span class="float-right"><b>310</b>/400</span>
                      <div class="progress progress-sm">
                        <div class="progress-bar bg-danger" style="width: 75%"></div>
                      </div>
                    </div>

                    <!-- /.progress-group -->
                    <div class="progress-group">
                      <span class="progress-text">Locations without phone no</span>
                      <span class="float-right"><b>480</b>/800</span>
                      <div class="progress progress-sm">
                        <div class="progress-bar bg-success" style="width: 60%"></div>
                      </div>
                    </div>

                    <!-- /.progress-group -->
                    <div class="progress-group">
                      Unclassified issues
                      <span class="float-right"><b>250</b>/500</span>
                      <div class="progress progress-sm">
                        <div class="progress-bar bg-warning" style="width: 50%"></div>
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
                <div class="row">
                  <div class="col-sm-3 col-6">
                    <div class="description-block border-right">
                      <span class="description-percentage text-success"><i class="fas fa-caret-up"></i> 17%</span>
                      <h5 class="description-header">11,099</h5>
                      <span class="description-text">TOTAL SYNCED</span>
                    </div>
                    <!-- /.description-block -->
                  </div>
                  <!-- /.col -->
                  <div class="col-sm-3 col-6">
                    <div class="description-block border-right">
                      <span class="description-percentage text-warning"><i class="fas fa-caret-left"></i> 0%</span>
                      <h5 class="description-header">2,890</h5>
                      <span class="description-text">TOTAL UNRESOLVED</span>
                    </div>
                    <!-- /.description-block -->
                  </div>
                  <!-- /.col -->
                  <div class="col-sm-3 col-6">
                    <div class="description-block border-right">
                      <span class="description-percentage text-success"><i class="fas fa-caret-up"></i> 20%</span>
                      <h5 class="description-header">3,893</h5>
                      <span class="description-text">TOTAL RESOLVED</span>
                    </div>
                    <!-- /.description-block -->
                  </div>
                  <!-- /.col -->
                  <div class="col-sm-3 col-6">
                    <div class="description-block">
                      <span class="description-percentage text-danger"><i class="fas fa-caret-down"></i> 18%</span>
                      <h5 class="description-header">10</h5>
                      <span class="description-text">TOTAL SUBSCRIPTIONS</span>
                    </div>
                    <!-- /.description-block -->
                  </div>
                </div>
                <!-- /.row -->
              </div>
              <!-- /.card-footer -->
            </div>
            <!-- /.card -->
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
            starterx("5050");
            
            function starterx(what) {
            var xhr = new XMLHttpRequest();
            xhr.open('GET', '../orggetter?pg_counter='+what, true);
            xhr.responseType = 'text';
            var maxx = 0;
            //starterx();

            console.log("1 - total chunks to be process");
            //get the total chunks
           
                xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                        if (xhr.status === 200) {
                            maxx = xhr.responseText;
                            console.log(what+" getting value= " + maxx);
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
            xhr.open('GET', '../controller?getAllTotalfromFHIR=', true);
            xhr.responseType = 'text';
            var maxx = 0;
            //starterx();

            console.log("1 - total chunks to be process");
            //get the total chunks
           
                xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                        if (xhr.status === 200) {
                            maxx = xhr.responseText;
                            console.log(" getting value = " + maxx);
                            document.getElementById("FHIR").innerHTML = "FHIR = " + xhr.responseText;


                        } else {
                            console.log("Server error while contacting main methods to get total number of chunks");
                            return;
                        }
                    }
                };

                xhr.send("");
                xhr.DONE
            }
        </script>

    </body>
</html>