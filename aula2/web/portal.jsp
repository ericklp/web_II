<%-- 
    Document   : portal
    Created on : Apr 6, 2018, 8:20:22 PM
    Author     : ericklopes
--%>

<%@page import="beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <%
                LoginBean loginbean = (LoginBean)pageContext.getSession().getAttribute("login");
                if(loginbean.getNome()==null || loginbean.getNome().isEmpty()) {
                    request.setAttribute("msg", "Usuário não logado!");
                    request.setAttribute("page", "index.html");
                    
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                else {
            %>
                    <jsp:useBean id="login" class="beans.LoginBean" scope="session" />
                    <h1>Nome: <jsp:getProperty name="login" property="nome" /></h1>
                    <a href="LogoutServlet">LogoutServlet</a>   
            <% }%>



    </body>
</html>
