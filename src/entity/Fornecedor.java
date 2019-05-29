package entity;

public class Fornecedor {
	
	private String cnpj;
	private String nome;
	private String endereco;
	private String descricao;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString() {
		return "Cnpj:" + this.cnpj
				+ "\nNome:" + this.nome
				+ "\nEndereço:" + this.endereco
				+ "\nDescrição:" + this.descricao;
	}

}
