<%-- 
    Document   : Index
    Created on : 10-09-2014, 05:24:28 PM
    Author     : pmzuniga
--%>

<%@taglib tagdir="/WEB-INF/tags" prefix="t"  %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<t:template>
    <jsp:attribute name="headContent">  

    </jsp:attribute>  

    <jsp:body> 

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><i class="fa fa-bell fa-fw"></i> Error</h1>
        </div>
    </div>
            
    
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Mensaje
                </div>
                <div class="panel-body">
                    <div class="alert alert-danger">
                        ${mensaje} 
                    </div>
                    <c:choose>
                        <c:when test="${urlRetorno != null}">
                            <button onclick="location.href='${urlRetorno}'" class="btn btn-primary">Volver</button>
                            <!--<a href="#" class="alert-link" href="${urlRetorno}">Volver</a>.-->
                        </c:when>
                        <c:otherwise>
                            <button type="button" onclick="javascript:history.go(-1)" class="btn btn-primary">Volver</button>
                            <!--<a href="#" class="alert-link" onclick="javascript:history.go(-1)" >Volver</a>.-->
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
 
    </jsp:body>
</t:template>                   
              





