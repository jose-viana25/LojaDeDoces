package entity;

public class Cliente {
	private String CPF;
	private String Email;
	private String Nome;
	private String Telefone;
	
	public Cliente cliente() {
		return null;
		
	}
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF( String CPF) {
		this.CPF = CPF;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

}
