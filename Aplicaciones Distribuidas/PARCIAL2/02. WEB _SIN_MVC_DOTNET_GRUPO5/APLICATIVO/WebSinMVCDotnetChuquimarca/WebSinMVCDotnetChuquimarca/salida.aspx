<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="salida.aspx.cs" Inherits="WebSinMVCDotnetChuquimarca.salida" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Final Encuesta</title>
</head>
<body>
    <h1>Gracias por cubrir nuestra encuesta</h1>
    <img src="resources/<%=Request.Form["imgProfile"]%>" width="200" height="200" alt="Archivo no seleccionado" />
    <%
        string str = Request.Form["txtNombre"] + " " + Request.Form["txtApellido"];
        string mode = Request.Form["chkProgleng"];
        if (mode != null)
        {
            str += ", nos has indicado que estas familiarizado con los siguientes lenguajes:";
        }
    %>
    <p><%=str %></p>
    <ul>
        <%
            try
            {
                string[] lengSelect = mode.Split(',');
                if (lengSelect != null)
                {
                    foreach (string s in lengSelect)
                    {
        %>
        <li><%=s%></li>
        <%
                    }
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        %>
    </ul>

</body>
</html>
