package entity;

import java.util.List;

public class Fornecedor {
	
	private String cnpj;
	private String nome;
	private String endereco;
	private String descricao;
	private List<Produto> listProdutos;
	
	public Fornecedor() {
		this.cnpj = "";
		this.nome = "";
		this.endereco = "";
		this.descricao = "";
	}
	
	

	public List<Produto> getListProdutos() {
		return listProdutos;
	}



	public void setListProdutos(List<Produto> listProdutos) {
		this.listProdutos = listProdutos;
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
