<%-- 
    Document   : mostrar
    Created on : May 18, 2018, 7:52:23 PM
    Author     : ericklopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head><title>JSP Page</title></head>
    <body>
        <h1>Status: ${status}</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>E-mail</th>
            <th>Data</th>
        </tr>
        <tr>
            <td>${pessoa.id}</td>
            <td>${pessoa.nome}</td>
            <td>${pessoa.email}</td>
        <td>
            <fmt:formatDate value="${pessoa.data}" pattern="dd/MM/yyyy" />
        </td>
        </tr>
        </table>
    </body>
</html>
