<%-- 
    Document   : newjsp
    Created on : Mar 2, 2018, 7:20:49 PM
    Author     : ericklopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Título</title>
    </head>
    <body>
        <b>Página HTML</b><br/>
        <h1><% out.println("Hello World!");%></h1>
        <h2><%
            for (int i=0; i<10; i++){
                out.println("Valor = " + i);
            }
            %>
        </h2>
    </body>
</html>
