<%-- 
    Document   : clientesVisualizar
    Created on : 07/04/2018, 21:45:00
    Author     : ericklopes
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>Cliente Visualizar</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/clientesVisualizar.css">
        <link rel="stylesheet" type="text/css" href="css/portal.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.js"></script>
    </head>
    <body>
        <%@ page errorPage="erro.jsp" %>
        <c:if test="${empty sessionScope.usuario}">
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema." />
            </jsp:forward>
        </c:if>
        <nav class="navbar navbar-expand-md navbar-dark bg-primary">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link" href="ClientesServlet">Cadastro de  Clientes</a></li>
                    <li class="nav-item"><a class="nav-link" href="AtendimentoServlet">Atendimentos</a></li>
                </ul>
            </div>
            <div class="navbar-collapse collapse w-100 order-2 dual-collapse2">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><p class="nav-link active">Nome: <c:out value="${usuario.nome}"/></p></li>
                    <li class="nav-item"><a class="nav-link" href="LoginServlet?action=logout">Sair</a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
        <h1>Visualizar Cliente</h1>
            <div class="form-row">
            <div class="form-group col-md-10">
            <label for="nome">Nome:</label><input class="form-control" type="text" name="nome" maxlength="100" value="${visualizarcliente.nome}" disabled/><br/>
            </div>
            <div class="form-group col-md-2">
            <label for="cpf">CPF:</label><input class="form-control" type="text" name="cpf" maxlength="11" value="${visualizarcliente.cpf}" disabled/><br/>
            </div>
            </div>
            <div class="form-row">
            <div class="form-group col-md-10">
            <label for="email">E-mail:</label><input class="form-control" type="email" name="email" maxlength="100" value="${visualizarcliente.email}" disabled/><br/>
            </div>
            <div class="form-group col-md-2">
            <label for="data">Data Nascimento:</label><input class="form-control" type="date" name="data" value="${visualizarcliente.data}" disabled/><br/>
            </div>
            </div>
            <div class="form-row">
            <div class="form-group col-md-2">
            <label for="cep">CEP:</label><input class="form-control" type="text" name="cep" maxlength="8" value="${visualizarcliente.cep}" disabled/><br/>
            </div>
            <div class="form-group col-md-10">
            <label for="rua">Rua:</label><input class="form-control" type="text" name="rua" maxlength="100" value="${visualizarcliente.rua}" disabled/><br/>
            </div>
            </div>
            <div class="form-row">
            <div class="form-group col-md-2">
            <label for="numero">Número:</label><input class="form-control" type="number" name="numero" value="${visualizarcliente.numero}" disabled/><br/>
            </div>
            <div class="form-group col-md-9">  
            <label for="cidade">Cidade:</label><input class="form-control" type="text" name="cidade" maxlength="100" value="${visualizarcliente.cidade.nome}" disabled/><br/>
            </div>
            <div class="form-group col-md-1">
            <label for="uf">UF:</label><input class="form-control" type="text" name="uf" maxlength="2" value="${visualizarcliente.cidade.estado.sigla}" disabled/><br/>
            </div>
            </div>
            <a class="btn btn-outline-danger" href="ClientesServlet">Cancelar</a>
        </div>
    </body>
            <footer>
            <p class="small font-weight-light">Em caso de problemas contactar o administrador: <strong><c:out value="${configuracao.email}" /></strong></p>  
        </footer>
</html>
