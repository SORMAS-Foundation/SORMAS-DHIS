<%@page import="com.mirabilia.org.hzi.test.tester_"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mirabilia.org.hzi.Util.dhis.optionFiler"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mirabilia.org.hzi.sormas.doa.DbConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.PreparedStatement"%>
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
                                    <form action="../asdfghjytrsfddsfkjshdgvgbhsrdtnjyunbshvagwcwgavetryjtbkuytjrhsevasfdcsdfgvhjybukretrsearstybjgk" method="post" id="fomX">
                                        <!-- /.card-header -->

                                    <%

                                        try {
                                            PreparedStatement ps;
                                            ResultSet rx;
                                            Connection conn = DbConnector.getConnection();
                                            ps = conn.prepareStatement("select * from optionfiles;");
                                            rx = ps.executeQuery();
                                            if (rx.next()) {

                                                String x1x = "";
                                                if ("ad_2".equalsIgnoreCase(rx.getString("r1x"))) {
                                                    x1x = "checked";
                                                }
                                                String x1x1 = "";
                                                if ("ad_3".equalsIgnoreCase(rx.getString("r1x"))) {
                                                    x1x1 = "checked";
                                                }
                                                String x1x11 = "";
                                                if ("ad_4".equalsIgnoreCase(rx.getString("r1x"))) {
                                                    x1x11 = "checked";
                                                }
                                                String x1x111 = "";
                                                if ("ad_5".equalsIgnoreCase(rx.getString("r1x"))) {
                                                    x1x111 = "checked";
                                                }

                                                String tm = "";
                                                if ("6hr".equalsIgnoreCase(rx.getString("r1"))) {
                                                    tm = "checked";
                                                }
                                                String tm1 = "";
                                                if ("24hr".equalsIgnoreCase(rx.getString("r1"))) {
                                                    tm1 = "checked";
                                                }
                                                String tm2 = "";
                                                if ("week".equalsIgnoreCase(rx.getString("r1"))) {
                                                    tm2 = "checked";
                                                }
                                                String tm3 = "";
                                                if ("month".equalsIgnoreCase(rx.getString("r1"))) {
                                                    tm3 = "checked";
                                                }


                                    %>
                                    <div class="card-body">
                                        <div class="callout" id="stepx">
                                            <h5>Maintenance</h5>

                                            <p>Please answer "Setup" if this is the first time the adapter is been installed or the adapter service has just been reinstalled. If not, click next to perform maintenance</p>
                                            <div class="row">
                                                <div class="col s4">
                                                    New Server?

                                                    <div class="switch">
                                                        <label>
                                                            Perform maintenance
                                                            <input type="checkbox" <%=rx.getString(2)%> name="server" id="maintenance">
                                                            <span class="lever"></span>
                                                            Setup as new Server
                                                        </label>
                                                    </div>

                                                </div>
                                                <a class="btn btn-app" onclick="step('stepx')">
                                                    <i class="fa fa-angle-double-right"></i> Next
                                                </a>

                                            </div>

                                        </div>


                                        <div class="callout" style="display: none;" id="p_maintenance">
                                            <h5>Maintenance Options</h5>

                                            <p>Please click on any of the available options to perform maintenance, you may want to refer to the user manual on this
                                            </p>
                                            <div class="row">

                                                <table class="table table-bordered text-center">
                                                    <tbody>

                                                        <tr>

                                                            <td>
                                                                <a type="button" onclick="start_pushX_()" class="btn btn-block btn-outline-secondary btn-xs nope">Manually Sync Aggregate Data</a>
                                                            </td>
                                                            <td>
                                                                <a type="button" onclick="start_pushX_m()" href="" class="btn btn-block btn-outline-secondary btn-xs nope">Manually Sync Case Based Data</a>
                                                            </td>
                                                            <td>
                                                                <a type="button" href="" class="btn btn-block btn-outline-secondary btn-xs disabled">Edit Option/Configuration Files</a>
                                                            </td>
                                                            <td>
                                                                <a type="button" href="" class="btn btn-block btn-outline-secondary btn-xs disabled">Reset the system and configurations</a>
                                                            </td>

                                                        </tr>
                                                    </tbody></table> 

                                            </div>
                                        </div>




                                        <div class="callout" style="display: none;" id="2_stepx">
                                            <h5>What will you like to publish to DHIS2 Server from the SORMAS System?</h5>

                                            <p>Please select all that applies</p>
                                            <div class="row">
                                                <div class="col s3">
                                                    CASES DATA
                                                    <div class="switch">
                                                        <label>
                                                            Disable Sync
                                                            <input type="checkbox"  <%=rx.getString(3)%>  name="case_data" class="only_x">
                                                            <span class="lever"></span>
                                                            Enable Sync
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col s3">
                                                    SAMPLES DATA
                                                    <div class="switch">
                                                        <label>
                                                            Disable Sync
                                                            <input type="checkbox" name="sample_data"  <%=rx.getString(4)%>  class="only_x">
                                                            <span class="lever"></span>
                                                            Enable Sync
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col s3">
                                                    CONTACT DATA
                                                    <div class="switch">
                                                        <label>
                                                            Disable Sync
                                                            <input type="checkbox" name="contact_data" <%=rx.getString(5)%>  class="only_x">
                                                            <span class="lever"></span>
                                                            Enable Sync
                                                        </label>
                                                    </div>
                                                </div>
                                                <div class="col s3">
                                                    AGGREGATES
                                                    <div class="switch">
                                                        <label>
                                                            Disable Sync
                                                            <input type="checkbox" name="with_aggregate" <%=rx.getString(6)%>  id="only__">
                                                            <span class="lever"></span>
                                                            Enable Sync
                                                        </label>
                                                    </div>
                                                </div>

                                                <div class="col s3">
                                                    AGGREGATES ONLY
                                                    <div class="switch">
                                                        <label>
                                                            Disable Sync
                                                            <input type="checkbox" name="aggregate_only" <%=rx.getString(7)%>  id="only_">
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
                                            <h5>Aggregation lowest level?</h5>

                                            <p id="non_app_"></p>
                                            <div class="row" >
                                                <div class="col s4" id="non_app">
                                                    <div class="icheck-primary d-inline">
                                                        <input type="radio" id="radioPrimar" name="r1x" <%=x1x%>  value="ad_2">
                                                        <label for="radioPrimar">
                                                            Admin 2 (State / Region)
                                                        </label>
                                                    </div><p></p>
                                                    <div class="icheck-primary d-inline">


                                                        <input type="radio" id="radioPrimary" name="r1x" <%=x1x1%> value="ad_3">
                                                        <label for="radioPrimary">
                                                            Admin 3 (LGA / District)
                                                        </label>
                                                    </div><p></p>
                                                    <div class="icheck-primary d-inline">
                                                        <input type="radio" id="radioPrim" name="r1x" <%=x1x11%> value="ad_4">
                                                        <label for="radioPrim">
                                                            Admin 4 (Ward / Community)
                                                        </label>
                                                    </div><p></p>
                                                    <div class="icheck-primary d-inline">
                                                        <input type="radio" id="radioP" name="r1x" <%=x1x111%> value="ad_5">
                                                        <label for="radioP">
                                                            Admin 5 (Health Facility / Facility)
                                                        </label>
                                                    </div>


                                                </div>




                                                <a class="btn btn-app" onclick="step('2_2_stepx')">
                                                    <i class="fa fa-angle-double-right"></i> Next
                                                </a>

                                            </div>

                                        </div>


                                        <div class="callout" style="display: none;" id="2_2_2_stepx">
                                            <h5>How often?</h5>

                                            <p>Please select one, note that too often duration may poss more traffic on both servers</p>
                                            <div class="row">
                                                <div class="col s4">
                                                    <div class="icheck-primary d-inline">
                                                        <input type="radio" id="radioPrimarx" name="r1" <%=tm%> value="6hr">
                                                        <label for="radioPrimarx">
                                                            6-hour
                                                        </label>
                                                    </div><p></p>
                                                    <div class="icheck-primary d-inline">


                                                        <input type="radio" id="radioPrimaryx" name="r1" <%=tm1%> value="24hr">
                                                        <label for="radioPrimaryx">
                                                            daily
                                                        </label>
                                                    </div><p></p>
                                                    <div class="icheck-primary d-inline">
                                                        <input type="radio" id="radioPrimx" name="r1" <%=tm2%> value="week">
                                                        <label for="radioPrimx">
                                                            weekly
                                                        </label>
                                                    </div><p></p>
                                                    <div class="icheck-primary d-inline">
                                                        <input type="radio" id="radioPx" name="r1" <%=tm3%> value="month">
                                                        <label for="radioPx">
                                                            monthly
                                                        </label>
                                                    </div>


                                                </div>




                                                <a class="btn btn-app" onclick="step('2_2_2_stepx')">
                                                    <i class="fa fa-angle-double-right"></i> Next
                                                </a>

                                            </div>

                                        </div>


                                        <div class="callout" style="display: none;" id="2_2_2_2_stepx">
                                            <h5>How do you want to install SORMAS Module on your DHIS2?</h5>


                                            <div class="col s6">

                                                <div class="switch">
                                                    <label>
                                                        Download Installer file instead
                                                        <input type="checkbox" id="instll" name="installer"   <%=rx.getString(9)%> onclick="checkerX()">
                                                        <span class="lever"></span>
                                                        Create Module Automatically
                                                    </label>
                                                </div>
                                            </div>
                                            <hr>



                                            <div class="row" id="instllx" style="display: none;">
                                                <div class="col s4 m4 l4">
                                                    <p>You will need to provide an administrator's username and password of the DHIS2 server</p>

                                                    <div class="form-group col s6 m6 l6">
                                                        <i>Using default DHIS URL found in the system</i>

                                                        <!--div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text"><i class="far fa-link"></i></span>
                                                            </div>
                                                            <input type="url" class="form-control" data-inputmask-alias="datetime" data-inputmask-inputformat="dd/mm/yyyy" data-mask="" im-insert="false" required>
                                                        </div--><br>

                                                        <label>DHIS2 Administrator Username:</label>

                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text"><i class="far fa-user"></i></span>
                                                            </div>
                                                            <input name="admin_uname" id="usn" type="text" class="form-control"  im-insert="false" required>
                                                        </div>

                                                        <label>DHIS2 Administrator Password</label>

                                                        <div class="input-group">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text"><i class="far fa-check"></i></span>
                                                            </div>
                                                            <input name="admin_upass" id="ups" type="password" class="form-control"  im-insert="false" required>
                                                        </div>
                                                        <!-- /.input group -->
                                                    </div>

                                                    <div class="btn btn-app" id="stop_a" >
                                                        <i class="fa fa-sign-in-alt"></i> Save Setting & Perform selected Action
                                                    </div>

                                                </div>

                                            </div>

                                            <div class="row" id="instllx_" style="display: none;">
                                                <div class="col s4 m4 l4">
                                                    <a class="btn btn-app" target="_blank" href="http://172.105.77.79/downlos/dhisMetadata.json">
                                                        <i class="fa fa-download"></i> Save Setting & Download Installers
                                                    </a>

                                                </div>




                                            </div>
                                            <!-- /.card-body -->
                                        </div>
                                        <!-- /.card -->
                                    </div>
                                </form>
                                <%

                                        }

                                    } finally {
                                    }

                                %>
                        </section> 

                    </div>             

                </section>




            </div>



            <!-- Modal -->
            <div class="modal fade" id="RespondX" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>

                        </div>
                        <div class="modal-body" style="overflow-x: auto;">
                            <p id="xdb"></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>


            <div id="overlay" onclick="off()">
                <div id="text"><h2>please wait...</h2></div></div>


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
                            $('#non_app').show();
                            $('#non_app_').html('Please select the lowest level you will like the sync with DHIS2');
                            // alert("You have selected Aggregate only, hence, all other options are disabled");
                        } else {
                            //  alert("You have selected Aggregate only");
                            $('#non_app').hide();
                            $('#non_app_').html('Not applicable... please click on next');
                        }
                        ;

                        if ($("#maintenance").prop("checked") === true) {

                        } else {

                            $('#p_maintenance').show(100);
                            $('#2_stepx').remove();
                        }
                        ;

                    }



                    //maintenance

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

                    $('a.nope').click(function () {
                        return false;
                    })


                    function start_pushX_() {


                        document.getElementById("overlay").style.display = "block";
                        $('#text').html("Pushing all available matched data to sormas...");
                        var xhr = new XMLHttpRequest();
                        xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?aggregatToDHIS=true', true);
                        xhr.responseType = 'text';
                        xhr.onload = function () {

                            if (xhr.readyState === xhr.DONE) {
                                if (xhr.status === 200) {

                                    document.getElementById("overlay").style.display = "none";

                                    alert('response from server  : ' + xhr.responseText);

                                }
                            }
                        };
                        xhr.send(null);

                    }
                    ;


                    function start_pushX_m() {


                        document.getElementById("overlay").style.display = "block";
                        $('#text').html("Syncing Persons record from SORMAS to DHIS2 Tracked Entity...");
                        var xhr = new XMLHttpRequest();
                        xhr.open('GET', '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?personToDHIS=true', true);
                        xhr.responseType = 'text';
                        xhr.onload = function () {

                            if (xhr.readyState === xhr.DONE) {
                                if (xhr.status === 200) {

                                    document.getElementById("overlay").style.display = "none";

                                    alert('response from server  : ' + xhr.responseText);

                                }
                            }
                        };
                        xhr.send(null);

                    }
                    ;




                <%   //processing dhis_ control metadata from static file
                    String couty = session.getAttribute("country").toString();

                    try {
                        InputStream is = null;
                        is = getServletContext().getResourceAsStream("/WEB-INF/metajson.json"); // this works!
                        InputStreamReader isReaderd = new InputStreamReader(is);
                        
                        BufferedReader readerd = new BufferedReader(isReaderd);
                        StringBuffer sbs = new StringBuffer();
                        String str;
                        while ((str = readerd.readLine()) != null) {
                            sbs.append(str);
                        }
                        System.out.println(sbs + "___________________________________________");
                        
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println(getServletContext().getAttributeNames() + "___________________________________________");
                    if ("Nigeria".equalsIgnoreCase(couty)) {
                        InputStream intput = getServletContext().getResourceAsStream("dhis_processor");
                        //creating an InputStreamReader object
                        InputStreamReader isReader = new InputStreamReader(intput);
                        //Creating a BufferedReader object
                        BufferedReader reader = new BufferedReader(isReader);
                        StringBuffer sb = new StringBuffer();
                        String str;
                        while ((str = reader.readLine()) != null) {
                            sb.append(str);
                        }

                        session.setAttribute("heavyjson", sb.toString());
                        intput.close();
                        isReader.close();
                        reader.close();
                    }
                    if ("Ghana".equalsIgnoreCase(couty)) {
                        InputStream intput = getServletContext().getResourceAsStream("dhis_processor_gh");
                        //creating an InputStreamReader object
                        InputStreamReader isReader = new InputStreamReader(intput);
                        //Creating a BufferedReader object
                        BufferedReader reader = new BufferedReader(isReader);
                        StringBuffer sb = new StringBuffer();
                        String str;
                        while ((str = reader.readLine()) != null) {
                            sb.append(str);
                        }

                        session.setAttribute("heavyjson", sb.toString());
                        intput.close();
                        isReader.close();
                        reader.close();
                    }


                %>

                    //   function get(e) {
                    $('#stop_a').click(function (event) {
                        event.preventDefault()


                        // $('#fomX').submit();
                        var usn = $('#usn').val();
                        var psn = $('#ups').val()
                        req = new XMLHttpRequest()
                        //  console.log('../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?PUSHRESULTS=true&usn=' + usn + '&ups=' + psn);
                        req.open("POST", '../iopujlksrefdxcersdfxcedrtyuilkmnbvsdfghoiuytrdcvbnmkiuytrewsazsedfcd345678?PUSHRESULTS=true&usn=' + usn + '&ups=' + psn + '', true);

                        req.send();

                        req.onload = function () {
                            // alert(req.responseText);

                            //var djson = '{"Error":3}';

                            console.log(req.responseText);

                            var json = JSON.parse(req.responseText);

                            console.log(json);

                            var jsonViewer = new JSONViewer();
                            document.querySelector("#xdb").appendChild(jsonViewer.getContainer());


                            jsonViewer.showJSON(json, -1, -1);
                            var json = "";
                            
                             $('#RespondX').modal('show');

                        };


                       

                    });




            </script>
    </body>
</html>