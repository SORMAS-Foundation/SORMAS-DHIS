    
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.mirabilia.org.hzi.sormas.getterSetters"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mirabilia.org.hzi.sormas.doa.DbConnector"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<!DOCTYPE html>
<html><head>
        <style>
            .loader,
            .loader:before,
            .loader:after {
                background: #ffffff;
                -webkit-animation: load1 1s infinite ease-in-out;
                animation: load1 1s infinite ease-in-out;
                width: 1em;
                height: 4em;
            }
            .loader {
                color: #ffffff;
                text-indent: -9999em;
                margin: 88px auto;
                position: relative;
                font-size: 11px;
                -webkit-transform: translateZ(0);
                -ms-transform: translateZ(0);
                transform: translateZ(0);
                -webkit-animation-delay: -0.16s;
                animation-delay: -0.16s;
                margin-top: 250px;
                z-index: 1000;
            }
            .loader:before,
            .loader:after {
                position: absolute;
                top: 0;
                content: '';
            }
            .loader:before {
                left: -1.5em;
                -webkit-animation-delay: -0.32s;
                animation-delay: -0.32s;
            }
            .loader:after {
                left: 1.5em;
            }
            @-webkit-keyframes load1 {
                0%,
                80%,
                100% {
                    box-shadow: 0 0;
                    height: 4em;
                }
                40% {
                    box-shadow: 0 -2em;
                    height: 5em;
                }
            }
            @keyframes load1 {
                0%,
                80%,
                100% {
                    box-shadow: 0 0;
                    height: 4em;
                }
                40% {
                    box-shadow: 0 -2em;
                    height: 5em;
                }
            }
            body{
                background-color: #7b7878bf;
                padding-top: 5em;

            }
            .d_text{
                width: 100%;
                justify-content: center;
                font-family: "Lucida Console", Courier, monospace;
                color: #505050;
                text-align: center;
            }
        </style>

    </head><body>
        <div class="loader">
        </div>
        <h3 class="d_text" id="d_text">working on it...</h3>
        <script src="../fhir_frontend/mira_assets/js/jquery.min.js" type="text/javascript"></script>
        
        <script>
           
             //clear the local tables first
             deleterXcc();
            
            
    //    
      
            
            function deleterXcc() {
                var xhr = new XMLHttpRequest();
                xhr.open('GET', '../localizerz?del_all=true', true);
                xhr.responseType = 'text';
                xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                        if (xhr.status === 200) {
                            maxx = xhr.responseText;
                            console.log("deleting");
                            $('#d_text').append("<br>Cached: Local Database cleared successfully");
                        } else {
                            $('#d_text').html("Server down: 500");
                            console.log("Server error while contacting main methods to get total number of chunks");
                            window.location.replace("../fhir_frontend/OrgToolOperation.jsp?sayfini=false");
                            return;
                        }
                         rg_starter();
                    }
                };

                xhr.send("");
               
            };
            
              function rg_starter() {
                var xhr = new XMLHttpRequest();
                xhr.open('GET', '../localizerz?rg=true', true);
                xhr.responseType = 'text';
                xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                        if (xhr.status === 200) {
                            maxx = xhr.responseText;
                            console.log("region");
                            $('#d_text').append("<br>Cached: State/region data successfully");
                        } else {
                            $('#d_text').html("Server down: 500");
                            console.log("Server error while contacting main methods to get total number of chunks");
                            window.location.replace("../fhir_frontend/OrgToolOperation.jsp?sayfini=false");
                            return;
                        }
                         ds_starter();
                    }
                };

                xhr.send("");
               
            };
            
            
            function ds_starter() {
                var xhr = new XMLHttpRequest();
                xhr.open('GET', '../localizerz?ds=true', true);
                xhr.responseType = 'text';
                xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                        if (xhr.status === 200) {
                            maxx = xhr.responseText;
                            console.log("district");
                            $('#d_text').append("<br>Cached: LGA / districts data successfully");
                        } else {
                            $('#d_text').html("Server down: 500");
                            window.location.replace("../fhir_frontend/OrgToolOperation.jsp?sayfini=false");
                            return;
                        }
                        wd_starter();
                    }
                };

                xhr.send("");
                
            };
            
            function wd_starter() {
                var xhr = new XMLHttpRequest();
                xhr.open('GET', '../localizerz?co=true', true);
                xhr.responseType = 'text';
                xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                        if (xhr.status === 200) {
                            maxx = xhr.responseText;
                            console.log("ward done");
                            
                           $('#d_text').append("<br>Cached: ward / community data successfully!<br>now processing facilities, this might take a moment");
                        } else {
                            $('#d_text').html("Server down: 500");
                            window.location.replace("../fhir_frontend/OrgToolOperation.jsp?sayfini=false");
                            return;
                        }
                           window.location.replace("../fhir_frontend/OrgToolOperation.jsp?sayfini=true"); //should be removed to allow facility run
                        fc_starter();
                    }
                };

                xhr.send("");
               // 
            };
            
            function fc_starter() {
                var xhr = new XMLHttpRequest();
                xhr.open('GET', '../localizerz?fa=true', true);
                xhr.responseType = 'text';
                xhr.onload = function () {
                    if (xhr.readyState === xhr.DONE) {
                        if (xhr.status === 200) {
                            maxx = xhr.responseText;
                            console.log("facility");
                             $('#d_text').append("Cached: facility data successfully");
                        } else {
                            $('#d_text').html("Server down: 500");
                            window.location.replace("../fhir_frontend/OrgToolOperation.jsp?sayfini=false");
                            return;
                        }
                         window.location.replace("../fhir_frontend/OrgToolOperation.jsp?sayfini=true");
                     
                    }
                };

                xhr.send("");
            };

        </script>


    </body></html>
