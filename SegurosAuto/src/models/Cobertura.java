package models;

public class Cobertura {
	String tipo;
	double valorFipe;
	double valorDeterminado;
	double danosMateriais;
	double danosCorporais;
	double franquiaCasco;
	double franquiaAcessorios;
	
	public Cobertura(String tipo, double valorFipe, double valorDeterminado, double danosMateriais,
			double danosCorporais, double franquiaCasco, double franquiaAcessorios) {
		super();
		this.tipo = tipo;
		this.valorFipe = valorFipe;
		this.valorDeterminado = valorDeterminado;
		this.danosMateriais = danosMateriais;
		this.danosCorporais = danosCorporais;
		this.franquiaCasco = franquiaCasco;
		this.franquiaAcessorios = franquiaAcessorios;
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
	
}
