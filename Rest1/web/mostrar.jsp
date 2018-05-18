<%-- 
    Document   : mostrar
    Created on : May 18, 2018, 7:52:23 PM
    Author     : ericklopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Dados</h1>
        <table>
            <tr>
                <th>Nome</th>
                <th>E-mail</th>
            </tr>
            <tr>
                <td>${pessoa.nome}</td>
                <td>${pessoa.email}</td>
            </tr>
        </table>
    </body>
</html>
