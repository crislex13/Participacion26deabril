<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Usuario"%>
<%
    List<Usuario> avisos = (List<Usuario>)request.getAttribute("avisos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>
        <p><a href="UsuarioController?action=add">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Clave</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${avisos}">
              <tr>
                <td>${item.id}</td>
                <td>${item.nombre}</td>
                <td>${item.correo}</td>
                <td>${item.clave}</td>
                <td><a href="UsuarioController?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="UsuarioController?action=delete&id=${item.id}">Eliminar</a></td>
            </tr>              
            </c:forEach>
        </table>
    </body>
</html>