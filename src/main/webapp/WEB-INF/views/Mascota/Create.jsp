<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
                            <a href="../Mascota/Index"><i class="fa fa-reply-all fa-fw"></i> Volver</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Inscribir Mascota</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Inscribir Mascota
                        </div>
                        <form:form action="/Anizooft/Mascota/Create" modelAttribute="mascota" method="post">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                       <div class="form-group">
                                           <label>Dueños</label>
                                           <select name="rutDueno" class="form-control script-obligatorio">
                                                <option label="(Seleccione)" value="" selected>Seleccione...</option>
		                                           <c:if  test="${!empty duenos}">
		                                                <c:forEach items="${duenos}" var="cur">
		                                                   <option value="${cur.rutdueño}">${cur.rutdueño} - ${cur.nombre} ${cur.apellido}</option>
		                                                </c:forEach>
		                                           </c:if>
		                                   </select>
                                       </div>
										<div class="form-group">
                                           <label>Nombre</label>
                                           <form:input path="nombre" class="form-control script-obligatorio" />
                                           
                                       </div>
                                       <div class="form-group">
                                       <div class="col-lg-4">
                                           <label>Año nacimiento</label>
                                           <select name="ano" class="form-control">
                                               <option selected>2000</option>
                                               <option>2001</option>
                                               <option>2002</option>
                                               <option>2003</option>
                                               <option>2004</option>
                                               <option>2005</option>
                                               <option>2006</option>
                                               <option>2007</option>
                                               <option>2008</option>
                                               <option>2009</option>
                                               <option>2010</option>
                                               <option>2011</option>
                                               <option>2012</option>
                                               <option>2013</option>
                                               <option>2014</option>
                                               <option>2015</option>
                                               <option>2016</option>
                                           </select>
                                       </div>
                                       </div>
                                       <div class="col-lg-4">
                                       <div class="form-group">
                                           <label>Mes nacimiento</label>
                                           <select name="mes" class="form-control">
                                               <option value="1" selected>Enero</option>
                                               <option value="2">Febrero</option>
                                               <option value="3">Marzo</option>
                                               <option value="4">Abril</option>
                                               <option value="5">Mayo</option>
                                               <option value="6">Junio</option>
                                               <option value="7">Julio</option>
                                               <option value="8">Agosto</option>
                                               <option value="9">Septiembre</option>
                                               <option value="10">Octubre</option>
                                               <option value="11">Noviembre</option>
                                               <option value="12">Diciembre</option>
                                           </select>
                                       </div>
                                       </div>
                                       <div class="col-lg-4">
                                       <div class="form-group">
                                           <label>Día nacimiento</label>
                                           <select name="dia" class="form-control">
                                               <option value="" selected>seleccione</option>
                                               <option value="1" selected>01</option>
                                               <option value="2">02</option>
                                               <option value="3">03</option>
                                               <option value="4">04</option>
                                               <option value="5">05</option>
                                               <option value="6">06</option>
                                               <option value="7">07</option>
                                               <option value="8">08</option>
                                               <option value="9">09</option>
                                               <option value="10">10</option>
                                               <option value="11">11</option>
                                               <option value="12">12</option>
                                               <option value="13">13</option>
                                               <option value="14">14</option>
                                               <option value="15">15</option>
                                               <option value="16">16</option>
                                               <option value="17">17</option>
                                               <option value="18">18</option>
                                               <option value="19">19</option>
                                               <option value="20">20</option>
                                               <option value="21">21</option>
                                               <option value="22">22</option>
                                               <option value="23">23</option>
                                               <option value="24">24</option>
                                               <option value="25">25</option>
                                               <option value="26">26</option>
                                               <option value="27">27</option>
                                               <option value="28">28</option>
                                               <option value="29">29</option>
                                               <option value="30">30</option>
                                               <option value="31">31</option>
                                           </select>
                                       </div>
                                       </div>
                                       <div class="form-group">
                                           <label>Especie</label>
                                           <form:input path="especie" class="form-control" />
                                           
                                       </div>
                                       <div class="form-group">
                                           <label>Raza</label>
                                           <form:input path="raza" class="form-control" />
                                           
                                       </div>
                                       <div class="form-group">
                                           <label>Género</label>
                                           <form:select path="genero" class="form-control">
	                                            <form:option value="M">Masculino</form:option>
	                                            <form:option value="F">Femenino</form:option>
	                                        </form:select>
                                       </div>
                                       <div class="form-group">
                                           <label>Peso</label>
                                           <form:input path="peso" class="form-control script-obligatorio" />
                                       </div>
                                      
                                       <button type="reset" id="limpiarForm" class="btn btn-default">Cancelar</button>
                                       <button type="submit"  onclick="return confirma();" class="btn btn-default">Guardar</button>
                                    
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        </form:form>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
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

    <!-- Custom Theme JavaScript -->
    <script src="http://ironsummitmedia.github.io/startbootstrap-sb-admin-2/dist/js/sb-admin-2.js"></script>

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
       
    });        
    
    
    
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
    //
