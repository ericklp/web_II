<%-- 
    Document   : atendimentoListar
    Created on : May 2, 2018, 10:52:54 PM
    Author     : ericklopes
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="beans.Atendimento"%>
<%@page import="java.util.List"%>
<%@page import="beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>Listar Produtos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/clienteListar.css">
        <link rel="stylesheet" type="text/css" href="css/ionicons.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.js"></script>
        <script src="js/clientesListar.js"></script>

    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-primary">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link" href="ProdutoServlet">Cadastro de  Produtos</a></li>
                    <li class="nav-item"><a class="nav-link" href="AtendimentoServlet">Atendimentos</a></li>
                </ul>
            </div>
            <div class="navbar-collapse collapse w-100 order-2 dual-collapse2">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" href="LoginServlet?action=logout">Sair</a></li>
                </ul>
            </div>
        </nav>
                    
        <a class="btn btn-outline-success" href="ProdutoServlet?action=formNew">Novo</a>
        <table class="table table-striped"><tr><th>Descrição Produto</th><th></th><th></th><th></th></tr>

        <c:forEach items="${produtos}" var="produto">
            <tr>
                <td><c:out value="${produto.nome}"/></td>
                <td><a href="ProdutoServlet?action=show&id=<c:out value="${produto.id}"/>" class="btn btn-outline-success">Visualizar</a></td>
                <td><a href="ProdutoServlet?action=formUpdate&id=<c:out value="${produto.id}"/>" class="btn btn-outline-success">Alterar</a></td>
                <td><a href="ProdutoServlet?action=remove&id=<c:out value="${produto.id}"/>" class="btn btn-outline-success">Deletar</a></td>
            </tr>
        </c:forEach>

        </table>
       
        
        <footer>
            <p class="small font-weight-light">Em caso de problemas contactar o administrador: <strong><c:out value="${configuracao.email}" /></strong></p>  
        </footer>
    </body>
</html>
