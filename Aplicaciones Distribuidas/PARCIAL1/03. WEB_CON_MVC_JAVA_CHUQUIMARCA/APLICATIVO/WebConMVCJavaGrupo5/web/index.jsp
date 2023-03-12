<%-- 
    Document   : index
    Created on : Oct 31, 2022, 5:44:40 PM
    Author     : santi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Web Sin MVC Java Chuquimarca</title>
    </head>
    <body>
        <h1>Bienvenido a la encuesta para desarrolladores</h1>
        <p>Indica los lenguajes de programación con los que estes familiarizados</p>
        <form action="ServletController" method="post">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Nombre </td>
                        <td><input type="text" name="txtNombre" value="" required/></td>
                    </tr>
                    <tr>
                        <td>Apellido </td>
                        <td><input type="text" name="txtApellido" value="" required/></td>
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
                        <th><input type="file" name="imgProfile" value="" width="250" accept=".jpg, .jpeg, .png"/></th>
                        <td><input type="submit" name="btnEnviar" value="Enviar" /></td>
                    </tr>
                </tbody>
            </table>
        </form>

    </body>
</html>
