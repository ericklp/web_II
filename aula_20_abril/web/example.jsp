<%-- 
    Document   : example
    Created on : Apr 20, 2018, 7:44:19 PM
    Author     : ericklopes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(10);
            arr.add(20);
            arr.add(30);
            for (Integer i: arr)
                out.println("<h2>"+i+"</h2>");
        %>
        <h1>${sessionScope}</h1> 
    </body>
</html>
