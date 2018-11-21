package models;

import java.util.Calendar;

public class Apolice {

	/*Em vez de criar as classes 
	 * que serão atributos de apólice, 
	 * iremos trata-las a priori como 
	 * atributos do tipo String
	 **/
	private int id;
	private Calendar inicio;
	private Calendar fim;
	private Corretora corretora;
	private Veiculo veiculo;
	private Segurado segurado;
	private Cobertura cobertura;
	private String status;
	
	public Apolice(int id, Corretora corretora, Veiculo veiculo, Segurado segurado, Cobertura cobertura, Calendar inicio, Calendar fim, String status){
		this.id = id;
		this.corretora  = corretora;
		this.veiculo  = veiculo;
		this.segurado  = segurado;
		this.cobertura  = cobertura;
		this.inicio = inicio;
		this.fim = fim;
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Calendar getInicio() {
		return inicio;
	}


	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}


	public Calendar getFim() {
		return fim;
	}


	public void setFim(Calendar fim) {
		this.fim = fim;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	
	public Corretora getCorretora(){
		return this.corretora;
	}
	public Veiculo getVeiculo(){
		return this.veiculo;
	}
	public Segurado getSegurado(){
		return this.segurado;
	}
	public Cobertura getCobertura(){
		return this.cobertura;
	}
	public void setCorretora(Corretora corretora){
		this.corretora = corretora;
	}
	public void setVeiculo(Veiculo veiculo){
		this.veiculo = veiculo;
	}
	public void setSegurado(Segurado segurado){
		this.segurado = segurado;
	}
	public void setCobertura(Cobertura cobertura){
		this.cobertura = cobertura;
	}

}
