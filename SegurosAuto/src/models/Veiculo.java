package models;

public class Veiculo {
	int id;
	String codigoFipe;
	String marca;
	String modelo;
	int portas;
	/*String anoModelo;
	String anoFabricacao;
	String noPassageiros;
	String Chassi;
	String Renavam;
	String Classe;*/
	
	public Veiculo(int id, String codigoFipe, String marca, String modelo, int portas) {
		super();
		this.id = id;
		this.codigoFipe = codigoFipe;
		this.marca = marca;
		this.modelo = modelo;
		this.portas = portas;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoFipe() {
		return codigoFipe;
	}
	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getPortas() {
		return portas;
	}
	public void setPortas(int portas) {
		this.portas = portas;
	}
	
	
}
