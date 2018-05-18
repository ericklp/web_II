<%-- 
    Document   : index.jsp
    Created on : Apr 20, 2018, 8:17:45 PM
    Author     : ericklopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index.jsp</title>
    </head>
    <body>
        <form action="Controladora" method="POST" >
            Nome: <input type="text" name="nome" /><br/>
            E-mail: <input type="text" name="email" /><br/>
            <input type="submit" value="Salvar" />
            <input type="reset" value="Limpar" />
        </form>
    </body>
</html>
