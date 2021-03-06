<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Anizooft</title>

    <!-- Bootstrap Core CSS -->
    <link href="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
     <link href="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Anizooft</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Ficha de usuario</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Opciones</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Salir</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Buscar...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        

                        <li>
                            <a href="../"><i class="fa fa-edit fa-fw"></i> Volver</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Informe de mascota(s)</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        B�squeda
                    </div>
                    <div class="panel-body">
                        <form method="post" action="/Anizooft/Informe/Mascota">
                            <div class="row">
                                <div class="col-md-4 col-sm-4">
                                    <div class="form-group">
                                        <label>Mascota</label>
                                        <select name="idMascota" class="form-control">
                                            <option value="">(Todas)</option>
                                            <c:if  test="${!empty mascotaList}">
                                                <c:forEach items="${mascotaList}" var="mascota">
                                                    <option value="${mascota.idmascota}">(${mascota.due�o.rutdue�o}) / (${mascota.idmascota}) ${mascota.nombre}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                        <label>Due�o</label>
                                        <select name="idDue�o" class="form-control">
                                            <option value="">(Todos)</option>
                                            <c:if  test="${!empty due�oList}">
                                                <c:forEach items="${due�oList}" var="due�o">
                                                    <option value="${due�o.rutdue�o}">(${due�o.rutdue�o}) ${due�o.nombre} ${due�o.apellido} </option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                        <label>Empleado</label>
                                        <select name="idEmpleado" class="form-control">
                                            <option value="">(Todos)</option>
                                            <c:if  test="${!empty empleadoList}">
                                                <c:forEach items="${empleadoList}" var="empleado">
                                                    <option value="${empleado.rutempleado}">(${empleado.rutempleado}) ${empleado.nombre} ${empleado.apellido} </option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </div>
                                                                        
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 col-sm-4">
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary" onclick="document.getElementById('exportaExcel').value='N';">Buscar</button>
<!--                                         <button id="limpiarForm" onclick="return false;" class="btn btn-primary">Limpiar</button> -->
<!--                                         <button class="btn btn-success" onclick="document.getElementById('exportaExcel').value='S';">Excel</button> -->
                                    	<input type="hidden" name="exportaExcel" id='exportaExcel' value="N"/>
                                    </div>
<!--                                 </div> -->
<!--                                 <div class="col-md-2 col-sm-2 pull-right"> -->
<!--                                         <label>Buscar los primeros</label> -->
<!--                                     <select class="form-control" name="cantReg"> -->
<!--                                         <option value="100">100</option> -->
<!--                                         <option value="500">500</option> -->
<!--                                         <option value="1000">1000</option> -->
<!--                                         <option value="mas de 1000">m�s de 1000</option> -->
<!--                                     </select> -->
<!--                                 </div> -->
                            	</div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
            
            
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Resultado
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Due�o</th>
                                            <th>Mascota</th>
                                            <th>Empleado</th>
                                            <th>Cantidad Atenciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${informeList}" var="informe">
                                            <tr class="odd gradeX">
	                                            <td>(${informe.rutdue�o}) ${informe.nombredue�o} ${informe.apellidodue�o}</td>
	                                            <td>(${informe.idmascota}) ${informe.nombremascota} ${informe.razamascota}</td>
	                                            <td>(${informe.rutempleado}) ${informe.nombreempleado} ${informe.apellidoempleado}</td>
	                                            <td>${informe.atenciones}</td>
                                        	</tr>
                                         </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>

</body>

</html>
