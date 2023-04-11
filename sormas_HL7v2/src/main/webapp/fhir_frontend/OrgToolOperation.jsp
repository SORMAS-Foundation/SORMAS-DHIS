 <%           
    if(session.getAttribute("xloggedx") != null || session.getAttribute("xloggedx") == "truet_" ){
%>

<%@page import="com.mirabilia.org.hzi.Util.credentialsManagerUtil"%>
<%@page import="com.mirabilia.org.hzi.Util.UtilityAbstracts"%>
<%@page import="com.mirabilia.org.hzi.Util.sourceDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="template/head.jsp"></jsp:include>
        <body class="sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed control-sidebar-slide-open accent-purple">
            <style>
                .clickables {
                    background-color: #ffffff;
                    /* HOVER OFF */
                    -webkit-transition: padding 2s;
                }

                .clickables:hover {
                    background-color:  #f4f4f4;

                    /* HOVER ON */
                    -webkit-transition: border-radius 2s;
                }

                .modal-backdrop {
                    visibility: hidden !important;
                }
                .modal.in {
                    background-color: rgba(0,0,0,0.5);
                }
                body{
                    background-color: #9dbeca;
                }
                .locked_0{
                    pointer-events: none;
                }

            </style>
            <style>
                .switch,.switch * {
                    -webkit-tap-highlight-color: transparent;
                    -webkit-user-select: none;
                    -moz-user-select: none;
                    -ms-user-select: none;
                    user-select: none
                }

                .switch label {
                    /* cursor:pointer; */
                }

                .switch label input[type=checkbox] {
                    opacity: 0;
                    width: 0;
                    height: 0
                }

                .switch label input[type=checkbox]:checked+.lever {
                    background-color: #84c7c1
                }

                .switch label input[type=checkbox]:checked+.lever:before,.switch label input[type=checkbox]:checked+.lever:after {
                    left: 18px
                }

                .switch label input[type=checkbox]:checked+.lever:after {
                    background-color: #26a69a
                }

                .switch label .lever {
                    /* content:""; */
                    display: inline-block;
                    position: relative;
                    width: 36px;
                    height: 14px;
                    background-color: rgba(0,0,0,0.38);
                    border-radius: 15px;
                    margin-right: 10px;
                    -webkit-transition: background 0.3s ease;
                    transition: background 0.3s ease;
                    vertical-align: middle;
                    margin: 0 16px;
                }

                .switch label .lever:before,.switch label .lever:after {
                    content: "";
                    position: absolute;
                    display: inline-block;
                    width: 20px;
                    height: 20px;
                    border-radius: 50%;
                    left: 0;
                    top: -3px;
                    -webkit-transition: left 0.3s ease, background .3s ease, -webkit-box-shadow 0.1s ease, -webkit-transform .1s ease;
                    transition: left 0.3s ease, background .3s ease, -webkit-box-shadow 0.1s ease, -webkit-transform .1s ease;
                    transition: left 0.3s ease, background .3s ease, box-shadow 0.1s ease, transform .1s ease;
                    transition: left 0.3s ease, background .3s ease, box-shadow 0.1s ease, transform .1s ease, -webkit-box-shadow 0.1s ease, -webkit-transform .1s ease
                }

                .switch label .lever:before {
                    background-color: rgba(38,166,154,0.15)
                }

                .switch label .lever:after {
                    background-color: #F1F1F1;
                    -webkit-box-shadow: 0px 3px 1px -2px rgba(0,0,0,0.2),0px 2px 2px 0px rgba(0,0,0,0.14),0px 1px 5px 0px rgba(0,0,0,0.12);
                    box-shadow: 0px 3px 1px -2px rgba(0,0,0,0.2),0px 2px 2px 0px rgba(0,0,0,0.14),0px 1px 5px 0px rgba(0,0,0,0.12)
                }

                input[type=checkbox]:checked:not(:disabled) ~ .lever:active::before,input[type=checkbox]:checked:not(:disabled).tabbed:focus ~ .lever::before {
                    -webkit-transform: scale(2.4);
                    transform: scale(2.4);
                    background-color: rgba(38,166,154,0.15)
                }

                input[type=checkbox]:not(:disabled) ~ .lever:active:before,input[type=checkbox]:not(:disabled).tabbed:focus ~ .lever::before {
                    -webkit-transform: scale(2.4);
                    transform: scale(2.4);
                    background-color: rgba(0,0,0,0.08)
                }

                .switch input[type=checkbox][disabled]+.lever {
                    cursor: default;
                    background-color: rgba(0,0,0,0.12)
                }

                .switch label input[type=checkbox][disabled]+.lever:after,.switch label input[type=checkbox][disabled]:checked+.lever:after {
                    background-color: #949494
                }

                .disabledbutton {
                    pointer-events: none;
                    opacity: 0.4;
                }

            </style>
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
                    font-size: 30px;
                    color: white;
                    transform: translate(-50%,-50%);
                    -ms-transform: translate(-50%,-50%);
                }
            </style>


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
                        <div id="text"><h2 style="padding-left:100px;">please wait... we are populating/updating your adapter with admin data</h2>
                        </div></div>


                <%
           
                    String sourcesX = sourceDTO.getSourcePaired();
                    String mastt = UtilityAbstracts.getMasterSpource();
                    String desss = UtilityAbstracts.getMdestinationSpource();

                %>

                <section class="col-lg-12 connectedSortable">
                    <div class="row">
                        <!-- Source creator -->
                        <section class="col-lg-12 connectedSortable" id="cade">
                            <!-- TO DO List -->
                            <div class="card card-default">
                                <div class="card-header">


                                    <h3 class="card-title">
                                        <i class="fas fa-cogs mr-1"></i>



                                        Active source paired selected = <b><i> <%=sourcesX%> </i></b>
                                    </h3> <span>&nbsp; &nbsp; may edit by clicking the <b>Edit Config</b> button </span>



                                </div>
                                <form action="../asdfghjytrsfddsfkjshdgvgbhsrdtnjyunbshvagwcwgavetryjtbkuytjrhsevasfdcsdfgvhjybukretrsearstybjgk" method="post" id="fomX">
                                    <!-- /.card-header -->

                                    <%

                                    %>
                                    <div class="card-body">
                                        <div class="callout" id="step_">
                                            <h5>Maintenance</h5>

                                            <p>Please answer "Setup" if this is the first time the adapter is been installed or the adapter service has just been reinstalled or you want to sync any new admin data to SORMAS system. If not, click next to perform maintenance</p>
                                            <div class="row">
                                                <div class="col s4">

                                                    <div class="switch">
                                                        <label >
                                                            Perform maintenance
                                                            <input type="checkbox" <%//rx.getString(2)%> name="server" id="maintenance">
                                                            <span class="lever" ></span>
                                                            <span title="Setup new sormas or sync new admin data with SORMAS server">Setup SORMAS Server</span>
                                                        </label>
                                                    </div>

                                                </div>
                                                <a class="btn btn-flat" onclick="openxx()">
                                                    <i class="fa fa-angle-double-right"></i> Next
                                                </a>

                                            </div>

                                        </div>
                                    </div>

                                </form></div>
                        </section>


                        <section class="col-lg-12 connectedSortable" style="display: none;" id="openxx_">
                            <div class="row">
                                <!-- Source creator -->
                                <section class="col-lg-12 connectedSortable">
                                    <!-- TO DO List -->
                                    <div class="card">



                                        <div class="card-body row">
                                            <a class="btn btn-flat" onclick="bcknxx()">
                                                <i class="fa fa-angle-double-left"></i> Close
                                            </a>
                                            <a href="source_controller.jsp" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-edit hvr-icon"></i> Edit Config
                                            </a>




                                            <a onclick="dd();" id="sync_x" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-download hvr-icon" title="Download Admin data from <%=mastt%>"></i> Master Data >> Adapter
                                            </a>



                                            <a onclick="start_pushX_X_x()" id="send_all_availx" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-play hvr-icon"></i> Sync with NEW SORMAS
                                            </a>



                                            <%

                                            %>



                                            <div class="col-md-3 col-sm-6 col-12 loadingxx" id="progress_x" style="display: none;">
                                                <div class="info-box bg-info">
                                                    <span class="info-box-icon"><i class="far fa-bookmark"></i></span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">Total Expected</span>
                                                        <span class="info-box-number" id="totalerc">${total_org}</span>

                                                        <div class="progress">
                                                            <div id="pbar" class="progress-bar" style="width: 100%"></div>
                                                        </div>
                                                        <span class="progress-description" id="chunker_">
                                                            Preparing...
                                                        </span>
                                                    </div>
                                                    <!-- /.info-box-content -->
                                                </div>
                                                <!-- /.info-box -->
                                            </div>



                                            <div class="col-md-3 col-sm-6 col-12" style="display: none;" id="progress_Fhirx">
                                                <div class="info-box bg-success">
                                                    <span class="info-box-icon"><i class="far fa-check"></i></span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">Storing @ SORMAS Server</span>
                                                        <span class="info-box-number" id="totaler_x"></span>

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

                                        </div>  
                                        <!-- /.card-body -->
                                        <div class="card-footer clearfix">
                                            <!--button type="button" class="btn btn-info float-right" data-toggle="modal" id="source_addition_button" data-target="#modal-sources"><i class="fas fa-plus"></i> Add item
                                            </button-->
                                        </div>


                                    </div>



                                </section>  <!--section class="col-lg-5 connectedSortable"-->

                                <input type="hidden" id="controllerx">
                                <section>



                                </section>


                            </div>
                        </section>



                        <section class="col-lg-12 connectedSortable" style="display: none;" id="openxx1">
                            <div class="row" >
                                <!-- Source creator -->
                                <section class="col-lg-12 connectedSortable">
                                    <!-- TO DO List -->
                                    <div class="card" id="addit">

                                        <div class="card-header" >



                                        </div>
                                        <!-- /.card-header -->



                                        <div class="card-body row">
                                            <a class="btn btn-flat" onclick="bcknxx()">
                                                <i class="fa fa-angle-double-left"></i> Close
                                            </a>
                                            <a href="source_controller.jsp" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-edit hvr-icon"></i> Edit Config
                                            </a>


                                            <a class="btn btn-app hvr-icon-buzz-out" onclick="lc()">
                                                <i class="fas fa-download hvr-icon" title="Download Admin data from <%=desss%>"></i> Destination Data >> Adapter
                                            </a>




                                            <a onclick="dd();" id="sync_" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-download hvr-icon" title="Download Admin data from <%=mastt%>"></i> Master Data >> Adapter
                                            </a>

                                            <a onclick="intPerser_am()" id="analysedb" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-cogs hvr-icon"></i> Analyse and Match
                                            </a>

                                            <a onclick="resx();" id="analyse"dsp class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-check hvr-icon"></i> Display Results
                                            </a>

                                            <!--    <a onclick="fhir_()" id="analysefhir" class="btn btn-app hvr-icon-buzz-out">
                                                    <i class="fas fa-play hvr-icon"></i> Sync with FHIR
                                                </a> -->

                                            <a onclick="start_pushX_()" id="send_all_avail" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-play hvr-icon"></i> Sync with SORMAS
                                            </a>




                                            <%
                                            %>





                                            <div class="col-md-3 col-sm-6 col-12 loadingxx" id="progress_" >
                                                <div class="info-box bg-info">
                                                    <span class="info-box-icon"><i class="far fa-bookmark"></i></span>

                                                    <div class="info-box-content">
                                                        <span class="info-box-text">Total Expected</span>
                                                        <span class="info-box-number" id="totalerc">${total_org}</span>

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

                                        </div>  
                                        <!-- /.card-body -->
                                        <div class="card-footer clearfix">
                                            <!--button type="button" class="btn btn-info float-right" data-toggle="modal" id="source_addition_button" data-target="#modal-sources"><i class="fas fa-plus"></i> Add item
                                            </button-->
                                        </div>


                                    </div>
                                    <!-- /.card -->

                                    <div class="card card-success card-outline" id="body_wx">
                                        <div class="card-header">

                                            <h3 class="card-title" data-togg="tooltip" title="NOTE: This is using local SORMAS Server as a baseline">
                                                <i class="fas fa-search"></i>
                                                Infrastructure Match Results
                                            </h3>
                                        </div>
                                        <div class="card-body"  style="">





                                            <div class="row input-group">

                                                <div onclick="dmd('')" class="col-xs-6 col-md-4 text-center clickables" data-togg="tooltip" title="Click here to view the Matched Data!" data-toggle="modal" data-target="#modal-xl" style="border-right: 1px solid #f4f4f4">
                                                    <div style="display:inline;width:60px;height:60px;">
                                                        <input type="text" class="knob" data-readonly="true" value="20" id="dtt" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; background: none; font: bold 12px Arial; text-align: center; color: rgb(57, 204, 204); padding: 0px; -webkit-appearance: none;">
                                                    </div>

                                                    <div class="knob-label" id="full" ></div>
                                                </div>

                                                <!-- ./col 
                                                <div onclick="dmd('pat_mat')" class="col-xs-6 col-md-3 text-center clickables" style="border-right: 1px solid #f4f4f4" data-toggle="modal" data-target="#">
                                                    <div style="display:inline;width:60px;height:60px;"><input type="text" class="knob" data-readonly="true" id="ctt"  value="50" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; background: none; font: bold 12px Arial; text-align: center; color: rgb(57, 204, 204); padding: 0px; -webkit-appearance: none;"></div>

                                                    <div class="knob-label" id="fullx" ></div>
                                                </div>
                                                ./col -->
                                                <div class="col-xs-6 col-md-4 text-center clickables"  data-togg="tooltip" title="Click here to load Deduplicator Wizard!" onclick="dmd('dup_')" data-toggle="modal"  data-target="#dup_modal-xl">
                                                    <div style="display:inline;width:60px;height:60px;"><input type="text" id="btt"  class="knob" data-readonly="true" value="30" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; background: none; font: bold 12px Arial; text-align: center; color: rgb(57, 204, 204); padding: 0px; -webkit-appearance: none;"></div>

                                                    <div class="knob-label" id="fullxxx"></div>
                                                </div>
                                                <div class="col-xs-6 col-md-4 text-center clickables" onclick="dmd('_mat')" data-toggle="modal"  data-target="#modal-warning"> 
                                                    <div style="display:inline;width:60px;height:60px;"><input type="text" id="att" class="knob" data-readonly="true" value="30" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; background: none; font: bold 12px Arial; text-align: center; color: rgb(57, 204, 204); padding: 0px; -webkit-appearance: none;"></div>

                                                    <div class="knob-label" id="fullxxxx"></div>
                                                </div>
                                                <!-- ./col -->
                                            </div>


                                        </div>
                                        <!-- /.card -->
                                    </div>


                                    <div class="card card-success card-outline" id="body_wx_">
                                        <div class="card-header">

                                            <h3 class="card-title" data-togg="tooltip" title="NOTE: This is using local SORMAS Server as a baseline">
                                                <i class="fas fa-sync"></i>
                                                Analyse and Match Tool 
                                            </h3><br>
                                            <i class="pull-right"><b>NOTE:</b> Make sure that each level is resolved before accessing the next level</i>
                                        </div>
                                        <div class="card-body row">
                                            <a class="btn btn-flat" onclick="bcknxx()">
                                                <i class="fa fa-angle-double-left"></i> Close
                                            </a>
                                            
                                            <a onclick="ana(1)" id="analysedb" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-sync hvr-icon"></i> Resolve Level 1
                                            </a>

                                            <a onclick="ana(2)" id="analysefhir" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fa fa-sync hvr-icon"></i> Resolve Level 2
                                            </a>

                                            <a onclick="ana(3)" id="send_all_avail" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-sync hvr-icon"></i> Resolve Level 3
                                            </a>
                                            <a onclick="ana(4)" id="send_all_avail" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-sync hvr-icon"></i> Resolve Level 4
                                            </a>
                                            <a onclick="ana(5)" id="send_all_avail" class="btn btn-app hvr-icon-buzz-out">
                                                <i class="fas fa-sync hvr-icon"></i> Resolve Level 5
                                            </a>
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

                </section>

                <jsp:include page="template/scripts_footer.jsp"></jsp:include>
                    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>




                    <script>


                                                var ctbb = '';
                                                $('[data-togg="tooltip"]').tooltip();
                                                $('#body_wx').hide();
                                                $('#body_wx_').hide();
                                                $('#progress_').hide();
                                                $('#progress_Fhir').hide();
                                                $('#sync_').hide();
                                                var max = 0;
                                                var maz = 0;
                                                var xhr = new XMLHttpRequest();
                                                xhr.open('GET', '../orggetter?pg_counter=1989', true);
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
                                                //   alertx();
                                                //    $('#addit').append("<button type=\"button\" class=\"btn btn-block bg-gradient-success btn-xs col-lg-4\">Server now ready</button><br>");

                                                gren();
                                                //   style="background-color: darkseagreen;min-height: 530px;"                            
                                                $('#sync_').show();
                                                var total = maxx * 100;
                                                $('#totaler').append(total); //chunker
                                                //   $('#chunker').append("chunks to process | "+ maxx);//chunker





                                                } else {
                                                //   console.log("Server error while contacting main methods to get total number of chunks");
                                                alertx("DHIS2 Not Availalable or Adapter timed-out, please re-login");
                                                return;
                                                }
                                                }
                                                };
                                                xhr.send("");
                                                }
                                                ;
                                                function gren() {
                                                // document.getElementById("contw").style.background = "#9eca9d";
                                                //  document.getElementById("contw").style.background-color = "darkseagreen";
                                                alertx("All Set");
                                                }
                                                ;
                                                //process the entire chunks one after the other




                                                //fires the main sync process.
                                                function starter() {
                                                maz = maxx;
                                                //debugger ristricting to ward leve
                                                maxx = 6;
                                                document.getElementById("overlay").style.display = "none";
                                                //$('#progress_').show();
                                                $('#progress_x').show();
                                                servlet_primer(maxx);
                                                console.log('running level>>> ' + maxx);
                                                //  myloader(0);

                                                }
                                                ;
                                                function servlet_primer(stat) {
                                                // var stat = 233;

                                                if (stat > 0) {
                                                var xhr = new XMLHttpRequest();
                                                xhr.open('GET', '../orggetter?pg_counterx=' + stat, true);
                                                xhr.responseType = 'text';
                                                xhr.onload = function () {
                                                if (xhr.readyState === xhr.DONE) {
                                                if (xhr.status === 200) {
                                                max = xhr.responseText;
                                                myloader(max);
                                                console.log("Number of chunk been processed currently = " + max);
                                                }
                                                }
                                                };
                                                xhr.send(null);
                                                success: servlet_primer(stat - 1);
                                                //  setTimeout($('#progress_x').hide();, 2000)

                                                }

                                                }
                                                ;
                                                function myloader(width) {
                                                // $('.progress-bar').css('width', width+'%');
                                                //     console.log(width + '%');
                                                //    $('#pbar').append(width);//???
                                                //

                                                document.getElementById("pbar").style.width = width + '%';
                                                document.getElementById("chunker").innerHTML = 'Total chunks remaining = ' + width;
                                                document.getElementById("chunker_").innerHTML = 'Total chunks remaining = ' + width;
                                                //document.getElementById("chunker_").innerHTML = maz;
                                                if (width < 3) {

                                                //Fhir need to start here.
                                                $('#progress_').hide();
                                                $('#progress_x').hide();
                                                $('#progress_Fhir').show();
                                                //Debugging with create only
                                                setTimeout(servlet_primer_fhir(1), 3000)

                                                }
                                                }
                                                ;
                    </script>



                    <script type="text/javascript">


                        function dd() {
                        document.getElementById("overlay").style.display = "block";
                        setTimeout(function () {
                        if (confirm("DANGER! \nThis action will Purge all MASTER Source Infrastructure Data already on the Adapter and reimport it afresh. \nDo you want to do that?")) {

                        starter();
                        } else {
                        document.getElementById("overlay").style.display = "none";
                        }


                        }, 1000);
                        }

                        function ana(e) {
                        document.getElementById("overlay").style.display = "block";
                        setTimeout(function () {
                        if (confirm("WARNING! \nLong Processing Action, you are about to run the match processor... This will take time. \nDo you want to do that?")) {
                        location.replace("../controllers_jsp/analytics_staging.jsp?levelX="+e);
                        } else {
                        document.getElementById("overlay").style.display = "none";
                        }


                        }, 1000);
                        }

                        function resx() {

                        var xhr = new XMLHttpRequest();
                        xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?count=10', true);
                        xhr.responseType = 'text';
                        xhr.onload = function () {
                        if (xhr.readyState === xhr.DONE) {
                        if (xhr.status === 200) {

                        //    console.log("Number of 100 percent machedprocessed currently = " + xhr.responseText);

                        const words = xhr.responseText.split(',');
                        $('#fullxxxx').html("Not Matchable = " + words[0]);
                        $('#fullxxx').html("Duplicates = " + words[1]);
                        //   $('#fullx').html("Partial Duplicates = " + words[2]);
                        $('#full').html("Matched = " + words[3]);
                        intPerser(xhr.responseText);
                        } else {
                        alert("There is a problem retreiving analytics from server, please rerun Analytics 'Analyse' button");
                        return;
                        }
                        }
                        };
                        xhr.send(null);
                        }


                        function intPerser_am() {

                        $('#body_wx_').show();
                        }

                        function intPerser(e) {
                        const words = e.split(',');
                        var a = parseInt(words[0]);
                        var b = parseInt(words[1]);
                        var c = parseInt(words[2]);
                        var d = parseInt(words[3]);
                        var tt = a + b + c + d;
                        $('#att').val(Math.floor((a / tt) * 100) + '%');
                        $('#btt').val(Math.floor((b / tt) * 100) + '%');
                        $('#ctt').val(Math.floor((c / tt) * 100) + '%');
                        $('#dtt').val(Math.floor((d / tt) * 100) + '%');
                        //   alert(Math.floor((c / tt) * 100));
                        $('#body_wx').show();
                        triggerKnob();
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
                        $('#progress_x').hide();
                        $('#progress_Fhir').hide();
                        }
                        ;
                        function alertxx() {
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
                        function alertx(e) {
                        const Toast = Swal.mixin({
                        toast: true,
                                position: 'top-end',
                                showConfirmButton: false,
                                timer: 6000
                        });
                        Toast.fire({
                        type: 'success',
                                title: e
                        });
                        }
                        ;
                        function alerterr(e) {
                        const Toast = Swal.mixin({
                        toast: true,
                                position: 'top-end',
                                showConfirmButton: false,
                                timer: 3000
                        });
                        Toast.fire({
                        type: 'error',
                                title: e
                        });
                        }
                        ;
                    </script>

                <%                if (request.getParameter("sayfini") != null) {
                        String sta = request.getParameter("sayfini");

                        if ("true".equals(sta)) {
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
                } else {
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


                </style>
                <script>
                    document.getElementById("overlay").style.display = "none";
                </script>

                <!--MODALS BASIN-->  
                <div class="" id="modal-xl_" style="display: none;">
                    <div class="" style="padding-left: 20px;padding-right: 10px;margin-top: 20px;margin-bottom: 20px;">
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="container-fluid">
                                    <div class="row mb-2">
                                        <div class="col-sm-6">
                                            <h1>Infrastructure Reconciliation Analytics for Matched Data</h1>
                                        </div>

                                    </div>
                                </div><!-- /.container-fluid -->
                                <button type="button" onclick="window.location.reload();" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <div class="">


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
                                                                        <input type="text" onchange="" id="nigeria_x" list="" autocomplete="off" value="${sessionScope.country}" disable="true" readonly class="form-control">

                                                                    </div>
                                                                    <div class="col-5">
                                                                        <div class="progress progress-xs" style="height: 30%;">
                                                                            <div class="progress-bar progress-bar-warning" id="dfe" style="width: 0%"> 
                                                                                <a onclick="statex('state_x')" id="state_g" type="button" class="btn btn-warning btn-flat"></a>
                                                                            </div></div>
                                                                        <h3 class="" id="789"></h3>
                                                                    </div>
                                                                    <div class="col-2">
                                                                        <a onclick="tableloader('nigeria_x')" id="state_g_" type="button" class="btn btn-success btn-flat">Show Details</a>
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
                                                                        <!--<input type="text" onchange="load_lga('')" id="state_x" list="state" autocomplete="off" class="form-control">-->
                                                                        <select class="form-control js-select2" id="state_x" onchange="load_lga('')">
                                                                            <option selected>select one</option>
                                                                        </select>


                                                                    </div>
                                                                    <div class="col-5">
                                                                        <div class="progress progress-xs" style="height: 30%;">
                                                                            <div class="progress-bar progress-bar-warning" id="dfe_lga" style="width: 0%"> 
                                                                                <a onclick="tableloader('state_x')" id="lga_g" type="button" class="btn btn-warning btn-flat"></a>
                                                                            </div></div>
                                                                        <h3 class="" id="789_lga"></h3>
                                                                    </div>
                                                                    <div class="col-2">
                                                                        <a onclick="tableloader('state_x')" id="lga_g_" type="button" class="btn btn-success btn-flat">Show Details</a>
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

                                                                        <select class="form-control js-select2" id="lga_x" onchange="load_ward('')">
                                                                            <option selected>select one</option>
                                                                        </select>

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
                                                                        <a onclick="tableloader('lga_x')" id="ward_g_" type="button" class="btn btn-success btn-flat">Show Details</a>
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

                                                                        <select class="form-control js-select2" onchange="load_hf('')" id="ward_x"">
                                                                            <option selected>select one</option>
                                                                        </select>


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
                                                                        <a onclick="tableloader('ward_x')" id="hf_g_" type="button" class="btn btn-success btn-flat">Show Details</a>
                                                                    </div>
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

                                                                    <select class="form-control js-select2" onchange="tableloader('hf_x')" id="hf_x"">
                                                                        <option selected>select one</option>
                                                                    </select>

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
                                                        <span class="">Please click "Show Details" button to expand details of the corresponding value</span>

                                                    </div>
                                                    <!-- /.timeline-label -->

                                                    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

                                                    <!-- timeline item -->
                                                    <div id="esef3456n" style="display: none;">
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




























                <!--MODALS BASIN-->  


                <div id="dup_now_closed" style="display: none">

                    <div class="" style="padding-left: 20px;padding-right: 10px;margin-top: 20px;margin-bottom: 20px;">
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="container-fluid">
                                    <div class="row mb-2">
                                        <div class="col-sm-6">
                                            <h1>Infrastructure Reconciliation Analytics for DUPLICATE Data</h1>
                                        </div>

                                    </div>
                                </div><!-- /.container-fluid -->
                                <button type="button" onclick="window.location.reload();" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <div class="">


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
                                                                        <input type="text" onchange="" id="dup_nigeria_x" list="" autocomplete="off" value="${sessionScope.country}" disable="true" readonly class="form-control">


                                                                    </div>
                                                                    <div class="col-5">
                                                                        <div class="progress progress-xs" style="height: 30%;">
                                                                            <div class="progress-bar progress-bar-warning" id="dup_dfe" style="width: 0%"> 
                                                                                <a onclick="statex('dup_state_x')" id="dup_state_g" type="button" class="btn btn-warning btn-flat"></a>
                                                                            </div></div>



                                                                        <h3 class="" id="dup_789"></h3>
                                                                    </div>
                                                                    <div class="col-2">
                                                                        <a onclick="tableloader('dup_nigeria_x')" id="dup_state_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->
                                                    <!-- timeline item -->
                                                    <div>
                                                        <i id="dup_statexx" class="fas fa-bars bg-yellow"></i>
                                                        <div class="timeline-item">
                                                            <span class="time"><i class="fas fa-clock"></i> 27 mins ago</span>
                                                            <h3 class="timeline-header"><a href="#">Select</a> State / Region</h3>
                                                            <div class="timeline-body">
                                                                <div class="row">
                                                                    <div class="input-group input-group col-3">

                                                                        <select class="form-control js-select2" id="dup_state_x" onchange="load_lga('dup_')">
                                                                            <option selected>select one</option>
                                                                        </select>

                                                                    </div>
                                                                    <div class="col-5">
                                                                        <div class="progress progress-xs" style="height: 30%;">
                                                                            <div class="progress-bar progress-bar-warning" id="dup_dfe_lga" style="width: 0%"> 
                                                                                <a onclick="tableloader('dup_state_x')" id="dup_lga_g" type="button" class="btn btn-warning btn-flat"></a>
                                                                            </div></div>
                                                                        <h3 class="" id="dup_789_lga"></h3>
                                                                    </div>
                                                                    <div class="col-2">
                                                                        <a onclick="tableloader('dup_state_x')" id="dup_lga_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                                                    </div>
                                                                    <div class="col-xs-2 col-md-1 text-center clickables" style="display: none">
                                                                        <div style="display:inline;width:60px;height:60px;"><div style="display:inline;width:60px;height:60px;">
                                                                                `<input type="text" id="btt_state" class="knob" data-readonly="true" value="30" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; background: none; font: bold 12px Arial; text-align: center; color: rgb(57, 204, 204); padding: 0px; -webkit-appearance: none;">
                                                                            </div>
                                                                        </div>
                                                                        <div class="knob-label" id="fullxxx" >Total Left = 23</div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->

                                                    <!-- timeline item -->
                                                    <div id="dup_lgax" style="display: none">
                                                        <i id="dup_lgaxx" class="fas fa-bars bg-yellow"></i>
                                                        <div class="timeline-item">
                                                            <span class="time"><i class="fas fa-clock"></i> 27 mins ago</span>
                                                            <h3 class="timeline-header"><a href="#">Select</a> Local Government Area / District</h3>
                                                            <div class="timeline-body">
                                                                <div class="row">
                                                                    <div class="input-group input-group-sm col-3">
                                                                        <select class="form-control js-select2" id="dup_lga_x" onchange="load_ward('dup_')">
                                                                            <option selected>select one</option>
                                                                        </select>

                                                                    </div>
                                                                    <div class="col-5">
                                                                        <div class="progress progress-xs" style="height: 30%;">
                                                                            <div class="progress-bar progress-bar-warning" id="dup_dfe_ward" style="width: 0%"> 
                                                                                <a onclick="tableloader('dup_lga_x')" id="dup_ward_g" type="button" class="btn btn-warning btn-flat"></a>
                                                                            </div>
                                                                        </div>
                                                                        <h3 class="" id="dup_789_ward"></h3>
                                                                    </div>
                                                                    <div class="col-2">
                                                                        <a onclick="tableloader('dup_lga_x')" id="dup_ward_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                                                    </div>

                                                                    <div class="col-xs-2 col-md-1 text-center clickables"  style="display: none">
                                                                        <div style="display:inline;width:60px;height:60px;"><div style="display:inline;width:60px;height:60px;">
                                                                                `<input type="text" id="btt_lga" class="knob" data-readonly="true" value="30" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; background: none; font: bold 12px Arial; text-align: center; color: rgb(57, 204, 204); padding: 0px; -webkit-appearance: none;">
                                                                            </div>
                                                                        </div>
                                                                        <div class="knob-label" id="fullxxx">Total Left = 423</div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->







                                                    <!-- timeline item -->
                                                    <div id="dup_wardx" style="display: none">
                                                        <i id="dup_wardxx" class="fas fa-bars bg-yellow"></i>
                                                        <div class="timeline-item">
                                                            <span class="time"><i class="fas fa-clock"></i> 27 mins ago</span>
                                                            <h3 class="timeline-header"><a href="#">Select</a> Ward / Community</h3>
                                                            <div class="timeline-body">
                                                                <div class="row">
                                                                    <div class="input-group input-group-sm col-3">
                                                                        <select class="form-control js-select2" id="dup_ward_x" onchange="load_hf('dup_')">
                                                                            <option selected>select one</option>
                                                                        </select>

                                                                    </div>
                                                                    <div class="col-5">
                                                                        <div class="progress progress-xs" style="height: 30%;">
                                                                            <div class="progress-bar progress-bar-warning" id="dup_dfe_hf" style="width: 0%"> 
                                                                                <a onclick="tableloader('dup_ward_x')" id="dup_hf_g" type="button" class="btn btn-warning btn-flat"></a>
                                                                            </div>
                                                                        </div>
                                                                        <h3 class="" id="dup_789_hf"></h3>
                                                                    </div>
                                                                    <div class="col-2">
                                                                        <a onclick="tableloader('dup_ward_x')" id="dup_hf_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                                                    </div>
                                                                    <div class="col-xs-2 col-md-1 text-center clickables"  style="display: none">
                                                                        <div style="display:inline;width:60px;height:60px;"><div style="display:inline;width:60px;height:60px;">
                                                                                `<input type="text" id="btt_ward" class="knob" data-readonly="true" value="30" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; background: none; font: bold 12px Arial; text-align: center; color: rgb(57, 204, 204); padding: 0px; -webkit-appearance: none;">
                                                                            </div>
                                                                        </div>
                                                                        <div class="knob-label" id="fullxxx">Total Left = 223</div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->


                                                    <!-- timeline item -->
                                                    <div id="dup_hfx" style="display: none">
                                                        <i id="dup_hfxx" class="fas fa-bars bg-yellow"></i>
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
                                                        <span class="">Please click "Show Details" button to expand details of the corresponding value</span>

                                                    </div>
                                                    <!-- /.timeline-label -->

                                                    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

                                                    <!-- timeline item -->
                                                    <div id="dup_esef3456n" style="display: none;">
                                                        <i class="fa fa-bars bg-purple"></i>
                                                        <div class="timeline-item">
                                                            <span class="time"><i class="fas fa-clock"></i> 2 days ago</span>


                                                            <div class="timeline-body">
                                                                <table id="dup_detailer" class="display" style="width:100%">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>SN</th>
                                                                            <th>SOMRAS UUID</th>
                                                                            <th>SORMAS NAME</th>
                                                                            <th>DUPLICATE WITH</th>
                                                                            <th>DUPLICATE UUID</th>
                                                                            <th>SOURCE CURRENTLY MATCHED</th>
                                                                            <th>SOURCE MATHCED UUID</th>
                                                                            <th>MODIFIED</th>
                                                                            <th>RESOLVE</th>
                                                                        </tr>
                                                                    </thead>

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












                <!--MODALS BASIN UNMATCHABLES-->  


                <div id="dup_now_closed" style="display: none">

                    <div class="" style="padding-left: 20px;padding-right: 10px;margin-top: 20px;margin-bottom: 20px;">
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="container-fluid">
                                    <div class="row mb-2">
                                        <div class="col-sm-6">
                                            <h1>Infrastructure Reconciliation Analytics for DUPLICATE Data</h1>
                                        </div>

                                    </div>
                                </div><!-- /.container-fluid -->
                                <button type="button" onclick="window.location.reload();" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <div class="">


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
                                                                        <input type="text" onchange="" id="dup_nigeria_x" list="" autocomplete="off" value="${sessionScope.country}" disable="true" readonly class="form-control">


                                                                    </div>
                                                                    <div class="col-5">
                                                                        <div class="progress progress-xs" style="height: 30%;">
                                                                            <div class="progress-bar progress-bar-warning" id="dup_dfe" style="width: 0%"> 
                                                                                <a onclick="statex('dup_state_x')" id="dup_state_g" type="button" class="btn btn-warning btn-flat"></a>
                                                                            </div></div>



                                                                        <h3 class="" id="dup_789"></h3>
                                                                    </div>
                                                                    <div class="col-2">
                                                                        <a onclick="tableloader('dup_nigeria_x')" id="dup_state_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->
                                                    <!-- timeline item -->
                                                    <div>
                                                        <i id="dup_statexx" class="fas fa-bars bg-yellow"></i>
                                                        <div class="timeline-item">
                                                            <span class="time"><i class="fas fa-clock"></i> 27 mins ago</span>
                                                            <h3 class="timeline-header"><a href="#">Select</a> State / Region</h3>
                                                            <div class="timeline-body">
                                                                <div class="row">
                                                                    <div class="input-group input-group col-3">

                                                                        <select class="form-control js-select2" id="dup_state_x" onchange="load_lga('dup_')">
                                                                            <option selected>select one</option>
                                                                        </select>

                                                                    </div>
                                                                    <div class="col-5">
                                                                        <div class="progress progress-xs" style="height: 30%;">
                                                                            <div class="progress-bar progress-bar-warning" id="dup_dfe_lga" style="width: 0%"> 
                                                                                <a onclick="tableloader('dup_state_x')" id="dup_lga_g" type="button" class="btn btn-warning btn-flat"></a>
                                                                            </div></div>
                                                                        <h3 class="" id="dup_789_lga"></h3>
                                                                    </div>
                                                                    <div class="col-2">
                                                                        <a onclick="tableloader('dup_state_x')" id="dup_lga_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                                                    </div>
                                                                    <div class="col-xs-2 col-md-1 text-center clickables" style="display: none">
                                                                        <div style="display:inline;width:60px;height:60px;"><div style="display:inline;width:60px;height:60px;">
                                                                                `<input type="text" id="btt_state" class="knob" data-readonly="true" value="30" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; background: none; font: bold 12px Arial; text-align: center; color: rgb(57, 204, 204); padding: 0px; -webkit-appearance: none;">
                                                                            </div>
                                                                        </div>
                                                                        <div class="knob-label" id="fullxxx" >Total Left = 23</div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->

                                                    <!-- timeline item -->
                                                    <div id="dup_lgax" style="display: none">
                                                        <i id="dup_lgaxx" class="fas fa-bars bg-yellow"></i>
                                                        <div class="timeline-item">
                                                            <span class="time"><i class="fas fa-clock"></i> 27 mins ago</span>
                                                            <h3 class="timeline-header"><a href="#">Select</a> Local Government Area / District</h3>
                                                            <div class="timeline-body">
                                                                <div class="row">
                                                                    <div class="input-group input-group-sm col-3">
                                                                        <select class="form-control js-select2" id="dup_lga_x" onchange="load_ward('dup_')">
                                                                            <option selected>select one</option>
                                                                        </select>

                                                                    </div>
                                                                    <div class="col-5">
                                                                        <div class="progress progress-xs" style="height: 30%;">
                                                                            <div class="progress-bar progress-bar-warning" id="dup_dfe_ward" style="width: 0%"> 
                                                                                <a onclick="tableloader('dup_lga_x')" id="dup_ward_g" type="button" class="btn btn-warning btn-flat"></a>
                                                                            </div>
                                                                        </div>
                                                                        <h3 class="" id="dup_789_ward"></h3>
                                                                    </div>
                                                                    <div class="col-2">
                                                                        <a onclick="tableloader('dup_lga_x')" id="dup_ward_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                                                    </div>

                                                                    <div class="col-xs-2 col-md-1 text-center clickables"  style="display: none">
                                                                        <div style="display:inline;width:60px;height:60px;"><div style="display:inline;width:60px;height:60px;">
                                                                                `<input type="text" id="btt_lga" class="knob" data-readonly="true" value="30" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; background: none; font: bold 12px Arial; text-align: center; color: rgb(57, 204, 204); padding: 0px; -webkit-appearance: none;">
                                                                            </div>
                                                                        </div>
                                                                        <div class="knob-label" id="fullxxx">Total Left = 423</div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->







                                                    <!-- timeline item -->
                                                    <div id="dup_wardx" style="display: none">
                                                        <i id="dup_wardxx" class="fas fa-bars bg-yellow"></i>
                                                        <div class="timeline-item">
                                                            <span class="time"><i class="fas fa-clock"></i> 27 mins ago</span>
                                                            <h3 class="timeline-header"><a href="#">Select</a> Ward / Community</h3>
                                                            <div class="timeline-body">
                                                                <div class="row">
                                                                    <div class="input-group input-group-sm col-3">
                                                                        <select class="form-control js-select2" id="dup_ward_x" onchange="load_hf('dup_')">
                                                                            <option selected>select one</option>
                                                                        </select>

                                                                    </div>
                                                                    <div class="col-5">
                                                                        <div class="progress progress-xs" style="height: 30%;">
                                                                            <div class="progress-bar progress-bar-warning" id="dup_dfe_hf" style="width: 0%"> 
                                                                                <a onclick="tableloader('dup_ward_x')" id="dup_hf_g" type="button" class="btn btn-warning btn-flat"></a>
                                                                            </div>
                                                                        </div>
                                                                        <h3 class="" id="dup_789_hf"></h3>
                                                                    </div>
                                                                    <div class="col-2">
                                                                        <a onclick="tableloader('dup_ward_x')" id="dup_hf_g" type="button" class="btn btn-success btn-flat">Show Details</a>
                                                                    </div>
                                                                    <div class="col-xs-2 col-md-1 text-center clickables"  style="display: none">
                                                                        <div style="display:inline;width:60px;height:60px;"><div style="display:inline;width:60px;height:60px;">
                                                                                `<input type="text" id="btt_ward" class="knob" data-readonly="true" value="30" data-width="60" data-height="60" data-fgcolor="#39CCCC" readonly="readonly" style="width: 34px; height: 20px; position: absolute; vertical-align: middle; margin-top: 20px; margin-left: -47px; border: 0px; background: none; font: bold 12px Arial; text-align: center; color: rgb(57, 204, 204); padding: 0px; -webkit-appearance: none;">
                                                                            </div>
                                                                        </div>
                                                                        <div class="knob-label" id="fullxxx">Total Left = 223</div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END timeline item -->


                                                    <!-- timeline item -->
                                                    <div id="dup_hfx" style="display: none">
                                                        <i id="dup_hfxx" class="fas fa-bars bg-yellow"></i>
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
                                                        <span class="">Please click "Show Details" button to expand details of the corresponding value</span>

                                                    </div>
                                                    <!-- /.timeline-label -->

                                                    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

                                                    <!-- timeline item -->
                                                    <div id="dup_esef3456n" style="display: none;">
                                                        <i class="fa fa-bars bg-purple"></i>
                                                        <div class="timeline-item">
                                                            <span class="time"><i class="fas fa-clock"></i> 2 days ago</span>


                                                            <div class="timeline-body">
                                                                <table id="dup_detailer" class="display" style="width:100%">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>SN</th>
                                                                            <th>SOMRAS UUID</th>
                                                                            <th>SORMAS NAME</th>
                                                                            <th>DUPLICATE WITH</th>
                                                                            <th>DUPLICATE UUID</th>
                                                                            <th>SOURCE CURRENTLY MATCHED</th>
                                                                            <th>SOURCE MATHCED UUID</th>
                                                                            <th>MODIFIED</th>
                                                                            <th>RESOLVE</th>
                                                                        </tr>
                                                                    </thead>

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









                <!-- Modal -->
                <div class="modal fade" id="deduplicate" role="dialog">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">

                            <div class="modal-body">

                                <i>Please mouse over each action to understand them before performing this operation. Note that this operation cannot be undone.</i>
                                <br/><div class="btn-group btn-group-justified" style="width: 100%;">
                                    <a href="#" id="acp_dup" class="btn btn-info">Accept Duplicate</a>
                                    <a href="#" id="acp_cur"  class="btn btn-success">Accept Current Match</a>
                                    <a href="#" id="acp_res"  class="btn btn-warning">Remove all Matched Elements</a>
                                </div>
                            </div>

                            <div class="modal-footer">rastructure Reconciliation An
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>


                <script>
                    function bcknxx() {
                    $("#openxx1").hide();
                    $("#cade").show();
                    $("#openxx_").hide();
                    $("#modal-xl_").hide();
                    $("#dup_modal-xl").hide();
                    }
                    ;
                    function openxx() {
                    $('#progress_x').hide();
                    $('#progress_').hide();
                    var checked = $('#maintenance:checkbox:checked').length > 0;
                    if (checked == true) {
                    // $('#overlay').show();
                    $("#openxx_").show();
                    $("#openxx1").hide();
                    } else {

                    $("#openxx1").show();
                    // $("#cade").hide();
                    $("#openxx_").hide();
                    }

                    }
                    ;
                    function start_pushX_X_x() {
                    document.getElementById("overlay").style.display = "block";
                    $('#text').html("Pushing all available matched data to sormas...");
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?pushfreshavailable=true', true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {

                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {

                    document.getElementById("overlay").style.display = "none";
                    //alertx(xhr.responseText);

                    }
                    }
                    };
                    xhr.send(null);
                    }



                    //buttons
                    function lc() {
                    document.getElementById("overlay").style.display = "block";
                    setTimeout(function () {
                    if (confirm("DANGER! \nThis action will Purge all SORMAS Infrastructure Data already on the Adapter and reimport it afresh. \nDo you want to do that?")) {
                    location.href = '../controllers_jsp/localized.jsp';
                    } else {
                    document.getElementById("overlay").style.display = "none";
                    }

                    }, 1000);
                    }
                    ;
                    function fhir_() {

                    alert("This action require all duplicates to be resuloved.");
                    }
                    function start_pushX_() {
                    document.getElementById("overlay").style.display = "block";
                    $('#text').html("Pushing all available matched data to sormas...");
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?pushavailable=true', true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {

                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {

                    document.getElementById("overlay").style.display = "none";
                    alertx(xhr.responseText);
                    }
                    }
                    };
                    xhr.send(null);
                    }
                    ;
                </script>

                <script>
                    function dmd(e) {
                        alert(e);
                    //e = dup_
                    $('#controllerx').val(e); //=dup_
                    //var v = document.getElementById(e).value;

                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?' + e + 'primer=' + e, true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                    //max = xhr.responseText;
                    const words = xhr.responseText.split(',');
                    const wordsx = xhr.responseText.split(',@@@');
                    //alert(xhr.responseText);
                    $('#' + e + 'dfe').css("width", words[0]);
                    $('#' + e + 'state_g').html(words[0]);
                    $('#' + e + '789').html('<a href="#">Total ' + e.replace('dup_', 'Duplicate') + ' at States Level on SORMAS </a> = ' + words[1] + ' | <a href="#">Total Matched</a> = ' + words[2])

                            $("#state_g_").addClass("locked_" + words[2]);
                    $('#' + e + 'state_x').html(wordsx);
                    $("#cade").hide();
                    $("#addit").hide();
                    if (e === "dup_") {

                    $("#dup_now_closed").show();
                    $("#modal-xl_").hide();
                    } else {

                    $("#modal-xl_").show();
                    $("#dup_now_closed").hide();
                    }


                    //   console.log("Number of chunk been processed currently = " + max);
                    }
                    }
                    };
                    xhr.send(null);
                    }

                    function dmds(e) {
                    const gh = e.split(',');
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?' + gh[1] + 'parentx=' + gh[0] + '&levelx=3', true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                    //max = xhr.responseText;
                    const words = xhr.responseText.split(',');
                    const wordsx = xhr.responseText.split(',@@@');
                    //   alert(words);

                    $('#' + gh[1] + 'dfe_lga').css("width", words[0]);
                    $('#' + gh[1] + 'lga_g').html(words[0]);
                    $('#' + gh[1] + '789_lga').html('<a href="#">Total LGAs for ' + gh[2] + ' on SORMAS </a> = ' + words[1] + ' | <a href="#"> Total LGAs from Source Server</a> = ' + words[2] + ' | <a href="#">Total ' + gh[1].replace('dup_', 'Duplicates ') + 'Matched</a> = ' + words[3])
                            $('#lga').html(wordsx);
                    $('#' + gh[1] + 'lga_g_').addClass("locked_" + words[2]);
                    $('#' + gh[1] + 'lga_x').html(wordsx);
                    // console.log(wordsx+"Number of chunk been processed currently = "  + gh[1]);
                    }
                    }
                    };
                    xhr.send(null);
                    }

                    function dmdm(e) {
                    const gh = e.split(',');
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?' + gh[1] + 'parentx=' + gh[0] + '&levelx=4', true);
                    //     console.log('../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?' + gh[1] + 'parentx=' + gh[0] + '&levelx=4');
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                    //max = xhr.responseText;
                    const words = xhr.responseText.split(',');
                    const wordsx = xhr.responseText.split(',@@@');
                    $('#' + gh[1] + 'dfe_ward').css("width", words[0]);
                    $('#' + gh[1] + 'ward_g').html(words[0]);
                    $('#' + gh[1] + '789_ward').html('<a href="#">Total Wards for ' + gh[2] + ' on SORMAS </a> = ' + words[1] + ' | <a href="#"> Total Wards from Source Server</a> = ' + words[2] + ' | <a href="#">Total ' + gh[1].replace('dup_', 'Duplicates ') + 'Matched</a> = ' + words[3])
                            $('#ward').html(wordsx);
                    $('#' + gh[1] + 'ward_g_').addClass("locked_" + words[2]);
                    $('#' + gh[1] + 'ward_x').html(wordsx);
                    //   console.log("Number of chunk been processed currently = " + max);
                    }
                    }
                    };
                    xhr.send(null);
                    }



                    function dmdmx(e) {
                    const gh = e.split(',');
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?' + gh[1] + 'parentx=' + gh[0] + '&levelx=5', true);
                    console.log('../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?' + gh[1] + 'parentx=' + gh[0] + '&levelx=5');
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                    //max = xhr.responseText;
                    const words = xhr.responseText.split(',');
                    const wordsx = xhr.responseText.split(',@@@');
                    $('#' + gh[1] + 'dfe_hfd').css("width", words[0]);
                    $('#' + gh[1] + 'hf_g').html(words[0]);
                    $('#' + gh[1] + '789_hf').html('<a href="#">Total Health Facility for ' + gh[2] + ' on SORMAS </a> = ' + words[1] + ' | <a href="#"> Total HFs from Source Server</a> = ' + words[2] + ' | <a href="#">Total ' + gh[1].replace('dup_', 'Duplicates ') + 'Matched</a> = ' + words[3])
                            $('#hf').html(wordsx);
                    $('#' + gh[1] + 'hf_g_').addClass("locked_" + words[2]);
                    $('#' + gh[1] + 'ward_x').html(wordsx);
                    //   console.log("Number of chunk been processed currently = " + max);
                    }
                    }
                    };
                    xhr.send(null);
                    }


                    function load_lga(e) {
                    var ex = $('#' + e + 'state_x option:selected').val();
                    var ex_ = $('#' + e + 'state_x option:selected').text();
                    console.log(ex);
                    dmds(ex + ',' + e + ',' + ex_);
                    $('#' + e + 'lgax').show();
                    $('#' + e + 'statexx').removeClass("fas fa-bars bg-yellow").addClass("fas fa-check bg-green")
                    }
                    function load_ward(e) {
                    var ex = $('#' + e + 'lga_x option:selected').val();
                    var ex_ = $('#' + e + 'lga_x option:selected').text();
                    console.log(e);
                    dmdm(ex + ',' + e + ',' + ex_);
                    $('#' + e + 'wardx').show();
                    $('#' + e + 'lgaxx').removeClass("fas fa-bars bg-yellow").addClass("fas fa-check bg-green")
                    }


                    function load_hf(e) {
                    var ex = $('#' + e + 'ward_x option:selected').val();
                    var ex_ = $('#' + e + 'ward_x option:selected').text();
                    console.log(e);
                    dmdmx(ex + ',' + e + ',' + ex_);
                    $('#' + e + 'hfx').show();
                    $('#' + e + 'wardxx').removeClass("fas fa-bars bg-yellow").addClass("fas fa-check bg-green")
                    }




                    function statex(e) {
                    var x = $('#controllerx').val();
                    //  alert(e);
                    // alert(x);
                    var v = document.getElementById(e).value;
                    console.log(v);
                    //  alert(v);
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?parentx=' + v + '&methodx' + x, true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {

                    console.log("Number of chunk been processed currently = " + max);
                    }
                    }
                    };
                    xhr.send(null);
                    }

                    function tableloader(e) {
                    ctbb = e;
                    var ex = $('#' + e + 'hf_x option:selected').val();
                    var ex_ = $('#' + e + 'hf_x option:selected').text();
                    $('#esef3456n').show();
                    $('#dup_esef3456n').show();
                    var pd = document.getElementById(e).value;
                    if (e.includes('dup_')) {
                    console.log("../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?jsonparentx=" + pd + "&jsonlevelx=" + e);
                    var table = $('#dup_detailer').DataTable({
                    "destroy": true,
                            "paging": true,
                            "processing": true,
                            "ajax": {
                            "url": "../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?jsonparentx=" + pd + "&jsonlevelx=" + e,
                                    "dataType": "json"
                            }
                    });
                    } else {
                    console.log("../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?jsonparentx=" + pd + "&jsonlevelx=" + e);
                    var table = $('#detailer').DataTable({
                    "destroy": true,
                            "paging": true,
                            "processing": true,
                            "ajax": {
                            "url": "../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?jsonparentx=" + pd + "&jsonlevelx=" + e,
                                    "dataType": "json"
                            }
                    });
                    }
                    ;
                    table.rows().every(function (rowIdx, tableLoop, rowLoop) {
                    var cell = table.cell({row: rowIdx, column: 0}).node();
                    $(cell).addClass('warningwwwwww');
                    });
                    }
                    ;
                    $(function () {
                    $(".knob").knob();
                    });
                    function triggerKnob() {
                    $("input.knob").trigger('change');
                    }
                    ;
                    $('#deduplicate').on('show.bs.modal', function (e) {
                    //dmd('dup_')

                    var uri_ = $(e.relatedTarget).data('uri');
                    const uri = uri_.split('@@');
                    $('#acp_dup').prop("href", "../4a24cf8b-fbcb-4554-b676-2b54a239be62?accept=" + uri[1] + "&wht=" + uri[0]);
                    $('#acp_cur').prop("href", "../4a24cf8b-fbcb-4554-b676-2b54a239be62?current=" + uri[2] + "&wht=" + uri[0]);
                    $('#acp_res').prop("href", "../4a24cf8b-fbcb-4554-b676-2b54a239be62?reset=true&wht=" + uri[0]);
                    //    $('#deduplicate').modal().show();

                    });
                    $('#acp_dup').click(function (event) {
                    event.preventDefault();
                    var href = $(this).attr('href');
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', href, true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                    alertx(xhr.responseText)
                    } else {
                    alerterr(xhr.responseText)
                    }
                    $('#deduplicate').modal().hide();
                    ;
                    tableloader(ctbb);
                    }
                    };
                    xhr.send(null);
                    });
                    $('#acp_cur').click(function (event) {
                    event.preventDefault();
                    var href = $(this).attr('href');
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', href, true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                    alertx(xhr.responseText)
                    } else {
                    alerterr(xhr.responseText)
                    }
                    $('#deduplicate').modal().hide();
                    ;
                    tableloader(ctbb);
                    }
                    };
                    xhr.send(null);
                    });
                    $('#acp_res').click(function (event) {
                    event.preventDefault();
                    var href = $(this).attr('href');
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', href, true);
                    xhr.responseType = 'text';
                    xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                    if (xhr.status === 200) {
                    alertx(xhr.responseText)
                    } else {
                    alerterr(xhr.responseText)
                    }
                    $('#deduplicate').modal().hide();
                    ;
                    tableloader(ctbb);
                    }
                    };
                    xhr.send(null);
                    });

                </script>

            </div>
    </body>
</html>



<%
    } else {
    response.sendRedirect(request.getContextPath());
    }

%>