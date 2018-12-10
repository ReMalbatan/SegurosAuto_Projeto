<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="models.Apolice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Relatórios - SeguroAuto</title>
</head>
<body>
	<nav class=" navbar navbar-dark bg-dark navbar-expand-lg">
		<a class="navbar-brand" href="#">Seguros-Auto</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="OrcamentoController">Fazer Orçamento</a></li>
				<li class="nav-item"><a class="nav-link disabled"
					href="ApoliceController">Listar Apólices</a></li>
				<li class="nav-item"><a class="nav-link disabled"
					href="RelatorioController">Gerar Relatorio</a></li>
			</ul>
		</div>
	</nav>

	<div class="container p-4">
		<div class="row">
			<div class="col-sm">
				<div class="text-center">
					<h5>Apólices vendidas no último mes</h5>
					<form action="${pageContext.request.contextPath}/RelatorioController" method="post">
					<button class="btn btn-primary btn-sm float-right"
						name="filtro" value="filtro-mes" type="submit">Gerar</button>
					</form>
				</div>
			</div>
			<div class="col-sm">
				<div class="text-center">
					<h5>Apólice por status</h5>
					<form action="${pageContext.request.contextPath}/RelatorioController" method="post">
					<select class="form-control" name="status">
						<option value="Ativo">Ativa</option>
						<option value="Inativa">Inativa</option>
						<option value="Aguardando Aprovacao">Aguardando aprovação</option>
					</select> <br>
					<button class="btn btn-primary btn-sm" name="filtro"
						value="filtro-status" type="submit">Gerar</button>
					</form>
				</div>
			</div>
			<div class="col-sm">
				<div class="text-center">
					<h5>Apólices por vendedor</h5>
					<form action="${pageContext.request.contextPath}/RelatorioController" method="post">
						<label>Vendedor</label> <input class="form-control" type="text"
							name="vendedor"><br> Data de início<br> <input
							class="form-control" type="date" name="dataInicio"><br>
						<br> Data de término<br> <input class="form-control"
							type="date" name="dataFim"><br> <br>
						<button class="btn btn-primary btn-sm float-right" name="filtro"
							value="filtro-vendedor" type="submit">Gerar</button>
					</form>

				</div>
			</div>
		</div>
	</div>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nº Apolice</th>
				<th>Nome Segurado</th>
				<th>Data de início</th>
				<th>Data de término</th>
				<th>Valor do prêmio</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<Apolice> apolices = (ArrayList<Apolice>) request.getAttribute("lista");
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				if (apolices != null) {
					for (Apolice a : apolices) {
						out.print("<tr>");
						out.print("<td>" + a.getId() + "</td>");
						out.print("<td>" + a.getSegurado().getNome() + "</td>");
						out.print("<td>" + df.format(a.getInicio().getTime()) + "</td>");
						out.print("<td>" + df.format(a.getFim().getTime()) + "</td>");
						out.print("<td>" + a.getCobertura().getPremioTotal() + "</td>");
						out.print("<td>" + a.getStatus() + "</td>");
						out.print("<td> <a href=\"ApoliceController?id=" + a.getId()
								+ "\" class=\"btn btn-primary float-right\">Detalhes</a></td>");
						out.print("</tr>");

					}
				}
			%>
		</tbody>
	</table>





	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>