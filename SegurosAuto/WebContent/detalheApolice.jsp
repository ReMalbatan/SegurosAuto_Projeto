<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="models.Apolice"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<!DOCTYPE html>
<html>
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
<% Apolice a = (Apolice) request.getAttribute("apolice");
DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); %>
    <nav class="navbar navbar-dark bg-dark navbar-expand-lg">
        <a class="navbar-brand text-white">Apólice nº <%=a.getId() %></a>
    </nav>

    <div class="container mt-3">
        <div class="row">
            <div class="col-sm">
                <h3> Dados da apólice</h3>
            </div>
            <div class="col-6">
            </div>
            <div class="col-sm">
            </div>
        </div>
    </div>

    <form>
        <div class="form-group pl-3">
            <label for="idApolice">Nº</label>
            <input readonly type="text" class="form-control col-6 p-2" id="idApolice" value= <%=a.getId()%>>
        </div>

        <div class="form-group pl-3">
            <label for="inicio">Início</label>
            <input readonly type="text" class="form-control col-6 p-2" id="inicio" value=<%=df.format(a.getInicio().getTime())%>>
        </div>

        <div class="form-group pl-3">
            <label for="termino">Término</label>
            <input readonly type="text" class="form-control col-6 p-2" id="termino" value=<%=df.format(a.getFim().getTime())%>>
        </div>
    </form>

    <div class="container mt-3">
        <div class="row">
            <div class="col-sm">
                <h3> Status da apólice</h3>
            </div>
            <div class="col-6">
            </div>
            <div class="col-sm">
            </div>
        </div>
    </div>
	<!-- Radio button status 
    <form class="p-2">
        <div class="form-check">
            <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1"
                checked>
            <label class="form-check-label ml-3" for="exampleRadios1">
                Válida
            </label>
        </div>
        <div class="form-check mt-1">
            <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
            <label class="form-check-label ml-3" for="exampleRadios2">
                Inválida
            </label>
        </div>
    </form>
    -->
    <form>
        <div class="form-group pl-3">
            <label for="Nome">Status Apolice</label>
            <input type="text" class="form-control col-6 p-2" id="status" value= <%= a.getStatus() %>>
        </div>
   </form>


    <div class="container mt-3">
        <div class="row">
            <div class="col-sm">
                <h3> Dados do segurado</h3>
            </div>
            <div class="col-6">
            </div>
            <div class="col-sm">
            </div>
        </div>
    </div>

    <form>
        <div class="form-group pl-3">
            <label for="Nome">Nome</label>
            <input readonly type="text" class="form-control col-6 p-2" id="Nome" value="<%=a.getSegurado().getNome() %>">
        </div>

        <div class="form-group pl-3">
            <label for="Nome">CPF</label>
            <input readonly type="text" class="form-control col-6 p-2" id="Nome" value=<%=a.getSegurado().getCpf() %>>
        </div>

        <div class="form-group pl-3">
            <label for="Nome">Nacionalidade</label>
            <input readonly type="text" class="form-control col-6 p-2" id="Nome" value=<%=a.getSegurado().getNacionalidade() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Profissao</label>
            <input readonly type="text" class="form-control col-6 p-2" id="Nome" value=<%=a.getSegurado().getProfissao() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Telefone</label>
            <input readonly type="text" class="form-control col-6 p-2" id="Nome" value=<%=a.getSegurado().getTelefone() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Endereço</label>
            <input readonly type="text" class="form-control col-6 p-2" name="endereco" value="<%=a.getSegurado().getEndereco() %>">
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Email</label>
            <input readonly type="text" class="form-control col-6 p-2" id="Nome" value=<%=a.getSegurado().getEmail() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Nascimento</label>
            <input readonly type="text" class="form-control col-6 p-2" id="Nome" value=<%=df.format(a.getSegurado().getNascimento().getTime()) %>>
        </div>
    </form>

    <div class="container mt-4">
        <div class="row">
            <div class="col-sm">
                <h3> Dados do Veículo</h3>
            </div>
            <div class="col-6">
            </div>
            <div class="col-sm">
            </div>
        </div>
    </div>

    <form>
        <div class="form-group pl-3">
            <label for="Fipe">Código FIPE</label>
            <input readonly type="text" class="form-control col-6 p-2" id="fipeId" value=<%=a.getVeiculo().getCodigoFipe() %>>
        </div>

        <div class="form-group pl-3">
            <label for="Nome">Marca</label>
            <input readonly type="text" class="form-control col-6 p-2" id="marca" value=<%=a.getVeiculo().getMarca() %>>
        </div>

        <div class="form-group pl-3">
            <label for="Nome">Modelo</label>
            <input readonly type="text" class="form-control col-6 p-2" id="modelo" value=<%=a.getVeiculo().getModelo() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Combustível</label>
            <input readonly type="text" class="form-control col-6 p-2" id="combustivel" value=<%=a.getVeiculo().getCombustivel() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Portas</label>
            <input readonly type="text" class="form-control col-6 p-2" id="portas" value=<%=a.getVeiculo().getPortas() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Ano de Fabricação</label>
            <input readonly type="text" class="form-control col-6 p-2" id="anoFabricacao" value=<%=a.getVeiculo().getAnoFabricacao() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Nº de passageiros</label>
            <input readonly type="text" class="form-control col-6 p-2" id="nPassageiros" value=<%=a.getVeiculo().getNum_passageiros() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Renavam</label>
            <input readonly type="text" class="form-control col-6 p-2" id="renavam" value=<%=a.getVeiculo().getRenavam() %>>
        </div>
    </form>

    <div class="container mt-4">
        <div class="row">
            <div class="col-sm">
                <h3> Dados da Cobertura</h3>
            </div>
            <div class="col-6">
            </div>
            <div class="col-sm">
            </div>
        </div>
    </div>

    <form>
        <div class="form-group pl-3">
            <label for="Fipe">Tipo de franquia</label>
            <input readonly type="text" class="form-control col-6 p-2" id="fipeId" value=<%=a.getCobertura().getTipo() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Valor Coberto</label>
            <input readonly type="text" class="form-control col-6 p-2" id="valorDeterminado" value=<%=a.getCobertura().getValorDeterminado() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Danos Materiais</label>
            <input readonly type="text" class="form-control col-6 p-2" id="valorDeterminado" value=<%=a.getCobertura().getDanosMateriais() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Danos Corporais</label>
            <input readonly type="text" class="form-control col-6 p-2" id="valorDeterminado" value=<%=a.getCobertura().getDanosCorporais() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Franquia Casco</label>
            <input readonly type="text" class="form-control col-6 p-2" id="valorDeterminado" value=<%=a.getCobertura().getFranquiaCasco() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Nome">Franquia Acessorios</label>
            <input readonly type="text" class="form-control col-6 p-2" id="valorDeterminado" value=<%=a.getCobertura().getFranquiaAcessorios() %>>
        </div>
    </form>

    <div class="container mt-4">
        <div class="row">
            <div class="col-sm">
                <h3> Dados da corretora</h3>
            </div>
            <div class="col-6">
            </div>
            <div class="col-sm">
            </div>
        </div>
    </div>

    <form>
        <div class="form-group pl-3">
            <label for="Fipe">Corretora</label>
            <input readonly type="text" class="form-control col-6 p-2" id="fipeId" value=<%=a.getCorretora().getNome()%>>
        </div>

        <div class="form-group pl-3">
            <label for="Nome">Telefone</label>
            <input readonly type="text" class="form-control col-6 p-2" id="marca" value=<%=a.getCorretora().getTelefone() %>>
        </div>
        <div class="form-group pl-3">
            <label for="Fipe">Email</label>
            <input readonly type="text" class="form-control col-6 p-2" id="fipeId" value=<%=a.getCorretora().getEmail() %>>
        </div>

        <div class="form-group pl-3">
            <label for="Nome">Corretor responsável</label>
            <input readonly type="text" class="form-control col-6 p-2" id="marca" value=<%=a.getCorretora().getCorretor() %>>
        </div>
    </form>
    <div class="col-6">
        <a href="IncioController" class="btn btn-secondary btn-lg float-left">Cancelar</a>

        <button type="button" class="btn btn-primary btn-lg float-right">Salvar</button>

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