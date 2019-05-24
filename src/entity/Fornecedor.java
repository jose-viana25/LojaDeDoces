package entity;

public class Fornecedor {
	
	private int codigo_fornecedor;
	private String cnpj;
	private String nome;
	private String endereco;
	private String descricao;
	
	public Fornecedor() {
		this.codigo_fornecedor = -1;
		this.cnpj = "";
		this.nome = "";
		this.endereco = "";
		this.descricao = "";
	}

	public int getCodigo_fornecedor() {
		return codigo_fornecedor;
	}

	public void setCodigo_fornecedor(int codigo_fornecedor) {
		this.codigo_fornecedor = codigo_fornecedor;
	}

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
	
	

}
