<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="index.aspx.cs" Inherits="WebSinMVCDotnetChuquimarca.index" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Encuesta para Desarrolladores</title>
</head>
<body>
    <h1>Bienvenido a la encuesta para desarrolladores</h1>
    <p>Indique los lenguajes de programación con los que está familiarizado</p>

    <form id="form1" action="salida.aspx" method="post">

        <table border="1">
            <tr>
                <td>Nombre</td>
                <td>
                    <input type="text" name="txtNombre" value="" required=""/></td>
            </tr>
            <tr>
                <td>Apellido</td>
                <td>
                    <input type="text" name="txtApellido" value="" required=""/></td>
            </tr>
            <tr>
                <td>Java</td>
                <td>
                    <input type="checkbox" name="chkProgleng" value="Java" /></td>
            </tr>
            <tr>
                <td>PHP</td>
                <td>
                    <input type="checkbox" name="chkProgLeng" value="PHP" /></td>
            </tr>
            <tr>
                <td>Phyton</td>
                <td>
                    <input type="checkbox" name="chkProgLeng" value="Phyton" /></td>
            </tr>
            <tr>
                <td>C++</td>
                <td>
                    <input type="checkbox" name="chkProgLeng" value="C++" /></td>
            </tr>
            <tr>
                <td>
                    <input type="file" name="imgProfile" value="" width="250" accept=".jpg, .jpeg, .png" /></td>
                <td>
                    <input type="submit" name="btnButton" value="Enviar" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
