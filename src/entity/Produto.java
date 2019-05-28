package entity;

import java.util.Date;

public class Produto {
	
	
	private double valor;
	private int quantidadeEmEstoque;
	private Date validade;
	private String nome; //primary key
	private String nome_tipoDeProduto;
	private String cnpj_fornecedor;
	
	
	public String getNome_tipoDeProduto() {
		return nome_tipoDeProduto;
	}
	public void setNome_tipoDeProduto(String nome_tipo) {
		this.nome_tipoDeProduto = nome_tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public String getCnpj_fornecedor() {
		return cnpj_fornecedor;
	}
	public void setCnpj_fornecedor(String codigo_fornecedor) {
		this.cnpj_fornecedor = codigo_fornecedor;
	}
	
	
	
	
}
