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

                    <div id="overlay" onclick="off()">
                        <div id="text"><h2>Working on it... we will redirect you to the processor.</h2></div></div>

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
                                    </h3> <span>&nbsp; &nbsp; may edit by clicking the <b>Edit Config</b> button </span>

                                </div>
                                <!-- /.card-header -->



                                <div class="card-body row">
                                    <a href="source_controller.jsp" class="btn btn-app hvr-icon-buzz-out">
                                        <i class="fas fa-edit hvr-icon"></i> Edit Config
                                    </a>


                                    <a class="btn btn-app hvr-icon-buzz-out" onclick="location.href = '../controllers_jsp/localized.jsp';">
                                        <i class="fas fa-download hvr-icon"></i> Prime Destination
                                    </a>




                                    <a onclick="dd();" id="sync_" class="btn btn-app hvr-icon-buzz-out">
                                        <i class="fas fa-download hvr-icon"></i> Prime DHIS
                                    </a>

                                    <a onclick="ana();" id="analysedb" class="btn btn-app hvr-icon-buzz-out">
                                        <i class="fas fa-sync hvr-icon"></i> Analyse DB
                                    </a>

                                    <a onclick="resx();" id="analyse"dsp class="btn btn-app hvr-icon-buzz-out">
                                        <i class="fas fa-cogs hvr-icon"></i> Display Results
                                    </a>
                                    
                                    <a onclick="" id="analysefhir" class="btn btn-app hvr-icon-buzz-out">
                                        <i class="fas fa-play hvr-icon"></i> Sync with FHIR
                                    </a>

<%



%>





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

                            <div class="card card-success card-outline" id="body_wx">
                                <div class="card-header">
                                    <h3 class="card-title">
                                       <i class="fas fa-search"></i>
                                        Infrastructure Match Results
                                    </h3>
                                </div>
                                <div class="card-body"  style="">
                                    
                                    <button onclick="dmd('mat')" type="button" class="btn btn-success hvr-curl-top-left" data-toggle="modal" id="full" data-target="#modal-xl">
                                        100% Matched
                                    </button>
                                    <button onclick="dmd('pat_mat')" type="button" class="btn btn-primary hvr-curl-top-left" data-toggle="modal" id="fullx" data-target="#modal-secondary">
                                        Partial Matched
                                    </button>
                                    |
                                    <button onclick="dmd('pat_dup')" type="button" class="btn btn-warning hvr-curl-top-left" data-toggle="modal" id="fullxx" data-target="#modal-info">
                                        Possible Duplicates
                                    </button>
                                    <button onclick="dmd('dup')" type="button" class="btn btn-danger hvr-curl-top-left" data-toggle="modal" id="fullxxx" data-target="#modal-danger">
                                        Duplicates
                                    </button>
                                    |
                                    <button onclick="dmd('_mat')" type="button" class="btn btn-info hvr-curl-top-left" data-toggle="modal" id="fullxxxx" data-target="#modal-warning">
                                        Not Matchable
                                    </button>
                                    
                                </div>
                                <!-- /.card -->
                            </div>

                           
                        </section>  <!--section class="col-lg-5 connectedSortable"-->

