<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="models.Apolice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <nav class=" navbar navbar-dark bg-dark navbar-expand-lg">
        <a class="navbar-brand" href="#">Lista de Apólices</a>


        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
    
     <%
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    ArrayList <Apolice> apolices = (ArrayList<Apolice>) request.getAttribute("lista");
    for (Apolice a : apolices){
    	out.print("<div class=\"col-sm-5\"> " +
    	"<div class=\"card mt-5\">" + 
    		"<div class=\"card-header\">  Apolice nº: "+ a.getId() + "</div>" +
    		"<div class=\"card-body\"> <h5 class=\"card-title\">Segurado: " + a.getSegurado().getNome() + "</h5>" +
    		"<p class=\"card-text\"> Período:" + df.format(a.getInicio().getTime()) + " até " + df.format(a.getFim().getTime()) + "</p> " + 
    		"<p class=\"card-text\"> Status: " + a.getStatus() + "</p> " +
    		"<a href=\"#\" class=\"btn btn-primary float-left\">Editar</a>" +
    		"<a href=\"ApoliceController?id=" + a.getId() +"\" class=\"btn btn-primary float-right\">Detalhes</a>" +
    		"</div>" +
    		"</div> </div>"
    	);
    }
    %>
        
    <br>
    <button class="btn btn-primary"> Voltar ao Início</button>
    <!-- Optional JavaScript -->
     <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
   
</body>
</html>