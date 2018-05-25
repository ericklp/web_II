 <%-- 
    Document   : clientesAlterar
    Created on : 07/04/2018, 18:55:04
    Author     : ericklopes
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="beans.Atendimento"%>
<%@page import="beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <title>Efetuar Atendimento</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/clientesAlterar.css">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="js/jquery.mask.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
        <script src="js/clientesForm.js" type="text/javascript"></script>
    </head>
    <body>
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
            <fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${alterarcliente.data}" var="data" />
            <%--<fmt:parseDate value="${alterarcliente.data}" var="data" pattern = "dd/MM/yyyy" />--%>
            <h1>Efetuar Atendimento</h1>
            <form action="AtendimentoServlet?action=new" method="POST">
                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label for="nome">Cliente</label>
                        <select id="nome" name="nome" class="custom-select" required>
                        <c:forEach items="${clientes}" var="cliente">
                            <option value="<c:out value="${cliente.id}"/>"><c:out value="${cliente.nome}"/> - <c:out value="${cliente.cpf}"/></option>
                        </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-5">
                        <label for="produto">Produto</label>
                        <select id="produto" name="produto" class="custom-select" required>
                        <c:forEach items="${produtos}" var="produto">
                            <option value="<c:out value="${produto.id}"/>"><c:out value="${produto.nome}"/></option>
                        </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-5">
                        <label for="tipo">Tipo Atendimento</label>
                        <select id="tipo" name="tipo" class="custom-select" required>
                        <c:forEach items="${tipos}" var="tipo">
                            <option value="<c:out value="${tipo.id}"/>"><c:out value="${tipo.nome}"/></option>
                        </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="data">Data</label>
                        <input class="form-control data" id="datepicker" type="text" name="data" value="" data-default="14:20:00" required/><br/>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="timepicker">Hora</label>
                        <input type="text" id="timepicker" name="time" class="timepicker"/>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-10">
                        <label for="desc">Descrição</label>
                        <input class="form-control" type="text" name="desc" maxlength="255" value="" required/><br/>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-10">
                        <label for="res">Concluído:</label>
                        <input id="res" name="res" type="checkbox" value="1">
                    </div>
                </div>
                    
                <input class="btn btn-outline-success" type="submit" value="Salvar"/>
                <a class="btn btn-outline-danger" href="AtendimentoServlet">Cancelar</a>
            </form>
        </div>
    </body>
</html>
