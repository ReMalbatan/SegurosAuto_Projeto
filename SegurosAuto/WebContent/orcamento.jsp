<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="models.*"%>
<%@page import="daos.ApoliceDAO"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
    
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous"> 
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		Cobertura cobert = (Cobertura) request.getAttribute("Cobertura");
%>
<div class="containter">
        <nav class=" navbar navbar-dark bg-dark navbar-expand-lg">
            <a class="navbar-brand" href="#">Orçamento do Seguro</a>
        </nav><br> 
        <div class="card">
            <table  class="table">
                <tr>
                    <th>Prêmio</th>
                    <th>Valor</th> 
                </tr>
                <tr>
                    <td>Casco</td>
                    <td>R$<%=String.format("%.2f",cobert.getPremioCasco()) %></td>
                </tr>
                <tr>
                    <td>Acessórios</td>
                    <td>R$<%=String.format("%.2f",cobert.getPremioAcessorios()) %></td>
                </tr>
                <tr>
                    <td>Danos Materiais</td>
                    <td>R$<%=String.format("%.2f",cobert.getPremioDanosMateriais()) %></td>
                </tr>
                <tr>
                    <td>Danos Corporais</td>
                    <td>R$<%=String.format("%.2f",cobert.getPremioDanosCorporais()) %></td>
                </tr>
                <tr>
                    <td>Prêmio Líquido</td>
                    <td>R$<%=String.format("%.2f",cobert.getPremioTotal()/1.0738) %></td>
                </tr>
                <tr>
                    <td>IOF</td>
                    <td>R$<%=String.format("%.2f",(cobert.getPremioTotal() - cobert.getPremioTotal()/1.0738))%></td>
                </tr>
                <tr>
                    <td>Premio Total</td>
                    <td>R$<%=String.format("%.2f",(cobert.getPremioTotal()))%></td>

                </tr>
            </table>
            <br>
        <div>
         <form action="${pageContext.request.contextPath}/OrcamentoController" method="post">
            <button class="btn btn-primary">Voltar Formulários</button>  
            <button class="btn btn-primary"> Cancelar</button>
            <button  class="btn btn-primary btn-sm float-right" name="button" value="comprar" type="submit">Comprar Seguro</button>
        </form>
        </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>