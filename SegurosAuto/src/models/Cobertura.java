package models;

public class Cobertura {
	String tipo;
	double valorFipe;
	double valorDeterminado;
	double danosMateriais;
	double danosCorporais;
	String tipoFranquiaCasco;
	double franquiaCasco;
	double franquiaAcessorios;
	
	double valorMercadoAcessorios;
	
	double premioCasco;
	double premioAcessorios;
	double premioDanosMateriais;
	double premioDanosCorporais;
	double premioTotal;
	
	
	public Cobertura (String tipo, double valorFipe, double valorDeterminado, double danosMateriais, double danosCorporais, 
			String franquiaCasco, double valorMercadoAcessorios) {
		this.tipo = tipo;
		this.valorFipe = valorFipe;
		this.valorDeterminado = valorDeterminado;
		this.danosMateriais = danosMateriais;
		this.danosCorporais = danosCorporais;
		this.tipoFranquiaCasco = franquiaCasco;
		this.calculaFranquiaCasco(franquiaCasco);
		this.franquiaAcessorios = (franquiaAcessorios != 0) ? valorMercadoAcessorios*0.15 : 0;
		this.valorMercadoAcessorios = valorMercadoAcessorios;
		this.premioTotal = calculaPremio();
	}
	
	public Cobertura(String tipo, double valorFipe, double valorDeterminado, double danosMateriais,
			double danosCorporais, String tipoFranquiaCasco, double franquiaCasco, double franquiaAcessorios,
			double valorMercadoAcessorios, double premioCasco, double premioAcessorios, double premioDanosMateriais,
			double premioDanosCorporais, double premioTotal) {
		super();
		this.tipo = tipo;
		this.valorFipe = valorFipe;
		this.valorDeterminado = valorDeterminado;
		this.danosMateriais = danosMateriais;
		this.danosCorporais = danosCorporais;
		this.tipoFranquiaCasco = tipoFranquiaCasco;
		this.franquiaCasco = franquiaCasco;
		this.franquiaAcessorios = franquiaAcessorios;
		this.valorMercadoAcessorios = valorMercadoAcessorios;
		this.premioCasco = premioCasco;
		this.premioAcessorios = premioAcessorios;
		this.premioDanosMateriais = premioDanosMateriais;
		this.premioDanosCorporais = premioDanosCorporais;
		this.premioTotal = premioTotal;
	}




	public Cobertura(String tipo, double valorFipe, double valorDeterminado, double danosMateriais,
			double danosCorporais) {
		super();
		this.tipo = tipo;
		this.valorFipe = valorFipe;
		this.valorDeterminado = valorDeterminado;
		this.danosMateriais = danosMateriais;
		this.danosCorporais = danosCorporais;
	}

	public String getTipoFranquiaCasco() {
		return tipoFranquiaCasco;
	}

	public void setTipoFranquiaCasco(String tipoFranquiaCasco) {
		this.tipoFranquiaCasco = tipoFranquiaCasco;
	}
	public double getValorMercadoAcessorios() {
		return valorMercadoAcessorios;
	}
	public void setValorMercadoAcessorios(double valorMercadoAcessorios) {
		this.valorMercadoAcessorios = valorMercadoAcessorios;
	}
	public double getPremioCasco() {
		return premioCasco;
	}
	public void setPremioCasco(double premioCasco) {
		this.premioCasco = premioCasco;
	}
	public double getPremioAcessorios() {
		return premioAcessorios;
	}
	public void setPremioAcessorios(double premioAcessorios) {
		this.premioAcessorios = premioAcessorios;
	}
	public double getPremioDanosMateriais() {
		return premioDanosMateriais;
	}
	public void setPremioDanosMateriais(double premioDanosMateriais) {
		this.premioDanosMateriais = premioDanosMateriais;
	}
	public double getPremioDanosCorporais() {
		return premioDanosCorporais;
	}
	public void setPremioDanosCorporais(double premioDanosCorporais) {
		this.premioDanosCorporais = premioDanosCorporais;
	}
	public double getPremioTotal() {
		return premioTotal;
	}
	public void setPremioTotal(double premioTotal) {
		this.premioTotal = premioTotal;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValorFipe() {
		return valorFipe;
	}
	public void setValorFipe(double valorFipe) {
		this.valorFipe = valorFipe;
	}
	public double getValorDeterminado() {
		return valorDeterminado;
	}
	public void setValorDeterminado(double valorDeterminado) {
		this.valorDeterminado = valorDeterminado;
	}
	public double getDanosMateriais() {
		return danosMateriais;
	}
	public void setDanosMateriais(double danosMateriais) {
		this.danosMateriais = danosMateriais;
	}
	public double getDanosCorporais() {
		return danosCorporais;
	}
	public void setDanosCorporais(double danosCorporais) {
		this.danosCorporais = danosCorporais;
	}
	public double getFranquiaCasco() {
		return franquiaCasco;
	}
	public void setFranquiaCasco(double franquiaCasco) {
		this.franquiaCasco = franquiaCasco;
	}
	public double getFranquiaAcessorios() {
		return franquiaAcessorios;
	}
	public void setFranquiaAcessorios(double franquiaAcessorios) {
		this.franquiaAcessorios = franquiaAcessorios;
	}
	
	public void calculaFranquiaCasco(String franquiaCasco) {
		double valorCobertura = (valorDeterminado == 0.0) ? valorFipe : valorDeterminado;
		switch (franquiaCasco) {
		case "majorada":
			this.franquiaCasco = 0.1*valorCobertura;
			break;
		case "obrigatoria":
			this.franquiaCasco = 0.08*valorCobertura;
			break;
		case "reduzida":
			this.franquiaCasco = 0.06*valorCobertura;
			break;
		default:
			this.franquiaCasco = 0;
		}
	}
	
	public double calculaPremio() {
		double premioTotal = 0;
		double valorCobertura = (valorDeterminado == 0.0) ? valorFipe : valorDeterminado;
		switch (this.tipoFranquiaCasco) {
		case "majorada":
			this.premioCasco = valorCobertura * 0.02;
			break;
		case "obrigatoria":
			this.premioCasco = valorCobertura * 0.03;
			break;
		case "reduzida":
			this.premioCasco = valorCobertura * 0.05;
			break;
		default:
			this.premioCasco = 0;
		}
		
		this.premioAcessorios = this.valorMercadoAcessorios * 0.005;
		this.premioDanosCorporais = this.danosCorporais * 0.0025;
		this.premioDanosMateriais = this.danosMateriais * 0.0025;
		premioTotal = this.premioAcessorios + this.premioCasco + this.premioDanosCorporais + this.premioDanosMateriais;
		premioTotal *= 1.0738;
		return premioTotal;
	}
	
}
