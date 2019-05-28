package entity;

public class ItensPedido {
	
	private int codigo_venda;
	private String nome_produto;
	private int quantidade;
	private double valorUnitario;
	
	public int getCodigo_venda() {
		return codigo_venda;
	}
	public void setCodigo_venda(int codigo_venda) {
		this.codigo_venda = codigo_venda;
	}
	public String getNome_produto() {
		return nome_produto;
	}
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	
	
}
