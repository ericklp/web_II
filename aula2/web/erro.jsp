<%-- 
    Document   : errojsp
    Created on : Apr 6, 2018, 9:18:43 PM
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
        <%
            String msg = (String)pageContext.getSession().getAttribute("msg");
            String pagina = (String)pageContext.getSession().getAttribute("page");
            
            if(msg==null || msg.isEmpty()){
                msg="Erro no servidor";
            }
                
            if(pagina==null || pagina.isEmpty()){
                pagina="index.html";
            }
        %>
        
        <h1><%=msg%></h1>
    </body>
</html>
