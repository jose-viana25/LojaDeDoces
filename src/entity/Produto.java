package entity;

import java.util.Date;

public class Produto {
	
	private int codigo;
	private int codigo_tipo;
	private double valor;
	private int quantidadeEmEstoque;
	private Date validade;
	private String nome;
	private String cnpj_fornecedor;
	
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
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
	public int getCodigo_tipo() {
		return codigo_tipo;
	}
	public void setCodigo_tipo(int codigo_tipo) {
		this.codigo_tipo = codigo_tipo;
	}
	
	
	
}
