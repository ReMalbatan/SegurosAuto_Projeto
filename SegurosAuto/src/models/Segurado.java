package models;

public class Segurado {
	int id;
	String nome;
	String cpf;
	String nacionalidade;
	
	public Segurado(int id, String nome, String cpf, String nacionalidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.nacionalidade = nacionalidade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	
}
