<%-- 
    Document   : salida
    Created on : 31 oct. 2022, 17:57:32
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Gracias por llenar la encuesta</h2>

        <p>
            <%= request.getParameter("txtNombre") + " " + request.getParameter("txtApellido")%>, 
            has respondido que estas familiarizado con los siguientes lenguajes de programación:
        </p>
        <ul>
            <%
                String[] lenguajesSeleccionados = request.getParameterValues("chkProgLeng");
                if (lenguajesSeleccionados != null) {
                    for (int i = 0; i < lenguajesSeleccionados.length; i++) {
            %>
            <li>
                <%= lenguajesSeleccionados[i]%>
            </li>
            <%}
            } else {
            %>
            <script>
                alert("Falta de información");
               window.location.href = "index.jsp";
            </script>
            <%
                }
            %>
            <%
                String fileName = (String) request.getParameter("imgProgramador");
                if (fileName != null) {
            %><br>
            <img src="resources/<%=fileName%>"width="250">
            <%
                }
            %>
        </ul>

    </body>
</html>
