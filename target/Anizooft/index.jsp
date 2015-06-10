<%-- 
    Document   : genericpage
    Created on : 26-09-2014, 03:36:09 PM
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
                    <h1 class="page-header"><i class="fa fa-dashboard fa-1x"></i> Inicio</h1>
                </div>
            </div>

            <div class="row">
                <table align="center">
                    <tr><td>
                        <img width="600px" height="376px" src="<c:url value='http://veterinarialaruca.cl/contenedor/cursos-para-ser-veterinario1.jpg'/>">
                    </td></tr>
                    <tr>
                        <td>
                            --
                        </td>
                    </tr>
                </table>
            </div>
        </jsp:body>
</t:template>
