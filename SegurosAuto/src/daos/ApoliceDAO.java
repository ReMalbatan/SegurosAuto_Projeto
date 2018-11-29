package daos;
import java.util.Calendar;
import models.Apolice;
import models.Cobertura;
import models.Corretora;
import models.Segurado;
import models.Veiculo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import  java.sql.Connection;

public class ApoliceDAO {
	private Connection connect;
	Random gerador = new Random();
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try{
			System.out.println("\n\nConectando...\n\n");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("\n\nConectou\n\n");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g2", "t1g2", "$wS!hMY%");
			System.out.println("\n\nConectou\n\n");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch( SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public ApoliceDAO(){
	}
	
	public static Calendar toCalendar(Date date){ 
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
		  return cal;
	}
	
	public void generate(Apolice apol) throws SQLException{
		Statement statement = null;
		this.connect = ApoliceDAO.getConnection();
		try{
			statement = this.connect.createStatement();
			String insertStatement = "INSERT INTO Apolice VALUES ("+
			apol.getInicio()+","+
			apol.getFim()+","+
			apol.getStatus()+","+
			apol.getCorretora()+","+
			apol.getSegurado()+","+
			apol.getCobertura().getTipo()+","+
			apol.getCobertura().getValorDeterminado()+","+
			apol.getCobertura().getDanosMateriais()+","+
			apol.getCobertura().getDanosCorporais()+","+
			apol.getCobertura().getFranquiaCasco()+","+
			apol.getCobertura().getFranquiaAcessorios()+","+
			apol.getVeiculo()+
			")";
			statement.executeQuery(insertStatement);	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if (statement != null){
				statement.close();
			}
			if(this.connect != null){
				this.connect.close();
			}
		}
	}
	
	public ArrayList<Apolice> getAll() throws SQLException{
		Statement statement = null;
		ArrayList<Apolice> temp = new ArrayList<Apolice>();
		this.connect = ApoliceDAO.getConnection();
		try{
			statement = this.connect.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Apolice");
			
			while (resultSet.next()){
				int idApolice = resultSet.getInt("id");
				Calendar data_inicio = ApoliceDAO.toCalendar(resultSet.getDate("data_Inicio"));
				Calendar data_fim = ApoliceDAO.toCalendar(resultSet.getDate("data_Fim"));
				String status = resultSet.getString("status");
				int corretora_FK = resultSet.getInt("Corretora_FK");
				int segurado_FK = resultSet.getInt("Segurado_Fk") + gerador.nextInt(30);
				int Veiculo_FK = resultSet.getInt("Veiculo_FK") + gerador.nextInt(40);
				String tipoCobertura = resultSet.getString("tipoCobertura");
				String valorDeterminado = resultSet.getString("valorDeterminado");
				String danosMateriais =  resultSet.getString("danosMateriais");
				String danosCorporais = resultSet.getString("danosCorporais") ;
				String franquiaCasco = resultSet.getString("franquiaCasco");
				String franquiaAcessorios = resultSet.getString("franquiaAcessorios");
				
				
				String getVeiculo = "SELECT * " + 
						"FROM Veiculo v " + 
						"WHERE v.CODIGO_FIPE = " + Veiculo_FK;
				Statement statement1 = this.connect.createStatement();
				ResultSet veiculoSet = statement1.executeQuery(getVeiculo);
				veiculoSet.next();
				
				String marca = veiculoSet.getString("Marca");
				String cod_FIPE = (new Integer(veiculoSet.getInt("codigo_FIPE"))).toString();
				String modelo = veiculoSet.getString("Modelo");
				String combustivel = veiculoSet.getString("Combustivel");
				int portas = veiculoSet.getInt("Portas");
				int numPassageiros = veiculoSet.getInt("Numero_Passageiros");
				String ano_fabricacao = veiculoSet.getString("Ano_fabricacao");
				double valorFipe = veiculoSet.getDouble("Valor_Fipev");
				
				String getSegurado = "SELECT * " + 
						"FROM Segurado s " + 
						"WHERE s.id = " + (new Integer(segurado_FK).toString());
				Statement statement2 = this.connect.createStatement();
				ResultSet seguradoSet = statement2.executeQuery(getSegurado);
				seguradoSet.next();
				
				int idSegurado = seguradoSet.getInt("id");
				String nome = seguradoSet.getString("Nome");
				String CPF = seguradoSet.getString("CPF");
				String sexo = seguradoSet.getString("Sexo");
				String nacionalidade = seguradoSet.getString("Nacionalidade");
				Calendar data_nascimento = toCalendar(seguradoSet.getDate("Data_Nascimento"));
				String profissao = seguradoSet.getString("Profissao");
				String cnh = seguradoSet.getString("CNH");
				String endereco = seguradoSet.getString("Endereco");
				String email = seguradoSet.getString("Email");
				String telefone = seguradoSet.getString("Telefone");
				
				String getCorretora = "SELECT * " + 
						"FROM Corretora c " + 
						"WHERE c.id = " + (new Integer(corretora_FK).toString());
				
				Apolice newApolice = new Apolice(idApolice, new Corretora("SegurosAuto", "12345", "corretora@corretora", ""),
						new Veiculo (cod_FIPE,marca, modelo, combustivel, portas, ano_fabricacao, numPassageiros, valorFipe), new Segurado(nome, CPF, sexo, nacionalidade, profissao, telefone, endereco, email, data_nascimento), 
						new Cobertura("Compreensivo" , valorFipe, Double.parseDouble(valorDeterminado), Double.parseDouble(danosMateriais), Double.parseDouble(danosCorporais), Double.parseDouble(franquiaCasco), Double.parseDouble(franquiaAcessorios)),
						data_inicio, data_fim, status);
				
				temp.add(newApolice);
				
				
				
				/*String veiculo = resultSet.getString("veiculo");
				String segurado = resultSet.getString("segurado");
				String franquia = resultSet.getString("franquia");
				
				Date inicio_temp = resultSet.getDate("inicio");
				Calendar inicio = Calendar.getInstance();
				inicio.setTime(inicio_temp);
				
				Date fim_temp = resultSet.getDate("fim");
				Calendar fim = Calendar.getInstance();
				fim.setTime(fim_temp);
				
				String status = resultSet.getString("status");*/
				
				/*
				Apolice novaApolice = new Apolice(corretora, veiculo, segurado, franquia, inicio, fim, status);
				novaApolice.setId(resultSet.getInt("id"));
				temp.add(novaApolice);*/
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if (statement != null){
				statement.close();
			}
			
			if(this.connect != null){
				this.connect.close();
			}
			
		}
		return temp;
	}
	
	
}
