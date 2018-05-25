<%-- 
    Document   : clientesVisualizar
    Created on : 07/04/2018, 21:45:00
    Author     : ericklopes
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>Detalhes Atendimento</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/clientesVisualizar.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.js"></script>
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
        <div class="container">
        <h1>Visualizar Atendimento</h1>
            <div class="form-row">
            <div class="form-group col-md-5">
            <label for="nome">Nome Cliente:</label><input class="form-control" type="text" name="nome" maxlength="100" value="${visualizaratendimento.cliente.nome}" disabled/><br/>
            </div>
            <div class="form-group col-md-5">
            <label for="produto">Produto:</label><input class="form-control" type="text" name="produto" maxlength="100" value="${visualizaratendimento.produto.nome}" disabled/><br/>
            </div>
            </div>
            <div class="form-row">
            <div class="form-group col-md-5">
            <label for="descricao">Descrição:</label><input class="form-control" type="text" name="descricao" maxlength="255" value="${visualizaratendimento.descricao}" disabled/><br/>
            </div>
            <div class="form-group col-md-5">
            <label for="tipo">Tipo Atendimento:</label><input class="form-control" type="text" name="tipo" maxlength="50" value="${visualizaratendimento.tipo_atendimento.nome}" disabled/><br/>
            </div>
            <!--
            <div class="form-group col-md-2">
            <label for="data">Data Nascimento:</label><input class="form-control" type="date" name="data" value="${visualizaratendimento.data}" disabled/><br/>
            </div> -->
            </div>
            <div class="form-row">
            <div class="form-group col-md-5">
            <label for="data">Data Atendimento:</label><input class="form-control" type="datetime" name="data" value="${visualizaratendimento.data}" disabled/><br/>
            </div>
            <div class="form-group col-md-5">
            <label for="res">Status:</label><input class="form-control" type="text" name="res" maxlength="12" value="<c:out value="${(visualizaratendimento.res_atendimento == \"Y\") ? \"Resolvido\" : \"Não Resolvido\"}"/>" disabled/><br/>
            </div>
            </div>
            <a class="btn btn-outline-danger" href="AtendimentoServlet">Cancelar</a>
        </div>
    </body>
</html>
