package daos;
import java.util.Calendar;
import models.Apolice;
import models.Cobertura;
import models.Corretora;
import models.Segurado;
import models.Veiculo;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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

	public void update(String atributo, String valor, String id) throws SQLException {
		Statement statement = null;
		this.connect = ApoliceDAO.getConnection();
		statement = this.connect.createStatement();
		statement.executeUpdate("UPDATE Apolice SET "+ atributo + "= \""+ valor +"\" WHERE id=" + id);
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
				int segurado_FK = resultSet.getInt("Segurado_Fk");
				int Veiculo_FK = resultSet.getInt("Veiculo_FK");
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

				//int idSegurado = seguradoSet.getInt("id");
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

				Corretora tempCorretora = new Corretora("SegurosAuto", "12345", "corretora@corretora", "");
				Veiculo tempVeiculo = new Veiculo (cod_FIPE,marca, modelo, combustivel, portas, ano_fabricacao, numPassageiros, valorFipe);
				Segurado tempSegurado = new Segurado(nome, CPF, sexo, nacionalidade, profissao, telefone, endereco, email, data_nascimento);
				Cobertura tempCobertura = new Cobertura("Compreensivo" , valorFipe, Double.parseDouble(valorDeterminado), Double.parseDouble(danosMateriais), Double.parseDouble(danosCorporais));
				
				Apolice newApolice = new Apolice(idApolice,tempCorretora, tempVeiculo, tempSegurado, tempCobertura, data_inicio,data_fim,status,0.0);



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
	
	public int getLastId(String tabela, String[] param, String[] paramValues) throws SQLException{
        String parametros = "";
        String values = "";
        
        int id=0;
        
        try {
        	for(String s : param) {
        		parametros += s + ",";
        		values += "?,";
        	}
        	parametros = parametros.substring(0, parametros.length() - 1);
        	values = values.substring(0, values.length() - 1);
        	
        	this.connect = ApoliceDAO.getConnection();
            
            PreparedStatement ps=this.connect.prepareStatement("insert into " + tabela + " (" + parametros + ") values("+ values + ")",Statement.RETURN_GENERATED_KEYS);
            
            for (int i = 1; i <= paramValues.length; i ++) {
            	if(param[i-1].equals("data_Fim") || param[i-1].equals("data_Inicio")) {
            		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            		Date date = df.parse(paramValues[i - 1]);
            		ps.setDate(i, new java.sql.Date(date.getTime()));
            	}
            	else {
            		ps.setString(i, paramValues[i - 1]);
            	}
            	
            }
                      
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                id=rs.getInt(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
			if(this.connect != null){
				this.connect.close();
			}

		}
        
        return id;    
    }
	
	public void createApolice(Apolice a) throws SQLException{
		/*String [] veiculoParamNames = {"Valor_Fipev", "Ano_Fabricacao", "Numero_Passageiros", "Portas", "Combustivel", "Modelo", "Marca", "CODIGO_FIPE"};
		String [] veiculoParamValues = {Double.toString(a.getVeiculo().getValorFipe()) ,a.getVeiculo().getAnoFabricacao(),
				Integer.toString(a.getVeiculo().getNum_passageiros()), Integer.toString(a.getVeiculo().getPortas()) ,a.getVeiculo().getCombustivel(),
				a.getVeiculo().getModelo() ,a.getVeiculo().getMarca() ,a.getVeiculo().getCodigoFipe().toString()};
		this.getLastId("Veiculo", veiculoParamNames, veiculoParamValues);*/
		
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		String[] SeguradoParamNames = {"Telefone", "Email", "Endereco", "CNH", "Profissao", "Data_Nascimento", "Nacionalidade", "Sexo", "CPF", "Nome"};
		String[] SeguradoParamValues = {a.getSegurado().getTelefone(),a.getSegurado().getEmail(), a.getSegurado().getEndereco(), a.getSegurado().getCpf(), a.getSegurado().getProfissao(),
				s.format(a.getSegurado().getNascimento().getTime()), a.getSegurado().getNacionalidade(), a.getSegurado().getSexo(), a.getSegurado().getCpf(), a.getSegurado().getNome()};
		int Segurado_Fk = this.getLastId("Segurado", SeguradoParamNames, SeguradoParamValues);
		
		String[] corretoraParamNames = {"Telefone_Corretor", "Email_Corretor", "Corretor", "Email", "Telefone", "Nome"};
		String[] corretoraParamValues = {"12345678", "corretor@corretor", "Jao Silva", "jao@jao.com", "12345678", "MeuSeguro"};
		int Corretora_FK = this.getLastId("Corretora", corretoraParamNames, corretoraParamValues);
		
		String[] apoliceParamNames = {"Veiculo_FK", "franquiaAcessorios", "franquiaCasco", "danosCorporais", "danosMateriais", "valorDeterminado",
				"tipoCobertura", "Segurado_FK", "Corretora_FK", "status", "data_Fim", "data_Inicio"};
		
		String[] apoliceParamValues = {a.getVeiculo().getCodigoFipe(),Double.toString(a.getCobertura().getFranquiaAcessorios()),
				Double.toString(a.getCobertura().getFranquiaCasco()), Double.toString(a.getCobertura().getDanosCorporais()),
				Double.toString(a.getCobertura().getDanosMateriais()), Double.toString(a.getCobertura().getValorDeterminado()), a.getCobertura().getTipo(),
				Integer.toString(Segurado_Fk), Integer.toString(Corretora_FK), a.getStatus(), s.format(a.getFim().getTime()), s.format(a.getInicio().getTime())};
		
		int id_apolice = this.getLastId("Apolice", apoliceParamNames, apoliceParamValues);
		System.out.println("Novo Id da apolice = " + id_apolice);
	}


}