// Validador de Rut
// Descargado desde http://www.juque.cl/
//
var oRut = $("#rutEmpresa");
function revisarDigito( dvr )
{	
	dv = dvr + ""	
	if ( dv != '0' && dv != '1' && dv != '2' && dv != '3' && dv != '4' && dv != '5' && dv != '6' && dv != '7' && dv != '8' && dv != '9' && dv != 'k'  && dv != 'K')	
	{		
		alert("Debe ingresar un digito verificador correcto");		
		oRut.focus();		
		oRut.select();			
                oRut.val("");	
		return false;	
	}	
	return true;
}

function revisarDigito2( crut )
{	
	largo = crut.length;	
	if ( largo < 2 )	
	{		
		alert("Debe ingresar el rut completo1")		
		//oRut.focus();		
		//oRut.select();		
                oRut.val("");
		return false;	
	}	
	if ( largo > 2 )		
		rut = crut.substring(0, largo - 1);	
	else		
		rut = crut.charAt(0);	
	dv = crut.charAt(largo-1);	
	revisarDigito( dv );	

	if ( rut == null || dv == null )
		return 0	

	var dvr = '0'	
	suma = 0	
	mul  = 2	

	for (i= rut.length -1 ; i >= 0; i--)	
	{	
		suma = suma + rut.charAt(i) * mul		
		if (mul == 7)			
			mul = 2		
		else    			
			mul++	
	}	
	res = suma % 11	
	if (res==1)		
		dvr = 'k'	
	else if (res==0)		
		dvr = '0'	
	else	
	{		
		dvi = 11-res		
		dvr = dvi + ""	
	}
	if ( dvr != dv.toLowerCase() )	
	{		
		alert("El rut es incorrecto")		
		oRut.focus();		
		oRut.select();			
                oRut.val("");	
		return false	
	}

	return true
}

function Rut(current){
        oRut = current;
	var texto = current.val();
        if (texto == "") return false;
        
	var tmpstr = "";	
	for ( i=0; i < texto.length ; i++ )		
		if ( texto.charAt(i) != ' ' && texto.charAt(i) != '.' && texto.charAt(i) != '-' )
			tmpstr = tmpstr + texto.charAt(i);	
	texto = tmpstr;	
	largo = texto.length;	
        
	if ( largo < 2 )	
	{	
		alert("Debe ingresar el rut completo");	
		oRut.focus();		
		oRut.select();			
                oRut.val("");	
		return false;	
	}	

	for (i=0; i < largo ; i++ )	
	{			
            if ( texto.charAt(i) !="0" && texto.charAt(i) != "1" && texto.charAt(i) !="2" && texto.charAt(i) != "3" && texto.charAt(i) != "4" && texto.charAt(i) !="5" && texto.charAt(i) != "6" && texto.charAt(i) != "7" && texto.charAt(i) !="8" && texto.charAt(i) != "9" && texto.charAt(i) !="k" && texto.charAt(i) != "K" )
            {			
                alert("El valor ingresado no corresponde a un R.U.T correcto");			
                oRut.focus();			
                oRut.select();		
                oRut.val("");			
                return false;		
            }	
	}	

	var invertido = "";	
	for ( i=(largo-1),j=0; i>=0; i--,j++ )		
		invertido = invertido + texto.charAt(i);	
	var dtexto = "";	
	dtexto = dtexto + invertido.charAt(0);	
	dtexto = dtexto + '-';	
	cnt = 0;	

	for ( i=1,j=2; i<largo; i++,j++ )	
	{		
            //alert("i=[" + i + "] j=[" + j +"]" );		
            if ( cnt == 3 )		
            {			
                dtexto = dtexto + '.';			
                j++;			
                dtexto = dtexto + invertido.charAt(i);			
                cnt = 1;		
            }		
            else		
            {				
                dtexto = dtexto + invertido.charAt(i);			
                cnt++;		
            }	
	}	

	invertido = "";	
	for ( i=(dtexto.length-1),j=0; i>=0; i--,j++ )		
		invertido = invertido + dtexto.charAt(i);	
        
        var regExp = /\./g;
        var rutFormateado = invertido.toUpperCase().replace(regExp,'');
        
	oRut.val(rutFormateado);		

	if ( revisarDigito2(texto) )		
            return true;	

	return false;
}
    
  </script>



</body>

</html>
