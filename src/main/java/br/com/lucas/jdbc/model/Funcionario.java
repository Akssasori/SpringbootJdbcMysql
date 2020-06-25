package br.com.lucas.jdbc.model;

public class Funcionario {
	
	private long id;
	private String primeiroNome;
	private String UltimoNome;
	private String email;
	
	public Funcionario() {
		
	}

	public Funcionario(long id, String primeiroNome, String ultimoNome, String email) {
		super();
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.UltimoNome = ultimoNome;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return UltimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		UltimoNome = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
