package models;

public class Veiculo {
	String codigoFipe;
	String marca;
	String modelo;
	String combustivel;
	int portas;
	String anoFabricacao;
	int num_passageiros;
	String renavam;
	
	public Veiculo(String codigoFipe, String marca, String modelo, String combustivel, int portas, String anoFabricacao,
			int num_passageiros, String renavam) {
		super();
		this.codigoFipe = codigoFipe;
		this.marca = marca;
		this.modelo = modelo;
		this.combustivel = combustivel;
		this.portas = portas;
		this.anoFabricacao = anoFabricacao;
		this.num_passageiros = num_passageiros;
		this.renavam = renavam;
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
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public int getPortas() {
		return portas;
	}
	public void setPortas(int portas) {
		this.portas = portas;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public int getNum_passageiros() {
		return num_passageiros;
	}
	public void setNum_passageiros(int num_passageiros) {
		this.num_passageiros = num_passageiros;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	
	
}
