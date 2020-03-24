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

                                        <div class="info-box-content" style="width:40%">
                                            <span class="info-box-text">New Org Unit</span>
                                            <span class="info-box-number">
                                                10
                                                <small> | Discovered</small>
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
                                            <span class="info-box-text">No of synced Org Units</span>
                                            <span class="info-box-number">41,410</span>
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
                                            <span class="info-box-text">Total No of Org Unit</span>
                                            <span class="info-box-text"><b id="org_total">Source</b></span>
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
                                            <span class="info-box-text">Total No of Org Unit</span>
                                            <span class="info-box-text"><b>Destination</b></span>
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
                    <!-- /.content -->
                </div>
                <!-- /.content-wrapper -->

                <!-- Control Sidebar -->
                <!-- /.control-sidebar -->

                <!-- Main Footer -->

            </div>
            
            
            
            
            
        <jsp:include page="template/scripts_footer.jsp"></jsp:include>



        <script>
            var xhr = new XMLHttpRequest();
            xhr.open('GET', '../orggetter?pg_counter=5050', true);
            xhr.responseType = 'text';
            var maxx = 0;
            starterx();

            console.log("1 - total chunks to be process");
            //get the total chunks
            function starterx() {
                xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                        if (xhr.status === 200) {
                            maxx = xhr.responseText;
                            console.log("1 - total chunks to be process = " + maxx);
                            document.getElementById('org_total').innerHTML = "DHIS = " + xhr.responseText;


                        } else {
                            console.log("Server error while contacting main methods to get total number of chunks");
                            return;
                        }
                    }
                };

                xhr.send("");
            }
        </script>

    </body>
</html>