<input type="hidden" id="controllerx">
                        <section>



                        </section>


                    </div>
                </section>
            </div>



            <jsp:include page="template/scripts_footer.jsp"></jsp:include>
            <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>




                <script>
                    
                
                        $('#body_wx').hide();
                    
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
                    //get the total chunks
                    function starterx() {
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                    maxx = xhr.responseText;
                 //   console.log("1 - total chunks to be process = " + maxx);
                    alertx();
                    //    $('#addit').append("<button type=\"button\" class=\"btn btn-block bg-gradient-success btn-xs col-lg-4\">Server now ready</button><br>");

                    gren();
                    //   style="background-color: darkseagreen;min-height: 530px;"                            
                    $('#sync_').show();
                    var total = maxx * 100;
                    $('#totaler').append(total); //chunker
                    //   $('#chunker').append("chunks to process | "+ maxx);//chunker





                    } else {
                 //   console.log("Server error while contacting main methods to get total number of chunks");
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




                    //fires the main sync process.
                    function starter() {
                    $('#progress_').show();
                    servlet_primer(maxx);
                    console.log('priming ' + maxx);
                    //  myloader(0);

                    }
                    ;
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

                    function ana() {
                    document.getElementById("overlay").style.display = "block";
                    setTimeout(function(){

                    location.replace("../controllers_jsp/analytics_staging.jsp");
                    }, 2000);
                    }
                    
                    function resx() {
                    
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?count=10', true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                        
                       console.log("Number of 100 percent machedprocessed currently = " + xhr.responseText);
                    const words = xhr.responseText.split(',');
                    $('#fullxxxx').html("100% Not Matchable = "+words[0]);
                    $('#fullxxx').html("100% Duplicates = "+words[1]);
                    $('#fullxx').html("Possible Duplicate = "+words[2]);
                    $('#fullx').html("Partial Matched = "+words[2]);
                    $('#full').html("100% Matched = "+words[3]);
                     $('#body_wx').show();
                    }else{
                        alert("There is a problem retreiving analytics from server, please rerun Analytics 'Analyse' button");
                        return;
                    }
                    }
                    };
                    xhr.send(null);
                   
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

            <%
                if (request.getParameter("sayfini") != null) {
                    String sta = request.getParameter("sayfini");

                    switch (sta) {
                        case "true":
            %>

            <script>

                const Toast = Swal.mixin({
                toast: true,
                        position: 'top-end',
                        showConfirmButton: true,
                        timer: 6000
                });
                Toast.fire({
                type: 'success',
                        title: 'Server completed.'
                });
            </script>



            <%
                    break;
                case "false":
            %>

            <script>

                const Toast = Swal.mixin({
                toast: true,
                        position: 'top-end',
                        showConfirmButton: true,
                        timer: 6000
                });
                Toast.fire({
                type: 'error',
                        title: 'Server could not complete Operation!'
                });
                
                
                
                    
                    
                    

                
                
                
                
                
                
                
                
                
            </script>



            <%
                            break;
                        default:
                        // code block
                    }

                }


            %>
            <style>
                #overlay {
                    position: fixed;
                    display: none;
                    width: 100%;
                    height: 100%;
                    top: 0;
                    left: 0;
                    right: 0;
                    bottom: 0;
                    background-color: rgba(0,0,0,0.5);
                    z-index: 2;
                    cursor: pointer;
                }

                #text{
                    position: absolute;
                    top: 50%;
                    left: 50%;
                    font-size: 50px;
                    color: white;
                    transform: translate(-50%,-50%);
                    -ms-transform: translate(-50%,-50%);
                }
            </style>
            <script>
                document.getElementById("overlay").style.display = "none";

            </script>
          <!--MODALS BASIN-->  
            <div class="modal fade" id="modal-xl" style="display: none;" aria-hidden="true">
                <div class="" style="padding-left: 20px; padding-right: 10px;">
                    <div class="modal-content">
                       
                       <div class="" style="min-height: 1416.81px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Infrastructure Reconciliation Wizard</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Last Updated</a></li>
              <li class="breadcrumb-item active">20-10-2020</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        
        <!-- Timelime example  -->
        <div class="row">
          <div class="col-md-12">
            <!-- The time line -->
            <div class="timeline">
              <!-- timeline time label -->
              <div class="time-label">
                <span class="bg-blue">Organisation Unit Selection</span>
              </div>
              <!-- /.timeline-label -->
              
              <!-- timeline item -->
              <div>
                  <i class="fas fa-user bg-green"></i>
                  <div class="timeline-item">
                      <span class="time"><i class="fas fa-clock"></i> 5 mins ago</span>
                      <h3 class="timeline-header no-border"><a href="#"></a> Parent organisation unit</h3>
                      <div class="timeline-body">
                          <div class="row">
  <div class="input-group input-group col-3">
                                  <input type="text" onchange="" id="nigeria_x" list="" autocomplete="off" value="Nigeria" disable="true" readonly class="form-control">

                              </div>
                              <div class="col-5">
                                  <div class="progress progress-xs" style="height: 30%;">
                                      <div class="progress-bar progress-bar-warning" id="dfe" style="width: 0%"> 
                                          <a onclick="statex('state_x')" id="state_g" type="button" class="btn btn-warning btn-flat"></a>
                                      </div></div>
                                  <h3 class="" id="789"></h3>
                              </div>
                                <div class="col-2">
                                    <a onclick="tableloader('nigeria_x')" id="state_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                 </div>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- END timeline item -->
              <!-- timeline item -->
              <div>
                  <i id="statexx" class="fas fa-bars bg-yellow"></i>
                  <div class="timeline-item">
                      <span class="time"><i class="fas fa-clock"></i> 27 mins ago</span>
                      <h3 class="timeline-header"><a href="#">Select</a> State / Region</h3>
                      <div class="timeline-body">
                          <div class="row">
                              <div class="input-group input-group col-3">
                                  <input type="text" onchange="load_lga()" id="state_x" list="state" autocomplete="off" class="form-control">

                              </div>
                              <div class="col-5">
                                  <div class="progress progress-xs" style="height: 30%;">
                                      <div class="progress-bar progress-bar-warning" id="dfe_lga" style="width: 0%"> 
                                          <a onclick="tableloader('state_x')" id="lga_g" type="button" class="btn btn-warning btn-flat"></a>
                                      </div></div>
                                  <h3 class="" id="789_lga"></h3>
                              </div>
                               <div class="col-2">
                                    <a onclick="tableloader('state_x')" id="lga_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                 </div>
                          </div>
                      </div>
                  </div>
              </div>
              <!-- END timeline item -->
              
                <!-- timeline item -->
                <div id="lgax" style="display: none">
                    <i id="lgaxx" class="fas fa-bars bg-yellow"></i>
                    <div class="timeline-item">
                        <span class="time"><i class="fas fa-clock"></i> 27 mins ago</span>
                        <h3 class="timeline-header"><a href="#">Select</a> Local Government Area / District</h3>
                        <div class="timeline-body">
                            <div class="row">
                                <div class="input-group input-group-sm col-3">
                                    <input type="text" list="lga" onchange="load_ward()" id="lga_x" autocomplete="off" class="form-control">

                                </div>
                                <div class="col-5">
                                    <div class="progress progress-xs" style="height: 30%;">
                                        <div class="progress-bar progress-bar-warning" id="dfe_ward" style="width: 0%"> 
                                            <a onclick="tableloader('lga_x')" id="ward_g" type="button" class="btn btn-warning btn-flat"></a>
                                        </div>
                                    </div>
                                    <h3 class="" id="789_ward"></h3>
                                </div>
                                <div class="col-2">
                                    <a onclick="tableloader('lga_x')" id="ward_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                 </div>
                            </div>
                        </div>
                    </div>
                </div>
              <!-- END timeline item -->
              
              
              
              
              
              
              
               <!-- timeline item -->
                <div id="wardx" style="display: none">
                    <i id="wardxx" class="fas fa-bars bg-yellow"></i>
                    <div class="timeline-item">
                        <span class="time"><i class="fas fa-clock"></i> 27 mins ago</span>
                        <h3 class="timeline-header"><a href="#">Select</a> Ward / Community</h3>
                        <div class="timeline-body">
                            <div class="row">
                                <div class="input-group input-group-sm col-3">
                                    <input type="text" list="ward" onchange="load_hf()" id="ward_x" autocomplete="off" class="form-control">

                                </div>
                                <div class="col-5">
                                    <div class="progress progress-xs" style="height: 30%;">
                                        <div class="progress-bar progress-bar-warning" id="dfe_hf" style="width: 0%"> 
                                            <a onclick="tableloader('ward_x')" id="hf_g" type="button" class="btn btn-warning btn-flat"></a>
                                        </div>
                                    </div>
                                    <h3 class="" id="789_hf"></h3>
                                </div>
                                <div class="col-2">
                                    <a onclick="tableloader('ward_x')" id="hf_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                 </div>
                            </div>
                        </div>
                    </div>
                </div>
              <!-- END timeline item -->
              
              
              
              
              
              
              
              
              
              
              
                <!--
              <div id="wardx" style="display: none">
                <i id="wardxx" class="fas fa-bars bg-yellow"></i>
                <div class="timeline-item">
                  <span class="time"><i class="fas fa-clock"></i> 27 mins ago</span>
                  <h3 class="timeline-header"><a href="#">Select</a> Ward / Community</h3>
                  <div class="timeline-body">
                    
                      <div class="input-group input-group-sm col-5">
                  <input type="text" list="ward" autocomplete="off" class="form-control">
                  <span class="input-group-append">
                    <button type="button" class="btn btn-info btn-flat">Next</button>
                  </span>
                </div>
                  </div>
                </div>
              </div>
              <!-- END timeline item -->
              
                <!-- timeline item -->
              <div id="hfx" style="display: none">
                <i id="hfxx" class="fas fa-bars bg-yellow"></i>
                <div class="timeline-item">
                  <span class="time"><i class="fas fa-clock"></i> 27 mins ago</span>
                  <h3 class="timeline-header"><a href="#">Select</a> Health Facilities</h3>
                  <div class="timeline-body">
                    
                      <div class="input-group input-group-sm col-5">
                  <input type="text" list="hf" autocomplete="off" class="form-control">
                  <span class="input-group-append">
                    <button type="button" class="btn btn-info btn-flat">Next</button>
                  </span>
                </div>
                  </div>
                </div>
              </div>
              <!-- END timeline item -->
              <!-- timeline time label -->
              <div class="time-label">
                <span class="bg-green">Details</span>
              </div>
              <!-- /.timeline-label -->
              
               <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
              
              <!-- timeline item -->
              <div>
                <i class="fa fa-bars bg-purple"></i>
                <div class="timeline-item">
                  <span class="time"><i class="fas fa-clock"></i> 2 days ago</span>
                  
                  
                  <div class="timeline-body">
                    <table id="detailer" class="display" style="width:100%">
        <thead>
            <tr>
                <th>SN</th>
                <th>SOMRAS UUID</th>
                <th>SOURCE UUID</th>
                <th>SORMAS NAME</th>
                <th>SOURCE NAME</th>
                <th>LAST MATCHED</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>SN</th>
                <th>SOMRAS UUID</th>
                <th>SOURCE UUID</th>
                <th>SORMAS NAME</th>
                <th>SOURCE NAME</th>
                <th>LAST MATCHED</th>
            </tr>
        </tfoot>
    </table>
                  </div>
                </div>
              </div>
              <!-- END timeline item -->
              <!-- timeline item -->
             
              <!-- END timeline item -->
             
            </div>
          </div>
          <!-- /.col -->
        </div>
      </div>
      <!-- /.timeline -->

    </section>
    <!-- /.content -->
  </div>
                        
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            
<datalist id="state">
 
