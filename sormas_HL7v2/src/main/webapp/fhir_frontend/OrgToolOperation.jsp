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
                <div class="content-wrapper" id="contw">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <div class="container-fluid">
                            <div class="row mb-2">
                                <div class="col-sm-6">
                                    <h2>Sources Controls</h2>
                                </div>
                                <div class="col-sm-6">
                                    <ol class="breadcrumb float-sm-right">
                                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                                        <li class="breadcrumb-item active">Configuration</li>
                                    </ol>
                                </div>
                            </div>
                        </div><!-- /.container-fluid -->
                    </section>

                <%
                    String sourcesX = sourceDTO.getSourcePaired();

                %>
                <section class="col-lg-12 connectedSortable">
                    <div class="row">
                        <!-- Source creator -->
                        <section class="col-lg-12 connectedSortable">
                            <!-- TO DO List -->
                            <div class="card">
                                <div class="card-header" id="addit">


                                    <h3 class="card-title">
                                        <i class="ion ion-clipboard mr-1"></i>



                                        Active source paired selected = <b><i> <%=sourcesX%> </i></b>
                                    </h3>

                                </div>
                                <!-- /.card-header -->



                                <div class="card-body row">
                                    <a href="source_controller.jsp" class="btn btn-app">
                                        <i class="fas fa-edit"></i> Edit
                                    </a>
                                    
                                    
                                    <a class="btn btn-app" onclick="location.href = '../controllers_jsp/localized.jsp';">
                                        <i class="fas fa-cogs"></i> Analyse
                                    </a>
                                    
                                    
                                    <a onclick="dd();" id="sync_" class="btn btn-app">
                                        <i class="fas fa-play"></i> Sync
                                    </a>







                                    <div class="col-md-3 col-sm-6 col-12 loadingxx" id="progress_">
                                        <div class="info-box bg-info">
                                            <span class="info-box-icon"><i class="far fa-bookmark"></i></span>

                                            <div class="info-box-content">
                                                <span class="info-box-text">Total Expected</span>
                                                <span class="info-box-number" id="totaler"></span>

                                                <div class="progress">
                                                    <div id="pbar" class="progress-bar" style="width: 100%"></div>
                                                </div>
                                                <span class="progress-description" id="chunker">
                                                    Preparing...
                                                </span>
                                            </div>
                                            <!-- /.info-box-content -->
                                        </div>
                                        <!-- /.info-box -->
                                    </div>

                                    <div class="col-md-3 col-sm-6 col-12" id="progress_Fhir">
                                        <div class="info-box bg-success">
                                            <span class="info-box-icon"><i class="far fa-check"></i></span>

                                            <div class="info-box-content">
                                                <span class="info-box-text">Storing @ FHIR Server</span>
                                                <span class="info-box-number" id="totaler_"></span>

                                                <div class="progress">
                                                    <div class="progress-bar" style="width: 100%"></div>
                                                </div>
                                                <span class="progress-description">
                                                    Data is being stored.
                                                </span>
                                            </div>
                                            <!-- /.info-box-content -->
                                        </div>
                                        <!-- /.info-box -->
                                    </div>
                                </div>                <!-- /.card-body -->
                                <div class="card-footer clearfix">
                                    <!--button type="button" class="btn btn-info float-right" data-toggle="modal" id="source_addition_button" data-target="#modal-sources"><i class="fas fa-plus"></i> Add item
                                    </button-->
                                </div>

                            </div>
                            <!-- /.card -->
                        </section>  <!--section class="col-lg-5 connectedSortable"-->





                    </div>
                </section>
            </div>



            <jsp:include page="template/scripts_footer.jsp"></jsp:include>




            <script>
                $('#progress_').hide();
                $('#progress_Fhir').hide();
                $('#sync_').hide();

                var max = 0;

                var xhr = new XMLHttpRequest();


                xhr.open('GET', '../orggetter?pg_counter=1', true);

                xhr.responseType = 'text';

                var maxx = 0;

                //populates the number of chunks from Source 1 (prehead)
                starterx();


                //fires the main sync process.
                function starter() {
                    $('#progress_').show();
                    servlet_primer(10);
                    //console.log(maxx);
                    //  myloader(0);

                }
                ;



                //get the total chunks
                function starterx() {
                    xhr.onload = function () {
                        if (xhr.readyState === xhr.DONE) {
                            if (xhr.status === 200) {
                                maxx = xhr.responseText;
                                console.log("1 - total chunks to be process = " + maxx);
                                alertx();
                                //    $('#addit').append("<button type=\"button\" class=\"btn btn-block bg-gradient-success btn-xs col-lg-4\">Server now ready</button><br>");

                                gren();
                                //   style="background-color: darkseagreen;min-height: 530px;"                            
                                $('#sync_').show();

                                var total = maxx * 100;

                                $('#totaler').append(total);//chunker
                                //   $('#chunker').append("chunks to process | "+ maxx);//chunker





                            } else {
                                console.log("Server error while contacting main methods to get total number of chunks");
                                return;
                            }
                        }
                    };

                    xhr.send("");
                }
                ;
                function gren() {
                    document.getElementById("contw").style.background = "#9eca9d";
//  document.getElementById("contw").style.background-color = "darkseagreen";
                }
                ;
                //process the entire chunks one after the other

                function servlet_primer(stat) {

                    if (stat > 0) {
                        var xhr = new XMLHttpRequest();
                        xhr.open('GET', '../orggetter?pg_counterx=' + stat, true);



                        xhr.responseType = 'text';
                        xhr.onload = function () {
                            if (xhr.readyState === xhr.DONE) {
                                if (xhr.status === 200) {
                                    max = xhr.responseText;
                                    myloader(max);
                                    //   console.log("Number of chunk been processed currently = " + max);
                                }
                            }
                        };

                        xhr.send(null);


                        success: servlet_primer(stat - 1);

                    }

                }
                ;

                function myloader(width) {
                    // $('.progress-bar').css('width', width+'%');
                    console.log(width + '%');

                    //    $('#pbar').append(width);//???
                    //

                    var dd = document.getElementById("pbar").style.width = width + '%';
                    var ddc = document.getElementById("chunker").innerHTML = width + "%";

                    if (width < 3) {

//Fhir need to start here.
                        $('#progress_').hide();
                        $('#progress_Fhir').show();
//Debugging with create only
                        setTimeout(servlet_primer_fhir(1), 3000)

                    }
                }
                ;





            </script>
            <script type="text/javascript">
                document.getElementById("sync").addEventListener("click", function (event) {
                    event.preventDefault()
                });

                function dd() {

                    starter();

                }
                
                
                 function ds() {
                 // window.location("./controllers/localizer.jsp");
                }

                function servlet_primer_fhir(stat) {

                    if (stat > 0) {
                        var xhr = new XMLHttpRequest();
                        xhr.open('GET', '../controller?getAllListfromDBtoFHIR=' + stat, true);



                        xhr.responseType = 'text';
                        xhr.onload = function () {
                            if (xhr.readyState === xhr.DONE) {
                                if (xhr.status === 200) {
                                    cleaner();
                                }
                            }
                        };

                        xhr.send(null);


                        success: servlet_primer(stat - 1);

                    }

                }
                ;


                function cleaner() {
                    $('#progress_').hide();
                    $('#progress_Fhir').hide();
                }
                ;

                function alertx() {
                    const Toast = Swal.mixin({
                        toast: true,
                        position: 'top-end',
                        showConfirmButton: false,
                        timer: 3000
                    });
                    Toast.fire({
                        type: 'success',
                        title: 'Server now ready!.'
                    });
                }
                ;
            </script>
    </body>
</html>