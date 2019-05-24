package entity;

public class ItensPedido {
	
	private int codigo_venda;
	private int codigo_produto;
	private int quantidade;
	private double valorUnitario;
	
	public int getCodigo_venda() {
		return codigo_venda;
	}
	public void setCodigo_venda(int codigo_venda) {
		this.codigo_venda = codigo_venda;
	}
	public int getCodigo_produto() {
		return codigo_produto;
	}
	public void setCodigo_produto(int codigo_produto) {
		this.codigo_produto = codigo_produto;
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
