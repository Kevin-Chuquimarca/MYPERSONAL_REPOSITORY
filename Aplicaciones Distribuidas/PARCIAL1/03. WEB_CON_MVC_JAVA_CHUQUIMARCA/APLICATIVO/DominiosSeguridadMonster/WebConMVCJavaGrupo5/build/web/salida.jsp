<%-- 
    Document   : salida
    Created on : Oct 31, 2022, 5:57:09 PM
    Author     : Grupo5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="datosEncuesta" scope="application" class="ec.edu.monster.modelo.DatosEncuesta" />
        <h2>Gracias por llenar la encuesta</h2>
        <p><jsp:getProperty name="datosEncuesta" property="txtNombre" /> <jsp:getProperty name="datosEncuesta" property="txtApellido" /> , has respondido que estas familiarizado con los siguientes lenguajes de programación:</p>
        <img src="resources/<jsp:getProperty name="datosEncuesta" property="imgProfile" />" width="200" height="200" alt="Archivo no seleccionado"/>
        <%--<jsp:getProperty name="datosEncuesta" property="chkProgLeng" />--%>
        <%String[] lenguajesSeleccionados = request.getParameterValues("chkProgLeng");%>
        <ul>
            <%
                if (lenguajesSeleccionados != null) {
                    for (int i = 0; i < lenguajesSeleccionados.length; i++) {
            %>
            <li>
                <%=lenguajesSeleccionados[i]%>
            </li>
            <%
                    }
                }
            %>
        </ul>
    </body>
</html>
