package models;

import java.util.Calendar;

public class Segurado {
	String nome;
	String cpf;
	String sexo;
	String nacionalidade;
	String profissao;
	String telefone;
	String endereco;
	String email;
	Calendar nascimento;
	
	public Segurado(String nome, String cpf, String sexo, String nacionalidade, String profissao, String telefone,
			String endereco, String email, Calendar nascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.nacionalidade = nacionalidade;
		this.profissao = profissao;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.nascimento = nascimento;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	
	
}
