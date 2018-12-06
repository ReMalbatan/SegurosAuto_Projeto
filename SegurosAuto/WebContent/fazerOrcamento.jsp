<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="models.Veiculo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="daos.ApoliceDAO"%>

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
<title>Novo orçamento</title>
</head>
<body>
        <nav class=" navbar navbar-dark bg-dark navbar-expand-lg">
            <a class="navbar-brand" href="#">Novo Orçamento</a>
        </nav><br> 
		<form action="${pageContext.request.contextPath}/OrcamentoController" method="post" >
		<%
		Veiculo veiculoSelecionado = (Veiculo) request.getAttribute("veiculoSelecionado");
		ArrayList <Veiculo> veiculos = (ArrayList<Veiculo>) request.getAttribute("listaVeiculos");
		Veiculo tempVeiculo = new Veiculo ("123","ABC", "modelo", "combustivel", 5, "1997", 3, 40000.00);
		veiculos.add(tempVeiculo);
		 %>
        <div class="row">
            <!-- Formulário Veículo -->
            <div class="col-sm">
                    <div class="card">

					<div class="card-header">Dados do Veículo</div>
					<label>Codigo Fipe</label>
					<div class="row">
					
					<div class="col-9">
						<select name="fipeId">
							<%
								for (Veiculo v : veiculos) {
									String selected = (veiculoSelecionado != null
											&& veiculoSelecionado.getCodigoFipe().equals(v.getCodigoFipe())) ? " selected " : " ";
									out.print("<option" + selected + "value=\"" + v.getCodigoFipe() + "\">" + v.getCodigoFipe() + " - "
											+ v.getModelo() + " / " + v.getMarca() + "</option>");
								}
							%>
						</select>
					</div>
					<div class="col-3">
						<button class="btn btn-primary btn-sm float-right" type="submit"
							name="button" value="buscar">Buscar Carro</button>
					</div>
					</div>




					Marca<br>
                            <input class="form-control" type="text" name="marca" value="<%= (veiculoSelecionado == null )? "" : veiculoSelecionado.getMarca() %>"><br>
                            Modelo<br>
                            <input class="form-control" type="text" name="modelo" value="<%= (veiculoSelecionado == null )? "" : veiculoSelecionado.getModelo() %>"><br>
                            Combustível<br>
                            <input class="form-control" type="text" name="combustivel" value="<%= (veiculoSelecionado == null )? "" : veiculoSelecionado.getCombustivel() %>"><br>
                            Portas<br>
                            <input  class="form-control" type="text" name="portas" value="<%= (veiculoSelecionado == null )? "" : veiculoSelecionado.getPortas() %>"><br>    
                            Ano de Fabricação<br>
                            <input  class="form-control" type="text" name="fabricacao" value="<%= (veiculoSelecionado == null )? "" : veiculoSelecionado.getAnoFabricacao() %>"><br>
                            Número de Passageiros<br>
                            <input  class="form-control" type="text" name="nPassageiros" value="<%= (veiculoSelecionado == null )? "" : veiculoSelecionado.getNum_passageiros() %>"><br>

                         
                    </div>
                </div>
            <!-- Formulário Segurado -->
            <div class="col-sm">
                <div class="card">
                    <div class="card-header">Dados do Segurado</div>
                    
                        Nome<br>
                        <input class="form-control" type="text" name="nome"><br>
                        CPF<br>
                        <input class="form-control" type="text" name="cpf"><br>
                        
                        <p>Sexo</p>
    					<p><input type="radio" name="genero" value="masculino"> Masculino</p>
   						<p><input type="radio" name="genero" value="feminino"> Feminino</p>
   						
                        Nacionalidade<br>
                        <input class="form-control" type="text" name="nacionalidade"><br>
                        Profissão<br>
                        <input class="form-control" type="text" name="profissao"><br>
                        Telefone<br>
                        <input class="form-control" type="text" name="telefone"><br>
                        Endereço<br>
                        <input class="form-control" type="text" name="endereco"><br>
                        Email<br>
                        <input class="form-control" type="text" name="email"><br><br>
                        Data de Nascimento<br>
                        <input class="form-control" type="date" name="nascimento"><br><br>
                </div>
            </div>
            <div class="col-sm">
                <div class="card">                      
                	<div class="card-header">Coberturas</div>
                        Tipo de Cobertura<br>
           	 			<input type="text" class="form-control col-6 p-2" name="tipoCobertura" value="Compreensivo">
                        
                        Valor de mercado (FIPE)<br>
                        <input  class="form-control" type="text" name=valorMercado value="<%= (veiculoSelecionado == null )? "" : veiculoSelecionado.getValorFipe() %>"><br><br>
                        
                        Valor determinado<br>
                        <input class="form-control" type="text" name=valorDeterminado><br><br>
                        
                        Danos materiais<br>
                        <input class="form-control" type="text" name=danosMateriais value="100000.00">
                        
                        Danos corporais<br>
                        <input class="form-control" type="text" name=danosCorporais value="100000.00"><br><br>
                        
                        Franquia Casco<br>
                        <p><input type="radio" name="franquiaCasco" value="majorada"> Majorada</p>
   						<p><input type="radio" name="franquiaCasco" value="obrigatoria"> Obrigatória</p>
   						<p><input type="radio" name="franquiaCasco" value="reduzida"> Reduzida</p>
                		
                		Franquia acessórios<br>
                        <input class="form-control" type="text" name=franquiaAcessorios value="0.0">               		
                </div>
                <div class="mt-2">
                	<a href="InicioController"  class="btn btn-primary btn-sm"> Voltar ao Início</a>
        			<button  class="btn btn-primary btn-sm float-right" name="button" value="orcar" type="submit">Gerar Orçamento</button>
                </div>
            </div>
        </div>
       
        
		 </form> 
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>