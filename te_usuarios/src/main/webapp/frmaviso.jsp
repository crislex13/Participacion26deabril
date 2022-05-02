<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Usuario"%>
<%
    Usuario aviso = (Usuario) request.getAttribute("aviso");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo registro</h1>
        <form action="UsuarioController" method="post">
            <input type="hidden" name="id" value="${aviso.id}" />
            <table>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="${aviso.nombre}" /></td>
                </tr>
                <tr>
                    <td>Correo</td>
                    <td>
                        <textarea name="correo">${aviso.correo}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>Clave</td>
                    <td>
                        <textarea name="clave">${aviso.clave}</textarea>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
