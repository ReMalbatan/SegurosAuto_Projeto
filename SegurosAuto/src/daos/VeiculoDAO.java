package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import models.Apolice;
import models.Segurado;
import models.Veiculo;

public class VeiculoDAO {
	private Connection connect;

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

	public VeiculoDAO(){

	}
	public ArrayList<Veiculo> getAll() throws SQLException{
		Statement statement = null;
		ArrayList<Veiculo> temp = new ArrayList<Veiculo>();
		this.connect = ApoliceDAO.getConnection();
		try{
			statement = this.connect.createStatement();
			ResultSet veiculoSet = statement.executeQuery("SELECT * FROM Veiculo");
			while( veiculoSet.next()) {
				String marca = veiculoSet.getString("Marca");
				String cod_FIPE = (new Integer(veiculoSet.getInt("codigo_FIPE"))).toString();
				String modelo = veiculoSet.getString("Modelo");
				String combustivel = veiculoSet.getString("Combustivel");
				int portas = veiculoSet.getInt("Portas");
				int numPassageiros = veiculoSet.getInt("Numero_Passageiros");
				String ano_fabricacao = veiculoSet.getString("Ano_fabricacao");
				double valorFipe = veiculoSet.getDouble("Valor_Fipev");

				Veiculo newVeiculo = new Veiculo(cod_FIPE, marca, modelo, combustivel, portas, ano_fabricacao, numPassageiros, valorFipe);
				temp.add(newVeiculo);
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
	
	public Veiculo getById(int id) throws SQLException{
		Statement statement = null;
		Veiculo tempVeiculo = null;
		this.connect = ApoliceDAO.getConnection();
		try{
			statement = this.connect.createStatement();
			String getVeiculo = "SELECT * " + 
					"FROM Veiculo v " + 
					"WHERE v.CODIGO_FIPE = " + id;
			ResultSet veiculoSet = statement.executeQuery(getVeiculo);
			veiculoSet.next();
			
			String marca = veiculoSet.getString("Marca");
			String cod_FIPE = (new Integer(veiculoSet.getInt("codigo_FIPE"))).toString();
			String modelo = veiculoSet.getString("Modelo");
			String combustivel = veiculoSet.getString("Combustivel");
			int portas = veiculoSet.getInt("Portas");
			int numPassageiros = veiculoSet.getInt("Numero_Passageiros");
			String ano_fabricacao = veiculoSet.getString("Ano_fabricacao");
			double valorFipe = veiculoSet.getDouble("Valor_Fipev");		
			tempVeiculo = new Veiculo (cod_FIPE,marca, modelo, combustivel, portas, ano_fabricacao, numPassageiros, valorFipe);
		
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
		return tempVeiculo;
	}
}
