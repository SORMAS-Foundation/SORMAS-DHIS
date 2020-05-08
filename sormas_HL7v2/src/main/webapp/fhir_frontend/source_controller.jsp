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
                    <section class="content-header">
                        <div class="container-fluid">
                            <div class="row mb-2">
                                <div class="col-sm-6">
                                    <h2>Sources Configurations</h2>
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
                                <div class="card">
                                    <div class="card-header">
                                        <h3 class="card-title">
                                            <i class="ion ion-clipboard mr-1"></i>
                                            Available Sources
                                        </h3>

                                        <!--div class="card-tools">
                                            <ul class="pagination pagination-sm">
                                                <li class="page-item"><a href="#" class="page-link">&laquo;</a></li>
                                                <li class="page-item"><a href="#" class="page-link">1</a></li>
                                                <li class="page-item"><a href="#" class="page-link">2</a></li>
                                                <li class="page-item"><a href="#" class="page-link">3</a></li>
                                                <li class="page-item"><a href="#" class="page-link">&raquo;</a></li>
                                            </ul>
                                        </div-->
                                    </div>
                                    <!-- /.card-header -->

                                    <div class="card-body">
                                        <ul class="todo-list" data-widget="todo-list" id="productTable">

                                        </ul>
                                    </div>
                                    <!-- /.card-body -->
                                    <div class="card-footer clearfix">
                                        <button type="button" class="btn btn-info float-right" data-toggle="modal" id="source_addition_button" data-target="#modal-sources"><i class="fas fa-plus">

                                            </i> Add item
                                        </button>
                                        
                                        
                                    </div>

                                </div>
                                <!-- /.card -->
                            </section>  <!--section class="col-lg-5 connectedSortable">
                                
                            
                    <div class="card">
                      <div class="card-header">
                        <h3 class="card-title">Collapsible Accordion</h3>
                      </div>
                    
                      <div class="card-body">
                        <div id="accordion">
                          <div class="card card-primary">
                            <div class="card-header">
                              <h4 class="card-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                  Collapsible Group Item #1
                                </a>
                              </h4>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse in">
                              <div class="card-body">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                                3
                                wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                                laborum
                                eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee
                                nulla
                                assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred
                                nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft
                                beer
                                farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                                labore sustainable VHS.
                              </div>
                            </div>
                          </div>
                          <div class="card card-danger">
                            <div class="card-header">
                              <h4 class="card-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                  Collapsible Group Danger
                                </a>
                              </h4>
                            </div>
                            <div id="collapseTwo" class="panel-collapse collapse">
                              <div class="card-body">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                                3
                                wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                                laborum
                                eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee
                                nulla
                                assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred
                                nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft
                                beer
                                farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                                labore sustainable VHS.
                              </div>
                            </div>
                          </div>
                          <div class="card card-success">
                            <div class="card-header">
                              <h4 class="card-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                                  Collapsible Group Success
                                </a>
                              </h4>
                            </div>
                            <div id="collapseThree" class="panel-collapse collapse">
                              <div class="card-body">
                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                                3
                                wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                                laborum
                                eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee
                                nulla
                                assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred
                                nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft
                                beer
                                farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                                labore sustainable VHS.
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    
                  </div>
                            </section-->

                        </div>             

                    </section>











                    <form id="sourceUpdate">

                        <!-- source linking tables -->
                        <section class="col-lg-12 connectedSortable">
                            <div class="card">
                                <div class="overlay dark" id="loading">
                                    <i class="fas fa-2x fa-sync-alt"></i>
                                </div>
                                <div class="container-fluid">
                                    <div class="row">

                                        <div class="col-md-12" >  
                                            <div class="card">
                                                <div class="card-header">
                                                    <h3 class="card-title">
                                                        <i class="ion ion-clipboard mr-1"></i>
                                                        Source Pairing
                                                    </h3>


                                                </div>

                                            </div>

                                        </div>

                                        <div class="col-md-6">
                                            <div class="card">
                                                <div class="card-header">
                                                    <h3 class="card-title"> <strong>Source</strong></h3>
                                                </div>
                                                <!-- /.card-header -->
                                                <div class="card-body">
                                                    <table class="table table-bordered" id="tableTable">
                                                        <thead>                  
                                                            <tr>
                                                                <th style="width: 10px">#</th>
                                                                <th>Source Name</th>
                                                                <th>URL</th>
                                                                <th style="width: 40px">Active</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>

                                                        </tbody>
                                                    </table>
                                                </div>
                                                <!-- /.card-body -->
                                                <div class="card-footer clearfix">
                                                    <ul class="pagination pagination-sm m-0 float-right">
                                                        <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                                        <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="col-sm-12">
                                                <a class="btn btn-app float-sm-left">
                                                    <i class="fas fa-undo"></i> Reset
                                                </a>
                                            </div>



                                            <!-- /.card -->
                                        </div>

                                        <!-- /.col -->
                                        <div class="col-md-6">
                                            <div class="card">
                                                <div class="card-header">
                                                    <h3 class="card-title"><strong>Destination</strong></h3>
                                                </div>
                                                <!-- /.card-header -->
                                                <div class="card-body">
                                                    <table class="table table-bordered" id="table_Table">
                                                        <thead>                  
                                                            <tr>
                                                                <th style="width: 10px">#</th>
                                                                <th>Source Name</th>
                                                                <th>URL</th>
                                                                <th style="width: 40px">Active</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>

                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="card-footer clearfix">
                                                    <ul class="pagination pagination-sm m-0 float-right">
                                                        <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                                                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                                        <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="col-sm-12">

                                                <a id="updatepairs" onclick="dd();" class="btn btn-app float-sm-right" href="#"> <i class="fa fa-save"></i> Save</a>

                                            </div>

                                            <!-- /.card-body -->

                                            <!-- /.card -->
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <!-- /.content-wrapper -->
                        </section>
                    </form>

                <%
                    String sourcesX = sourceDTO.getSourcePaired();
                    System.out.println(sourcesX);

                %>

                <section class="col-lg-12 connectedSortable">
                    <div class="row">
                        <!-- Source creator -->
                        <section class="col-lg-12 connectedSortable">
                            <!-- TO DO List -->
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">
                                        <i class="ion ion-clipboard mr-1"></i>
                                        Available Paired Sources
                                    </h3>

                                    <!--div class="card-tools">
                                        <ul class="pagination pagination-sm">
                                            <li class="page-item"><a href="#" class="page-link">&laquo;</a></li>
                                            <li class="page-item"><a href="#" class="page-link">1</a></li>
                                            <li class="page-item"><a href="#" class="page-link">2</a></li>
                                            <li class="page-item"><a href="#" class="page-link">3</a></li>
                                            <li class="page-item"><a href="#" class="page-link">&raquo;</a></li>
                                        </ul>
                                    </div-->
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <ul class="todo-list" data-widget="todo-list" id="">
                                        <%=sourcesX%>
                                    </ul>
                                </div>
                                <!-- /.card-body -->


                            </div>
                            <!-- /.card -->
                        </section>  <!--section class="col-lg-5 connectedSortable">
                            
                        
                <div class="card">
                  <div class="card-header">
                    <h3 class="card-title">Collapsible Accordion</h3>
                  </div>
                
                  <div class="card-body">
                    <div id="accordion">
                      <div class="card card-primary">
                        <div class="card-header">
                          <h4 class="card-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                              Collapsible Group Item #1
                            </a>
                          </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in">
                          <div class="card-body">
                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                            3
                            wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                            laborum
                            eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee
                            nulla
                            assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred
                            nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft
                            beer
                            farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                            labore sustainable VHS.
                          </div>
                        </div>
                      </div>
                      <div class="card card-danger">
                        <div class="card-header">
                          <h4 class="card-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                              Collapsible Group Danger
                            </a>
                          </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse">
                          <div class="card-body">
                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                            3
                            wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                            laborum
                            eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee
                            nulla
                            assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred
                            nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft
                            beer
                            farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                            labore sustainable VHS.
                          </div>
                        </div>
                      </div>
                      <div class="card card-success">
                        <div class="card-header">
                          <h4 class="card-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                              Collapsible Group Success
                            </a>
                          </h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse">
                          <div class="card-body">
                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid.
                            3
                            wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt
                            laborum
                            eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee
                            nulla
                            assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred
                            nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft
                            beer
                            farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus
                            labore sustainable VHS.
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                
              </div>
                        </section-->

                    </div>             

                </section>






                <div class="modal fade" id="modal-sources">
                    <div class="modal-dialog">
                        <div class="modal-content bg-info">
                            <div class="modal-header">
                                <h4 class="modal-title">Add New Source</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span></button>
                            </div>
                            <form role="form" id="source_addition">
                                <div class="modal-body">


                                    <div class="card-body">
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Title</label>
                                            <input type="text" name="title" class="form-control" id="exampleInputEmail1" placeholder="Enter title">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Path/URL</label>
                                            <input type="url" name="url" class="form-control" id="exampleInputPassword1" placeholder="url with trailing slash">
                                        </div>
                                        <div class="form-group">
                                            <label for="ddd">Description</label>
                                            <input type="text" name="desc" class="form-control" id="ddd" placeholder="description">
                                        </div>

                                        <div class="form-group mb-0">

                                            <input type="checkbox" name="active">Activate this source?.
                                        </div>



                                    </div>
                                </div>
                                <div class="modal-footer justify-content-between">
                                    <button type="button" class="btn btn-outline-light" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-outline-light">Save changes</button>
                                </div>
                            </form>
                        </div>
                        <!-- /.modal-content -->
                    </div>
                    <!-- /.modal-dialog -->
                </div>



                <jsp:include page="template/scripts_footer.jsp"></jsp:include>



                <!--script>
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
                 </script-->
                <script type="text/javascript">



                    function alertx() {
                    const Toast = Swal.mixin({
                    toast: true,
                            position: 'top-end',
                            showConfirmButton: false,
                            timer: 3000
                    });
                    Toast.fire({
                    type: 'success',
                            title: 'Data sent to server successfully.'
                    });
                    productList();
                    }
                    ;
                    //source destination setting
                    function alertxx(ee) {
                    const Toast = Swal.mixin({
                    toast: true,
                            position: 'top-end',
                            showConfirmButton: false,
                            timer: 3000
                    });
                    Toast.fire({
                    type: 'success',
                            title: 'Sent to server: ' + ee
                    });
                    //  productList();
                    }
                    ;
                </script>


                <script type="text/javascript">
                    //source_addition
                    $(document).ready(function () {
                    $('#loading').hide();
                    $('#source_addition').on('submit', function (event) {
                    event.preventDefault();
                    $.ajax({
                    url: "../controller",
                            method: "GET",
                            data: $(this).serialize(),
                            //  dataType: "json",
                            beforeSend: function () {

                            $('#loading').show();
                            },
                            success: function (data) {
                            $('#loading').hide();
                            //alert('Operation sent to server!');
                            alertx();
                            $('#modal-sources').modal('toggle');
                            },
                            error: function (xhr, status, error) {
                            var errorMessage = xhr.status + ': ' + xhr.statusText
                                    alert('Operation NOT OK, contact admin! - ' + errorMessage);
                            }

                    });
                    });
                    });
                </script>

                <script type="text/javascript">
                    document.getElementById("updatepairs").addEventListener("click", function(event){
                    event.preventDefault()
                    });
                    function dd(){



                    $('#sourceUpdate').submit();
                    }



                </script>

                <script type="text/javascript">
                    //source_addition
                    $(document).ready(function () {
                    $('#sourceUpdate').on('submit', function (event) {
                    //  alert('Operation sent to server!');
                    event.preventDefault();
                    $.ajax({
                    url: "../controller?getupdateStarted=0",
                            method: "GET",
                            data: $(this).serialize(),
                            //  dataType: "json",
                            beforeSend: function () {
                            $('#loading').show();
                            },
                            success: function (data) {
                            $('#loading').hide();
                            //     alert('Operation sent to server!'+data);
                            alertxx(data);
                            //   $('#modal-sources').modal('toggle');
                            },
                            error: function (xhr, status, error) {
                            var errorMessage = xhr.status + ': ' + xhr.statusText
                                    alert('Operation NOT OK, contact admin! - ' + errorMessage);
                            }

                    });
                    });
                    });
                </script>




                <script type="text/javascript">

                    function productList() {
                    //      console.log("in source lists");
                    $.ajax({
                    url: '../controller?getAllList=0',
                            type: 'GET',
                            //   dataType: 'json',
                            success: function (products) {
                            //  console.log(products);
                            productListSuccess(products);
                            },
                            error: function (request, message, error) {
                            //handleException(request, message, error);
                            alert(error + " : " + message);
                            //            console.log(message);
                            }
                    });
                    }
                    ;
                    productList();
                    function productListSuccess(products) {
                    //     console.log(products);
                    // Iterate over the collection of data
                    // $.each($.parseJSON(products), function (index, value) {
                    // Add a row to the Product table
                    // console.log(value.getOwnPropertyNames());

                    //   productAddRow(product);
                    if ($("#productTable li").length > 0) {
                    $("#productTable").empty();
                    }

                    products = $.parseJSON(products);
                    $.each(products, function (i, item) {
                    //   console.log(item.url);
                    productAddRow(item);
                    });
                    }
                    ;
                    function productAddRow(product) {

                    //  product = $.parseJSON(product);
                    // console.log(product.prototype.URL);
                    //  console.log(product.name);
                    // Check if <tbody> tag exists, add one if not
                    if ($("#productTable li").length == 0) {
                    $("#productTable").append("<li></li>");
                    }
                    // Append row to <table>
                    $("#productTable li").append(
                            productBuildTableRow(product));
                    }


                    function productBuildTableRow(product) {

                    var ret = "<span class=\"handle\"><i class=\"fas fa-ellipsis-v\"></i><i class=\"fas fa-ellipsis-v\"></i></span><div  class=\"icheck-primary d-inline ml-2\"></div><span class=\"text\">" + product.url + "</span><small class=\"badge badge-danger\"><i class=\"fa fa-" + product.status + "\"></i></small><div class=\"tools\"><a href=\"" + product.url + "\" id=\"ss\"><i class=\"fas fa-edit\"></i><i class=\"fas fa-trash-o\"></i></a></div><hr>";
                    //      console.log(product.url);
                    //     console.log(ret);
                    return ret;
                    }
                </script>





                <script type="text/javascript">
                    //populate the list of available sources for pairing
                    function tableList() {
                    //    console.log("in source lists");
                    $.ajax({
                    url: '../controller?getAllList=606', //getting sources
                            type: 'GET',
                            //   dataType: 'json',
                            success: function (tables) {
                            //  console.log(tables);
                            tableListSuccess(tables);
                            },
                            error: function (request, message, error) {
                            //handleException(request, message, error);
                            alert(error + " : " + message);
                            //          console.log(message);
                            }
                    });
                    }
                    ;
                    tableList();
                    function tableListSuccess(tables) {
                    if ($("#tableTable tbody").length > 0) {
                    $("#tableTable").empty();
                    }

                    tables = $.parseJSON(tables);
                    $.each(tables, function (i, item) {
                    //   console.log(item.url);
                    tableAddRow(item);
                    });
                    }
                    ;
                    function tableAddRow(table) {

                    // Check if <tbody> tag exists, add one if not
                    if ($("#tableTable tbody").length == 0) {
                    $("#tableTable").append("<tbody><thead><tr><th>Name</th><th>URL</th><th>On</th></tr></thead></tbody>");
                    }
                    // Append row to <table>
                    $("#tableTable tbody").append(
                            tableBuildTableRow(table));
                    }


                    function tableBuildTableRow(table) {

                    var ret = "<tr><td>" + table.title + "</td><td>" + table.url + "</td><td><input type=\"radio\" name=\"from\" value=\"" + table.uuid + "\"></td></tr>";
                    return ret;
                    }
                </script>











                <script type="text/javascript">
                    //populates the available sources for destination pairing to a source
                    function table_List() {
                    //  console.log("in source lists");
                    $.ajax({
                    url: '../controller?getAllList=0',
                            type: 'GET',
                            //   dataType: 'json',
                            success: function (table_s) {
                            //  console.log(table_s);
                            table_ListSuccess(table_s);
                            },
                            error: function (request, message, error) {
                            //handleException(request, message, error);
                            alert(error + " : " + message);
                            //    console.log(message);
                            }
                    });
                    }
                    ;
                    table_List();
                    function table_ListSuccess(table_s) {

                    if ($("#table_Table tbody").length > 0) {
                    $("#table_Table").empty();
                    }

                    table_s = $.parseJSON(table_s);
                    $.each(table_s, function (i, item) {
                    // console.log(item.uuid);
                    table_AddRow(item);
                    });
                    }
                    ;
                    function table_AddRow(table_) {

                    // Check if <tbody> tag exists, add one if not
                    if ($("#table_Table tbody").length == 0) {
                    $("#table_Table").append("<tbody><thead><tr><th>Name</th><th>URL</th><th>On</th></tr></thead></tbody>");
                    }
                    // Append row to <table_>
                    $("#table_Table tbody").append(
                            table_BuildTableRow(table_));
                    }


                    function table_BuildTableRow(table_) {
                    var ret = "<tr><td>" + table_.title + "</td><td>" + table_.url + "</td><td><input type=\"radio\" name=\"to\" value=\"" + table_.uuid + "\"></td></tr>";
                    return ret;
                    }
                </script>



                </body>
                </html>