</datalist>
          
          <datalist id="lga">
</datalist>
          
          <datalist id="ward">
</datalist>
          
          <datalist id="hf">
</datalist>
          <script>
              function dmd(e){
                  $('#controllerx').val(e);
                  //var v = document.getElementById(e).value;
                 
                  var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?primer='+e, true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                    //max = xhr.responseText;
                    const words = xhr.responseText.split(',');
                    const wordsx = xhr.responseText.split(',@@@');
                    $('#dfe').css("width", words[0]);
                    $('#state_g').html(words[0]);
                    $('#789').html('<a href="#">Total States @ destination</a> = '+words[1]+' | <a href="#">Total States from Source</a> = '+words[2]+' | <a href="#">Total Matched</a> = '+words[3])
                   $('#state').html(wordsx);
                   
                    //   console.log("Number of chunk been processed currently = " + max);
                    }}};
                    xhr.send(null);
              }
              
              function dmds(e){
                  var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?parentx='+e+'&levelx=3', true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                    //max = xhr.responseText;
                    const words = xhr.responseText.split(',');
                    const wordsx = xhr.responseText.split(',@@@');
                    $('#dfe_lga').css("width", words[0]);
                    $('#lga_g').html(words[0]);
                    $('#789_lga').html('<a href="#">Total LGAs @ destination</a> = '+words[1]+' | <a href="#">Total LGAs from Source</a> = '+words[2]+' | <a href="#">Total Matched</a> = '+words[3])
                   $('#lga').html(wordsx);
                   
                    //   console.log("Number of chunk been processed currently = " + max);
                    }}};
                    xhr.send(null);
              }
              
                function dmdm(e){
                  var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?parentx='+e+'&levelx=4', true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                    //max = xhr.responseText;
                    const words = xhr.responseText.split(',');
                    const wordsx = xhr.responseText.split(',@@@');
                    $('#dfe_ward').css("width", words[0]);
                    $('#ward_g').html(words[0]);
                    $('#789_ward').html('<a href="#">Total Wards @ destination</a> = '+words[1]+' | <a href="#">Total Wards from Source</a> = '+words[2]+' | <a href="#">Total Matched</a> = '+words[3])
                   $('#ward').html(wordsx);
                   
                    //   console.log("Number of chunk been processed currently = " + max);
                    }}};
                    xhr.send(null);
              }
              
              
              function load_lga(){
                  var ex = $('#state_x').val();
                  dmds(ex);
                  $('#lgax').show();
                  $('#statexx').removeClass("fas fa-bars bg-yellow").addClass("fas fa-check bg-green")
              }
              function load_ward(){
                  var ex = $('#lga_x').val();
                  dmdm(ex);
                  $('#wardx').show();
                  $('#lgaxx').removeClass("fas fa-bars bg-yellow").addClass("fas fa-check bg-green")
              }
              
              function statex(e){
                  var x = $('#controllerx').val();
                  alert(e);
                  alert(x);
                  var v = document.getElementById(e).value;
                  alert(v);
                  var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?parentx='+v+'&methodx'+x, true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                                
                    //   console.log("Number of chunk been processed currently = " + max);
                    }}};
                    xhr.send(null);
                  
              }
              
              function tableloader(e) {
               
                 var pd = document.getElementById(e).value;
               
                
                $('#detailer').DataTable( {
                    "destroy": true,
                    "paging": true,
                "processing": true,
            
                "ajax": {
                 "url": "../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?jsonparentx="+pd+"&jsonlevelx"+e,
                 "dataType": "json"
                    }
                } );
                    } ;
                    
          </script>
            </body>
</html>