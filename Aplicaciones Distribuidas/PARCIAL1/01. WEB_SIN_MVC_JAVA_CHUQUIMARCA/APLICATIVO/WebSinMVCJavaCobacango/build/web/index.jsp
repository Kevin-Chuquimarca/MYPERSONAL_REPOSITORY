<%-- 
    Document   : index.jsp
    Created on : 31 oct. 2022, 17:51:48
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Web Sin MVC Java Cobacango</title>
    </head>
    <body>
        <h1>LENGUAJES DE PROGRAMACIÓN</h1>
        <p>Indica los lenguajes de programación con los que Ud. esta famailiarizado</p>
        <form action="salida.jsp">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Nombres</td>
                        <td><input type="text" name="txtNombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos</td>
                        <td><input type="text" name="txtApellido" value="" /></td>
                    </tr>
                    <tr>
                        <td>Java</td>
                        <td><input type="checkbox" name="chkProgLeng" value="Java" /></td>
                    </tr>
                    <tr>
                        <td>PHP</td>
                        <td><input type="checkbox" name="chkProgLeng" value="PHP" /></td>
                    </tr>
                    <tr>
                        <td>Ruby</td>
                        <td><input type="checkbox" name="chkProgLeng" value="Ruby" /></td>
                    </tr>
                    <tr>
                        <td>Python</td>
                        <td><input type="checkbox" name="chkProgLeng" value="Python" /></td>
                    </tr>
                    <tr>
                        <td><input type="file" name="imgProgramador" value="" width="250"></td>
                        <td><input type="submit" value="Enviar" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
