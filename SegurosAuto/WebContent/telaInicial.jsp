<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Homepage | Seguros-Auto</title>
</head>
<body>
 <nav class=" navbar navbar-dark bg-dark navbar-expand-lg mb-3">
        <a class="navbar-brand" href="#">Seguros-Auto</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="OrcamentoController">Fazer Or�amento</a>
                </li>
                <li class="nav-item" onclick="loginError()">
                    <a class="nav-link disabled" href="#">Listar Ap�lices</a>
                </li>
                <li class="nav-item" onclick="loginError()">
                    <a class="nav-link disabled" href="#">Gerar Relatorio</a>
                </li>
            </ul>
        </div>

		<script>
			function loginError() {
				alert("Por favor, fa�a o login primeiro.");
			}
		</script>
		<form class="form-inline" action="${pageContext.request.contextPath}/InicioController" method="post">
            <input class="form-control mr-sm-2" type="text" name="login" placeholder="Login">
            <input class="form-control mr-sm-2" type="password" name="senha" placeholder="Senha">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log In</button>
        </form>
    </nav>
    <br>
    <div class="row">
            <div class="col-sm">
            </div>
            <div class="col-sm">
                
                    <h1>Bem vindo ao site!</h1>
		</div>
                <div class="col-sm">
                    
                    </div>
            
    </div>
    


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