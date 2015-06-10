<%@tag description="basepage" body-content="scriptless" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="headContent" fragment="true" required="true"  %> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Veterinaria  - ANIZOOFT</title>

    <link href="<c:url value='http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/bootstrap/dist/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/metisMenu/dist/metisMenu.min.css' />" rel="stylesheet">
    <link href="<c:url value='http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/dist/css/timeline.css' />" rel="stylesheet">
    <link href="<c:url value='http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/dist/css/sb-admin-2.css' />" rel="stylesheet">
    <link href="<c:url value='http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/morrisjs/morris.css' />" rel="stylesheet">
    <link href="<c:url value='http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/font-awesome/css/font-awesome.min.css' />" rel="stylesheet" type="text/css">
    
       
    <script src="<c:url value='http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/jquery/dist/jquery.min.js'/>"></script>
    <script src="<c:url value='http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/metisMenu/dist/metisMenu.min.js'/>"></script>
    <script src="<c:url value='http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/bower_components/raphael/raphael-min.js'/>"></script>
    <script src="<c:url value='http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/dist/js/sb-admin-2.js'/>"></script>
    <script src="<c:url value='/resources/js/bootstrap-datepicker.js'/>"></script>
    <script src="<c:url value='/resources/js/jquery.dataTables.js'/>"></script>
    <script src="<c:url value='/resources/js/dataTables.bootstrap.js'/>"></script>
    <script src="<c:url value='/resources/js/validarut.js'/>"></script>
    <link href="<c:url value='/resources/css/bootstrap-datepicker.css' />" rel="stylesheet">
    
    <script type="text/javascript">
    $(document).ready(function() {
        //Limpia formulario
        $("#limpiarForm").click(function(){
            //Borra cuadros de texto
            $(".panel-body").find(":input")
                    .not("[readonly]")
                    .not($( ".script-calendario" ))
                    .val("");
            
            //Resetea comboBox
            $(".panel-body").find("select").each(function(){
                var curr = $(this);
                curr.val($(this).find("option:first").val());
            });
            
            //Setea fechas de las busquedas
            if ( $(".panel-body").find(".script-calendario").length > 1 ){
                var d = new Date();
                var month = d.getMonth() +1;
                var day = d.getDate();
                var dayAnt = d.getDate()-1;
                $(".panel-body").find(".script-calendario").first().val(((''+dayAnt).length<2 ? '0' : '') + dayAnt +"/"+ ((''+month).length<2 ? '0' : '') + month +"/"+ d.getFullYear());
                $(".panel-body").find(".script-calendario").last().val(((''+day).length<2 ? '0' : '') + day +"/"+ ((''+month).length<2 ? '0' : '') + month +"/"+ d.getFullYear());
            }
            $(".panel-body").find(".script-calendario").each(function(){
                var curr = $(this);
                
                curr.val();
                
                return false;
            });
        });
        
        //Validar solo numeros            
        $('.script-valida-numero').on("keyup, blur, focus",function (){
            this.value = (this.value + '').replace(/[^0-9]/g, '');
        });
        
        //Iniciador de calendarios
        $(".script-calendario").each(function(){
            var current = $(this);
            current.datepicker({
                format: 'dd/mm/yyyy',
                autoclose :true
            });
            
            current.next().click(function(){
                current.focus();
            });
        });
        
        //Valida campo rut
        $(".script-rut").blur(function(){
            var current = $(this);
            var bRutValido = Rut(current);
            if(!bRutValido)
                current.parent().toggleClass("has-error", true).toggleClass("has-success", false);
            else
                current.parent().toggleClass("has-error", false).toggleClass("has-success", true);
        });
        
        //Asigna colores si error en campos obligatorios.
        $(".script-obligatorio").each(function(){
            var current = $(this);
            if($.trim(current.val()) == "" ){
                current.val("");
                current.parent().toggleClass("has-error", true);
            }else{
                current.parent().toggleClass("has-success", true);
            }

            current.blur(function(){
                if($.trim(current.val()) == ""){
                    current.val("");
                    current.parent().toggleClass("has-error", true).toggleClass("has-success", false);
                }else{
                    current.parent().toggleClass("has-error", false).toggleClass("has-success", true);
                }
            });
        });
        
        //Inicia tablas
        $('#dataTables-example').dataTable({
            language: {
                search:         "Buscar en la tabla: ",
                lengthMenu:     "Mostrar _MENU_ registros",
                info:           "Mostrando  _START_ a _END_ de _TOTAL_ elementos",
                infoEmpty:      "Mostrando 0 a 0 de 0 elementos",
                infoFiltered:   "(filtrado de _MAX_ elementos totales)",
                infoPostFix:    "",
                loadingRecords: "Cargando...",
                zeroRecords:    "No hay elementos",
                emptyTable:     "No se encontraron elementos",
                paginate: {
                    first:      "Primera",
                    previous:   "Anterior",
                    next:       "Siguiente",
                    last:       "Ultima"
                }
            }
        });
    });
    
    /* SECCCION FUNCIONES GENERALES*/
    function confirma(){
        var bAlert = false;
        $(".script-obligatorio").each(function(){
            var current = $(this);
            if  (current.parent().hasClass("has-error"))
                bAlert = true;
        });
        if (bAlert){
            alert("Los campos marcados con rojo son obligatorios.");
            return false;
        }
        return true;
        //$('#convenio').submit();
    }
    
    
    
    function FormatoHora(evt,str) { 
        var nav4 = window.Event ? true : false; 
        var key = nav4 ? evt.which : evt.keyCode; 
        hora=str.value ;

        if(hora.length===0){ 
            return ((key >= 48 && key <= 50)); 
        } 
        if(hora.length===1){ 
            if(hora.charAt(0)===2) 
            {
                return ((key >= 48 && key <= 51));	
            }else{
                return ((key >= 48 && key <= 57));
            } 
        } 
        if(hora.length===2) 
        { 
            return ((key === 58)); 
        } 
        if(hora.length===3) 
        { 
            return ((key >= 48 && key <= 53)); 
        } 
        if(hora.length===4) 
        { 
            return ((key >= 48 && key <= 57)); 
        } 
        if(hora.length>4) 
        { 
            return false; 
        } 
    } 
    
    function soloNumeros(e){
	var key = window.Event ? e.which : e.keyCode
	return (key >= 48 && key <= 57)
    }
    
    
    </script>
</head>

<body>
    
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div id="pageheader">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<spring:url value='/Home/Index' htmlEscape='true' />">ANIZOOFT</a>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="<spring:url value='/Security/logout' htmlEscape='true' />"><i class="fa fa-sign-out fa-fw"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
              
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                        </li>
                        <li>
                            <a class="active" href="<spring:url value='/' htmlEscape='true'/>"><i class="fa fa-dashboard fa-fw"></i> Inicio</a>
                        </li>
                        <li>
                            <a class="active" href="<spring:url value='/Dueno/Index' htmlEscape='true'/>"><i class="fa fa-edit fa-fw"></i> Dueño</a>
                        </li>
                        <li>
                            <a class="active" href="<spring:url value='/Mascota/Index' htmlEscape='true'/>"><i class="fa fa-edit fa-fw"></i> Mascota</a>
                        </li>
                        <li>
                            <a class="active" href="<spring:url value='/FichaAtencion/Index' htmlEscape='true'/>"><i class="fa fa-edit fa-fw"></i> Ficha de Atención</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
                                    
        

    
        <div id="page-wrapper">
            <div id="body">
                
                <jsp:invoke fragment="headContent" /> 

                <jsp:doBody />

           </div>
        </div>
    </div>
                
</body>

</html>