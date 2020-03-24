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
                                    <h1>Tables</h1>
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

                    <!-- Source creator -->
                    <section class="col-lg-5 connectedSortable">
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
                                <button type="button" class="btn btn-info float-right" data-toggle="modal" id="source_addition_button" data-target="#modal-sources"><i class="fas fa-plus"></i> Add item
                                </button>
                            </div>
                        </div>
                        <!-- /.card -->

                    </section>


                    <!-- source linking tables -->
                    <section class="col-lg-12 connectedSortable">
                        <div class="card">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="card">
                                            <div class="card-header">
                                                <h3 class="card-title"> <strong>Source</strong></h3>
                                            </div>
                                            <!-- /.card-header -->
                                            <div class="card-body">
                                                <table class="table table-bordered">
                                                    <thead>                  
                                                        <tr>
                                                            <th style="width: 10px">#</th>
                                                            <th>Source Name</th>
                                                            <th>URL</th>
                                                            <th style="width: 40px">Active</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>1.</td>
                                                            <td>Abia</td>
                                                            <td> </td>
                                                            <td>
                                                                <div class="icheck-primary d-inline">
                                                                    <input type="radio" id="11x" name="11" >
                                                                    <label for="11x">
                                                                    </label>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>2.</td>
                                                            <td>Dhis2 Nigeria Instance</td>
                                                            <td> </td>
                                                            <td>
                                                                <div class="icheck-primary d-inline">
                                                                    <input type="radio" id="11xx" name="11" >
                                                                    <label for="11xx">
                                                                    </label>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>3.</td>
                                                            <td>Sormas Test Server</td>
                                                            <td> </td>
                                                            <td>
                                                                <div class="icheck-primary d-inline">
                                                                    <input type="radio" id="11" name="11" >
                                                                    <label for="11">
                                                                    </label>
                                                                </div>
                                                            </td>
                                                        </tr>
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
                                                <table class="table table-bordered">
                                                    <thead>                  
                                                        <tr>
                                                            <th style="width: 10px">#</th>
                                                            <th>Source Name</th>
                                                            <th>URL</th>
                                                            <th style="width: 40px">Active</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>1.</td>
                                                            <td>Abia</td>
                                                            <td> </td>
                                                            <td>
                                                                <div class="icheck-primary d-inline">
                                                                    <input type="radio" id="radioPrimary1" name="r1" >
                                                                    <label for="radioPrimary1">
                                                                    </label>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>2.</td>
                                                            <td>Dhis2 Nigeria Instance</td>
                                                            <td> </td>
                                                            <td>
                                                                <div class="icheck-primary d-inline">
                                                                    <input type="radio" id="radioPrimary2" name="r1" >
                                                                    <label for="radioPrimary2">
                                                                    </label>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>3.</td>
                                                            <td>Sormas Test Server</td>
                                                            <td> </td>
                                                            <td>
                                                                <div class="icheck-primary d-inline">
                                                                    <input type="radio" id="radioPrimary3" name="r1" >
                                                                    <label for="radioPrimary3">
                                                                    </label>
                                                                </div>
                                                            </td>
                                                        </tr>
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
                                            <a href="#" class="btn btn-app float-sm-right" role="button">
                                                <i class="fa fa-save"></i> Save
                                            </a>
                                        </div>

                                        <!-- /.card-body -->

                                        <!-- /.card -->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.content-wrapper -->
                    </section>
                </div>

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

                }
                ;

            </script>


            <script type="text/javascript">
                $(document).ready(function () {

                    $('#source_addition').on('submit', function (event) {
                        event.preventDefault();
                        $.ajax({
                            url: "../controller",
                            method: "GET",
                            data: $(this).serialize(),
                            //  dataType: "json",
                            beforeSend: function () {
                                $('#source_addition_button').attr('disabled', 'disabled');
                            },
                            success: function (data) {
                                $('#source_addition_button').attr('disabled', false);
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

                function productList() { 
                  //  alert("it works!");
// Call Web API to get a list of Product
                    $.ajax({
                        url: '../controller?getAllList=0',
                        type: 'GET',
                        dataType: 'json',
                        success: function (products) {
                             console.log(products);
                            productListSuccess(products);
                        },
                        error: function (request, message, error) {
                            //handleException(request, message, error);
                         alert(error+" : "+message);
                         console.log(message);
                        }
                    });
                };
                
                productList();
                
function productListSuccess(products) {
    // console.log(products);
  // Iterate over the collection of data
  $.each(products, function (index, product) {
    // Add a row to the Product table
   
    productAddRow(product);
  });
}


function productAddRow(product) {
    alert(product.prototype.URL);
 // Check if <tbody> tag exists, add one if not
  if ($("#productTable li").length == 0) {
   $("#productTable").append("<li></li>");
  }
  // Append row to <table>
  $("#productTable li").append(
    productBuildTableRow(product));
}


function productBuildTableRow(product) {
  var ret = "<span class=\"handle\"><i class=\"fas fa-ellipsis-v\"></i><i class=\"fas fa-ellipsis-v\"></i></span><div  class=\"icheck-primary d-inline ml-2\"></div><span class=\"text\">"+
          +product.url+"</span><small class=\"badge badge-danger\"><i class=\"fa fa-check\"></i></small><div class=\"tools\"><a href=\"#\" id=\"ss\"><i class=\"fas fa-edit\"></i><i class=\"fas fa-trash-o\"></i></a></div>";
    "<tr>" +
     "<td>" + product.ProductName + "</td>" +
     "<td>" + product.IntroductionDate + "</td>"
      + "<td>" + product.Url + "</td>" +
    "</tr>";
    
    //<span class="handle"><i class="fas fa-ellipsis-v"></i><i class="fas fa-ellipsis-v"></i></span><div  class="icheck-primary d-inline ml-2"></div><span class="text">Design a nice theme</span><small class="badge badge-danger"><i class="fa fa-check"></i></small><div class="tools"><a href="#" id="ss"><i class="fas fa-edit"></i><i class="fas fa-trash-o"></i></a></div>
  return ret;
}
            </script>


    </body>
</html>