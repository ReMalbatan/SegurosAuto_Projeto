package models;

public class Corretora {
	int id;
	String nome;
	String telefone;
	String email;
	String corretor;
	
	public Corretora(int id, String nome, String telefone, String email, String corretor) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.corretor = corretor;
	}
	
	public int getId(){
		return this.id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCorretor() {
		return corretor;
	}
	public void setCorretor(String corretor) {
		this.corretor = corretor;
	}

}
