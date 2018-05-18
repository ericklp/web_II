<%-- 
    Document   : mostrar
    Created on : Apr 20, 2018, 8:22:29 PM
    Author     : ericklopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ação efetuada com sucesso</h1>
        Dados: <br/>
        <c:forEach items="${dados}" var="x">
            ${x}<br/>
        </c:forEach>
    </body>
</html>
