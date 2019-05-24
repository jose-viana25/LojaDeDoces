package entity;

import java.util.List;

public class TipoDeProduto {
	
	private int codigo;
	private String nome;
	private String descricao;
	private List<Produto> listProdutos;
	
	public TipoDeProduto() {
		this.codigo = -1;
		this.nome = "";
		this.descricao = "";
	}
	
	public List<Produto> getListProdutos() {
		return listProdutos;
	}

	public void setListProdutos(List<Produto> listProdutos) {
		this.listProdutos = listProdutos;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
