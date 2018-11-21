package daos;
import models.Apolice;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import  java.sql.Connection;

public class ApoliceDAO {
	private Connection connect;
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try{
			Class.forName("org.mysql.jdbc.Drive");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g2", "t1g2", "$wS!hMY%");
			
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
	
	public ArrayList<Apolice> getAll() throws SQLException{
		Statement statement = null;
		ArrayList<Apolice> temp = new ArrayList<Apolice>();
		this.connect = ApoliceDAO.getConnection();
		try{
			statement = this.connect.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM apolice");
			
			while (resultSet.next()){
				String corretora = resultSet.getString("corretora");
				String veiculo = resultSet.getString("veiculo");
				String segurado = resultSet.getString("segurado");
				String franquia = resultSet.getString("franquia");
				
				Date inicio_temp = resultSet.getDate("inicio");
				Calendar inicio = Calendar.getInstance();
				inicio.setTime(inicio_temp);
				
				Date fim_temp = resultSet.getDate("fim");
				Calendar fim = Calendar.getInstance();
				fim.setTime(fim_temp);
				
				String status = resultSet.getString("status");
				
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
