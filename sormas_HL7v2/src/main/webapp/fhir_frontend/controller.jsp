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

                <!-- Content Wrapper. Contains page content -->
                <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        <div class="container-fluid">
                            <div class="row mb-2">
                                <div class="col-sm-6">
                                    <h2>Cases Configurations Wizard</h2>
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


                    <section class="col-lg-12 connectedSortable">
                        <div class="row">
                            <!-- Source creator -->
                            <section class="col-lg-12 connectedSortable">
                                <!-- TO DO List -->
                                <div class="card card-default">
                                    <div class="card-header">
                                        <h3 class="card-title">
                                            <i class="fas fa-cogs"></i>
                                            Controller Setup
                                        </h3>
                                    </div>
                                    <!-- /.card-header -->
                                    <div class="card-body">
                                        <div class="callout" id="stepx">
                                            <h5>System Configuration choice</h5>

                                            <p>Please answer Yes if this is the first time the adapter is been installed or the adapter service has just been reinstalled. If not, select No</p>
                                            <div class="row">
                                                <div class="col s4">
                                                    New Server?
                                                    <div class="switch">
                                                        <label>
                                                            No
                                                            <input type="checkbox">
                                                            <span class="lever"></span>
                                                            Yes
                                                        </label>
                                                    </div>

                                                </div>
                                                <a class="btn btn-app" onclick="step('stepx')">
                                                    <i class="fa fa-angle-double-right"></i> Next
                                                </a>

                                            </div>

                                        </div>

                                        <div class="callout" style="display: none;" id="2_stepx">
                                            <h5>What will you like to publish to DHIS2 Server from the SORMAS System?</h5>

                                            <p>Please select all that applies</p>
                                            <div class="row">
                                                <div class="col s4">
                                                    CASES DATA
                                                    <div class="switch">
                                                        <label>
                                                            Disable Sync
                                                            <input type="checkbox"  class="only_x">
                                                            <span class="lever"></span>
                                                            Enable Sync
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col s4">
                                                    SAMPLES DATA
                                                    <div class="switch">
                                                        <label>
                                                            Disable Sync
                                                            <input type="checkbox" class="only_x">
                                                            <span class="lever"></span>
                                                            Enable Sync
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col s4">
                                                    CONTACT DATA
                                                    <div class="switch">
                                                        <label>
                                                            Disable Sync
                                                            <input type="checkbox" class="only_x">
                                                            <span class="lever"></span>
                                                            Enable Sync
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col s4">
                                                    AGGREGATES ONLY
                                                    <div class="switch">
                                                        <label>
                                                            Disable Sync
                                                            <input type="checkbox" id="only_">
                                                            <span class="lever"></span>
                                                            Enable Sync
                                                        </label>
                                                    </div>
                                                </div>

                                                <a class="btn btn-app" onclick="step('2_stepx')">
                                                    <i class="fa fa-angle-double-right"></i> Next
                                                </a>

                                            </div>

                                        </div>





                                        <div class="callout" style="display: none;" id="2_2_stepx">
                                            <h5>How often?</h5>

                                            <p>Please select one, note that too often duration may poss more traffic on both servers</p>
                                            <div class="row">
                                                <div class="col s4">
                                                    <div class="icheck-primary d-inline">
                                                        <input type="radio" id="radioPrimar" name="r1">
                                                        <label for="radioPrimar">
                                                            hourly
                                                        </label>
                                                    </div><p></p>
                                                    <div class="icheck-primary d-inline">


                                                        <input type="radio" id="radioPrimary" name="r1" >
                                                        <label for="radioPrimary">
                                                            6-hour
                                                        </label>
                                                    </div><p></p>
                                                    <div class="icheck-primary d-inline">
                                                        <input type="radio" id="radioPrim" name="r1" >
                                                        <label for="radioPrim">
                                                            12-hour
                                                        </label>
                                                    </div><p></p>
                                                    <div class="icheck-primary d-inline">
                                                        <input type="radio" id="radioP" name="r1" >
                                                        <label for="radioP">
                                                            daily
                                                        </label>
                                                    </div>


                                                </div>




                                                <a class="btn btn-app" onclick="step('2_2_stepx')">
                                                    <i class="fa fa-angle-double-right"></i> Next
                                                </a>

                                            </div>

                                        </div>


                                        <div class="callout" style="display: none;" id="2_2_2_stepx">
                                            <h5>Can I do ahead and install SORMAS Module on you DHIS2?</h5>

                                            <p>You will meed to provide an administrator username and password of the DHIS2 server</p>
                                            <div class="col s6">

                                                <div class="switch">
                                                    <label>
                                                        Download Installer file instead
                                                        <input type="checkbox" id="instll" onclick="checkerX()">
                                                        <span class="lever"></span>
                                                        Create Module Automatically
                                                    </label>
                                                </div>
                                            </div>
                                            <hr>
                                            
                                          
                                            
                                            <div class="row" id="instllx" style="display: none;">
                                                <div class="col s4 m4 l4">

                                                    <div class="form-group col s6 m6 l6">
                                                        <label>DHIS2 URL:</label>

                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text"><i class="far fa-link"></i></span>
                                                            </div>
                                                            <input type="url" class="form-control" data-inputmask-alias="datetime" data-inputmask-inputformat="dd/mm/yyyy" data-mask="" im-insert="false" required>
                                                        </div>

                                                        <label>Administrator Username:</label>

                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text"><i class="far fa-user"></i></span>
                                                            </div>
                                                            <input type="text" class="form-control" data-inputmask-alias="datetime" data-inputmask-inputformat="dd/mm/yyyy" data-mask="" im-insert="false" required>
                                                        </div>

                                                        <label>Administrator Password</label>

                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text"><i class="far fa-key"></i></span>
                                                            </div>
                                                            <input type="password" class="form-control" data-inputmask-alias="datetime" data-inputmask-inputformat="dd/mm/yyyy" data-mask="" im-insert="false" required>
                                                        </div>
                                                        <!-- /.input group -->
                                                    </div>

                                                    <a class="btn btn-app" onclick="step('2_2_2_stepx')">
                                                        <i class="fa fa-sign-in-alt"></i> Perform selected Action
                                                    </a>

                                                </div>

                                            </div>
                                            
                                              <div class="row" id="instllx_" style="display: none;">
                                                <div class="col s4 m4 l4">
                                            <a class="btn btn-app" onclick="step('2_2_2_stepx')">
                                                        <i class="fa fa-download"></i> Download Installers
                                                    </a>
                                            
                                            </div>
                                            



                                        </div>
                                        <!-- /.card-body -->
                                    </div>
                                    <!-- /.card -->
                            </section> 

                        </div>             

                    </section>




                </div>




            <jsp:include page="template/scripts_footer.jsp"></jsp:include>


            <script>

                function step(e) {
                    $("#" + e).addClass("disabledbutton");
                    $("#" + e).toggleClass("callout-success");
                    // alert("#2_" + e);
                    $("#2_" + e).show(500);
                    checker();
                }
                function checker() {
                    if ($("#only_").prop("checked") === true) {
                        $(".only_").prop("checked", false);
                        alert("You have selected Aggregate only, hence, all other options are disabled");
                    }

                }





                function checkerX() {
                    if ($("#instll").prop("checked") === true) {
                        $("#instllx").show(1000);
                        $("#instllx_").hide(1000);
                        

                    } else {
                        $("#instllx").hide(1000);
                        $("#instllx_").show(1000);
                    }

                }






                ;

            </script>
    </body>
</html>